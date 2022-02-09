package HealthClub;

import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ArrayList;

public class Membership extends DBManager {
	
	public static ArrayList<String> MsInfo = new ArrayList<>();
	
	public static void Buy_Membership(int Ms_No) {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			String sql = "";

			if (Ms_No == 1) {
				sql = "UPDATE `healthclub`.`member` SET `MembershipCode` = '1000' WHERE (`MemberID` = \'" + GUI.loginID
						+ "\');";
			} else if (Ms_No == 2) {
				sql = "UPDATE `healthclub`.`member` SET `MembershipCode` = '1001' WHERE (`MemberID` = \'" + GUI.loginID
						+ "\');";
			} else if (Ms_No == 3) {
				sql = "UPDATE `healthclub`.`member` SET `MembershipCode` = '1002' WHERE (`MemberID` = \'" + GUI.loginID
						+ "\');";
			} else {
				sql = "UPDATE `healthclub`.`member` SET `MembershipCode` = '1003' WHERE (`MemberID` = \'" + GUI.loginID
						+ "\');";
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
	
	// 이용중인 회원권 정보 확인
	public static void MembershipInfo() {
		try {			
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			
			String mscode = Member.MemberInfo.get(6);
			String sql = "SELECT * FROM healthclub.membership where MembershipCode = " + mscode + ";";

			rs = stmt.executeQuery(sql);
		
			while (rs.next()) {
				MsInfo.clear();
				
				MsInfo.add(rs.getString("MembershipCode"));
				MsInfo.add(rs.getString("MembershipOption"));
				MsInfo.add(rs.getString("MembershipPrice"));
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
