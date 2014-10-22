package myeclipse.bookOnline.service;

import java.util.List;

import myeclipse.bookOnline.bean.Book;
import myeclipse.bookOnline.bean.Cart;
import myeclipse.bookOnline.bean.Category;
import myeclipse.bookOnline.bean.Order;
import myeclipse.bookOnline.bean.Page;
import myeclipse.bookOnline.bean.User;

public interface BusinessService {

	public void add(Category category);

	public List<Category> list();
	
	public Category findCategory(String id);
	
	public void addBook(Book book);
	
	public Book findBook(String id);
	
	public Page getPageData(String pageNum);
	
	public Page getBookPageData(String pageNum,String category_id);

	public void purchase(Cart cart, Book book);

	public void registeUser(User user);
	
	public User findUser(String userid);
	
	public User findUser(String username,String password);
	
	public void createOrder(User user,Cart cart) throws Exception;
	
	public Order findOrder(String orderid);

	public List<Order> listOrder(String state);

	public void confirmGoods(String orderid);

	public void deleteBook(Cart cart,String bookid);

	public void empty(Cart cart);

	
}