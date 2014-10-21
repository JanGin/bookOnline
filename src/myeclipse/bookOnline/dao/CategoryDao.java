package myeclipse.bookOnline.dao;

import java.util.List;

import myeclipse.bookOnline.bean.Category;

public interface CategoryDao {

	public abstract void add(Category category);

	//public abstract void delete();

	//public abstract void update();

	public abstract Category find(String id);

	public abstract List<Category> list();

}