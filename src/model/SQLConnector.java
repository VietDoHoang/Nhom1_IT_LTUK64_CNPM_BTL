package model;

import java.sql.Connection;
import java.sql.DriverManager;

public class SQLConnector {
	private static String url = "jdbc:mysql://localhost/ql_covid";
	private static String user = "root";
	private static String password = "";
	private static Connection con;
	
	protected SQLConnector() {
	}
	
	protected static Connection getCon() throws Exception{
		try {
			con = DriverManager.getConnection(url, user, password);
			return con;
		} catch (Exception e) {
			// TODO: handle exception
			throw new Exception("Lỗi kết nối database");
		}
		
	}
}
