package HealthClub;

import java.text.SimpleDateFormat;


import java.util.Calendar;
import java.util.Date;
import java.util.ArrayList;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.FileOutputStream;
import java.io.OutputStream;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumnModel;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;
import javax.swing.JTextPane;
import javax.swing.BoxLayout;

import Calendar.*;
import java.awt.GridBagLayout;
import java.awt.Panel;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import javax.swing.JMenuBar;
import javax.swing.JProgressBar;

public class GUI {
	JFrame frame;

	static boolean memberlogin;
	static boolean managerlogin;

	static ArrayList<String> MemberID = Member.MemberID_check();
	static ArrayList<String> trainerID = Trainer.TrainerID_check();

	private JTextField pntext2;
	private JTextField pntext1;
	private JTextField addresstext;
	private JTextField nametext;
	private JTextField UpdatetextField;

	public static String loginID = null;

	public static DefaultTableModel model = new DefaultTableModel(Member.colNames, 0);

	public static String after1;
	public static String after2;
	public static String co;
	public static String before1;

	String cb_birth = null;
	String cb_year = "1900";
	String cb_month = "01";
	String cb_day = "01";
	String cb_pntext0 = "010";

	ImageIcon icon = new ImageIcon(Toolkit.getDefaultToolkit().getImage(getClass().getResource("gym_icon.png")));

	public GUI() {
		initialize();
	}

	public void initialize() {
		frame = new JFrame("Health Club");
		frame.setBounds(100, 100, 462, 450);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setIconImage(icon.getImage());
		frame.setLocationRelativeTo(null);

		JPanel myPage = new JPanel();
		myPage.setBackground(Color.DARK_GRAY);
		myPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(myPage);
		myPage.setLayout(null);

		JButton btnBackmy = new JButton("\uC774\uC804");
		btnBackmy.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBackmy.setBackground(Color.ORANGE);
		btnBackmy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnBackmy.setBounds(337, 378, 97, 23);
		myPage.add(btnBackmy);

		JPanel myInfo = new JPanel();
		myInfo.setBackground(Color.LIGHT_GRAY);
		myInfo.setBounds(12, 55, 422, 279);
		myPage.add(myInfo);
		myInfo.setLayout(null);

		Panel myshipinfo_2 = new Panel();
		myshipinfo_2.setBackground(Color.GRAY);
		myshipinfo_2.setBounds(10, 10, 400, 259);
		myInfo.add(myshipinfo_2);

		// 나의 정보확인에서 내가 구매한 회원권 정보
		DefaultTableCellRenderer dtcr = new DefaultTableCellRenderer();
		String[] MIheading = new String[] { "MembershipCode", "MembershipOption", "MembershipPrice" };
		Object[][] MIdata = new Object[][] { { "회원권 코드", "회원권 옵션", "회원권 가격", }, { "", "", "" } };
		myshipinfo_2.setLayout(null);

		JPanel x_PTinfo_panel = new JPanel();
		x_PTinfo_panel.setBackground(Color.WHITE);
		x_PTinfo_panel.setBounds(7, 210, 387, 29);
		myshipinfo_2.add(x_PTinfo_panel);

		JLabel x_PTInfo = new JLabel(" \uC774\uC6A9\uC911\uC778 PT\uAD8C\uC774 \uC5C6\uC2B5\uB2C8\uB2E4.");
		x_PTInfo.setHorizontalAlignment(SwingConstants.CENTER);
		x_PTInfo.setForeground(Color.RED);
		x_PTInfo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		x_PTInfo.setBackground(Color.WHITE);
		x_PTinfo_panel.add(x_PTInfo);
		x_PTinfo_panel.setVisible(false);

		JPanel x_shipinfo_panel = new JPanel();
		x_shipinfo_panel.setBackground(Color.WHITE);
		x_shipinfo_panel.setBounds(7, 65, 387, 29);
		myshipinfo_2.add(x_shipinfo_panel);

		JLabel x_shipInfo = new JLabel(
				"   \uC774\uC6A9\uC911\uC778 \uD68C\uC6D0\uAD8C\uC774 \uC5C6\uC2B5\uB2C8\uB2E4.");
		x_shipInfo.setHorizontalAlignment(SwingConstants.CENTER);
		x_shipInfo.setForeground(Color.RED);
		x_shipInfo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		x_shipInfo.setBackground(Color.WHITE);
		x_shipinfo_panel.add(x_shipInfo);

		x_shipinfo_panel.setVisible(false);

		JLabel shipoptionInfo = new JLabel("");
		shipoptionInfo.setBounds(139, 68, 123, 24);
		myshipinfo_2.add(shipoptionInfo);

		JLabel pttimeInfo = new JLabel("");
		pttimeInfo.setBounds(246, 212, 68, 24);
		myshipinfo_2.add(pttimeInfo);

		JLabel ptcodeInfo = new JLabel("");
		ptcodeInfo.setBounds(7, 213, 68, 24);
		myshipinfo_2.add(ptcodeInfo);

		JLabel ptpartInfo = new JLabel("");
		ptpartInfo.setBounds(326, 213, 64, 24);
		myshipinfo_2.add(ptpartInfo);

		JLabel shipcodeInfo = new JLabel("");
		shipcodeInfo.setBounds(7, 68, 78, 24);
		shipcodeInfo.setHorizontalAlignment(JLabel.CENTER);
		myshipinfo_2.add(shipcodeInfo);

		JLabel pttrainerInfo = new JLabel("");
		pttrainerInfo.setBounds(86, 213, 68, 24);
		myshipinfo_2.add(pttrainerInfo);

		JLabel ptpriceInfo = new JLabel("");
		ptpriceInfo.setBounds(166, 213, 68, 24);
		myshipinfo_2.add(ptpriceInfo);

		JLabel shippriceInfo = new JLabel("");
		shippriceInfo.setBounds(271, 67, 123, 24);
		myshipinfo_2.add(shippriceInfo);

		JTable shipinfo_table = new JTable(MIdata, MIheading);
		shipinfo_table.setBounds(0, 35, 400, 60);
		myshipinfo_2.add(shipinfo_table);

		shipinfo_table.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		myshipinfo_2.add(shipinfo_table);
		shipinfo_table.setRowHeight(30);

		TableColumnModel tcm5 = shipinfo_table.getColumnModel();
		for (int i = 0; i < 3; i++) {
			tcm5.getColumn(i).setCellRenderer(dtcr);
		}
		;

		shipinfo_table.getColumn("MembershipCode").setPreferredWidth(100);
		shipinfo_table.getColumn("MembershipOption").setPreferredWidth(160);
		shipinfo_table.getColumn("MembershipPrice").setPreferredWidth(160);

		// 나의 정보확인에서 내가 구매한 PT권 정보
		String[] PIheading = new String[] { "PTCode", "TrainerID", "PTPrice", "PTTime", "PTExersiceSection" };
		Object[][] PIdata = new Object[][] { { "PT권 코드", "담당 트레이너", "PT권 가격", "PT 시간", "헬스파트" },
				{ "", "", "", "", "" } };
		myshipinfo_2.setLayout(null);

		JTable ptinfo_table = new JTable(PIdata, PIheading);
		ptinfo_table.setBounds(0, 180, 400, 60);
		myshipinfo_2.add(ptinfo_table);

		ptinfo_table.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		myshipinfo_2.add(ptinfo_table);
		ptinfo_table.setRowHeight(30);

		TableColumnModel tcm6 = ptinfo_table.getColumnModel();
		for (int i = 0; i < 5; i++) {
			tcm6.getColumn(i).setCellRenderer(dtcr);
		}
		;

		ptinfo_table.getColumn("PTCode").setPreferredWidth(100);
		ptinfo_table.getColumn("TrainerID").setPreferredWidth(170);
		ptinfo_table.getColumn("PTPrice").setPreferredWidth(170);
		ptinfo_table.getColumn("PTTime").setPreferredWidth(170);
		ptinfo_table.getColumn("PTExersiceSection").setPreferredWidth(170);

		JLabel lbl_1 = new JLabel("\uC774\uC6A9\uC911\uC778 \uD68C\uC6D0\uAD8C \uC815\uBCF4");
		lbl_1.setBounds(12, 10, 195, 15);
		lbl_1.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		myshipinfo_2.add(lbl_1);

		JLabel lbl_2 = new JLabel("\uC774\uC6A9\uC911\uC778 PT\uAD8C \uC815\uBCF4");
		lbl_2.setBounds(10, 155, 183, 15);
		lbl_2.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		myshipinfo_2.add(lbl_2);

		JPanel tle1 = new JPanel();
		tle1.setBounds(0, 114, 400, 31);
		tle1.setBackground(Color.LIGHT_GRAY);
		myshipinfo_2.add(tle1);

		JPanel mypnel1 = new JPanel();
		mypnel1.setBackground(Color.GRAY);
		mypnel1.setBounds(12, 10, 398, 259);
		myInfo.add(mypnel1);
		mypnel1.setLayout(null);

		JLabel lblmemberinfo7 = new JLabel("\uD68C \uC6D0 \uAD8C");
		lblmemberinfo7.setBounds(21, 185, 68, 22);
		mypnel1.add(lblmemberinfo7);
		lblmemberinfo7.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		JLabel lblmemberinfo8 = new JLabel("PT\uC774\uC6A9\uAD8C");
		lblmemberinfo8.setBounds(21, 211, 68, 22);
		mypnel1.add(lblmemberinfo8);
		lblmemberinfo8.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		JLabel lblmemberinfo1 = new JLabel("\uD68C\uC6D0\uBC88\uD638");
		lblmemberinfo1.setBounds(21, 23, 68, 22);
		mypnel1.add(lblmemberinfo1);
		lblmemberinfo1.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		JLabel lblmemberinfo2 = new JLabel("\uC774     \uB984");
		lblmemberinfo2.setBounds(21, 50, 68, 22);
		mypnel1.add(lblmemberinfo2);
		lblmemberinfo2.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		JLabel lblmemberinfo3 = new JLabel("\uC131     \uBCC4");
		lblmemberinfo3.setBounds(21, 77, 68, 22);
		mypnel1.add(lblmemberinfo3);
		lblmemberinfo3.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		JLabel lblmemberinfo4 = new JLabel("\uC804\uD654\uBC88\uD638");
		lblmemberinfo4.setBounds(21, 104, 68, 22);
		mypnel1.add(lblmemberinfo4);
		lblmemberinfo4.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		JLabel lblmemberinfo5 = new JLabel("\uC0DD\uB144\uC6D4\uC77C");
		lblmemberinfo5.setBounds(21, 131, 68, 22);
		mypnel1.add(lblmemberinfo5);
		lblmemberinfo5.setFont(new Font("맑은 고딕", Font.BOLD, 15));

		JLabel lblmemberinfo6 = new JLabel("\uC8FC     \uC18C");
		lblmemberinfo6.setBounds(21, 158, 68, 22);
		mypnel1.add(lblmemberinfo6);
		lblmemberinfo6.setFont(new Font("맑은 고딕", Font.BOLD, 16));

		JPanel mypnel2 = new JPanel();
		mypnel2.setBackground(Color.WHITE);
		mypnel2.setBounds(103, 0, 295, 259);
		mypnel1.add(mypnel2);
		mypnel2.setLayout(null);

		JLabel memberinfo1 = new JLabel("");
		memberinfo1.setForeground(Color.BLACK);
		memberinfo1.setBounds(13, 26, 269, 20);
		memberinfo1.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo1);

		JLabel memberinfo2 = new JLabel("");
		memberinfo2.setForeground(Color.BLACK);
		memberinfo2.setBounds(13, 52, 269, 20);
		memberinfo2.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo2);

		JLabel memberinfo3 = new JLabel("");
		memberinfo3.setForeground(Color.BLACK);
		memberinfo3.setBounds(13, 78, 269, 20);
		memberinfo3.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo3);

		JLabel memberinfo4 = new JLabel("");
		memberinfo4.setForeground(Color.BLACK);
		memberinfo4.setBounds(13, 104, 269, 20);
		memberinfo4.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo4);

		JLabel memberinfo5 = new JLabel("");
		memberinfo5.setForeground(Color.BLACK);
		memberinfo5.setBounds(13, 130, 269, 20);
		memberinfo5.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo5);

		JLabel memberinfo6 = new JLabel("");
		memberinfo6.setForeground(Color.BLACK);
		memberinfo6.setBounds(13, 156, 269, 20);
		memberinfo6.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo6);

		JLabel memberinfo7 = new JLabel("");
		memberinfo7.setForeground(Color.BLACK);
		memberinfo7.setBounds(13, 185, 131, 20);
		memberinfo7.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo7);

		JLabel memberinfo8 = new JLabel("");
		memberinfo8.setForeground(Color.BLACK);
		memberinfo8.setBounds(13, 211, 132, 20);
		memberinfo8.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		mypnel2.add(memberinfo8);

		JButton btnInfo = new JButton("\uC790\uC138\uD788\uBCF4\uAE30");
		btnInfo.setForeground(Color.DARK_GRAY);
		btnInfo.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnInfo.setBackground(Color.ORANGE);
		btnInfo.setBounds(184, 178, 111, 27);

		JButton btnMore = new JButton("\uC790\uC138\uD788\uBCF4\uAE30");
		btnMore.setForeground(Color.DARK_GRAY);
		btnMore.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		btnMore.setBackground(Color.ORANGE);
		btnMore.setBounds(184, 191, 111, 35);
		mypnel2.add(btnMore);

		JLabel lblMy = new JLabel("\uB098\uC758 \uC815\uBCF4\uD655\uC778");
		lblMy.setForeground(Color.ORANGE);
		lblMy.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblMy.setBounds(12, 10, 124, 33);
		myPage.add(lblMy);

		JButton btnCalmy = new JButton("\uCE98\uB9B0\uB354");
		btnCalmy.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnCalmy.setBackground(Color.ORANGE);
		btnCalmy.setBounds(337, 345, 97, 23);
		myPage.add(btnCalmy);

		JPanel managementPage = new JPanel();
		managementPage.setBackground(Color.DARK_GRAY);
		managementPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(managementPage);

		// 컬럼 추가 메소드 실행
		Member.MemberList();

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);

		JTable mb_table = new JTable(model);
		mb_table.setRowHeight(25);
		mb_table.setFillsViewportHeight(true);
		mb_table.getTableHeader().setReorderingAllowed(false);
		mb_table.getTableHeader().setResizingAllowed(false);
		mb_table.setForeground(Color.BLACK);
		mb_table.setBackground(Color.WHITE);

		// 셀 너비 조정
		mb_table.getColumn("회원번호").setPreferredWidth(35);
		mb_table.getColumn("이름").setPreferredWidth(30);
		mb_table.getColumn("성별").setPreferredWidth(30);
		mb_table.getColumn("전화번호").setPreferredWidth(65);
		mb_table.getColumn("생년월일").setPreferredWidth(45);
		mb_table.getColumn("주소").setPreferredWidth(70);

		// 셀 가운데 정렬
		TableColumnModel tcm = mb_table.getColumnModel();
		for (int i = 0; i < 5; i++) {
			tcm.getColumn(i).setCellRenderer(dtcr);
		}
		;

		
		JButton btnDelete = new JButton("\uC120\uD0DD\uD68C\uC6D0\uC0AD\uC81C");
		btnDelete.setBackground(Color.ORANGE);
		btnDelete.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btnDelete.setBounds(337, 312, 97, 23);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TableUpdate.Delete();
				JOptionPane.showMessageDialog(null, "회원번호: " + after1 + "의 회원정보가 삭제되었습니다.");
			}
		});

		JLabel updatelabel = new JLabel("\uC218\uC815 \uD56D\uBAA9");
		updatelabel.setForeground(Color.WHITE);
		updatelabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		updatelabel.setBounds(116, 345, 85, 23);
		managementPage.add(updatelabel);

		JLabel selectlabel = new JLabel("\uC120\uD0DD \uD56D\uBAA9 ");
		selectlabel.setForeground(Color.WHITE);
		selectlabel.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		selectlabel.setBounds(116, 312, 85, 23);
		managementPage.add(selectlabel);

		JLabel Updatebefore = new JLabel("");
		Updatebefore.setHorizontalAlignment(SwingConstants.CENTER);
		Updatebefore.setForeground(Color.BLACK);
		Updatebefore.setFont(new Font("맑은 고딕", Font.BOLD, 14));
		Updatebefore.setBounds(204, 311, 100, 25);
		managementPage.add(Updatebefore);

		JPanel selectpanel = new JPanel();
		selectpanel.setBackground(Color.WHITE);
		selectpanel.setBounds(183, 312, 142, 23);
		managementPage.add(selectpanel);

		JLabel label_12 = new JLabel("\uD68C\uC6D0\uC815\uBCF4\uAD00\uB9AC");
		label_12.setForeground(Color.ORANGE);
		label_12.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		label_12.setBounds(12, 10, 143, 33);
		managementPage.add(label_12);
		managementPage.add(btnDelete);

		JButton btnUpdatecell = new JButton("\uC120\uD0DD\uC815\uBCF4\uC218\uC815");
		btnUpdatecell.setFont(new Font("맑은 고딕", Font.BOLD, 10));
		btnUpdatecell.setBackground(Color.ORANGE);
		btnUpdatecell.setBounds(337, 345, 97, 23);
		btnUpdatecell.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				after2 = UpdatetextField.getText();
				TableUpdate.Update();
				JOptionPane.showMessageDialog(null, "회원번호: " + after1 + "의 회원정보가 수정되었습니다.");
			}
		});
		managementPage.add(btnUpdatecell);

		

		JTableHeader header = mb_table.getTableHeader();
		managementPage.add(header, BorderLayout.NORTH);
		managementPage.setLayout(null);
		managementPage.add(mb_table, FlowLayout.CENTER);

		JScrollPane pane = new JScrollPane(mb_table);

		UpdatetextField = new JTextField();
		UpdatetextField.setBounds(183, 345, 142, 23);
		UpdatetextField.setColumns(10);
		UpdatetextField.setHorizontalAlignment(JTextField.CENTER);
		managementPage.add(UpdatetextField);
		JPanel managerPage = new JPanel();
		managerPage.setBackground(Color.DARK_GRAY);
		managerPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(managerPage);
		managerPage.setLayout(null);

		JLabel lblNewLabel_6 = new JLabel("  \uC9C0\uC815\uB41C \uAD00\uB9AC\uC790");
		lblNewLabel_6.setForeground(Color.RED);
		lblNewLabel_6.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		lblNewLabel_6.setBounds(0, 75, 150, 40);
		managerPage.add(lblNewLabel_6);

		JButton btnMember = new JButton("\uD68C\uC6D0\uC815\uBCF4\uC218\uC815");
		btnMember.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMember.setBackground(Color.ORANGE);
		btnMember.setBounds(88, 215, 240, 50);
		managerPage.add(btnMember);

		JButton btnSignup = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnSignup.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnSignup.setBackground(Color.ORANGE);
		btnSignup.setBounds(88, 145, 240, 50);
		managerPage.add(btnSignup);

		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 130, 445, 150);
		managerPage.add(panel_3);

		JLabel label_MgAnna = new JLabel("                 \uB97C \uD1B5\uD574 \uD68C\uC6D0\uAC00\uC785\uACFC \uC218\uC815\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		label_MgAnna.setForeground(Color.BLACK);
		label_MgAnna.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		label_MgAnna.setBounds(25, 75, 395, 40);
		managerPage.add(label_MgAnna);

		JLabel lblNewLabel_1 = new JLabel("\uAD00\uB9AC\uC790\uBA54\uB274");
		lblNewLabel_1.setForeground(Color.ORANGE);
		lblNewLabel_1.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_1.setBounds(12, 10, 98, 33);
		managerPage.add(lblNewLabel_1);

		JButton btnbackstart = new JButton("\uC774\uC804");
		btnbackstart.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnbackstart.setBackground(Color.ORANGE);
		btnbackstart.setBounds(165, 327, 112, 43);
		managerPage.add(btnbackstart);

		JPanel panel_MgMain = new JPanel();
		panel_MgMain.setBackground(Color.LIGHT_GRAY);
		panel_MgMain.setBounds(0, 115, 445, 178);
		managerPage.add(panel_MgMain);

		JPanel panel_MgTitle = new JPanel();
		panel_MgTitle.setBounds(0, 75, 445, 40);
		managerPage.add(panel_MgTitle);
		JButton btnBackmanager2 = new JButton("\uC774\uC804");
		btnBackmanager2.setSize(97, 23);
		btnBackmanager2.setLocation(337, 378);
		btnBackmanager2.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBackmanager2.setBackground(Color.ORANGE);
		btnBackmanager2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				managementPage.setVisible(false);
				managerPage.setVisible(true);
			}
		});
		managementPage.add(btnBackmanager2);

		pane.setBounds(10, 54, 424, 252);
		managementPage.add(pane);
		managementPage.setVisible(false);

		JPanel signupPage = new JPanel();
		signupPage.setForeground(Color.WHITE);
		signupPage.setBackground(Color.DARK_GRAY);
		signupPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(signupPage);
		signupPage.setLayout(null);

		JButton btnBackterms = new JButton("\uC774\uC804");
		btnBackterms.setBounds(337, 378, 97, 23);
		btnBackterms.setFont(new Font("맑은 고딕", Font.BOLD, 12));

		btnBackterms.setBackground(Color.ORANGE);
		signupPage.add(btnBackterms);

		JPanel SelectSex = new JPanel();
		SelectSex.setBounds(51, 137, 345, 33);
		SelectSex.setBackground(Color.DARK_GRAY);
		signupPage.add(SelectSex);
		SelectSex.setLayout(null);

		JLabel SexLabel = new JLabel("\uC131     \uBCC4 : ");
		SexLabel.setBounds(0, 4, 80, 20);
		SexLabel.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		SexLabel.setForeground(Color.ORANGE);
		SelectSex.add(SexLabel);

		JRadioButton rdbtnMan = new JRadioButton("\uB0A8\uC131");
		rdbtnMan.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		rdbtnMan.setBounds(78, 6, 67, 23);
		rdbtnMan.setForeground(Color.ORANGE);
		rdbtnMan.setBackground(Color.DARK_GRAY);
		SelectSex.add(rdbtnMan);

		JRadioButton rdbtnWoman = new JRadioButton("\uC5EC\uC131");
		rdbtnWoman.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		rdbtnWoman.setBounds(139, 6, 63, 23);
		rdbtnWoman.setForeground(Color.ORANGE);
		rdbtnWoman.setBackground(Color.DARK_GRAY);
		SelectSex.add(rdbtnWoman);

		rdbtnMan.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnMan.isSelected()) {
					rdbtnMan.setSelected(true);
					rdbtnWoman.setSelected(false);
				}
			}
		});

		rdbtnWoman.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnWoman.isSelected()) {
					rdbtnMan.setSelected(false);
					rdbtnWoman.setSelected(true);
				}
			}
		});

		JPanel SelectTel = new JPanel();
		SelectTel.setBackground(Color.DARK_GRAY);
		SelectTel.setBounds(51, 175, 345, 34);
		signupPage.add(SelectTel);
		SelectTel.setLayout(new BoxLayout(SelectTel, BoxLayout.X_AXIS));

		JLabel label_9 = new JLabel("\uC804\uD654\uBC88\uD638 : ");
		label_9.setForeground(Color.ORANGE);
		label_9.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		SelectTel.add(label_9);

		JComboBox pntext0 = new JComboBox(new Object[] {});
		pntext0.setModel(new DefaultComboBoxModel(new String[] { "010", "011", "016", "017", "018" }));
		pntext0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_pntext0 = pntext0.getSelectedItem().toString();
			}
		});
		pntext0.setToolTipText("");
		pntext0.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		SelectTel.add(pntext0);

		JLabel label_10 = new JLabel("-");
		label_10.setForeground(Color.WHITE);
		label_10.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		SelectTel.add(label_10);

		pntext1 = new JTextField();
		SelectTel.add(pntext1);
		pntext1.setColumns(10);

		JLabel label_11 = new JLabel("-");
		label_11.setForeground(Color.WHITE);
		label_11.setFont(new Font("맑은 고딕", Font.PLAIN, 14));
		SelectTel.add(label_11);

		pntext2 = new JTextField();
		pntext2.setColumns(10);
		SelectTel.add(pntext2);

		JPanel SelectBirth = new JPanel();
		SelectBirth.setBackground(Color.DARK_GRAY);
		SelectBirth.setBounds(51, 219, 345, 33);
		signupPage.add(SelectBirth);
		SelectBirth.setLayout(new BoxLayout(SelectBirth, BoxLayout.X_AXIS));

		JLabel label_5 = new JLabel("\uC0DD\uB144\uC6D4\uC77C : ");
		label_5.setForeground(Color.ORANGE);
		label_5.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		SelectBirth.add(label_5);

		ArrayList<String> ComYear = new ArrayList<String>();
		for (int i = 1900; i <= Calendar.getInstance().get(Calendar.YEAR); i++) {
			ComYear.add(i + "");
		}
		JComboBox b_year = new JComboBox(ComYear.toArray());
		b_year.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_year = b_year.getSelectedItem().toString();
			}
		});
		b_year.setToolTipText("");
		b_year.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		SelectBirth.add(b_year);

		JLabel label_6 = new JLabel(" \uB144 ");
		label_6.setForeground(Color.ORANGE);
		label_6.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		SelectBirth.add(label_6);

		JComboBox b_month = new JComboBox();
		b_month.setModel(new DefaultComboBoxModel(
				new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09", "10", "11", "12" }));
		b_month.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_month = b_month.getSelectedItem().toString();
			}
		});
		b_month.setToolTipText("");
		b_month.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		SelectBirth.add(b_month);

		JLabel label_7 = new JLabel(" \uC6D4 ");
		label_7.setForeground(Color.ORANGE);
		label_7.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		SelectBirth.add(label_7);

		JComboBox b_day = new JComboBox();
		b_day.setModel(new DefaultComboBoxModel(new String[] { "01", "02", "03", "04", "05", "06", "07", "08", "09",
				"10", "11", "12", "13", "14", "15", "16", "17", "18", "19", "20", "21", "22", "23", "24", "25", "26",
				"27", "28", "29", "30", "31" }));
		b_day.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				cb_day = b_day.getSelectedItem().toString();
			}
		});
		b_day.setToolTipText("");
		b_day.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		SelectBirth.add(b_day);

		JLabel label_8 = new JLabel(" \uC77C ");
		label_8.setForeground(Color.ORANGE);
		label_8.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		SelectBirth.add(label_8);

		JPanel panel = new JPanel();
		panel.setBackground(Color.DARK_GRAY);
		panel.setBounds(51, 262, 345, 34);
		signupPage.add(panel);
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JLabel lblNewLabel_3 = new JLabel("\uC8FC\uC18C : ");
		lblNewLabel_3.setForeground(Color.ORANGE);
		lblNewLabel_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel.add(lblNewLabel_3);

		addresstext = new JTextField();
		panel.add(addresstext);
		addresstext.setColumns(10);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.DARK_GRAY);
		panel_1.setBounds(51, 94, 345, 33);
		signupPage.add(panel_1);
		panel_1.setLayout(new BoxLayout(panel_1, BoxLayout.X_AXIS));

		JLabel lblNewLabel_4 = new JLabel("\uC131\uD568 : ");
		lblNewLabel_4.setForeground(Color.ORANGE);
		lblNewLabel_4.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		panel_1.add(lblNewLabel_4);

		nametext = new JTextField();
		panel_1.add(nametext);
		nametext.setColumns(10);

		JPanel menuPage = new JPanel();
		menuPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(menuPage);
		menuPage.setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(Color.DARK_GRAY);
		panel_4.setBounds(0, 0, 446, 411);
		menuPage.add(panel_4);
		panel_4.setLayout(null);

		JButton btnOut = new JButton("\uD1F4\uC7A5\uC2DC\uAC04");
		btnOut.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnOut.setBackground(Color.ORANGE);
		btnOut.setBounds(167, 285, 112, 63);
		panel_4.add(btnOut);

		JButton btnMs = new JButton("\uD68C\uC6D0\uC774\uC6A9\uAD8C \uAD6C\uB9E4");
		btnMs.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMs.setBackground(Color.ORANGE);
		btnMs.setBounds(43, 223, 359, 52);
		panel_4.add(btnMs);

		JButton btnMy = new JButton("\uB098\uC758 \uC815\uBCF4 \uD655\uC778");
		btnMy.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnMy.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMy.setBackground(Color.ORANGE);
		btnMy.setBounds(43, 99, 359, 52);
		panel_4.add(btnMy);

		JButton btnPt = new JButton("PT \uC774\uC6A9\uAD8C \uAD6C\uB9E4");
		btnPt.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnPt.setBackground(Color.ORANGE);
		btnPt.setBounds(43, 161, 359, 52);
		panel_4.add(btnPt);

		JButton btnIn = new JButton("\uCD9C\uC11D\uC2DC\uAC04");
		btnIn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnIn.setBackground(Color.ORANGE);
		btnIn.setBounds(43, 285, 112, 63);
		panel_4.add(btnIn);

		JButton btnBefore = new JButton("\uB098\uAC00\uAE30");
		btnBefore.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnBefore.setBackground(Color.ORANGE);
		btnBefore.setBounds(290, 285, 112, 63);
		panel_4.add(btnBefore);

		JLabel lblNewLabel = new JLabel("\uD68C\uC6D0 \uBA54\uB274");
		lblNewLabel.setForeground(Color.ORANGE);
		lblNewLabel.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel.setBounds(12, 10, 112, 33);
		panel_4.add(lblNewLabel);

		JLabel time = new JLabel();
		time.setHorizontalAlignment(SwingConstants.RIGHT);
		time.setForeground(Color.ORANGE);
		time.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		time.setText("2020-10-23 12:05");

		JLabel label_1 = new JLabel("\uC800\uD76C \uD718\uD2B8\uB2C8\uC2A4 \uD074\uB7FD\uC5D0");
		label_1.setBounds(0, 66, 149, 40);
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		label_1.setForeground(Color.ORANGE);
		label_1.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 14));
		label_1.setBackground(Color.WHITE);
		menuPage.add(label_1);

		JPanel termsPage = new JPanel();
		termsPage.setBackground(Color.DARK_GRAY);
		termsPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(termsPage);
		termsPage.setLayout(null);

		JButton btnBackmanager = new JButton("\uC774\uC804");
		btnBackmanager.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnBackmanager.setBounds(337, 378, 97, 23);
		btnBackmanager.setBackground(Color.ORANGE);
		termsPage.add(btnBackmanager);

		JLabel lblNewLabel_2 = new JLabel("\uC774\uC6A9\uC57D\uAD00\uB3D9\uC758");
		lblNewLabel_2.setForeground(Color.ORANGE);
		lblNewLabel_2.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		lblNewLabel_2.setBounds(12, 10, 124, 33);
		termsPage.add(lblNewLabel_2);

		JCheckBox checkbox3 = new JCheckBox(
				" \uD5EC\uC2A4\uC7A5 \uC774\uC6A9\uC57D\uAD00 \uB3D9\uC758        (\uD544\uC218)");
		checkbox3.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		checkbox3.setSelected(false);
		checkbox3.setBackground(Color.ORANGE);
		checkbox3.setBounds(8, 49, 211, 23);
		termsPage.add(checkbox3);

		JCheckBox checkbox2 = new JCheckBox(
				" \uD5EC\uC2A4\uC7A5 \uD658\uBD88 \uADDC\uC815 \uB3D9\uC758       (\uD544\uC218)");
		checkbox2.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		checkbox2.setBackground(Color.ORANGE);
		checkbox2.setBounds(8, 146, 211, 23);
		termsPage.add(checkbox2);

		JCheckBox checkbox4 = new JCheckBox(
				" \uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC774\uC6A9 \uB3D9\uC758(\uD544\uC218)");
		checkbox4.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		checkbox4.setBackground(Color.ORANGE);
		checkbox4.setBounds(8, 244, 211, 23);
		termsPage.add(checkbox4);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(8, 77, 426, 63);
		termsPage.add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textPane.setText(
				"\uC81C1\uC870(\uBAA9\uC801) \uC774 \uC57D\uAD00\uC740 \u25CB\u25CB\uCCB4\uB825\uB2E8\uB828\uC7A5\uACFC \uCCB4\uB825\uB2E8\uB828\uC7A5\uC774 \uC81C\uACF5\uD558\uB294 \uC2DC\uC124 \uBC0F \uC11C\uBE44\uC2A4\uB97C \uC774\uC6A9\uD558\uB294 \uC790(\uC774\uD558 \u2018\uC774\uC6A9\uC790\u2019\uB77C \uD569\uB2C8\uB2E4) \uC0AC\uC774\uC5D0 \uCCB4\uACB0\uB41C \uACC4\uC57D\uC5D0 \uB530\uB978 \uAD8C\uB9AC\u2024\uC758\uBB34\uC5D0 \uAD00\uD55C \uC0AC\uD56D\uC744 \uC815\uD568\uC744 \uBAA9\uC801\uC73C\uB85C \uD569\uB2C8\uB2E4.\r\n\r\n\uC81C2\uC870(\uC801\uC6A9\uB300\uC0C1) \uC774 \uC57D\uAD00\uC740 \u25CB\u25CB\uCCB4\uB825\uB2E8\uB828\uC7A5\uC744 \uC774\uC6A9\uD558\uB294 \uBAA8\uB4E0 \uC774\uC6A9\uC790\uC5D0\uAC8C \uC801\uC6A9\uD569\uB2C8\uB2E4.\r\n\r\n\uC81C3\uC870(\uC774\uC6A9\uACC4\uC57D \uBC0F \uC57D\uAD00 \uAD50\uBD80)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uB294 \uCCB4\uB825\uB2E8\uB828\uC7A5(\uC774\uD558 \u2018\uC0AC\uC5C5\uC790\u2019\uB77C \uD569\uB2C8\uB2E4)\uC774 \uC815\uD55C \uC808\uCC28\uC5D0 \uB530\uB77C \uC774\uC6A9 \uC2E0\uCCAD\uC744 \uD558\uACE0 \uC774\uC6A9\uB8CC\uB97C \uB0A9\uBD80\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC0AC\uC5C5\uC790\uB294 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC2E0\uCCAD\uC744 \uC2B9\uB099\uD560 \uACBD\uC6B0 \uC774\uC6A9\uC790\uC5D0\uAC8C \uC774\uC6A9\uC99D\uACFC \uC57D\uC2DD \uC57D\uAD00(\uC774\uC6A9\uC99D \uC774\uBA74\uC5D0 \uCCA8\uBD80)\uC744 \uAD50\uBD80\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2462 \uC0AC\uC5C5\uC790\uB294 \uC81C2\uD56D\uC758 \uC57D\uC2DD\uC57D\uAD00\uC758 \uAD50\uBD80\uC5D0 \uAD00\uACC4\uC5C6\uC774 \uC774\uC6A9\uC790\uAC00 \uC694\uAD6C\uD560 \uACBD\uC6B0 \uC57D\uAD00\uC758 \uC0AC\uBCF8\uC744 \uAD50\uBD80\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n\uC81C4\uC870(\uAC8C\uC2DC\u2024\uC124\uBA85\uC758\uBB34)\r\n\r\n  \u2460 \uC0AC\uC5C5\uC790\uB294 \uC774\uC6A9\uC790\uAC00 \uC6A9\uC774\uD558\uAC8C \uBCFC \uC218 \uC788\uB294 \uC7A5\uC18C\uC5D0 \uB2E4\uC74C \uC0AC\uD56D\uC744 \uAC8C\uC2DC\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n    1. \uC2DC\uAC04\uBCC4 \uD504\uB85C\uADF8\uB7A8 \uB0B4\uC6A9 \uBC0F \uC815\uC6D0\r\n    2. \uC9C0\uB3C4\uAC15\uC0AC\uC758 \uC778\uC801\uC0AC\uD56D\r\n    3. \uAC15\uC2B5\uC758 \uBCC0\uACBD\r\n    4. \uC774\uC6A9\uB8CC\r\n    5. \uC57D\uAD00\uB0B4\uC6A9\r\n    6. \uC18C\uC9C0\uD488 \uBCF4\uAD00\uC2DC \uC720\uC758 \uC0AC\uD56D \uB4F1\r\n    7. \uC774\uC6A9\uC790 \uC548\uC804\uC218\uCE59 \uB4F1 \uAE30\uD0C0 \uD544\uC694\uC0AC\uD56D\r\n\r\n  \u2461 \uC0AC\uC5C5\uC790\uB294 \uC774\uC6A9\uC790\uAC00 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC2DC\uC124 \uBC0F \uAE30\uAD6C\uB97C \uC548\uC804\uD558\uAC8C \uC774\uC6A9\uD560 \uC218 \uC788\uB3C4\uB85D \uC774\uC6A9\uBC29\uBC95 \uBC0F \uC8FC\uC758\uC0AC\uD56D \uC124\uBA85 \uB4F1 \uC120\uB7C9\uD55C \uAD00\uB9AC\uC790\uB85C\uC11C \uC758\uBB34\uB97C \uB2E4\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n\uC81C5\uC870(\uC774\uC6A9\uC99D \uC81C\uC2DC)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uB294 \uC0AC\uC5C5\uC790\uAC00 \uC774\uC6A9\uC99D \uC81C\uC2DC\uB97C \uC694\uAD6C\uD560 \uACBD\uC6B0 \uC774\uC6A9\uC99D\uC744 \uC81C\uC2DC\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC774\uC6A9\uC790\uB294 \uC774\uC6A9\uC99D\uC744 \uBD84\uC2E4\uD558\uC600\uC744 \uACBD\uC6B0 \uC9C0\uCCB4\uC5C6\uC774 \uC0AC\uC5C5\uC790\uC5D0\uAC8C \uADF8 \uC0AC\uC2E4\uC744 \uD1B5\uC9C0 \uD558\uACE0 \uC7AC\uAD50\uBD80\uB97C \uBC1B\uC544\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n\uC81C6\uC870(\uC774\uC6A9\uC2E0\uCCAD \uCCA0\uD68C)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uAC00 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC744 \uD560\uBD80\uACC4\uC57D\uC73C\uB85C \uC2E0\uCCAD\uD55C \uACBD\uC6B0 \uC2E0\uCCAD\uC77C\uB85C\uBD80\uD130 7\uC77C \uC774\uB0B4 \uC11C\uBA74\uC73C\uB85C, \uBC29\uBB38\uC0AC\uC6D0 \uAD8C\uC720\uB85C \uC2E0\uCCAD\uD55C \uACBD\uC6B0\uC5D0\uB294 \uC2E0\uCCAD\uC77C\uB85C\uBD80\uD130 14\uC77C \uC774\uB0B4\uC5D0 \uC774\uC6A9\uC2E0\uCCAD\uC744 \uCCA0\uD68C\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4. \uB2E8 \uC2E0\uCCAD\uC77C\uC5D0 \uACC4\uC57D\uC11C(\uB610\uB294 \uC57D\uAD00)\uC744 \uAD50\uBD80\uBC1B\uC9C0 \uBABB\uD55C \uACBD\uC6B0 \uC774\uC6A9 \uAC1C\uC2DC\uC77C\uC744 \uAE30\uC900\uC73C\uB85C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC81C1\uD56D\uC758 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \u2018\uD560\uBD80\uAC70\uB798\uC5D0\uAD00\uD55C\uBC95\uB960\u2019 \uC81C6\uC870, \u2018\uBC29\uBB38\uD310\uB9E4\uB4F1\uC5D0\uAD00\uD55C\uBC95\uB960\u2019 \uC81C9\uC870\uC5D0 \uB530\uB978 \uC6D0\uC0C1\uD68C\uBCF5\uC758 \uC758\uBB34\uB97C \uC9D1\uB2C8\uB2E4.\r\n\r\n\uC81C7\uC870(\uC774\uC6A9 \uC5F0\uAE30)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uB294 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9 \uC804 \uB610\uB294 \uC774\uC6A9 \uC911  \uC5F0\uAE30\uAC00 \uD544\uC694\uD55C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uC640 \uD611\uC758\uD558\uC5EC \uC774\uC6A9\uC2DC\uAE30\uB97C \uC5F0\uAE30\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC81C1\uD56D\uC758 \uACBD\uC6B0\uC5D0 \uC774\uC6A9\uC790\uB294 \uC5F0\uAE30\uC2E0\uCCAD\uC11C\uB97C \uC0AC\uC5C5\uC790\uC5D0\uAC8C \uC81C\uCD9C\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4. \r\n\r\n  \u2462 \uC81C2\uD56D\uC758 \uC2E0\uCCAD\uC744 \uBC1B\uC740 \uC0AC\uC5C5\uC790\uB294 \uD2B9\uBCC4\uD55C \uC0AC\uC815\uC774 \uC5C6\uB294 \uD55C \uC2B9\uB099\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n\uC81C8\uC870(\uACC4\uC57D\uC758 \uD574\uC81C\u2024\uD574\uC9C0)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uB294 \uB2E4\uC74C \uAC01 \uD638\uC758 \uC0AC\uC720\uAC00 \uC788\uC744 \uACBD\uC6B0 \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n    1. \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC2DC\uC124 \uC774\uC6A9 \uBC0F \uAC15\uC2B5 \uB4F1\uC5D0 \uAD00\uD55C \uACC4\uC57D\uB0B4\uC6A9 \uB610\uB294 \uAD11\uACE0\uB0B4\uC6A9\uC774 \uC2E4\uC81C\uC640 \uB2E4\uB978 \uACBD\uC6B0\r\n    2. \uCCB4\uB825\uB2E8\uB828\uAE30\uAE30 \uBC0F \uC2DC\uC124\uC758 \uACE0\uC7A5\uC73C\uB85C \uC815\uC0C1\uC801\uC778 \uC774\uC6A9\uC774 \uACE4\uB780\uD55C \uACBD\uC6B0 \r\n    3. \uC774\uC804\u2024\uD734\uC5C5\u2024\uD3D0\uC5C5\u2024\uC815\uC6D0\uCD08\uACFC \uB4F1\uC73C\uB85C \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC774 \uACE4\uB780\uD55C \uACBD\uC6B0\r\n    4. \uAE30\uD0C0 \uC0AC\uC5C5\uC790\uC758 \uCC45\uC784 \uC788\uB294 \uC0AC\uC720\uB85C \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC774 \uACE4\uB780\uD55C \uACBD\uC6B0 \r\n\r\n  \u2461 \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD558\uB294 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uC640 \uC774\uC6A9\uC790\uB294 \uB2E4\uC74C\uACFC \uAC19\uC740 \uC870\uAC74\uC73C\uB85C \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n<\uC774\uC6A9\uAC1C\uC2DC\uC77C \uC774\uC804 \uACC4\uC57D \uD574\uC81C\u2024\uD574\uC9C0>\r\n\r\n    1. \uC81C1\uD56D \uAC01 \uD638\uC758 \uC0AC\uC720\uB85C \uC778\uD558\uC5EC \uC774\uC6A9\uC790\uAC00 \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD558\uB294 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uCD1D \uC774\uC6A9\uAE08\uC561(\u2018\uB9E4 \uC774\uC6A9 \uACC4\uC57D\uC2DC \uC774\uC6A9\uB8CC\uB85C \uB0A9\uC785\uD55C \uCD1D\uC561\u2019\uC73C\uB85C \uC774\uD558 \uAC19\uC74C) \uC804\uC561\uACFC \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uC744 \uC774\uC6A9\uC790\uC5D0\uAC8C \uD658\uBD88\uD569\uB2C8\uB2E4.\r\n    2. \uC774\uC6A9\uC790 \uC0AC\uC815\uC73C\uB85C \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD558\uB294 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uC744 \uACF5\uC81C\uD55C \uD6C4 \uC774\uC6A9\uC790\uC5D0\uAC8C \uD658\uBD88\uD569\uB2C8\uB2E4.\r\n\r\n<\uC774\uC6A9\uAC1C\uC2DC\uC77C \uC774\uD6C4 \uACC4\uC57D \uD574\uC81C\u2024\uD574\uC9C0>\r\n\r\n    1. \uC81C1\uD56D \uAC01 \uD638\uC758 \uC0AC\uC720\uB85C \uC774\uC6A9\uC790\uAC00 \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD558\uB294 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uCD1D \uC774\uC6A9\uAE08\uC561\uC5D0\uC11C \uD574\uC9C0\uC77C\uAE4C\uC9C0 \uC774\uC6A9\uAE08\uC561\uC744 \uC77C\uD560 \uACC4\uC0B0\uD558\uC5EC \uACF5\uC81C\uD558\uACE0 \uB09C \uD6C4\uC758 \uAE08\uC561\uACFC \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uC744 \uC774\uC6A9\uC790\uC5D0\uAC8C \uD658\uBD88\uD569\uB2C8\uB2E4.\r\n    2. \uC774\uC6A9\uC790 \uC0AC\uC815\uC73C\uB85C \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD558\uB294 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uCD1D \uC774\uC6A9\uAE08\uC561\uC744 \uAE30\uC900\uC73C\uB85C \uD574\uC9C0\uC77C\uAE4C\uC9C0 \uC774\uC6A9\uC77C\uC218\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uACFC \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uC744 \uACF5\uC81C\uD55C \uD6C4 \uC774\uC6A9\uC790\uC5D0\uAC8C \uD658\uBD88\uD569\uB2C8\uB2E4.\r\n\r\n  \u2462 \uACC4\uC57D\uC758 \uD574\uC81C\u2024\uD574\uC9C0\uC5D0\uB3C4 \uBD88\uAD6C\uD558\uACE0 \uC0AC\uC5C5\uC790\uAC00 \uC81C\uACF5\uD55C \uC0AC\uC740\uD488\uC740 \uBC18\uD658 \uB610\uB294 \uD658\uBD88\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.\r\n\r\n\uC81C9\uC870(\uC190\uD574\uBC30\uC0C1)\r\n\r\n  \u2460 \uCCB4\uB825\uB2E8\uB828\uC7A5\uC758 \uC2DC\uC124\uBB3C\uC5D0 \uC758\uD574 \uC774\uC6A9\uC790\uC5D0\uAC8C \uC2E0\uCCB4\uC0C1\uC758 \uD53C\uD574\uAC00 \uBC1C\uC0DD\uD55C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uADF8 \uC190\uD574\uB97C \uBC30\uC0C1\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4. \uB2E4\uB9CC \uADF8 \uC190\uD574\uAC00 \uBD88\uAC00\uD56D\uB825\uC73C\uB85C \uC778\uD558\uC5EC \uBC1C\uC0DD\uD55C \uACBD\uC6B0 \uB610\uB294 \uADF8 \uC190\uD574\uC758 \uBC1C\uC0DD\uC774 \uC774\uC6A9\uC790\uC758 \uACE0\uC758 \uB610\uB294 \uACFC\uC2E4\uB85C \uC778\uD55C \uACBD\uC6B0\uC5D0\uB294 \uADF8 \uBC30\uC0C1\uC758 \uCC45\uC784\uC774 \uACBD\uAC10 \uB610\uB294 \uBA74\uC81C\uB429\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC774\uC6A9\uC790\uC758 \uACE0\uC758\u2024\uC911\uB300\uD55C \uACFC\uC2E4\uB85C \uCCB4\uB825\uB2E8\uB828\uAE30\uAE30\uC758 \uD30C\uC190 \uB4F1 \uCCB4\uB825\uB2E8\uB828\uC7A5\uC5D0 \uC190\uD574\uAC00 \uBC1C\uC0DD\uD55C \uACBD\uC6B0 \uC774\uC6A9\uC790\uB294 \uC774\uB97C \uBC30\uC0C1\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n\uC81C10\uC870(\uC18C\uC9C0\uD488\uC758 \uBCF4\uAD00)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uB294 \uC0AC\uC5C5\uC790\uC5D0\uAC8C \uC790\uC2E0\uC774 \uD734\uB300\uD55C \uC18C\uC9C0\uD488\uC758 \uBCF4\uAD00\uC744 \uC694\uAD6C\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC81C1\uD56D\uC758 \uC694\uAD6C\uB97C \uBC1B\uC740 \uC0AC\uC5C5\uC790\uB294 \uC774\uC6A9\uC790\uC758 \uC18C\uC9C0\uD488\uC744 \uC548\uC804\uD558\uAC8C \uBCF4\uAD00\uD55C \uD6C4 \uBC18\uD658\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2462 \uC81C1\uD56D\uC5D0 \uC758\uD574 \uBCF4\uAD00\uD55C \uC18C\uC9C0\uD488\uC774 \uBA78\uC2E4 \uB610\uB294 \uD6FC\uC190\uB41C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uBD88\uAC00\uD56D\uB825\uC73C\uB85C \uC778\uD55C \uAC83\uC784\uC744 \uC785\uC99D\uD558\uC9C0 \uBABB\uD558\uBA74 \uADF8 \uC190\uD574\uB97C \uBC30\uC0C1\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2463 \uC774\uC6A9\uC790\uAC00 \uBCF4\uAD00\uC744 \uC758\uB8B0\uD558\uC9C0 \uC54A\uC740 \uC18C\uC9C0\uD488\uB3C4 \uC0AC\uC5C5\uC790\uCE21\uC758 \uCC45\uC784\uC788\uB294 \uC0AC\uC720\uB85C  \uBA78\uC2E4 \uB610\uB294 \uD6FC\uC190\uB41C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uADF8 \uC190\uD574\uB97C \uBC30\uC0C1\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4. \r\n\r\n  \u2464 \uC774\uC6A9\uC790\uB294 \uD734\uB300\uD488\uC774 \uD654\uD3D0, \uC720\uAC00\uC99D\uAD8C \uAE30\uD0C0 \uACE0\uAC00\uBB3C\uC778 \uACBD\uC6B0 \uADF8 \uC885\uB958\uC640 \uAC00\uC561\uC744 \uBA85\uC2DC\uD558\uC5EC \uC0AC\uC5C5\uC790\uC5D0\uAC8C \uBCF4\uAD00\uC744 \uC758\uB8B0\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4. \uC0AC\uC5C5\uC790\uB294 \uC774\uC6A9\uC790\uC758 \uC694\uAD6C\uC5D0 \uC751\uD558\uC5EC \uD574\uB2F9 \uBB3C\uD488\uC744 \uC548\uC804\uD558\uAC8C \uBCF4\uAD00\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4. \r\n\r\n  \u2465 \uC81C5\uD56D\uC5D0 \uC758\uD574 \uC774\uC6A9\uC790\uAC00 \uBCF4\uAD00\uC744 \uC758\uB8B0\uD558\uC9C0 \uC54A\uC740 \uACE0\uAC00\uBB3C\uC774 \uBA78\uC2E4 \uB610\uB294 \uD6FC\uC190\uB41C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uC81C4\uD56D\uC5D0 \uC758\uAC70 \uC190\uD574\uBC30\uC0C1 \uCC45\uC784\uC744 \uC9D1\uB2C8\uB2E4. \r\n\r\n  \u2466 \uAE30\uD0C0 \uC774\uC6A9\uC790\uC758 \uC18C\uC9C0\uD488 \uBCF4\uAD00\uC5D0 \uAD00\uD55C \uC0AC\uD56D\uC740 \uC0C1\uBC95 \uC81C151\uC870 \uC774\uD558\uC758 \uADDC\uC815\uC5D0 \uC758\uD569\uB2C8\uB2E4. \r\n\r\n\uC81C11\uC870(\uBA74\uCC45\uC870\uD56D)\r\n\r\n  \u2460 \uC0AC\uC5C5\uC790\uB294 \uCC9C\uC7AC\uC9C0\uBCC0 \uAE30\uD0C0 \uBD88\uAC00\uD56D\uB825\uC758 \uC0AC\uC720\uB85C \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC774 \uACE4\uB780\uD55C \uB54C\uC5D0\uB294 \uADF8 \uC0AC\uC720\uAC00 \uC885\uB8CC\uB420 \uB54C\uAE4C\uC9C0 \uC774\uC6A9\uC744 \uC911\uB2E8\uC2DC\uD0AC \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC81C1\uD56D\uC758 \uACBD\uC6B0\uC5D0 \uC774\uC6A9\uC790\uB294 \uACC4\uC57D\uC744 \uD574\uC9C0\uD560 \uC218 \uC788\uB2E4. \uB2E8, \uC774 \uACBD\uC6B0 \uC774\uC6A9\uC790\uB294 \uC0AC\uC5C5\uC790\uC5D0 \uB300\uD574 \uC190\uD574\uBC30\uC0C1\uC744 \uCCAD\uAD6C\uD560 \uC218 \uC5C6\uC2B5\uB2C8\uB2E4.\r\n\r\n  \u2462 \uC774\uC6A9\uC790\uAC00 \uC81C1\uD56D\uC744 \uC774\uC720\uB85C \uACC4\uC57D\uC744 \uD574\uC9C0\uD558\uB294 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uCD1D \uC774\uC6A9\uAE08\uC561\uC5D0\uC11C \uC774\uC6A9\uC744 \uC911\uB2E8\uD55C \uB0A0\uAE4C\uC9C0 \uC77C\uD560 \uACC4\uC0B0\uD558\uC5EC \uACF5\uC81C\uD558\uACE0 \uB09C \uD6C4\uC758 \uAE08\uC561\uC744 \uD658\uBD88\uD569\uB2C8\uB2E4.\r\n\r\n\uC81C12\uC870(\uC0AC\uBB3C\uD568 \uC5F4\uC1E0 \uBC18\uD658)\r\n\r\n  \u2460 \uC774\uC6A9\uC790\uB294 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9 \uC885\uB8CC\uC640 \uB3D9\uC2DC\uC5D0 \uC0AC\uBB3C\uD568\uC5F4\uC1E0\uB97C \uC0AC\uC5C5\uC790\uC5D0\uAC8C \uBC18\uD658\uD558\uC5EC\uC57C \uD569\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC774\uC6A9\uC790\uAC00 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC885\uB8CC\uC77C\uC5D0 \uC0AC\uBB3C\uD568 \uC5F4\uC1E0\uB97C \uBC18\uD658\uD558\uC9C0 \uC54A\uC744 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uC5F4\uC1E0 \uBC18\uD658\uC77C\uAE4C\uC9C0 \uC0AC\uBB3C\uD568 \uC0AC\uC6A9\uB8CC\uB97C \uCCAD\uAD6C\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n  \u2462 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9\uC774 \uC885\uB8CC\uD55C \uB0A0\uB85C\uBD80\uD130 1\uB2EC\uC774 \uACBD\uACFC\uD558\uC5EC\uB3C4 \uC774\uC6A9\uC790\uAC00 \uC0AC\uBB3C\uD568 \uC5F4\uC1E0\uB97C \uBC18\uD658\uD558\uC9C0 \uC54A\uC744 \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uC0AC\uBB3C\uD568\uC744 \uD68C\uC218\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n\uC81C13\uC870(\uAE30\uD0C0)\r\n\r\n  \u2460 \uC774 \uC57D\uAD00\uC5D0\uC11C \uADDC\uC815\uD558\uC9C0 \uC54A\uC740 \uC0AC\uD56D\uC740 \uAD00\uACC4\uBC95\uB839 \uBC0F \uAC70\uB798 \uAD00\uD589\uC744 \uACE0\uB824\uD558\uC5EC \uC2E0\uC758\uCE59\uC5D0 \uB530\uB77C \uC0AC\uC5C5\uC790\uC640 \uC774\uC6A9\uC790\uAC00 \uD569\uC758\uD558\uC5EC \uD574\uACB0\uD569\uB2C8\uB2E4.\r\n\r\n  \u2461 \uC774 \uC57D\uAD00\uACFC \uAD00\uB828\uB41C \uC18C\uC1A1\uC758 \uAD00\uD560\uBC95\uC6D0\uC740 \uBBFC\uC0AC\uC18C\uC1A1\uBC95");
		scrollPane.setViewportView(textPane);

		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(8, 175, 426, 63);
		termsPage.add(scrollPane_1);

		JTextPane textPane_1 = new JTextPane();
		textPane_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textPane_1.setText(
				"\uC81C1\uC870(\uC774\uC6A9\uC2E0\uCCAD \uCCA0\uD68C) \uC774\uC6A9\uC2E0\uCCAD\uC744 \uD560\uBD80\uACC4\uC57D\uC73C\uB85C \uD55C \uACBD\uC6B0\uB294 7\uC77C \uC774\uB0B4, \uBC29\uBB38\uC0AC\uC6D0\uC744 \uD1B5\uD558\uC5EC \uD55C \uACBD\uC6B0\uB294 14\uC77C \uC774\uB0B4 \uCCA0\uD68C\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4\r\n\r\n\uC81C2\uC870(\uC774\uC6A9\uC5F0\uAE30) \uC774\uC6A9\uC790\uB294 \uCCB4\uB825\uB2E8\uB828\uC7A5 \uC774\uC6A9 \uC804 \uB610\uB294 \uC774\uC6A9 \uC911 \uC5F0\uAE30\uAC00 \uD544\uC694\uD55C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uC640 \uD611\uC758\uD558\uC5EC \uC774\uC6A9\uC2DC\uAE30\uB97C \uC5F0\uAE30\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n\uC81C3\uC870(\uACC4\uC57D\uC758 \uD574\uC81C\u2024\uD574\uC9C0) \uC774\uC6A9\uC790\uB294 \uACC4\uC57D\uB0B4\uC6A9 \uB610\uB294 \uAD11\uACE0\uB0B4\uC6A9\uC774 \uC0AC\uC2E4\uACFC \uB2E4\uB974\uAC70\uB098, \uAE30\uAE30\u2024\uC2DC\uC124\uACE0\uC7A5\u2024\uC815\uC6D0\uCD08\uACFC \uB4F1\uC778 \uACBD\uC6B0 \uACC4\uC57D\uC744 \uD574\uC81C\u2024\uD574\uC9C0\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n<\uACC4\uC57D\uD574\uC81C\u2024\uD574\uC9C0\uC870\uAC74>\r\n\r\n\uC0AC\uC720\r\n\uC774\uC6A9 \uAC1C\uC2DC\uC77C \uC774\uC804\r\n\uC0AC\uC5C5\uC790\uADC0\uCC45: \uCD1D \uC774\uC6A9\uAE08\uC561 \uC804\uC561\uACFC \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uB97C \uD658\uBD88\r\n\uC774\uC6A9\uC790\uADC0\uCC45: \uCD1D \uC774\uC6A9\uAE08\uC561\uC5D0\uC11C \uD574\uC9C0\uC77C\uAE4C\uC9C0 \uC774\uC6A9\uAE08\uC561\uC744 \uC77C\uD560\uACC4\uC0B0\uD558\uC5EC \uACF5\uC81C\uD558\uACE0 \uB09C \uD6C4\uC758 \uAE08\uC561\uACFC \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uB97C \uD658\uBD88\r\n\r\n\uC774\uC6A9 \uAC1C\uC2DC\uC77C \uC774\uD6C4 \r\n\uC0AC\uC5C5\uC790\uADC0\uCC45: \uCD1D \uC774\uC6A9\uAE08\uC561\uC5D0\uC11C 10%\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uC744 \uACF5\uC81C\uD55C \uD6C4 \uD658\uBD88\r\n\uC774\uC6A9\uC790\uADC0\uCC45: \uCD1D \uC774\uC6A9\uAE08\uC561\uC5D0\uC11C \uD574\uC9C0\uC77C\uAE4C\uC9C0 \uC774\uC6A9\uC77C\uC218\uC5D0 \uD574\uB2F9\uD558\uB294 \uAE08\uC561\uACFC \uCD1D \uC774\uC6A9\uAE08\uC561\uC758 10%\uB97C \uACF5\uC81C\uD55C \uD6C4 \uD658\uBD88\r\n\r\n   \u203B \uCD1D \uC774\uC6A9\uAE08\uC561 : \uB9E4 \uC774\uC6A9\uACC4\uC57D\uC2DC \uC774\uC6A9\uB8CC\uB85C \uB0A9\uC785\uD55C \uAE08\uC561\r\n\r\n\uC81C4\uC870(\uC190\uD574\uBC30\uC0C1) \uCCB4\uB825\uB2E8\uB828\uC7A5\uC758 \uC2DC\uC124\uBB3C\uC5D0 \uC758\uD558\uC5EC \uC774\uC6A9\uC790 \uC2E0\uCCB4\uC5D0 \uD53C\uD574\uAC00 \uBC1C\uC0DD\uD55C \uACBD\uC6B0 \uC0AC\uC5C5\uC790\uB294 \uC774\uC6A9\uC790\uC758 \uACE0\uC758\u2024\uACFC\uC2E4\uC774 \uC5C6\uB294 \uD55C \uC190\uD574\uB97C \uBC30\uC0C1\uD569\uB2C8\uB2E4.\r\n\r\n\uC81C5\uC870(\uC18C\uC9C0\uD488\uC758 \uBCF4\uAD00) \uC0AC\uC5C5\uC790\uB294 \uC774\uC6A9\uC790\uC758 \uC18C\uC9C0\uD488\uC744 \uC548\uC804\uD558\uAC8C \uBCF4\uAD00\uD558\uC5EC\uC57C \uD558\uBA70 \uBCF4\uAD00\uC744 \uC758\uB8B0\uD558\uC9C0 \uC54A\uC740 \uC18C\uC9C0\uD488\uB3C4 \uC0AC\uC5C5\uC790\uC758 \uCC45\uC784\uC788\uB294 \uC0AC\uC720\uB85C \uBA78\uC2E4 \uB610\uB294 \uD6FC\uC190\uB41C \uACBD\uC6B0 \uADF8 \uC190\uD574\uB97C \uBC30\uC0C1\uD569\uB2C8\uB2E4.");
		scrollPane_1.setViewportView(textPane_1);

		JScrollPane scrollPane_1_1 = new JScrollPane();
		scrollPane_1_1.setBounds(8, 273, 426, 63);
		termsPage.add(scrollPane_1_1);

		JTextPane textPane_1_1 = new JTextPane();
		textPane_1_1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		textPane_1_1.setText(
				"\uAC1C\uC778\uC815\uBCF4\uBCF4\uD638\uBC95\uC5D0 \uB530\uB77C \uB124\uC774\uBC84\uC5D0 \uD68C\uC6D0\uAC00\uC785 \uC2E0\uCCAD\uD558\uC2DC\uB294 \uBD84\uAED8 \uC218\uC9D1\uD558\uB294 \uAC1C\uC778\uC815\uBCF4\uC758 \uD56D\uBAA9, \uAC1C\uC778\uC815\uBCF4\uC758 \uC218\uC9D1 \uBC0F \uC774\uC6A9\uBAA9\uC801, \uAC1C\uC778\uC815\uBCF4\uC758 \uBCF4\uC720 \uBC0F \uC774\uC6A9\uAE30\uAC04, \uB3D9\uC758 \uAC70\uBD80\uAD8C \uBC0F \uB3D9\uC758 \uAC70\uBD80 \uC2DC \uBD88\uC774\uC775\uC5D0 \uAD00\uD55C \uC0AC\uD56D\uC744 \uC548\uB0B4 \uB4DC\uB9AC\uC624\uB2C8 \uC790\uC138\uD788 \uC77D\uC740 \uD6C4 \uB3D9\uC758\uD558\uC5EC \uC8FC\uC2DC\uAE30 \uBC14\uB78D\uB2C8\uB2E4.\r\n\r\n1. \uC218\uC9D1\uD558\uB294 \uAC1C\uC778\uC815\uBCF4\r\n\uC774\uC6A9\uC790\uB294 \uD68C\uC6D0\uAC00\uC785\uC744 \uD558\uC9C0 \uC54A\uC544\uB3C4 \uC815\uBCF4 \uAC80\uC0C9, \uB274\uC2A4 \uBCF4\uAE30 \uB4F1 \uB300\uBD80\uBD84\uC758 \uB124\uC774\uBC84 \uC11C\uBE44\uC2A4\uB97C \uD68C\uC6D0\uACFC \uB3D9\uC77C\uD558\uAC8C \uC774\uC6A9\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4. \uC774\uC6A9\uC790\uAC00 \uBA54\uC77C, \uCE98\uB9B0\uB354, \uCE74\uD398, \uBE14\uB85C\uADF8 \uB4F1\uACFC \uAC19\uC774 \uAC1C\uC778\uD654 \uD639\uC740 \uD68C\uC6D0\uC81C \uC11C\uBE44\uC2A4\uB97C \uC774\uC6A9\uD558\uAE30 \uC704\uD574 \uD68C\uC6D0\uAC00\uC785\uC744 \uD560 \uACBD\uC6B0, \uB124\uC774\uBC84\uB294 \uC11C\uBE44\uC2A4 \uC774\uC6A9\uC744 \uC704\uD574 \uD544\uC694\uD55C \uCD5C\uC18C\uD55C\uC758 \uAC1C\uC778\uC815\uBCF4\uB97C \uC218\uC9D1\uD569\uB2C8\uB2E4.\r\n\r\n\uD68C\uC6D0\uAC00\uC785 \uC2DC\uC810\uC5D0 \uB124\uC774\uBC84\uAC00 \uC774\uC6A9\uC790\uB85C\uBD80\uD130 \uC218\uC9D1\uD558\uB294 \uAC1C\uC778\uC815\uBCF4\uB294 \uC544\uB798\uC640 \uAC19\uC2B5\uB2C8\uB2E4.\r\n- \uD68C\uC6D0 \uAC00\uC785 \uC2DC\uC5D0 \u2018\uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638, \uC774\uB984, \uC0DD\uB144\uC6D4\uC77C, \uC131\uBCC4, \uD734\uB300\uC804\uD654\uBC88\uD638\u2019\uB97C \uD544\uC218\uD56D\uBAA9\uC73C\uB85C \uC218\uC9D1\uD569\uB2C8\uB2E4. \uB9CC\uC57D \uC774\uC6A9\uC790\uAC00 \uC785\uB825\uD558\uB294 \uC0DD\uB144\uC6D4\uC77C\uC774 \uB9CC14\uC138 \uBBF8\uB9CC \uC544\uB3D9\uC77C \uACBD\uC6B0\uC5D0\uB294 \uBC95\uC815\uB300\uB9AC\uC778 \uC815\uBCF4(\uBC95\uC815\uB300\uB9AC\uC778\uC758 \uC774\uB984, \uC0DD\uB144\uC6D4\uC77C, \uC131\uBCC4, \uC911\uBCF5\uAC00\uC785\uD655\uC778\uC815\uBCF4(DI), \uD734\uB300\uC804\uD654\uBC88\uD638)\uB97C \uCD94\uAC00\uB85C \uC218\uC9D1\uD569\uB2C8\uB2E4. \uADF8\uB9AC\uACE0 \uC120\uD0DD\uD56D\uBAA9\uC73C\uB85C \uC774\uBA54\uC77C \uC8FC\uC18C, \uD504\uB85C\uD544 \uC815\uBCF4\uB97C \uC218\uC9D1\uD569\uB2C8\uB2E4.\r\n- \uB2E8\uCCB4\uC544\uC774\uB514\uB85C \uD68C\uC6D0\uAC00\uC785 \uC2DC \uB2E8\uCCB4\uC544\uC774\uB514, \uBE44\uBC00\uBC88\uD638, \uB2E8\uCCB4\uC774\uB984, \uC774\uBA54\uC77C\uC8FC\uC18C, \uD734\uB300\uC804\uD654\uBC88\uD638\uB97C \uD544\uC218\uD56D\uBAA9\uC73C\uB85C \uC218\uC9D1\uD569\uB2C8\uB2E4. \uADF8\uB9AC\uACE0 \uB2E8\uCCB4 \uB300\uD45C\uC790\uBA85\uC744 \uC120\uD0DD\uD56D\uBAA9\uC73C\uB85C \uC218\uC9D1\uD569\uB2C8\uB2E4.\r\n\uC11C\uBE44\uC2A4 \uC774\uC6A9 \uACFC\uC815\uC5D0\uC11C \uC774\uC6A9\uC790\uB85C\uBD80\uD130 \uC218\uC9D1\uD558\uB294 \uAC1C\uC778\uC815\uBCF4\uB294 \uC544\uB798\uC640 \uAC19\uC2B5\uB2C8\uB2E4.\r\nNAVER \uB0B4\uC758 \uAC1C\uBCC4 \uC11C\uBE44\uC2A4 \uC774\uC6A9, \uC774\uBCA4\uD2B8 \uC751\uBAA8 \uBC0F \uACBD\uD488 \uC2E0\uCCAD \uACFC\uC815\uC5D0\uC11C \uD574\uB2F9 \uC11C\uBE44\uC2A4\uC758 \uC774\uC6A9\uC790\uC5D0 \uD55C\uD574 \uCD94\uAC00 \uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1\uC774 \uBC1C\uC0DD\uD560 \uC218 \uC788\uC2B5\uB2C8\uB2E4. \uCD94\uAC00\uB85C \uAC1C\uC778\uC815\uBCF4\uB97C \uC218\uC9D1\uD560 \uACBD\uC6B0\uC5D0\uB294 \uD574\uB2F9 \uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uC2DC\uC810\uC5D0\uC11C \uC774\uC6A9\uC790\uC5D0\uAC8C \u2018\uC218\uC9D1\uD558\uB294 \uAC1C\uC778\uC815\uBCF4 \uD56D\uBAA9, \uAC1C\uC778\uC815\uBCF4\uC758 \uC218\uC9D1 \uBC0F \uC774\uC6A9\uBAA9\uC801, \uAC1C\uC778\uC815\uBCF4\uC758 \uBCF4\uAD00\uAE30\uAC04\u2019\uC5D0 \uB300\uD574 \uC548\uB0B4 \uB4DC\uB9AC\uACE0 \uB3D9\uC758\uB97C \uBC1B\uC2B5\uB2C8\uB2E4.\r\n\r\n\uC11C\uBE44\uC2A4 \uC774\uC6A9 \uACFC\uC815\uC5D0\uC11C IP \uC8FC\uC18C, \uCFE0\uD0A4, \uC11C\uBE44\uC2A4 \uC774\uC6A9 \uAE30\uB85D, \uAE30\uAE30\uC815\uBCF4, \uC704\uCE58\uC815\uBCF4\uAC00 \uC0DD\uC131\uB418\uC5B4 \uC218\uC9D1\uB420 \uC218 \uC788\uC2B5\uB2C8\uB2E4. \uB610\uD55C \uC774\uBBF8\uC9C0 \uBC0F \uC74C\uC131\uC744 \uC774\uC6A9\uD55C \uAC80\uC0C9 \uC11C\uBE44\uC2A4 \uB4F1\uC5D0\uC11C \uC774\uBBF8\uC9C0\uB098 \uC74C\uC131\uC774 \uC218\uC9D1\uB420 \uC218 \uC788\uC2B5\uB2C8\uB2E4.\r\n\uAD6C\uCCB4\uC801\uC73C\uB85C 1) \uC11C\uBE44\uC2A4 \uC774\uC6A9 \uACFC\uC815\uC5D0\uC11C \uC774\uC6A9\uC790\uC5D0 \uAD00\uD55C \uC815\uBCF4\uB97C \uC790\uB3D9\uD654\uB41C \uBC29\uBC95\uC73C\uB85C \uC0DD\uC131\uD558\uC5EC \uC774\uB97C \uC800\uC7A5(\uC218\uC9D1)\uD558\uAC70\uB098,\r\n2) \uC774\uC6A9\uC790 \uAE30\uAE30\uC758 \uACE0\uC720\uD55C \uC815\uBCF4\uB97C \uC6D0\uB798\uC758 \uAC12\uC744 \uD655\uC778\uD558\uC9C0 \uBABB \uD558\uB3C4\uB85D \uC548\uC804\uD558\uAC8C \uBCC0\uD658\uD558\uC5EC \uC218\uC9D1\uD569\uB2C8\uB2E4. \uC11C\uBE44\uC2A4 \uC774\uC6A9 \uACFC\uC815\uC5D0\uC11C \uC704\uCE58\uC815\uBCF4\uAC00 \uC218\uC9D1\uB420 \uC218 \uC788\uC73C\uBA70,\r\n\uB124\uC774\uBC84\uC5D0\uC11C \uC81C\uACF5\uD558\uB294 \uC704\uCE58\uAE30\uBC18 \uC11C\uBE44\uC2A4\uC5D0 \uB300\uD574\uC11C\uB294 '\uB124\uC774\uBC84 \uC704\uCE58\uC815\uBCF4 \uC774\uC6A9\uC57D\uAD00'\uC5D0\uC11C \uC790\uC138\uD558\uAC8C \uADDC\uC815\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\uC774\uC640 \uAC19\uC774 \uC218\uC9D1\uB41C \uC815\uBCF4\uB294 \uAC1C\uC778\uC815\uBCF4\uC640\uC758 \uC5F0\uACC4 \uC5EC\uBD80 \uB4F1\uC5D0 \uB530\uB77C \uAC1C\uC778\uC815\uBCF4\uC5D0 \uD574\uB2F9\uD560 \uC218 \uC788\uACE0, \uAC1C\uC778\uC815\uBCF4\uC5D0 \uD574\uB2F9\uD558\uC9C0 \uC54A\uC744 \uC218\uB3C4 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n2. \uC218\uC9D1\uD55C \uAC1C\uC778\uC815\uBCF4\uC758 \uC774\uC6A9\r\n\uB124\uC774\uBC84 \uBC0F \uB124\uC774\uBC84 \uAD00\uB828 \uC81C\uBC18 \uC11C\uBE44\uC2A4(\uBAA8\uBC14\uC77C \uC6F9/\uC571 \uD3EC\uD568)\uC758 \uD68C\uC6D0\uAD00\uB9AC, \uC11C\uBE44\uC2A4 \uAC1C\uBC1C\u30FB\uC81C\uACF5 \uBC0F \uD5A5\uC0C1, \uC548\uC804\uD55C \uC778\uD130\uB137 \uC774\uC6A9\uD658\uACBD \uAD6C\uCD95 \uB4F1 \uC544\uB798\uC758 \uBAA9\uC801\uC73C\uB85C\uB9CC \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n\r\n- \uD68C\uC6D0 \uAC00\uC785 \uC758\uC0AC\uC758 \uD655\uC778, \uC5F0\uB839 \uD655\uC778 \uBC0F \uBC95\uC815\uB300\uB9AC\uC778 \uB3D9\uC758 \uC9C4\uD589, \uC774\uC6A9\uC790 \uBC0F \uBC95\uC815\uB300\uB9AC\uC778\uC758 \uBCF8\uC778 \uD655\uC778, \uC774\uC6A9\uC790 \uC2DD\uBCC4, \uD68C\uC6D0\uD0C8\uD1F4 \uC758\uC0AC\uC758 \uD655\uC778 \uB4F1 \uD68C\uC6D0\uAD00\uB9AC\uB97C \uC704\uD558\uC5EC \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n- \uCF58\uD150\uCE20 \uB4F1 \uAE30\uC874 \uC11C\uBE44\uC2A4 \uC81C\uACF5(\uAD11\uACE0 \uD3EC\uD568)\uC5D0 \uB354\uD558\uC5EC, \uC778\uAD6C\uD1B5\uACC4\uD559\uC801 \uBD84\uC11D, \uC11C\uBE44\uC2A4 \uBC29\uBB38 \uBC0F \uC774\uC6A9\uAE30\uB85D\uC758 \uBD84\uC11D, \uAC1C\uC778\uC815\uBCF4 \uBC0F \uAD00\uC2EC\uC5D0 \uAE30\uBC18\uD55C \uC774\uC6A9\uC790\uAC04 \uAD00\uACC4\uC758 \uD615\uC131, \uC9C0\uC778 \uBC0F \uAD00\uC2EC\uC0AC \uB4F1\uC5D0 \uAE30\uBC18\uD55C \uB9DE\uCDA4\uD615 \uC11C\uBE44\uC2A4 \uC81C\uACF5 \uB4F1 \uC2E0\uADDC \uC11C\uBE44\uC2A4 \uC694\uC18C\uC758 \uBC1C\uAD74 \uBC0F \uAE30\uC874 \uC11C\uBE44\uC2A4 \uAC1C\uC120 \uB4F1\uC744 \uC704\uD558\uC5EC \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n- \uBC95\uB839 \uBC0F \uB124\uC774\uBC84 \uC774\uC6A9\uC57D\uAD00\uC744 \uC704\uBC18\uD558\uB294 \uD68C\uC6D0\uC5D0 \uB300\uD55C \uC774\uC6A9 \uC81C\uD55C \uC870\uCE58, \uBD80\uC815 \uC774\uC6A9 \uD589\uC704\uB97C \uD3EC\uD568\uD558\uC5EC \uC11C\uBE44\uC2A4\uC758 \uC6D0\uD65C\uD55C \uC6B4\uC601\uC5D0 \uC9C0\uC7A5\uC744 \uC8FC\uB294 \uD589\uC704\uC5D0 \uB300\uD55C \uBC29\uC9C0 \uBC0F \uC81C\uC7AC, \uACC4\uC815\uB3C4\uC6A9 \uBC0F \uBD80\uC815\uAC70\uB798 \uBC29\uC9C0, \uC57D\uAD00 \uAC1C\uC815 \uB4F1\uC758 \uACE0\uC9C0\uC0AC\uD56D \uC804\uB2EC, \uBD84\uC7C1\uC870\uC815\uC744 \uC704\uD55C \uAE30\uB85D \uBCF4\uC874, \uBBFC\uC6D0\uCC98\uB9AC \uB4F1 \uC774\uC6A9\uC790 \uBCF4\uD638 \uBC0F \uC11C\uBE44\uC2A4 \uC6B4\uC601\uC744 \uC704\uD558\uC5EC \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n- \uC720\uB8CC \uC11C\uBE44\uC2A4 \uC81C\uACF5\uC5D0 \uB530\uB974\uB294 \uBCF8\uC778\uC778\uC99D, \uAD6C\uB9E4 \uBC0F \uC694\uAE08 \uACB0\uC81C, \uC0C1\uD488 \uBC0F \uC11C\uBE44\uC2A4\uC758 \uBC30\uC1A1\uC744 \uC704\uD558\uC5EC \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n- \uC774\uBCA4\uD2B8 \uC815\uBCF4 \uBC0F \uCC38\uC5EC\uAE30\uD68C \uC81C\uACF5, \uAD11\uACE0\uC131 \uC815\uBCF4 \uC81C\uACF5 \uB4F1 \uB9C8\uCF00\uD305 \uBC0F \uD504\uB85C\uBAA8\uC158 \uBAA9\uC801\uC73C\uB85C \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n- \uC11C\uBE44\uC2A4 \uC774\uC6A9\uAE30\uB85D\uACFC \uC811\uC18D \uBE48\uB3C4 \uBD84\uC11D, \uC11C\uBE44\uC2A4 \uC774\uC6A9\uC5D0 \uB300\uD55C \uD1B5\uACC4, \uC11C\uBE44\uC2A4 \uBD84\uC11D \uBC0F \uD1B5\uACC4\uC5D0 \uB530\uB978 \uB9DE\uCDA4 \uC11C\uBE44\uC2A4 \uC81C\uACF5 \uBC0F \uAD11\uACE0 \uAC8C\uC7AC \uB4F1\uC5D0 \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n- \uBCF4\uC548, \uD504\uB77C\uC774\uBC84\uC2DC, \uC548\uC804 \uCE21\uBA74\uC5D0\uC11C \uC774\uC6A9\uC790\uAC00 \uC548\uC2EC\uD558\uACE0 \uC774\uC6A9\uD560 \uC218 \uC788\uB294 \uC11C\uBE44\uC2A4 \uC774\uC6A9\uD658\uACBD \uAD6C\uCD95\uC744 \uC704\uD574 \uAC1C\uC778\uC815\uBCF4\uB97C \uC774\uC6A9\uD569\uB2C8\uB2E4.\r\n3. \uAC1C\uC778\uC815\uBCF4\uC758 \uBCF4\uAD00\uAE30\uAC04\r\n\uD68C\uC0AC\uB294 \uC6D0\uCE59\uC801\uC73C\uB85C \uC774\uC6A9\uC790\uC758 \uAC1C\uC778\uC815\uBCF4\uB97C \uD68C\uC6D0 \uD0C8\uD1F4 \uC2DC \uC9C0\uCCB4\uC5C6\uC774 \uD30C\uAE30\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\uB2E8, \uC774\uC6A9\uC790\uC5D0\uAC8C \uAC1C\uC778\uC815\uBCF4 \uBCF4\uAD00\uAE30\uAC04\uC5D0 \uB300\uD574 \uBCC4\uB3C4\uC758 \uB3D9\uC758\uB97C \uC5BB\uC740 \uACBD\uC6B0, \uB610\uB294 \uBC95\uB839\uC5D0\uC11C \uC77C\uC815 \uAE30\uAC04 \uC815\uBCF4\uBCF4\uAD00 \uC758\uBB34\uB97C \uBD80\uACFC\uD558\uB294 \uACBD\uC6B0\uC5D0\uB294 \uD574\uB2F9 \uAE30\uAC04 \uB3D9\uC548 \uAC1C\uC778\uC815\uBCF4\uB97C \uC548\uC804\uD558\uAC8C \uBCF4\uAD00\uD569\uB2C8\uB2E4.\r\n\r\n\uC774\uC6A9\uC790\uC5D0\uAC8C \uAC1C\uC778\uC815\uBCF4 \uBCF4\uAD00\uAE30\uAC04\uC5D0 \uB300\uD574 \uD68C\uC6D0\uAC00\uC785 \uC2DC \uB610\uB294 \uC11C\uBE44\uC2A4 \uAC00\uC785 \uC2DC \uB3D9\uC758\uB97C \uC5BB\uC740 \uACBD\uC6B0\uB294 \uC544\uB798\uC640 \uAC19\uC2B5\uB2C8\uB2E4.\r\n- \uBD80\uC815 \uAC00\uC785 \uBC0F \uC774\uC6A9 \uBC29\uC9C0\r\n\uAC00\uC785\uC778\uC99D \uD734\uB300\uC804\uD654\uBC88\uD638 \uB610\uB294DI (\uB9CC14\uC138 \uBBF8\uB9CC\uC758 \uACBD\uC6B0 \uBC95\uC815\uB300\uB9AC\uC778DI) : \uC218\uC9D1\uC2DC\uC810\uC73C\uB85C\uBD80\uD1306\uAC1C\uC6D4 \uBCF4\uAD00\r\n\uD0C8\uD1F4\uD55C \uC774\uC6A9\uC790\uC758 \uD734\uB300\uC804\uD654\uBC88\uD638(\uBCF5\uD638\uD654\uAC00 \uBD88\uAC00\uB2A5\uD55C \uC77C\uBC29\uD5A5 \uC554\uD638\uD654(\uD574\uC2DC\uCC98\uB9AC)) : \uD0C8\uD1F4\uC77C\uB85C\uBD80\uD1306\uAC1C\uC6D4 \uBCF4\uAD00\r\n- QR\uCF54\uB4DC \uBCF5\uAD6C \uC694\uCCAD \uB300\uC751\r\nQR\uCF54\uB4DC \uB4F1\uB85D \uC815\uBCF4:\uC0AD\uC81C \uC2DC\uC810\uC73C\uB85C\uBD80\uD1306\uAC1C\uC6D4 \uBCF4\uAD00\r\n- \uC2A4\uB9C8\uD2B8\uD50C\uB808\uC774\uC2A4 \uBD84\uC7C1 \uC870\uC815 \uBC0F \uACE0\uAC1D\uBB38\uC758 \uB300\uC751\r\n\uD734\uB300\uC804\uD654\uBC88\uD638:\uB4F1\uB85D/\uC218\uC815/\uC0AD\uC81C \uC694\uCCAD \uC2DC\uB85C\uBD80\uD130 \uCD5C\uB3001\uB144\r\n- \uB124\uC774\uBC84 \uD50C\uB7EC\uC2A4 \uBA64\uBC84\uC2ED \uC11C\uBE44\uC2A4 \uD61C\uD0DD \uC911\uBCF5 \uC81C\uACF5 \uBC29\uC9C0\r\n\uC554\uD638\uD654\uCC98\uB9AC(\uD574\uC2DC\uCC98\uB9AC)\uD55CDI :\uD61C\uD0DD \uC81C\uACF5 \uC885\uB8CC\uC77C\uB85C\uBD80\uD1306\uAC1C\uC6D4 \uBCF4\uAD00\r\n\uC804\uC790\uC0C1\uAC70\uB798 \uB4F1\uC5D0\uC11C\uC758 \uC18C\uBE44\uC790 \uBCF4\uD638\uC5D0 \uAD00\uD55C \uBC95\uB960, \uC804\uC790\uAE08\uC735\uAC70\uB798\uBC95, \uD1B5\uC2E0\uBE44\uBC00\uBCF4\uD638\uBC95 \uB4F1 \uBC95\uB839\uC5D0\uC11C \uC77C\uC815\uAE30\uAC04 \uC815\uBCF4\uC758 \uBCF4\uAD00\uC744 \uADDC\uC815\uD558\uB294 \uACBD\uC6B0\uB294 \uC544\uB798\uC640 \uAC19\uC2B5\uB2C8\uB2E4. \uB124\uC774\uBC84\uB294 \uC774 \uAE30\uAC04 \uB3D9\uC548 \uBC95\uB839\uC758 \uADDC\uC815\uC5D0 \uB530\uB77C \uAC1C\uC778\uC815\uBCF4\uB97C \uBCF4\uAD00\uD558\uBA70, \uBCF8 \uC815\uBCF4\uB97C \uB2E4\uB978 \uBAA9\uC801\uC73C\uB85C\uB294 \uC808\uB300 \uC774\uC6A9\uD558\uC9C0 \uC54A\uC2B5\uB2C8\uB2E4.\r\n- \uC804\uC790\uC0C1\uAC70\uB798 \uB4F1\uC5D0\uC11C \uC18C\uBE44\uC790 \uBCF4\uD638\uC5D0 \uAD00\uD55C \uBC95\uB960\r\n\uACC4\uC57D \uB610\uB294 \uCCAD\uC57D\uCCA0\uD68C \uB4F1\uC5D0 \uAD00\uD55C \uAE30\uB85D: 5\uB144 \uBCF4\uAD00\r\n\uB300\uAE08\uACB0\uC81C \uBC0F \uC7AC\uD654 \uB4F1\uC758 \uACF5\uAE09\uC5D0 \uAD00\uD55C \uAE30\uB85D: 5\uB144 \uBCF4\uAD00\r\n\uC18C\uBE44\uC790\uC758 \uBD88\uB9CC \uB610\uB294 \uBD84\uC7C1\uCC98\uB9AC\uC5D0 \uAD00\uD55C \uAE30\uB85D: 3\uB144 \uBCF4\uAD00\r\n- \uC804\uC790\uAE08\uC735\uAC70\uB798\uBC95\r\n\uC804\uC790\uAE08\uC735\uC5D0 \uAD00\uD55C \uAE30\uB85D: 5\uB144 \uBCF4\uAD00\r\n- \uD1B5\uC2E0\uBE44\uBC00\uBCF4\uD638\uBC95\r\n\uB85C\uADF8\uC778 \uAE30\uB85D: 3\uAC1C\uC6D4\r\n\r\n\uCC38\uACE0\uB85C \uB124\uC774\uBC84\uB294 \u2018\uAC1C\uC778\uC815\uBCF4 \uC720\uD6A8\uAE30\uAC04\uC81C\u2019\uC5D0 \uB530\uB77C 1\uB144\uAC04 \uC11C\uBE44\uC2A4\uB97C \uC774\uC6A9\uD558\uC9C0 \uC54A\uC740 \uD68C\uC6D0\uC758 \uAC1C\uC778\uC815\uBCF4\uB97C \uBCC4\uB3C4\uB85C \uBD84\uB9AC \uBCF4\uAD00\uD558\uC5EC \uAD00\uB9AC\uD558\uACE0 \uC788\uC2B5\uB2C8\uB2E4.\r\n\r\n4. \uAC1C\uC778\uC815\uBCF4 \uC218\uC9D1 \uBC0F \uC774\uC6A9 \uB3D9\uC758\uB97C \uAC70\uBD80\uD560 \uAD8C\uB9AC\r\n\uC774\uC6A9\uC790\uB294 \uAC1C\uC778\uC815\uBCF4\uC758 \uC218\uC9D1 \uBC0F \uC774\uC6A9 \uB3D9\uC758\uB97C \uAC70\uBD80\uD560 \uAD8C\uB9AC\uAC00 \uC788\uC2B5\uB2C8\uB2E4. \uD68C\uC6D0\uAC00\uC785 \uC2DC \uC218\uC9D1\uD558\uB294 \uCD5C\uC18C\uD55C\uC758 \uAC1C\uC778\uC815\uBCF4, \uC989, \uD544\uC218 \uD56D\uBAA9\uC5D0 \uB300\uD55C \uC218\uC9D1 \uBC0F \uC774\uC6A9 \uB3D9\uC758\uB97C \uAC70\uBD80\uD558\uC2E4 \uACBD\uC6B0, \uD68C\uC6D0\uAC00\uC785\uC774 \uC5B4\uB824\uC6B8 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		scrollPane_1_1.setViewportView(textPane_1_1);

		JCheckBox checkbox1 = new JCheckBox(
				" \uC774\uBCA4\uD2B8 \uBB38\uC790 \uC218\uC2E0\uB3D9\uC758        (\uC120\uD0DD)");
		checkbox1.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		checkbox1.setBackground(Color.ORANGE);
		checkbox1.setBounds(8, 342, 211, 23);
		termsPage.add(checkbox1);

		JButton btnsignup = new JButton("\uC218\uB77D");
		btnsignup.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnsignup.setBackground(Color.ORANGE);
		btnsignup.setBounds(228, 378, 97, 23);
		termsPage.add(btnsignup);

		JCheckBox checkAll = new JCheckBox("\uC804\uCCB4 \uB3D9\uC758");
		checkAll.setFont(new Font("맑은 고딕", Font.PLAIN, 12));
		checkAll.setHorizontalAlignment(SwingConstants.CENTER);
		checkAll.setBackground(Color.ORANGE);
		checkAll.setBounds(337, 342, 97, 23);
		termsPage.add(checkAll);

		checkAll.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkAll.isSelected()) {
					checkbox1.setSelected(true);
					checkbox2.setSelected(true);
					checkbox3.setSelected(true);
					checkbox4.setSelected(true);
				} else if (!(checkAll.isSelected())) {
					checkbox1.setSelected(false);
					checkbox2.setSelected(false);
					checkbox3.setSelected(false);
					checkbox4.setSelected(false);
				}
			}
		});

		JLabel lblNewLabel_5 = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lblNewLabel_5.setForeground(Color.ORANGE);
		lblNewLabel_5.setFont(new Font("맑은 고딕", Font.BOLD, 26));
		lblNewLabel_5.setBounds(170, 25, 108, 39);
		signupPage.add(lblNewLabel_5);

		JPanel msPage = new JPanel();
		msPage.setBackground(Color.DARK_GRAY);
		msPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(msPage);
		msPage.setLayout(null);

		JLabel label_MsAttend = new JLabel("\uD68C\uC6D0\uB4F1\uB85D");
		label_MsAttend.setBounds(350, 131, 75, 25);
		msPage.add(label_MsAttend);
		label_MsAttend.setHorizontalAlignment(SwingConstants.CENTER);
		label_MsAttend.setForeground(Color.RED);
		label_MsAttend.setFont(new Font("맑은 고딕", Font.BOLD, 17));

		JButton btnMsSign1 = new JButton("\uB4F1  \uB85D");
		btnMsSign1.setForeground(Color.DARK_GRAY);
		btnMsSign1.setBackground(Color.ORANGE);
		btnMsSign1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMsSign1.setBounds(325, 161, 117, 27);
		btnMsSign1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 1;
				Membership.Buy_Membership(no);
				JOptionPane.showMessageDialog(null, "회원권 구매가 완료 되었습니다.");
			}
		});
		msPage.add(btnMsSign1);

		JButton btnMsSign2 = new JButton("\uB4F1  \uB85D");
		btnMsSign2.setForeground(Color.DARK_GRAY);
		btnMsSign2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMsSign2.setBackground(Color.ORANGE);
		btnMsSign2.setBounds(325, 191, 117, 27);
		btnMsSign2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 2;
				Membership.Buy_Membership(no);
				JOptionPane.showMessageDialog(null, "회원권 구매가 완료 되었습니다.");
			}
		});
		msPage.add(btnMsSign2);

		JButton btnMsSign3 = new JButton("\uB4F1  \uB85D");
		btnMsSign3.setForeground(Color.DARK_GRAY);
		btnMsSign3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMsSign3.setBackground(Color.ORANGE);
		btnMsSign3.setBounds(325, 221, 117, 27);
		btnMsSign3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 3;
				Membership.Buy_Membership(no);
				JOptionPane.showMessageDialog(null, "회원권 구매가 완료 되었습니다.");
			}
		});
		msPage.add(btnMsSign3);

		JButton btnMsSign4 = new JButton("\uB4F1  \uB85D");
		btnMsSign4.setForeground(Color.DARK_GRAY);
		btnMsSign4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMsSign4.setBackground(Color.ORANGE);
		btnMsSign4.setBounds(325, 251, 117, 27);
		btnMsSign4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 4;
				Membership.Buy_Membership(no);
				JOptionPane.showMessageDialog(null, "회원권 구매가 완료 되었습니다.");
			}
		});
		msPage.add(btnMsSign4);

		JPanel panel_MsRside = new JPanel();
		panel_MsRside.setBounds(323, 130, 121, 150);
		msPage.add(panel_MsRside);

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		String[] Msheading = new String[] { "MembershipOption", "MembershipPrice" };
		Object[][] Msdata = new Object[][] { { "회원권 옵션", "회원권 가격", }, { "1개월 (락커룸 + 운동복 지급)", "50,000원" },
				{ "3개월 (락커룸 + 운동복 지급)", "120,000원" }, { "6개월 (락커룸 + 운동복 지급)", "210,000원" },
				{ "12개월 (락커룸 + 운동복 지급)", "390,000원" } };

		JTable Mstable = new JTable(Msdata, Msheading);
		Mstable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		Mstable.setBounds(0, 130, 322, 150);
		msPage.add(Mstable);
		Mstable.setRowHeight(30);

		TableColumnModel tcm4 = Mstable.getColumnModel();
		for (int i = 0; i < 2; i++) {
			tcm4.getColumn(i).setCellRenderer(dtcr);
		}
		;

		Mstable.getColumn("MembershipPrice").setPreferredWidth(60);
		Mstable.getColumn("MembershipOption").setPreferredWidth(180);
		Mstable.setFocusable(false);
		Mstable.setRowSelectionAllowed(false);

		JLabel label_MsSign = new JLabel("\uB4F1\uB85D \uBC84\uD2BC");
		label_MsSign.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_MsSign.setForeground(Color.ORANGE);
		label_MsSign.setBounds(190, 75, 90, 40);
		msPage.add(label_MsSign);

		JLabel label_MsAnna = new JLabel(
				"\uD68C\uC6D0\uAD8C \uBAA9\uB85D\uC744 \uD655\uC778 \uD6C4              \uC744 \uB20C\uB7EC \uB4F1\uB85D\uD558\uC138\uC694.");
		label_MsAnna.setForeground(Color.BLACK);
		label_MsAnna.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_MsAnna.setBounds(22, 75, 430, 40);
		msPage.add(label_MsAnna);

		JButton btnBackms = new JButton("\uC774\uC804");
		btnBackms.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnBackms.setBackground(Color.ORANGE);
		btnBackms.setBounds(166, 327, 112, 43);
		msPage.add(btnBackms);

		JLabel labMs = new JLabel("\uD68C\uC6D0\uAD8C \uC815\uBCF4\uD655\uC778");
		labMs.setForeground(Color.ORANGE);
		labMs.setFont(new Font("맑은 고딕", Font.BOLD, 19));
		labMs.setBounds(12, 10, 143, 33);
		msPage.add(labMs);

		JPanel panel_MsTitle = new JPanel();
		panel_MsTitle.setBounds(0, 75, 445, 40);
		msPage.add(panel_MsTitle);

		JPanel panel_MsMain = new JPanel();
		panel_MsMain.setBackground(Color.LIGHT_GRAY);
		panel_MsMain.setBounds(0, 115, 445, 178);
		msPage.add(panel_MsMain);

		JPanel ptPage = new JPanel();
		ptPage.setBackground(Color.DARK_GRAY);
		ptPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(ptPage);
		ptPage.setLayout(null);
		ptPage.setVisible(false);

		JLabel label_PtAttend = new JLabel("\uD68C\uC6D0\uB4F1\uB85D");
		label_PtAttend.setHorizontalAlignment(SwingConstants.CENTER);
		label_PtAttend.setForeground(Color.RED);
		label_PtAttend.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_PtAttend.setBounds(360, 131, 75, 25);
		ptPage.add(label_PtAttend);

		JButton btnPtSign1 = new JButton("\uB4F1  \uB85D");
		btnPtSign1.setForeground(Color.DARK_GRAY);
		btnPtSign1.setBackground(Color.ORANGE);
		btnPtSign1.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnPtSign1.setBounds(355, 161, 85, 27);
		btnPtSign1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 1;
				PT.Buy_PT(no);
				JOptionPane.showMessageDialog(null, "PT이용권 구매가 완료 되었습니다.");
			}
		});
		ptPage.add(btnPtSign1);

		JButton btnPtSign2 = new JButton("\uB4F1  \uB85D");
		btnPtSign2.setForeground(Color.DARK_GRAY);
		btnPtSign2.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnPtSign2.setBackground(Color.ORANGE);
		btnPtSign2.setBounds(355, 191, 85, 27);
		btnPtSign2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 2;
				PT.Buy_PT(no);
				JOptionPane.showMessageDialog(null, "PT이용권 구매가 완료 되었습니다.");
			}
		});
		ptPage.add(btnPtSign2);

		JButton btnPtSign3 = new JButton("\uB4F1  \uB85D");
		btnPtSign3.setForeground(Color.DARK_GRAY);
		btnPtSign3.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnPtSign3.setBackground(Color.ORANGE);
		btnPtSign3.setBounds(355, 221, 85, 27);
		btnPtSign3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 3;
				PT.Buy_PT(no);
				JOptionPane.showMessageDialog(null, "PT이용권 구매가 완료 되었습니다.");
			}
		});
		ptPage.add(btnPtSign3);

		JButton btnPtSign4 = new JButton("\uB4F1  \uB85D");
		btnPtSign4.setForeground(Color.DARK_GRAY);
		btnPtSign4.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnPtSign4.setBackground(Color.ORANGE);
		btnPtSign4.setBounds(355, 251, 85, 27);
		btnPtSign4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int no = 4;
				PT.Buy_PT(no);
				JOptionPane.showMessageDialog(null, "PT이용권 구매가 완료 되었습니다.");
			}
		});
		ptPage.add(btnPtSign4);

		JPanel panel_PtRside = new JPanel();
		panel_PtRside.setBounds(351, 130, 94, 150);
		ptPage.add(panel_PtRside);

		JButton btnBackpt = new JButton("\uC774\uC804");
		btnBackpt.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnBackpt.setBackground(Color.ORANGE);
		btnBackpt.setBounds(250, 327, 150, 50);
		ptPage.add(btnBackpt);

		JLabel labelPt = new JLabel("PT \uC815\uBCF4\uD655\uC778");
		labelPt.setForeground(Color.ORANGE);
		labelPt.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		labelPt.setBounds(15, 15, 130, 40);
		ptPage.add(labelPt);

		JButton btnTnpt = new JButton("\uD2B8\uB808\uC774\uB108 \uBCF4\uAE30");
		btnTnpt.setBackground(Color.ORANGE);
		btnTnpt.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		btnTnpt.setBounds(49, 327, 150, 50);
		ptPage.add(btnTnpt);

		dtcr.setHorizontalAlignment(SwingConstants.CENTER);
		String[] Ptheading = new String[] { "TrainerName", "PRPrice", "PTTime", "PTExersiceSection" };
		Object[][] Ptdata = new Object[][] { { "트레이너", "PT 가격", "PT 시간", "헬스파트" },
				{ "엄덕현", "100,000원", "월, 수, 금", "웨이트" }, { "이재준", "80,000원", "화, 목, 토", "필라테스" },
				{ "안상언", "120,000", "수, 금, 일", "다이어트" }, { "이재준", "120,000", "화, 목, 일", "다이어트" } };

		JTable Pttable = new JTable(Ptdata, Ptheading);
		Pttable.setBackground(Color.WHITE);
		Pttable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		Pttable.setBounds(0, 130, 350, 150);
		ptPage.add(Pttable);
		Pttable.setRowHeight(30);
		Pttable.setFocusable(false);
		Pttable.setRowSelectionAllowed(false);

		TableColumnModel tcm2 = Pttable.getColumnModel();
		for (int i = 0; i < 4; i++) {
			tcm2.getColumn(i).setCellRenderer(dtcr);
		}
		;

		JLabel label_PtAnna = new JLabel(
				"PT \uBAA9\uB85D\uC744 \uD655\uC778\uD558\uC2DC\uACE0              \uC744 \uB20C\uB7EC \uB4F1\uB85D\uD558\uC138\uC694.");
		label_PtAnna.setBackground(Color.WHITE);
		label_PtAnna.setForeground(Color.BLACK);
		label_PtAnna.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		label_PtAnna.setBounds(25, 75, 395, 40);
		ptPage.add(label_PtAnna);

		JLabel label_PtSign = new JLabel("\uB4F1\uB85D \uBC84\uD2BC");
		label_PtSign.setFont(new Font("맑은 고딕", Font.BOLD, 18));
		label_PtSign.setForeground(Color.ORANGE);
		label_PtSign.setBounds(180, 75, 90, 40);
		ptPage.add(label_PtSign);

		JPanel panel_PtTitle = new JPanel();
		panel_PtTitle.setBackground(Color.WHITE);
		panel_PtTitle.setBounds(0, 75, 445, 40);
		ptPage.add(panel_PtTitle);

		JPanel panel_PtMain = new JPanel();
		panel_PtMain.setBackground(Color.LIGHT_GRAY);
		panel_PtMain.setBounds(0, 115, 445, 178);
		ptPage.add(panel_PtMain);

		JPanel tnPage = new JPanel();
		tnPage.setBackground(Color.DARK_GRAY);
		tnPage.setBounds(0, 0, 684, 411);
		frame.getContentPane().add(tnPage);
		tnPage.setLayout(null);
		frame.getContentPane().add(tnPage, BorderLayout.CENTER);

		JButton btnBacktn = new JButton("\uC774\uC804");
		btnBacktn.setBounds(166, 327, 112, 43);
		btnBacktn.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnBacktn.setBackground(Color.ORANGE);
		tnPage.add(btnBacktn);

		JLabel labelTn = new JLabel("\uD2B8\uB808\uC774\uB108 \uC815\uBCF4\uD655\uC778");
		labelTn.setBounds(15, 15, 180, 40);
		labelTn.setForeground(Color.ORANGE);
		labelTn.setFont(new Font("맑은 고딕", Font.BOLD, 20));
		tnPage.add(labelTn);

		String[] Tnheading = new String[] { "TrainerName", "TrainerPN", "TrainerSex", "TrainerBirth",
				"TrainerStartDate", "ExerciseSection" };
		Object[][] Tndata = new Object[][] { { "이   름", "연  락  처", "성  별", "생년월일", "입 관 일", "담당파트 " },
				{ "엄덕현", "01046349692", "남", "19960528", "20150713", "웨이트" },
				{ "이재준", "01054951545", "남", "19960315", "20160213", "필라테스" },
				{ "안상언", "01056633573", "남", "19970318", "20170813", "다이어트" },
				{ "김상원", "01046854153", "여", "19960918", "20150913", "에어로빅" } };

		JTable Tntable = new JTable(Tndata, Tnheading);
		Tntable.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		Tntable.setBounds(0, 130, 445, 150);
		tnPage.add(Tntable);
		Tntable.setRowHeight(30);
		Tntable.getColumn("TrainerName").setPreferredWidth(50);
		Tntable.getColumn("TrainerPN").setPreferredWidth(100);
		Tntable.getColumn("TrainerSex").setPreferredWidth(50);

		TableColumnModel tcm3 = Tntable.getColumnModel();
		for (int i = 0; i < 6; i++) {
			tcm3.getColumn(i).setCellRenderer(dtcr);
		}
		;

		JLabel label_TnAnna = new JLabel(
				"\uD5EC\uC2A4\uC7A5 \uD2B8\uB808\uC774\uB108 \uC815\uBCF4 \uBAA9\uB85D \uC785\uB2C8\uB2E4.");
		label_TnAnna.setForeground(Color.BLACK);
		label_TnAnna.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		label_TnAnna.setBounds(83, 75, 303, 40);
		tnPage.add(label_TnAnna);

		JPanel panel_TnTitle = new JPanel();
		panel_TnTitle.setBackground(Color.WHITE);
		panel_TnTitle.setBounds(0, 75, 445, 40);
		tnPage.add(panel_TnTitle);

		JPanel panel_TnMain = new JPanel();
		panel_TnMain.setBackground(Color.LIGHT_GRAY);
		panel_TnMain.setBounds(0, 115, 445, 178);
		tnPage.add(panel_TnMain);
		tnPage.setVisible(false);

		JPanel startPage = new JPanel();
		startPage.setBackground(Color.WHITE);
		startPage.setBounds(0, 0, 446, 411);
		frame.getContentPane().add(startPage);
		startPage.setLayout(null);

		JLabel label_3 = new JLabel("\uB4F1\uB85D\uBC88\uD638");
		label_3.setBounds(214, 10, 130, 45);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.ORANGE);
		label_3.setFont(new Font("맑은 고딕", Font.BOLD, 16));
		label_3.setBackground(Color.WHITE);
		startPage.add(label_3);

		JPanel panBoard = new JPanel();
		panBoard.setBounds(167, 55, 252, 40);
		panBoard.setBackground(Color.WHITE);
		startPage.add(panBoard);

		JLabel answer = new JLabel("");
		answer.setHorizontalAlignment(SwingConstants.CENTER);
		answer.setFont(new Font("맑은 고딕", Font.PLAIN, 25));
		answer.setBackground(Color.WHITE);
		panBoard.add(answer);

		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 155, 411);
		panel_2.setBackground(Color.DARK_GRAY);
		startPage.add(panel_2);
		panel_2.setLayout(null);

		JButton btnMenu = new JButton("\uC785\uC7A5");
		btnMenu.setBounds(34, 179, 91, 76);
		panel_2.add(btnMenu);
		btnMenu.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		btnMenu.setBackground(Color.ORANGE);

		JButton btnManager = new JButton("\uAD00\uB9AC\uC790\uBA54\uB274");
		btnManager.setFont(new Font("맑은 고딕", Font.BOLD, 13));
		btnManager.setBackground(Color.ORANGE);
		btnManager.setBounds(0, 378, 155, 33);
		panel_2.add(btnManager);

		JLabel label_4 = new JLabel("\uC800\uD76C \uD718\uD2B8\uB2C8\uC2A4\uC13C\uD130\uB97C");
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.ORANGE);
		label_4.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 14));
		label_4.setBackground(Color.WHITE);
		label_4.setBounds(6, 58, 149, 40);
		panel_2.add(label_4);

		JLabel label_2 = new JLabel("\uC624\uC2E0 \uAC83\uC744 \uD658\uC601\uD569\uB2C8\uB2E4");
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.ORANGE);
		label_2.setFont(new Font("맑은 고딕 Semilight", Font.BOLD, 14));
		label_2.setBackground(Color.WHITE);
		label_2.setBounds(6, 91, 149, 40);
		panel_2.add(label_2);

		JButton button_2 = new JButton("1");
		button_2.setBounds(167, 135, 76, 52);
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("1");
			}
		});
		button_2.setForeground(Color.WHITE);
		button_2.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_2.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_2);

		JButton button_3 = new JButton("2");
		button_3.setBounds(255, 135, 76, 52);
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("2");
			}
		});
		button_3.setForeground(Color.WHITE);
		button_3.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_3.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_3);

		JButton button_4 = new JButton("3");
		button_4.setBounds(343, 135, 76, 52);
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("3");
			}
		});
		button_4.setForeground(Color.WHITE);
		button_4.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_4.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_4);

		JButton button_5 = new JButton("6");
		button_5.setBounds(343, 197, 76, 52);
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("6");
			}
		});
		button_5.setForeground(Color.WHITE);
		button_5.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_5.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_5);

		JButton button_6 = new JButton("5");
		button_6.setBounds(255, 197, 76, 52);
		button_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("5");
			}
		});
		button_6.setForeground(Color.WHITE);
		button_6.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_6.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_6);

		JButton button_7 = new JButton("4");
		button_7.setBounds(167, 197, 76, 52);
		button_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("4");
			}
		});
		button_7.setForeground(Color.WHITE);
		button_7.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_7.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_7);

		JButton button_8 = new JButton("9");
		button_8.setBounds(343, 259, 76, 52);
		button_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("9");
			}
		});
		button_8.setForeground(Color.WHITE);
		button_8.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_8.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_8);

		JButton button_9 = new JButton("8");
		button_9.setBounds(255, 259, 76, 52);
		button_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("8");
			}
		});
		button_9.setForeground(Color.WHITE);
		button_9.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_9.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_9);

		JButton button_10 = new JButton("7");
		button_10.setBounds(167, 259, 76, 52);
		button_10.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("7");
			}
		});
		button_10.setForeground(Color.WHITE);
		button_10.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_10.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_10);

		JButton button_11 = new JButton("\uC218\uC815");
		button_11.setBounds(343, 321, 76, 52);
		button_11.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				answer.setText("");
			}
		});
		button_11.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button_11.setBackground(Color.ORANGE);
		startPage.add(button_11);

		JButton button_summit = new JButton("\uD655\uC778");
		button_summit.setBounds(167, 321, 76, 52);

		button_summit.setFont(new Font("맑은 고딕", Font.BOLD, 17));
		button_summit.setBackground(Color.ORANGE);
		startPage.add(button_summit);

		JButton button_12 = new JButton("0");
		button_12.setBounds(255, 321, 76, 52);
		button_12.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("0");
			}
		});
		button_12.setForeground(Color.WHITE);
		button_12.setFont(new Font("맑은 고딕", Font.BOLD, 21));
		button_12.setBackground(Color.LIGHT_GRAY);
		startPage.add(button_12);
		startPage.setVisible(true);

		button_2.addActionListener(new NumberActionListener(answer, "1"));
		button_3.addActionListener(new NumberActionListener(answer, "2"));
		button_4.addActionListener(new NumberActionListener(answer, "3"));
		button_5.addActionListener(new NumberActionListener(answer, "6"));
		button_6.addActionListener(new NumberActionListener(answer, "5"));
		button_7.addActionListener(new NumberActionListener(answer, "4"));
		button_8.addActionListener(new NumberActionListener(answer, "9"));
		button_9.addActionListener(new NumberActionListener(answer, "8"));
		button_10.addActionListener(new NumberActionListener(answer, "7"));
		button_12.addActionListener(new NumberActionListener(answer, "0"));

		JLabel opentext_1 = new JLabel();
		opentext_1.setBounds(167, 105, 252, 27);
		opentext_1.setForeground(new Color(255, 0, 0));
		opentext_1.setHorizontalAlignment(SwingConstants.CENTER);
		opentext_1.setBackground(Color.WHITE);
		startPage.add(opentext_1);

		JLabel label = new JLabel("\uD68C\uC6D0\uB2D8\uC758             \uB97C \uC785\uB825\uD558\uC138\uC694.");
		label.setBounds(167, 21, 254, 22);
		startPage.add(label);
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("맑은 고딕", Font.PLAIN, 16));
		label.setBackground(Color.WHITE);

		btnMember.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managementPage.setVisible(true);
				managerPage.setVisible(false);
				// 관리자메뉴에서 회원 목록 페이지
			}
		});

		button_summit.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Member.MemberID_check();
				if (Member.MemberID_List.contains(answer.getText())) {
					opentext_1.setText("회원번호가 확인되었습니다.");
					memberlogin = true;
					managerlogin = false;
					// 출석 누르면 메뉴화면으로 이동 <<1번쨰 페이지
				} else if (trainerID.contains(answer.getText())) {
					opentext_1.setText("관리자번호가 확인되었습니다.");
					managerlogin = true;
					memberlogin = false;
				} else {
					opentext_1.setText("일치하는 회원번호가 없습니다.");
				}
			}
		});

		btnManager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (managerlogin == true) {
					startPage.setVisible(false);
					managerPage.setVisible(true);
					JOptionPane.showMessageDialog(null, "관리자메뉴에 들어갑니다.");
				} else {
					JOptionPane.showMessageDialog(null, "접근불가! 회원 메뉴로 접속하세요.");
				}
				// 스타트페이지에서 관리자 메뉴 누를시 관리자 메뉴로 이동
			}
		});
		btnMenu.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				if (memberlogin == true && managerlogin == false) {
					loginID = answer.getText();
					menuPage.setVisible(true);
					startPage.setVisible(false);
					JOptionPane.showMessageDialog(null, "환영합니다! 득근하세요!");
					Member.MemberInfo();
					memberinfo1.setText(Member.MemberInfo.get(0));
					memberinfo2.setText(Member.MemberInfo.get(1));
					memberinfo3.setText(Member.MemberInfo.get(2));
					memberinfo4.setText(Member.MemberInfo.get(3));
					memberinfo5.setText(Member.MemberInfo.get(4));
					memberinfo6.setText(Member.MemberInfo.get(5));
					memberinfo7.setText(Member.MemberInfo.get(6));
					memberinfo8.setText(Member.MemberInfo.get(7));
				} else if (managerlogin == true && memberlogin == false) {
					JOptionPane.showMessageDialog(null, "관리자 메뉴로 접속하세요.");
				} else {
					JOptionPane.showMessageDialog(null, "회원번호 입력을 먼저 해주세요.");
				}
			}
		});

		tnPage.setVisible(false);
		btnBacktn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tnPage.setVisible(false);
				ptPage.setVisible(true);
				// 트레이너 확인에서 이전 누를시 메인메뉴로 이동
			}
		});

		termsPage.setVisible(false);
		btnBackmanager.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				termsPage.setVisible(false);
				managerPage.setVisible(true);
				// 괸리자메뉴에서 회원가입 누를시 약관화면 이동
			}
		});

		termsPage.setVisible(false);
		btnsignup.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (checkbox2.isSelected() && checkbox3.isSelected() && checkbox4.isSelected()) {
					termsPage.setVisible(false);
					signupPage.setVisible(true);
					// 메인메뉴에서 pt 확인 누를시 화면 이동
				} else {
					JOptionPane.showMessageDialog(null, "필수 항목을 동의해주세요.");
				}
				// 회원가입에서 이전 누를시 약관 화면 이동
			}
		});

		managerPage.setVisible(false);
		btnbackstart.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				managerlogin = false;
				managerPage.setVisible(false);
				startPage.setVisible(true);
				// 관리자페이지에서 이전 누를시 스타트페이지로 이동
			}
		});
		btnSignup.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				termsPage.setVisible(true);
				managerPage.setVisible(false);
				// 메인메뉴에서 pt 확인 누를시 화면 이동
			}
		});

		mb_table.addMouseListener(new MouseListener() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int row = mb_table.getSelectedRow();
				int column = mb_table.getSelectedColumn();
				after1 = (String) mb_table.getValueAt(row, 0);

				Updatebefore.setText((String) mb_table.getValueAt(row, column));

				co = (String) mb_table.getColumnName(column);
				if (co == "회원정보")
					co = "MemberID";
				else if (co == "이름")
					co = "MemberName";
				else if (co == "성별")
					co = "MemberSex";
				else if (co == "전화번호")
					co = "MemberTel";
				else if (co == "생년월일")
					co = "MemberBirth";
				else if (co == "주소")
					co = "MemberAddress";
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		mb_table.addMouseListener(new MouseListener() {

			@Override
			public void mouseClicked(MouseEvent e) {
				int row = mb_table.getSelectedRow();
				int column = mb_table.getSelectedColumn();
				after1 = (String) mb_table.getValueAt(row, 0);

				co = (String) mb_table.getColumnName(column);
				if (co == "회원정보")
					co = "MemberID";
				else if (co == "이름")
					co = "MemberName";
				else if (co == "성별")
					co = "MemberSex";
				else if (co == "전화번호")
					co = "MemberTel";
				else if (co == "생년월일")
					co = "MemberBirth";
				else if (co == "주소")
					co = "MemberAddress";
			}

			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
			}
		});

		msPage.setVisible(false);
		btnBackms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msPage.setVisible(false);
				menuPage.setVisible(true);
				// 회원권 확인에서 이전 누를시 메인메뉴로 이동
			}
		});

		menuPage.setVisible(false);

		Date date_now = new Date(System.currentTimeMillis());
		SimpleDateFormat fourteen_format = new SimpleDateFormat("yyyy년 MM월dd일 HH시mm분 \n");

		btnOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					OutputStream output = new FileOutputStream(
							"MemoData/" + MemoCalendar.calYear + ((MemoCalendar.calMonth + 1) < 10 ? "0" : "")
									+ (MemoCalendar.calMonth + 1) + (MemoCalendar.calDayOfMon < 10 ? "0" : "")
									+ MemoCalendar.calDayOfMon + "_" + GUI.loginID + ".txt",
							true);
					String str = ("\n 퇴장시간 : " + fourteen_format.format(date_now));
					byte[] by = str.getBytes();
					output.write(by);

				} catch (Exception e1) {
					e1.getStackTrace();
				}
				JOptionPane.showMessageDialog(null, "퇴장시간이 파일에 기록되었습니다.");
			}
		});
		btnMore.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mypnel1.setVisible(false);
				myshipinfo_2.setVisible(true);

				switch (Member.MemberInfo.get(6)) {
				case "X":
					x_shipinfo_panel.setVisible(true);
					break;
				default:
					x_shipinfo_panel.setVisible(false);
					Membership.MembershipInfo();
					shipcodeInfo.setText(Membership.MsInfo.get(0));
					shipoptionInfo.setText(Membership.MsInfo.get(1));
					shippriceInfo.setText(Membership.MsInfo.get(2));
					break;
				}

				switch (Member.MemberInfo.get(7)) {
				case "X":
					x_PTinfo_panel.setVisible(true);
					break;
				default:
					x_PTinfo_panel.setVisible(false);
					PT.PTInfo();
					ptcodeInfo.setText(PT.PTInfo.get(0));
					ptpriceInfo.setText(PT.PTInfo.get(2));
					pttimeInfo.setText(PT.PTInfo.get(3));
					ptpartInfo.setText(PT.PTInfo.get(4));

					Trainer.TrainerNameInfo();
					pttrainerInfo.setText(Trainer.trName);
					break;
				}
			}
		});
		mypnel2.add(btnMore);

		btnBefore.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				menuPage.setVisible(false);
				startPage.setVisible(true);
				memberlogin = false;
				managerlogin = false;
				JOptionPane.showMessageDialog(null, "감사합니다 안녕히가세요.");
			}
		});

		btnMy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				mypnel1.setVisible(true);
				myshipinfo_2.setVisible(false);
				myPage.setVisible(true);
				menuPage.setVisible(false);
				// 메인메뉴에서 내정보 확인 누를시 화면 이동
			}
		});

		btnMs.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				msPage.setVisible(true);
				menuPage.setVisible(false);
				// 메인메뉴에서 회원권 확인 누를시 화면 이동
			}
		});

		btnPt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ptPage.setVisible(true);
				menuPage.setVisible(false);
				// 메인메뉴에서 pt 확인 누를시 화면 이동
			}
		});
		signupPage.setVisible(false);

		btnBackterms.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				termsPage.setVisible(true);
				signupPage.setVisible(false);
				// 괸리자메뉴에서 회원가입 누를시 약관화면 이동
			}
		});

		btnIn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemoCalendar ctext = new MemoCalendar();
				MemoCalendar.memoArea.append("입장시간 : " + fourteen_format.format(date_now));
				// 메인메뉴에서 출석 누를시 현재 시간 메모장 입력
			}
		});

		myPage.setVisible(false);
		btnBackmy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				myPage.setVisible(false);
				menuPage.setVisible(true);
				myshipinfo_2.setVisible(false);
				// 내 정보확인에서 이전 누를시 메인메뉴로 이동
			}
		});

		btnCalmy.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				new MemoCalendar();
				// 괸리자메뉴에서 회원가입 누를시 약관화면 이동
			}
		});

		btnOut.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				MemoCalendar.memoArea.append("퇴장시간 : " + fourteen_format.format(date_now));
				// 메인메뉴에서 퇴장 누를시 현재 시간 메모장 입력
			}
		});

		btnTnpt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				tnPage.setVisible(true);
				ptPage.setVisible(false);
				// pt페이지에서 트레이너 보기 누를시 트레이너 페이지 이동
			}
		});

		btnBackpt.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ptPage.setVisible(false);
				menuPage.setVisible(true);
				// pt 확인에서 이전 누를시 메인메뉴로 이동
			}
		});

		btnBacktn.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				ptPage.setVisible(true);
				tnPage.setVisible(false);
				// 트레이너 확인에서 이전 누를시 메인메뉴로 이동
			}
		});

		MemberDTO dto = new MemberDTO();
		MemberDAO dao = new MemberDAO();

		JButton btnOK = new JButton("\uD655\uC778");
		btnOK.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dto.setMname(nametext.getText());
				if (rdbtnMan.isSelected()) {
					dto.setMsex("남자");
				} else {
					dto.setMsex("여자");
				}
				dto.setMtel(cb_pntext0 + pntext1.getText() + pntext2.getText());
				cb_birth = cb_year + cb_month + cb_day;
				dto.setMbirth(cb_birth);
				dto.setMaddress(addresstext.getText());
				try {
					dao.memberJoin(dto);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.\n회원번호 : " + dto.m_id);
				startPage.setVisible(true);
				signupPage.setVisible(false);
			}
		});

		btnOK.setBackground(Color.ORANGE);
		btnOK.setFont(new Font("맑은 고딕", Font.BOLD, 12));
		btnOK.setBounds(337, 345, 97, 23);
		signupPage.add(btnOK);
	}

	private void add(JScrollPane scroll_Pane, String center) {
		// TODO Auto-generated method stub
	}

	class NumberActionListener implements ActionListener {
		private JLabel label;
		private String text;

		public NumberActionListener(JLabel l, String s) {
			label = l;
			text = s;
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			label.setText(label.getText() + text);
		}
	}
}