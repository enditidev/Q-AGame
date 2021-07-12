import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.JTextComponent;

import java.awt.Color;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Label;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;
import java.awt.Button;
import javax.swing.DropMode;
import javax.swing.JPasswordField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Profile extends JFrame {

	private JPanel contentPane;
	private JTextField textUser;
	private JTextField textEmail;
	private JTextField textName;
	private JPasswordField passwordnew;
	private JPasswordField passwordagain;
	private JPasswordField passwordold;
	
    public static String pass;
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Profile frame = new Profile();
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
	public Profile() {
		
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 618);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		panel.setForeground(new Color(0, 0, 0));
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(new Color(51, 153, 153));
		contentPane.add(panel, BorderLayout.CENTER);
		
		Label label = new Label("Name:");
		label.setFont(new Font("VNtimes new roman", Font.PLAIN, 20));
		label.setBounds(37, 74, 70, 35);
		panel.add(label);
		
		Label label_1 = new Label("Email:");
		label_1.setFont(new Font("VNtimes new roman", Font.PLAIN, 20));
		label_1.setBounds(37, 144, 70, 35);
		panel.add(label_1);
		
		Label label_2 = new Label("User:");
		label_2.setFont(new Font("VNtimes new roman", Font.PLAIN, 20));
		label_2.setBounds(37, 212, 70, 35);
		panel.add(label_2);
		
		Label label_3 = new Label("Old password:");
		label_3.setFont(new Font("VNtimes new roman", Font.PLAIN, 19));
		label_3.setBounds(37, 282, 125, 35);
		panel.add(label_3);
		
		Label label_4 = new Label("New password:");
		label_4.setFont(new Font("VNtimes new roman", Font.PLAIN, 19));
		label_4.setBounds(39, 357, 140, 35);
		panel.add(label_4);
		
		Label label_4_1 = new Label("Enter the password:");
		label_4_1.setFont(new Font("VNtimes new roman", Font.PLAIN, 19));
		label_4_1.setBounds(37, 428, 175, 35);
		panel.add(label_4_1);
		
		textUser = new JTextField();
		textUser.setEditable(false);
		textUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		//txtUser.setText(c);
		textUser.setColumns(10);
		textUser.setBorder(null);
		textUser.setBounds(218, 212, 192, 35);
		panel.add(textUser);
		
		textEmail = new JTextField();
		textEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		//txtEmail.setText(b);
		textEmail.setColumns(10);
		textEmail.setBorder(null);
		textEmail.setBounds(218, 144, 192, 35);
		panel.add(textEmail);
		
		textName = new JTextField();
		textName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		//txtName.setText(a);
		textName.setColumns(10);
		textName.setBorder(null);
		textName.setBounds(218, 74, 192, 35);
		panel.add(textName);
		
		Button btnUpdate = new Button("Update");
		btnUpdate.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				if (passwordold.getText().equals(pass)) {
					if(passwordnew.getText().equals(passwordagain.getText())) {
				try {
					Class.forName("com.mysql.cj.jdbc.Driver");
					java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
					Statement stmt = conn.createStatement();
					int rs = stmt.executeUpdate("update Account set Name ='"+textName.getText()+"',email = '"+textEmail.getText()+"',password ='"+passwordnew.getText()+"' where user ='"+DangNhap1.tendn+"'");
					if(rs == 1) {
						JOptionPane.showMessageDialog(null, "Thay đổi thông tin tài khoản thành công !");
					}else {
						JOptionPane.showMessageDialog(null, "Thay đổi thông tin tài khoản không thành công!");
					}
					conn.close();
					}catch(Exception e1) {
						System.out.println(e1);
					}
			}else {
				JOptionPane.showMessageDialog(null, "Mật khẩu mới không khớp !");
			}
		}else {
			JOptionPane.showMessageDialog(null, "Sai mật khẩu cũ !");
		}
	}
});
		btnUpdate.setFont(new Font("VNtimes new roman", Font.PLAIN, 30));
		btnUpdate.setBounds(150, 496, 125, 44);
		panel.add(btnUpdate);
		
		Label label_5 = new Label("Edit Profile");
		label_5.setForeground(Color.WHITE);
		label_5.setFont(new Font("VNtimes new roman", Font.BOLD, 30));
		label_5.setAlignment(Label.CENTER);
		label_5.setBackground(new Color(51, 153, 153));
		label_5.setBounds(90, 22, 224, 46);
		panel.add(label_5);
		
		passwordnew = new JPasswordField();
		passwordnew.setBorder(null);
		passwordnew.setBounds(218, 357, 194, 35);
		panel.add(passwordnew);
		
		passwordagain = new JPasswordField();
		passwordagain.setBorder(null);
		passwordagain.setBounds(218, 430, 197, 35);
		panel.add(passwordagain);
		
		passwordold = new JPasswordField();
		passwordold.setBorder(null);
		passwordold.setBounds(218, 285, 194, 35);
		panel.add(passwordold);
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
			Statement stmt = conn.createStatement();
			String url ="select * from Account where user ='"+DangNhap1.tendn+"'";
			//String url ="select * from Account where user ='thanh'";
			ResultSet rs = stmt.executeQuery(url);
			if(rs.next()) {
				textName.setText(rs.getString(1));
				textEmail.setText(rs.getString(2));
				textUser.setText(rs.getString(3));
				pass = rs.getString(4);
				//a = rs.getString(1);
				//b = rs.getString(2);
				//c = rs.getString(3);
				//passwordold = rs.getString(5);*/
			}else {
				JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu !");
			}
			conn.close();
			}catch(Exception e1) {
				System.out.println(e1);
			}
	}
}
