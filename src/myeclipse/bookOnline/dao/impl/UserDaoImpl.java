package myeclipse.bookOnline.dao.impl;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;

import myeclipse.bookOnline.bean.User;
import myeclipse.bookOnline.dao.UserDao;
import myeclipse.bookOnline.utils.JdbcUtils;

public class UserDaoImpl implements UserDao {

	@Override
	public void add(User user) {
		try {
			
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "insert into user (id,username,password,phone,cellphone,address,email) values(?,?,?,?,?,?,?)";
			Object[] params = {user.getId(),user.getUsername(),user.getPassword(),
					user.getPhone(),user.getCellphone(),user.getAddress(),user.getEmail()};
			runner.update(sql,params);
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
			
		
	}

	@SuppressWarnings("deprecation")
	@Override
	public User find(String userid) {
		try {
			
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where id=?";
			return (User)runner.query(sql, userid, new BeanHandler(User.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

	@SuppressWarnings("deprecation")
	@Override
	public User find(String username, String password) {
		try {
			
			QueryRunner runner = new QueryRunner(JdbcUtils.getDataSource());
			String sql = "select * from user where username=? and password=?";
			Object[] params = {username,password};
			return (User)runner.query(sql, params, new BeanHandler(User.class));
		} catch (Exception e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
