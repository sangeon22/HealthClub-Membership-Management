package HealthClub;

import java.sql.*;
import java.util.ArrayList;

public class Trainer extends DBManager {
	
	public static String trName = "";
	
	// ��� Ʈ���ֳ� �ڵ� �ҷ�����
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
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("���� " + e);
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
	
	// ���� �α������� ȸ���� ��� Ʈ���̳� �̸� �ҷ�����
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
			System.out.println("����̹� �ε� ����");
		} catch (SQLException e) {
			System.out.println("���� " + e);
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