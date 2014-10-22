package myeclipse.bookOnline.bean;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Order {

	private String id;
	private Date ordertime;
	private boolean state;
	private Double price;
	private User user;
	private Set<OrderItem> set = new HashSet<OrderItem>();
	
	public Set<OrderItem> getSet() {
		return set;
	}
	public void setSet(Set<OrderItem> set) {
		this.set = set;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public boolean isState() {
		return state;
	}
	
	public void setState(boolean state) {
		this.state = state;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
	public Date getOrdertime() {
		return ordertime;
	}
	public void setOrdertime(Date ordertime) {
		this.ordertime = ordertime;
	}
}
