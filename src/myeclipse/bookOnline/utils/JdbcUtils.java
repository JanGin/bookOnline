package myeclipse.bookOnline.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {

	private static DataSource ds;
	static{
		ds = new ComboPooledDataSource("c3p0-config.xml");
	}
	
	public static DataSource getDataSource(){
		return ds;
	}
	
	public Connection getConnection() throws SQLException{
		return ds.getConnection();
	}
}
