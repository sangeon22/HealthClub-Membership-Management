package HealthClub;

import java.sql.*;
import java.util.ArrayList;

public class Trainer extends DBManager {
	
	public static String trName = "";
	
	// 모든 트레애너 코드 불러오기
	public static ArrayList<String> TrainerID_check() {
		String TrainerID = null;
		ArrayList<String> TrainerID_List = new ArrayList<>();

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM healthclub.trainer";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				TrainerID = rs.getString("TrainerID");
				TrainerID_List.add(TrainerID);
			}
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
		return TrainerID_List;
	}
	
	// 현재 로그인중인 회원의 담당 트레이너 이름 불러오기
	public static void TrainerNameInfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String trID = PT.PTInfo.get(1);
			String sql = "SELECT * FROM healthclub.trainer where TrainerID = " + trID + ";";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				trName = rs.getString("TrainerName");
			}

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