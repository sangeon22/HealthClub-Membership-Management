package HealthClub;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Member extends DBManager {
	// 필요한 정보를 담을 자원
	static String MemberID = null;
	static ArrayList<String> MemberID_List = new ArrayList<>();
	static ArrayList<String> MemberInfo = new ArrayList<>();
	static Vector<String> colNames = new Vector<String>();
	
	// 회원 번호만 가져 오는 메소드 (로그인용)
	public static ArrayList<String> MemberID_check() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String sql = "SELECT * FROM healthclub.member";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				MemberID = rs.getString("MemberID");
				MemberID_List.add(MemberID);
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
		return MemberID_List;
	}
	
	// 로그인 중인 회원 정보 불러오기 (나의 정보 확인용)
	public static void MemberInfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String sql = "SELECT *, IFNULL(MembershipCode, 'X') AS MS_CODE, IFNULL(PTCode, 'X') AS PT_Code "
					+ "FROM healthclub.member where MemberID = " + GUI.loginID + ";";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// 로그인 회원이 바뀔 때, 기존 로그인 회원의 정보를 모두 지움
				MemberInfo.clear();
				
				MemberInfo.add(rs.getString("MemberID"));
				MemberInfo.add(rs.getString("MemberName"));
				MemberInfo.add(rs.getString("MemberSex"));
				MemberInfo.add(rs.getString("MemberTel"));
				MemberInfo.add(rs.getString("MemberBirth"));
				MemberInfo.add(rs.getString("MemberAddress"));
				MemberInfo.add(rs.getString("MS_CODE"));
				MemberInfo.add(rs.getString("PT_Code"));
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

	// 회원 전체 리스트를 가져오는 메소드 (회원 테이블 용)
	public static void MemberList() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM healthclub.member";
			rs = stmt.executeQuery(sql);

			colNames.add("회원번호");
			colNames.add("이름");
			colNames.add("성별");
			colNames.add("전화번호");
			colNames.add("생년월일");
			colNames.add("주소");

			while (rs.next()) {
				String id = rs.getString("MemberID");
				String name = rs.getString("MemberName");
				String sex = rs.getString("MemberSex");
				String tel = rs.getString("MemberTel");
				String birth = rs.getString("MemberBirth");
				String address = rs.getString("MemberAddress");

				Vector<String> row = new Vector<String>();

				row.add(id);
				row.add(name);
				row.add(sex);
				row.add(tel);
				row.add(birth);
				row.add(address);

				GUI.model.addRow(row);
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