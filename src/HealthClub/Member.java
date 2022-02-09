package HealthClub;

import java.sql.*;
import java.util.ArrayList;
import java.util.Vector;

public class Member extends DBManager {
	// �ʿ��� ������ ���� �ڿ�
	static String MemberID = null;
	static ArrayList<String> MemberID_List = new ArrayList<>();
	static ArrayList<String> MemberInfo = new ArrayList<>();
	static Vector<String> colNames = new Vector<String>();
	
	// ȸ�� ��ȣ�� ���� ���� �޼ҵ� (�α��ο�)
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
		return MemberID_List;
	}
	
	// �α��� ���� ȸ�� ���� �ҷ����� (���� ���� Ȯ�ο�)
	public static void MemberInfo() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			String sql = "SELECT *, IFNULL(MembershipCode, 'X') AS MS_CODE, IFNULL(PTCode, 'X') AS PT_Code "
					+ "FROM healthclub.member where MemberID = " + GUI.loginID + ";";

			rs = stmt.executeQuery(sql);

			while (rs.next()) {
				// �α��� ȸ���� �ٲ� ��, ���� �α��� ȸ���� ������ ��� ����
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

	// ȸ�� ��ü ����Ʈ�� �������� �޼ҵ� (ȸ�� ���̺� ��)
	public static void MemberList() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();
			String sql = "SELECT * FROM healthclub.member";
			rs = stmt.executeQuery(sql);

			colNames.add("ȸ����ȣ");
			colNames.add("�̸�");
			colNames.add("����");
			colNames.add("��ȭ��ȣ");
			colNames.add("�������");
			colNames.add("�ּ�");

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