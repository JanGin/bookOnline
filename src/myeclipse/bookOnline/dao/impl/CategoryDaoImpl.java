package myeclipse.bookOnline.dao.impl;

import java.sql.SQLException;
import java.util.List;

import myeclipse.bookOnline.dao.CategoryDao;
import myeclipse.bookOnline.utils.JdbcUtils;
import myeclipse.bookOnline.bean.Category;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

public class CategoryDaoImpl implements CategoryDao {

	/* (non-Javadoc)
	 * @see myclispe.bookOnline.dao.impl.CategoryDao#add(myeclispe.bookOnline.bean.Category)
	 */
	@Override
	public void add(Category category){
		try {
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into category (id,name,description) values(?,?,?)";
			Object[] params = {category.getId(),category.getName(),category.getDescription()};
				runner.update(sql,params);
		} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see myclispe.bookOnline.dao.impl.CategoryDao#delete()
	
	@Override
	public void delete(){
		
	}
	 */
	/* (non-Javadoc)
	 * @see myclispe.bookOnline.dao.impl.CategoryDao#update()
	
	@Override
	public void update(){
		
	}
	 */
	/* (non-Javadoc)
	 * @see myclispe.bookOnline.dao.impl.CategoryDao#find()
	 */
	@SuppressWarnings("deprecation")
	@Override
	public Category find(String id){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category where id = ?";
			return (Category) runner.query(sql, id, new BeanHandler(Category.class));
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
	
	/* (non-Javadoc)
	 * @see myclispe.bookOnline.dao.impl.CategoryDao#list()
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<Category> list(){
		try{
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from category";
			return (List<Category>) runner.query(sql,new BeanListHandler(Category.class));
		} catch(Exception e){
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}
}
