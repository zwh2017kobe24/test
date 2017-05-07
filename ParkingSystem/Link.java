package ParkingSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public interface Link {
	static void link(String sql){
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //加载JDBC驱动
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=HomeDB"; //连接服务器和数据库test
		String userName = "zwh2017kobe24"; //默认用户名
		String userPwd = "zhaiwenhao960320"; //密码
		Connection conn;
		try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		System.out.println("Connection Successful!"); //如果连接成功 控制台输出Connection Successful!
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	
	}
}
