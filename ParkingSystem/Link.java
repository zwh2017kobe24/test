package ParkingSystem;

import java.sql.Connection;
import java.sql.DriverManager;

public interface Link {
	static void link(String sql){
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //����JDBC����
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=HomeDB"; //���ӷ����������ݿ�test
		String userName = "zwh2017kobe24"; //Ĭ���û���
		String userPwd = "zhaiwenhao960320"; //����
		Connection conn;
		try {
		Class.forName(driverName);
		conn = DriverManager.getConnection(dbURL, userName, userPwd);
		System.out.println("Connection Successful!"); //������ӳɹ� ����̨���Connection Successful!
		}
		catch (Exception e) {
			e.printStackTrace();
			}
	
	}
}
