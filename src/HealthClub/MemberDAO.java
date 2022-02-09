package HealthClub;

import java.sql.*;

public class MemberDAO extends DBManager {
	static DBManager db = new DBManager();

	public boolean memberJoin(MemberDTO dto) throws Exception {
		boolean flag = false;
		String id = dto.getMid();
		String name = dto.getMname();
		String tel = dto.getMtel();
		String sex = dto.getMsex();
		String birth = dto.getMbirth();
		String address = dto.getMaddress();

		String sql = "INSERT INTO healthclub.member(MemberID, MemberName, MemberSex, MemberTel, MemberBirth, MemberAddress) VALUES";

		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			conn = DriverManager.getConnection(url, "root", "root");
			stmt = conn.createStatement();

			sql += "('" + new String(id.getBytes()) + "','" + new String(name.getBytes()) + "','"
					+ new String(sex.getBytes()) + "','" + new String(tel.getBytes()) + "','"
					+ new String(birth.getBytes()) + "','" + new String(address.getBytes()) + "')";

			stmt.executeUpdate(sql);

		} catch (Exception e) {
			System.out.println(e);
			flag = false;

		} finally {
			try {
				if (stmt != null)
					stmt.close();
				if (conn != null)
					conn.close();
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		return flag;
	}
}