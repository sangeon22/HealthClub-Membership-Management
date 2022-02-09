package HealthClub;

import java.sql.*;

public class DBManager {

	final static String url = "jdbc:mysql://localhost:3306/healthclub?useUnicode=true&characterEncoding=utf8&useJDBCCompliantTimeZoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC";
	static Connection conn = null;
	static Statement stmt = null;
	static ResultSet rs = null;
	static int delete = 0;
	static int update = 0;
	
	public DBManager() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			
		} catch (ClassNotFoundException e) {
			System.out.println("드라이버 로딩 실패");
		} catch (SQLException e) {
			System.out.println("에러 " + e);
		} finally {
			try {
				if (conn != null && !conn.isClosed()) {
					conn.close();
				}
				if (stmt != null && !stmt.isClosed()) {
					stmt.close();
				}
				if (rs != null && !rs.isClosed()) {
					rs.close();
				}
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}
}
