package HealthClub;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class PT extends DBManager {
	
	public static ArrayList<String> PTInfo = new ArrayList<>();
	
	public static void Buy_PT(int PT_No) {

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			String sql = "";
			
			if (PT_No == 1) {
				sql = "UPDATE `healthclub`.`member` SET `PTCode` = '2000', `TrainerID` = '4634' WHERE (`MemberID` = \'" + GUI.loginID + "\');";
			} else if(PT_No == 2) {
				sql = "UPDATE `healthclub`.`member` SET `PTCode` = '2001', `TrainerID` = '5495' WHERE (`MemberID` = \'" + GUI.loginID + "\');";
			} else if(PT_No == 3) {
				sql = "UPDATE `healthclub`.`member` SET `PTCode` = '2002', `TrainerID` = '5663' WHERE (`MemberID` = \'" + GUI.loginID + "\');";
			} else {
				sql = "UPDATE `healthclub`.`member` SET `PTCode` = '2003', `TrainerID` = '4685' WHERE (`MemberID` = \'" + GUI.loginID + "\');";
			}
			
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
	
	// 이용중인 PT 정보 불러오기
	public static void PTInfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			
			String ptcode = Member.MemberInfo.get(7);
			String sql = "SELECT * FROM healthclub.pt where PTCode = " + ptcode + ";";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				PTInfo.clear();
				
				PTInfo.add(rs.getString("PTCode"));
				PTInfo.add(rs.getString("TrainerID"));
				PTInfo.add(rs.getString("PTTime"));
				PTInfo.add(rs.getString("PTPrice"));
				PTInfo.add(rs.getString("PTExersiceSection"));
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
