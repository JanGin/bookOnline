package myeclipse.bookOnline.dao;

import java.util.List;

import myeclipse.bookOnline.bean.Book;

public interface BookDao {

	public void add(Book book);

	public Book find(String id);
	
	public List<Book> getPageData(int startIndex,int pageSize);

	public Integer getTotalRecord();
	
	public Integer getTotalRecord(String category_id);
	
	public List<Book> getPageData(int startIndex,int pageSize,String category_id);

	//public void delete(Book book);
}