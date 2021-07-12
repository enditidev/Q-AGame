import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.*;
import java.util.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class DangNhap1 extends JFrame implements ActionListener
{
	

	ImageIcon moi = new ImageIcon("Image/logo.png");
	
	JButton newAccountButton = new JButton("Create a new Account");
	JCheckBox showPass = new JCheckBox("show password");
	ArrayList<String>loginData = new ArrayList<String>();
	static String loginDataArr[];
	
	public static String tendn ="";
	private JTextField txtUser;
	private JPasswordField txtPass;
	
	
	public static void main(String[] args) throws IOException 
	{
		new DangNhap1();
	}
	
	public DangNhap1() throws IOException
	{
		super("Login");
		//setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Logo EOTIH\\logo.png"));
		getContentPane().setBackground(new Color(255, 204, 51));
		setTitle("Login Game");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(450, 448);
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblLogo = new JLabel("");
		lblLogo.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblLogo.setBounds(138, 0, 160, 118);
		getContentPane().add(lblLogo);
		lblLogo.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\lock_150px.png"));
		
		JLabel lblNotA = new JLabel("Chưa có tài khoản ?");
		lblNotA.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNotA.setBounds(73, 323, 169, 40);
		getContentPane().add(lblNotA);
		
		JLabel lblRegister = new JLabel("Đăng kí ngay !");
		lblRegister.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				Dangki1 a = new Dangki1();
			}
		});
		lblRegister.setForeground(Color.RED);
		lblRegister.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblRegister.setBounds(251, 323, 169, 40);
		getContentPane().add(lblRegister);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBorder(null);
		panel.setBounds(63, 125, 320, 56);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		txtUser = new JTextField();
		txtUser.setBorder(null);
		txtUser.setText("username");
		txtUser.setBounds(10, 10, 250, 35);
		panel.add(txtUser);
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtUser.setColumns(10);
		
		JLabel lblLogo_1 = new JLabel("");
		lblLogo_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\user_50px.png"));
		lblLogo_1.setBounds(258, 0, 50, 50);
		panel.add(lblLogo_1);
		lblLogo_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setBorder(null);
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(63, 191, 320, 56);
		getContentPane().add(panel_1);
		
		JLabel lblLogo_1_1 = new JLabel("");
		lblLogo_1_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\key_50px.png"));
		lblLogo_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
		lblLogo_1_1.setBounds(260, 0, 50, 50);
		panel_1.add(lblLogo_1_1);
		
		txtPass = new JPasswordField();
		txtPass.setBorder(null);
		txtPass.setText("password");
		txtPass.setBounds(10, 10, 250, 35);
		panel_1.add(txtPass);
		
		JPanel panel_1_1 = new JPanel();
		panel_1_1.setLayout(null);
		panel_1_1.setBorder(null);
		panel_1_1.setBackground(SystemColor.desktop);
		panel_1_1.setBounds(63, 257, 318, 56);
		getContentPane().add(panel_1_1);
		
		JLabel lblNewLabel = new JLabel("Log in");
		lblNewLabel.setBounds(0, 0, 318, 56);
		panel_1_1.add(lblNewLabel);
		lblNewLabel.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				tendn = txtUser.getText();
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
					Statement stmt = conn.createStatement();
					String url ="select * from Account where user ='"+txtUser.getText()+"' and password ='"+txtPass.getText()+"'";
					ResultSet rs = stmt.executeQuery(url);
					if(rs.next()) {
						JOptionPane.showMessageDialog(null, "Đăng nhập thành công");
						MenuPRO p = new MenuPRO();
					}else {
						JOptionPane.showMessageDialog(null, "Đăng nhập thất bại");
					}
					conn.close();
					}catch(Exception e1) {
						System.out.println(e1);
					}
			}
		});
		lblNewLabel.setForeground(SystemColor.window);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		
		addToFrame();
		addActionListener();
		
		setVisible(true);
	}
	
	
	public void addToFrame()
	{
	}
	
	public void addActionListener()
	{
		showPass.addActionListener(this);
		newAccountButton.addActionListener(this);
	}
	
	
	
	public void actionPerformed(ActionEvent e)
	{
		
		
		if (e.getSource() == newAccountButton)
		{
		}
		
	}
}