package mms.member.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtil {
	public static Connection con;
	static {
		
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			//Class.forName("org.mariadb.jdbc.Driver");

		} catch (ClassNotFoundException e) {
			System.out.println("ojdbc6_g.jar 파일이 없습니다.");
		}

	}

	public static Connection getConnection() {
		
		try {
			String sql = "jdbc:oracle:thin:@localhost:1521:orcl";
			con = DriverManager.getConnection(sql, "javalink", "javalink");
			
			//String sql = "jdbc:mariadb://localhost:3306/test_database";
			//con = DriverManager.getConnection(sql, "root", "1q2w3e4r");
			return con;
		} catch (SQLException e) {
		
			System.out.println("연결에 실패했습니다.");
		}
		return null;
		
	}

	public static void close(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	

}
