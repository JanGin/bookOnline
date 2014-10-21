package myeclipse.bookOnline.bean;

public class CartItem {

	private Book book;
	private Integer quantity;
	private Double price;
	
	public Book getBook() {
		return book;
	}
	public void setBook(Book book) {
		this.book = book;
	}
	public Integer getQuantity() {
		return quantity;
	}
	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}
	public Double getPrice() {
		
		this.price = this.book.getPrice() * this.quantity;
		return price;
	}
	public void setPrice(Double price) {
		this.price = price;
	}
	
}
