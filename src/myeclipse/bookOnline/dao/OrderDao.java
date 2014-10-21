package myeclipse.bookOnline.dao;

import java.util.List;

import myeclipse.bookOnline.bean.Order;

public interface OrderDao {

	void addOrder(Order order);

	Order find(String orderid);
	
	List<Order> getAllOrders(boolean states);
	
	void updateStates(Order order);

}