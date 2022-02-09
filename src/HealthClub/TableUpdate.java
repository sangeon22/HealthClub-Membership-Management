package HealthClub;

import java.sql.DriverManager;
import java.sql.SQLException;
import HealthClub.GUI;

public class TableUpdate extends DBManager {

	public static void Delete() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String sql = "DELETE FROM `healthclub`.`member` WHERE (`MemberID` = \'" + GUI.after1 + "\');";

			delete = stmt.executeUpdate(sql);

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

	public static void Update() {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String sql = "UPDATE `healthclub`.`member` SET " + GUI.co + "= \'" + GUI.after2 + "\' WHERE (`MemberID` = \'" + GUI.after1 + "\');";

			update = stmt.executeUpdate(sql);

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