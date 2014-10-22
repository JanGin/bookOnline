package myeclipse.bookOnline.dao.impl;

import java.util.List;

import myeclipse.bookOnline.bean.Book;
import myeclipse.bookOnline.dao.BookDao;
import myeclipse.bookOnline.utils.JdbcUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

public class BookDaoImpl implements BookDao {

	/* (non-Javadoc)
	 * @see myeclipse.bookOnline.dao.impl.BookDao#add(myeclispe.bookOnline.bean.Book)
	 */
	public void add(Book book){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into book (id,name,author,price,image,description,category_id) values(?,?,?,?,?,?,?)";
			Object[] params = {book.getId(),book.getName(),book.getAuthor(),book.getPrice(),book.getImage(),book.getDescription(),book.getCategory_id()};
			runner.update(sql, params);
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see myeclipse.bookOnline.dao.impl.BookDao#find(java.lang.String)
	 */
	@SuppressWarnings("deprecation")
	public Book find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where id=?";
			return (Book) runner.query(sql, id, new BeanHandler(Book.class));
			
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/*
	 * 得到分页数据
	 */
	@SuppressWarnings({ "deprecation", "unchecked" })
	public List<Book> getPageData(int startIndex,int pageSize){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book limit ?,?";
			Object[] params = {startIndex,pageSize};
			return (List<Book>) runner.query(sql, params, new BeanListHandler(Book.class));
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	
	}
	
	/*
	 * 获得总的记录数
	 */
	public Integer getTotalRecord(){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select count(*) from book";
			long l =  (Long)runner.query(sql,new ScalarHandler());
			return (int)l;
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	/*
	 * 获取分类下的页面数据
	 */
	@SuppressWarnings({ "unchecked", "deprecation" })
	public List<Book> getPageData(int startIndex,int pageSize,String category_id){
		
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from book where category_id=? limit ?,?";
			Object params[] = {category_id,startIndex,pageSize};
			return (List<Book>) runner.query(sql, params, new BeanListHandler(Book.class));
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	/*
	 * 获取个各分类下的总记录数
	 */
	@SuppressWarnings("deprecation")
	public Integer getTotalRecord(String category_id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			
			String sql = "select count(*) from book where category_id=?";
			long totalrecord = (Long) runner.query(sql, category_id,new ScalarHandler());
			return (int)totalrecord;
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}

	
	/*public void delete(Book book) {
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "delete * from book where id=?";
			runner.update(sql, book.getId());
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
*/
	
}
