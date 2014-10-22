package myeclipse.bookOnline.bean;

import java.util.HashMap;
import java.util.Map;

import myeclipse.bookOnline.bean.Book;

public class Cart {

	private Double price;
	private Map<String,CartItem> map = new HashMap<String,CartItem>();
	public Map<String, CartItem> getMap() {
		return map;
	}
	public void setMap(Map<String, CartItem> map) {
		this.map = map;
	}
	//对外提供买书的方法
	public void addBook(Book book) {
		
		CartItem item = map.get("bookid");
		if (item == null){
			item = new CartItem();
			item.setBook(book);
			item.setQuantity(1);
			map.put(book.getId(), item);				//当第一次购买时往map集合里添加购物项
		} else{
			item.setQuantity(item.getQuantity() + 1);
		}
	}
	public Double getPrice() {
		Double totalPrice = 0.0;
		for (Map.Entry<String, CartItem> entry : map.entrySet()){
			totalPrice += entry.getValue().getPrice();
		}
		this.price = totalPrice;
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}

}
