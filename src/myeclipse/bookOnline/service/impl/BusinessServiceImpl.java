package myeclipse.bookOnline.service.impl;

import java.util.Date;
import java.util.List;
import java.util.Map;

import myeclipse.bookOnline.bean.Book;
import myeclipse.bookOnline.bean.Cart;
import myeclipse.bookOnline.bean.CartItem;
import myeclipse.bookOnline.bean.Category;
import myeclipse.bookOnline.bean.Order;
import myeclipse.bookOnline.bean.OrderItem;
import myeclipse.bookOnline.bean.Page;
import myeclipse.bookOnline.bean.User;
import myeclipse.bookOnline.dao.BookDao;
import myeclipse.bookOnline.dao.CategoryDao;
import myeclipse.bookOnline.dao.OrderDao;
import myeclipse.bookOnline.dao.UserDao;
import myeclipse.bookOnline.service.BusinessService;
import myeclipse.bookOnline.utils.DaoFactory;
import myeclipse.bookOnline.utils.UUID_Util;

public class BusinessServiceImpl implements BusinessService {

	CategoryDao cdao = DaoFactory.getInstance().createDao("myeclipse.bookOnline.dao.impl.CategoryDaoImpl",CategoryDao.class);
	BookDao bdao = DaoFactory.getInstance().createDao("myeclipse.bookOnline.dao.impl.BookDaoImpl", BookDao.class);
	UserDao udao = DaoFactory.getInstance().createDao("myeclipse.bookOnline.dao.impl.UserDaoImpl", UserDao.class);
	OrderDao odao = DaoFactory.getInstance().createDao("myeclipse.bookOnline.dao.impl.OrderDaoImpl", OrderDao.class);
	/* 
	 * ��ӷ���
	 */
	public void add(Category category){
		cdao.add(category);
	}
	
	public Category findCategory(String id){
		return cdao.find(id);
	}
	/* 
	 * �鿴���з���
	 */
	public List<Category> list(){
		//System.out.println(cdao);
		return cdao.list();
	}
	/*=========================================================================================*/
	/*
	 * ɾ��ͼ��
	 */
	public void deleteBook(Cart cart,String bookid){
		Map<String,CartItem> map = cart.getMap();
		map.remove(bookid);
	}
	/*
	 * ���ͼ��
	 */
	public void addBook(Book book){
		bdao.add(book);
	}
	
	/*
	 * ����ͼ��
	 */
	public Book findBook(String id){
		return bdao.find(id);
	}
	/*
	 *��ȡҳ������ 
	 */
	@SuppressWarnings("rawtypes")
	@Override
	public Page getPageData(String pageNum) {
		
		Integer totalRecord = bdao.getTotalRecord();
		Page page = null;
		if (pageNum == null){
			page = new Page(1,totalRecord);
		} else{
			page = new Page(Integer.parseInt(pageNum),totalRecord);
		}
		
		List list = bdao.getPageData(page.getStartIndex(),page.getPageSize());
		page.setList(list);
		return page;
	}
	
	/**��ȡ��������ķ�ҳ����**/
	@SuppressWarnings("rawtypes")
	@Override
	public Page getBookPageData(String pageNum,String category_id){
		int totalRecord = bdao.getTotalRecord(category_id);
	
		Page page = null;
		if(pageNum==null){
			page = new Page(1,totalRecord);
		}else{
			page = new Page(Integer.parseInt(pageNum),totalRecord);
		}
		List list = bdao.getPageData(page.getStartIndex(), page.getPageSize(),category_id);
		page.setList(list);
		return page;
	}
	
	/*==========================================================================================*/
	
	/*
	 * �ṩ����ķ���
	 * @see myeclipse.bookOnline.service.BusinessService#purchase(myeclipse.bookOnline.bean.Cart, myeclipse.bookOnline.bean.Book)
	 */
	@Override
	public void purchase(Cart cart,Book book){
		cart.addBook(book);
	}
	/*
	 * �û�ע�����
	 * @see myeclipse.bookOnline.service.BusinessService#registeUser(myeclipse.bookOnline.bean.User)
	 */
	@Override
	public void registeUser(User user){
		udao.add(user);
	}
	
	public User findUser(String userid){
		
		return udao.find(userid);
	}
	
	public User findUser(String username,String password){
		return udao.find(username, password);
	}
	
	/*=================================================================================*/
	
	/*
	 * �ṩ��������
	 */
	
	public void createOrder(User user,Cart cart) throws Exception{
		if (cart == null){
			throw new Exception("��ǰ���ﳵ�����κ���Ʒ!");
		}
		Order order = new Order();
		order.setId(UUID_Util.createID());
		order.setUser(user);
		order.setOrdertime(new Date());
		order.setState(false);
		order.setPrice(cart.getPrice());
		
		//��ȡÿһ���������Ա����ɶ�����
		for(Map.Entry<String, CartItem> entry : cart.getMap().entrySet()){
			OrderItem oitem = new OrderItem();
			oitem.setId(UUID_Util.createID());
			oitem.setBook(entry.getValue().getBook());
			oitem.setQuantity(entry.getValue().getQuantity());
			oitem.setPrice(entry.getValue().getPrice());
			order.getSet().add(oitem);			//��������䶩��
		}
		
		odao.addOrder(order);
	}
	
	@Override
	public Order findOrder(String orderid){
		return (Order)odao.find(orderid);
	}
	
	@Override
	public List<Order> listOrder(String state){
		return odao.getAllOrders(Boolean.parseBoolean(state));
		
	}
	
	/*
	 *ȷ�Ϸ���
	 */
	public void confirmGoods(String orderid){
		Order order = odao.find(orderid);
		order.setState(true);
		odao.updateStates(order);
	}

	/*
	 * ��չ��ﳵ
	 */
	@Override
	public void empty(Cart cart) {
		
		Map<String,CartItem> map = cart.getMap();
		map.clear();
	}

	
}
