package myeclipse.bookOnline.bean;

public class OrderItem {

	private String id;
	private Integer quantity;
	private Double price;
	
	private Book book;

	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
}
