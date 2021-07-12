import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.IOException;
import javax.swing.SwingConstants;
import javax.swing.UIManager;


public class Ranking extends JFrame {

	private JPanel contentPane;
	public static String hoten = "";
	public static String tendn = "";
	
	// Top 1
	public static String aname = "";
	public static String apoint = "";
	
	// Top 2
	public static String bname = "";
	public static String bpoint = "";
	
	// Top 3
	public static String cname = "";
	public static String cpoint = "";
	
	// Top 4
	public static String dname = "";
	public static String dpoint = "";
		
	// Top 5
	public static String ename = "";
	public static String epoint = "";
		
	// Top 6
	//public static String fname = "";
	//public static String fpoint = "";
	
	// Top 7
	//public static String gname = "";
	//public static String gpoint = "";
		
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ranking frame = new Ranking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public Ranking() {
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
			Statement stmt = conn.createStatement();
			// Top 1
			String url = "SELECT Name,point FROM Account WHERE point = (SELECT DISTINCT(point) FROM Account ORDER BY point LIMIT 6,1)";
			ResultSet rs = stmt.executeQuery(url);
			if(rs.next()) {
				aname = rs.getString(1);
				apoint = rs.getString(2);
			}else {
				JOptionPane.showMessageDialog(null, "Không có top 1 !");
			}
			//Top 2
			String url2 = "SELECT Name,point FROM Account WHERE point = (SELECT DISTINCT(point) FROM Account ORDER BY point LIMIT 5,1)";
			ResultSet rs2 = stmt.executeQuery(url2);
			if(rs2.next()) {
				bname = rs2.getString(1);
				bpoint = rs2.getString(2);
			}else {
				JOptionPane.showMessageDialog(null, "Không có top 2 !");
			}
			//Top 3
			
			String url3 = "SELECT Name,point FROM Account WHERE point = (SELECT DISTINCT(point) FROM Account ORDER BY point LIMIT 4,1)";
			ResultSet rs3 = stmt.executeQuery(url3);
			if(rs3.next()) {
				cname = rs3.getString(1);
				cpoint = rs3.getString(2);
			}else {
				JOptionPane.showMessageDialog(null, "Không có top 3 !");;
			}
			
			conn.close();
			}catch(Exception e1) {
				System.out.println(e1);
			}
		//setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Logo EOTIH\\logo.png"));
		setTitle("RANKING");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 518, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Menu menuBar = new Menu((JPanel) null);
		menuBar.setBounds(0, 0, 434, 22);
		contentPane.add(menuBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.BLUE);
		panel.setBounds(0, 20, 493, 192);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPic = new JLabel("");
		lblPic.setHorizontalAlignment(SwingConstants.CENTER);
		lblPic.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\trophy_100px.png"));
		lblPic.setForeground(Color.WHITE);
		lblPic.setFont(new Font("Impact", Font.PLAIN, 20));
		lblPic.setBounds(-12, 13, 120, 120);
		panel.add(lblPic);
		
		JLabel lblNewLabel = new JLabel("TOP 1");
		lblNewLabel.setForeground(Color.BLACK);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblNewLabel.setBounds(52, 120, 372, 35);
		panel.add(lblNewLabel);
		
		JLabel lblTop1 = new JLabel(aname+"  Point : "+apoint);
		lblTop1.setHorizontalAlignment(SwingConstants.CENTER);
		lblTop1.setForeground(Color.BLACK);
		lblTop1.setFont(new Font("Times New Roman", Font.BOLD, 20));
		lblTop1.setBounds(52, 152, 372, 35);
		panel.add(lblTop1);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\899a765758b42d730e33511da1fedab5.jpg"));
		lblLogo_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblLogo_1.setBounds(-2, 0, 517, 214);
		panel.add(lblLogo_1);
		
		JPanel panelPlay_1_1_1 = new JPanel();
		panelPlay_1_1_1.setLayout(null);
		panelPlay_1_1_1.setBackground(new Color(255, 255, 255));
		panelPlay_1_1_1.setBounds(0, 248, 493, 52);
		contentPane.add(panelPlay_1_1_1);
		
		JLabel lblNewLabel_2_1_1 = new JLabel("");
		lblNewLabel_2_1_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\silver_medal_50px.png"));
		lblNewLabel_2_1_1.setBounds(10, 0, 50, 50);
		panelPlay_1_1_1.add(lblNewLabel_2_1_1);
		
		JLabel lblTop2 = new JLabel("TOP 2 : " +bname+"  Point : "+bpoint);
		lblTop2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop2.setFont(new Font("Impact", Font.PLAIN, 25));
		lblTop2.setBounds(74, 10, 407, 32);
		panelPlay_1_1_1.add(lblTop2);
		
		JPanel panelPlay_1_1_1_1 = new JPanel();
		panelPlay_1_1_1_1.setLayout(null);
		panelPlay_1_1_1_1.setBackground(new Color(255, 255, 255));
		panelPlay_1_1_1_1.setBounds(0, 313, 493, 52);
		contentPane.add(panelPlay_1_1_1_1);
		
		JLabel lblNewLabel_2_1_1_1 = new JLabel("");
		lblNewLabel_2_1_1_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\bronze_medal_50px.png"));
		lblNewLabel_2_1_1_1.setBounds(10, 0, 50, 50);
		panelPlay_1_1_1_1.add(lblNewLabel_2_1_1_1);
		
		JLabel lblTop3 = new JLabel("TOP 3 : "+cname+"  Point : "+cpoint);
		lblTop3.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop3.setFont(new Font("Impact", Font.PLAIN, 25));
		lblTop3.setBounds(72, 13, 348, 32);
		panelPlay_1_1_1_1.add(lblTop3);
		
		JPanel panelPlay_1_1_1_2 = new JPanel();
		panelPlay_1_1_1_2.setLayout(null);
		panelPlay_1_1_1_2.setBackground(Color.WHITE);
		panelPlay_1_1_1_2.setBounds(0, 378, 493, 52);
		contentPane.add(panelPlay_1_1_1_2);
		
		JLabel lblNewLabel_2_1_1_2 = new JLabel("");
		lblNewLabel_2_1_1_2.setBounds(10, 0, 50, 50);
		panelPlay_1_1_1_2.add(lblNewLabel_2_1_1_2);
		
		JLabel lblTop4 = new JLabel("TOP 4 : ");
		lblTop4.setHorizontalAlignment(SwingConstants.LEFT);
		
		lblTop4.setFont(new Font("Impact", Font.PLAIN, 25));
		lblTop4.setBounds(74, 10, 348, 32);
		panelPlay_1_1_1_2.add(lblTop4);
		
		JPanel panelPlay_1_1_1_2_1 = new JPanel();
		panelPlay_1_1_1_2_1.setLayout(null);
		panelPlay_1_1_1_2_1.setBackground(Color.WHITE);
		panelPlay_1_1_1_2_1.setBounds(0, 443, 493, 52);
		contentPane.add(panelPlay_1_1_1_2_1);
		
		JLabel lblNewLabel_2_1_1_2_1 = new JLabel("");
		lblNewLabel_2_1_1_2_1.setBounds(10, 0, 50, 50);
		panelPlay_1_1_1_2_1.add(lblNewLabel_2_1_1_2_1);
		
		JLabel lblTop = new JLabel("TOP 5  : ");
		lblTop.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop.setFont(new Font("Impact", Font.PLAIN, 25));
		lblTop.setBounds(74, 10, 348, 32);
		panelPlay_1_1_1_2_1.add(lblTop);
		
		
		/*JLabel lblTop_1 = new JLabel("TOP 6 : ");
		lblTop_1.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop_1.setFont(new Font("Impact", Font.PLAIN, 25));
		lblTop_1.setBounds(74, 10, 348, 32);
		panelPlay_1_1_1_2_2.add(lblTop_1);
		
		JPanel panelPlay_1_1_1_2_3 = new JPanel();
		panelPlay_1_1_1_2_3.setLayout(null);
		panelPlay_1_1_1_2_3.setBackground(Color.WHITE);
		panelPlay_1_1_1_2_3.setBounds(0, 536, 444, 52);
		contentPane.add(panelPlay_1_1_1_2_3);
		
		JLabel lblNewLabel_2_1_1_2_3 = new JLabel("");
		lblNewLabel_2_1_1_2_3.setBounds(10, 0, 50, 50);
		panelPlay_1_1_1_2_3.add(lblNewLabel_2_1_1_2_3);
		
		JLabel lblTop_2 = new JLabel("TOP 7 : ");
		lblTop_2.setHorizontalAlignment(SwingConstants.LEFT);
		lblTop_2.setFont(new Font("Impact", Font.PLAIN, 25));
		lblTop_2.setBounds(74, 10, 348, 32);
		panelPlay_1_1_1_2_3.add(lblTop_2);*/
	}
}