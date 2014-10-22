package myeclipse.bookOnline.dao;

import myeclipse.bookOnline.bean.User;

public interface UserDao {

	public void add(User user);
	
	public User find(String userid);
	
	public User find(String username,String password);
}
