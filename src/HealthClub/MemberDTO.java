package HealthClub;

import java.util.Random;

public class MemberDTO {
	public String m_id = "";
	private String m_name;
	private String m_tel;
	private String m_sex;
	private String m_birth;
	private String m_address;

	static Member member = new Member();
	static Random rd = new Random();

	// 회원번호에 사용할 난수 생성하는 메소드
	public String getMid() {
		try {
			m_id = "";
			while (true) {
				for (int i = 1; i <= 4; i++) {
					String num = String.valueOf(rd.nextInt(10));
					m_id += num;
				}

				if (Member.MemberID_List.contains(m_id)) {
					continue;
				}

				else {
					break;
				}
			}
		} catch (NullPointerException npe) {
			System.out.println("Null Opint Exception!!");
		} finally {

		}
		return m_id;
	}

	public void setMid(String m_id) {
		this.m_id = m_id;
	}

	public String getMname() {
		return m_name;
	}

	public void setMname(String m_name) {
		this.m_name = m_name;
	}

	public String getMtel() {
		return m_tel;
	}

	public void setMtel(String m_tel) {
		this.m_tel = m_tel;
	}

	public String getMsex() {
		return m_sex;
	}

	public void setMsex(String m_sex) {
		this.m_sex = m_sex;
	}

	public String getMbirth() {
		return m_birth;
	}

	public void setMbirth(String m_birth) {
		this.m_birth = m_birth;
	}

	public String getMaddress() {
		return m_address;
	}

	public void setMaddress(String m_address) {
		this.m_address = m_address;
	}

	@Override
	public String toString() {
		String str = String.format("아이디:%s \n이름:%s \n번호:%s \n성별:%s \n생일:%s \n주소:%s \n", m_id, m_name, m_tel, m_sex,
				m_birth, m_address);
		return str;
	}
}