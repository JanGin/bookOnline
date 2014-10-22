package myeclipse.bookOnline.dao.impl;

import java.util.List;
import java.util.Set;

import myeclipse.bookOnline.bean.Book;
import myeclipse.bookOnline.bean.Order;
import myeclipse.bookOnline.bean.OrderItem;
import myeclipse.bookOnline.bean.User;
import myeclipse.bookOnline.dao.OrderDao;
import myeclipse.bookOnline.utils.JdbcUtils;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class OrderDaoImpl implements OrderDao {

	@Override
	public void addOrder(Order order){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into orders (id,ordertime,price,states,user_id) values (?,?,?,?,?)";
			Object[] params = {order.getId(),order.getOrdertime(),order.getPrice(),order.isState(),order.getUser().getId()};
			runner.update(sql, params);
			
			Set<OrderItem> itemSet = order.getSet();
			for (OrderItem item : itemSet){
				String sql_ = "insert into orderitem (id,quantity,price,order_id,book_id) values (?,?,?,?,?)";
				Object[] params_ = {item.getId(),item.getQuantity(),item.getPrice(),order.getId(),item.getBook().getId()};
				runner.update(sql_, params_);
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	@SuppressWarnings({ "deprecation", "unchecked" })
	@Override
	public Order find(String orderid){
		
		try{
			//�ҳ������Ļ�����Ϣ
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where id=?";
		    Order order = (Order) runner.query(sql,orderid,new BeanHandler(Order.class));
		
		    //�ҳ�������Ļ�����Ϣ
		    sql = "select * from orderitem where order_id =?";
		    List<OrderItem> list = (List<OrderItem>) runner.query(sql,orderid,new BeanListHandler(OrderItem.class));
		    for(OrderItem item : list){
		    	//���������Ϣ��䶩����
		    	sql = "select book.* from orderitem,book where orderitem.id=? and orderitem.book_id = book.id";
		    	Book book = (Book) runner.query(sql,item.getId(), new BeanHandler(Book.class));
		    	item.setBook(book);
		    }
		    //��������䶩��
		    order.getSet().addAll(list);
		    
		    //��������� �û���Ϣ
		    sql = "select user.* from orders,user where orders.id=? and orders.user_id = user.id";
		    User user = (User)runner.query(sql,order.getId(), new BeanHandler(User.class));
		    order.setUser(user);
		    return order;
		    
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	@Override
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Order> getAllOrders(boolean states){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from orders where states=?";
			List<Order> list = (List<Order>) runner.query(sql, states, new BeanListHandler(Order.class));
			for(Order order : list){
				//�ҳ���ǰ���������ĸ��û�
				sql = "select user.* from orders,user where orders.id=? and orders.user_id=user.id";
				User user = (User) runner.query(sql,order.getId(), new BeanHandler(User.class));
				order.setUser(user);
		}
			return list;
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
}

	@Override
	public void updateStates(Order order){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "update orders set states=? where id=?";
			Object params[] = {order.isState(),order.getId()};
			runner.update(sql, params);
		}catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
