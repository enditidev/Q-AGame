import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Color;
import java.awt.Font;

import javax.swing.border.EtchedBorder;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;
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


public class Dangki1 extends JFrame {

	private JPanel contentPane;
	private JTextField txtEmail;
	private JPasswordField txtPass;

	//Music bgMusic = new Music("G:/JAVA/background/a.wav");
	private JTextField txtName;
	private JTextField txtUser;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dangki1 frame = new Dangki1();
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
	public Dangki1() {
		setVisible(true);
		setTitle("Game - Register");
		setBackground(Color.WHITE);
		setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\JAVA\\background\\Material-design.jpg"));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("REGISTER !");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("Impact", Font.PLAIN, 40));
		lblNewLabel.setBounds(130, 10, 268, 121);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_3_2 = new JLabel("");
		lblNewLabel_3_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3_2.setHorizontalTextPosition(SwingConstants.CENTER);
		lblNewLabel_3_2.setIcon(new ImageIcon("G:\\icon\\user_male_skin_type_6_100px.png"));
		lblNewLabel_3_2.setBounds(136, 99, 150, 107);
		contentPane.add(lblNewLabel_3_2);
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBorder(null);
		panel.setBackground(Color.WHITE);
		panel.setBounds(32, 162, 366, 388);
		contentPane.add(panel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(0, 153, 204));
		panel_1.setLayout(null);
		panel_1.setBounds(42, 304, 300, 50);
		panel.add(panel_1);
		
		JLabel lblSignUp = new JLabel("REGISTER ");
		lblSignUp.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
					String Name = txtName.getText();
					String user = txtUser.getText();
					String Email = txtEmail.getText();
					String password = txtPass.getText();
					 try {
						 if(Name.equals("") || user.equals("") || Email.equals("") || password.equals(""))
						 
							 JOptionPane.showMessageDialog(null, "Vui l??ng nh???p ????? th??ng tin !");
						 else {
							 try {
								 Class.forName("com.mysql.cj.jdbc.Driver");
									java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
									Statement stmt = conn.createStatement();
									 String url = "INSERT INTO Account values('" + Name + "','" + Email + "','" + user + "','" + password + "','0')";
									 int rs = stmt.executeUpdate(url);
										if(rs == 0) {
											JOptionPane.showMessageDialog(null, "????ng k?? th???t b???i");
										}else {
											JOptionPane.showMessageDialog(null, "????ng k?? th??nh c??ng");
										}
							 }catch (Exception exception) {
				                	System.out.println(exception);
							 }
							
							 
						 }
						 
					 }catch (Exception exception) {
			                	System.out.println(exception);
						
					}
					 
			}
		});
		lblSignUp.setForeground(Color.BLACK);
		lblSignUp.setBounds(0, 0, 300, 50);
		panel_1.add(lblSignUp);
		lblSignUp.setHorizontalAlignment(SwingConstants.CENTER);
		lblSignUp.setFont(new Font("Impact", Font.PLAIN, 30));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(42, 124, 300, 50);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setBorder(null);
		txtEmail.setBounds(5, 3, 244, 42);
		txtEmail.setText("Email");
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtEmail.setColumns(10);
		panel_2.add(txtEmail);
		
		JLabel lblNewLabel_3_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1.setBounds(249, 0, 50, 50);
		panel_2.add(lblNewLabel_3_1_1);
		lblNewLabel_3_1_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\gmail_50px.png"));
		
		JPanel panel_2_1 = new JPanel();
		panel_2_1.setLayout(null);
		panel_2_1.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_1.setBackground(Color.WHITE);
		panel_2_1.setBounds(42, 244, 300, 50);
		panel.add(panel_2_1);
		
		JLabel lblNewLabel_3_1_1_1 = new JLabel("New label");
		lblNewLabel_3_1_1_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\key_50px.png"));
		lblNewLabel_3_1_1_1.setBounds(250, 0, 50, 50);
		panel_2_1.add(lblNewLabel_3_1_1_1);
		
		txtPass = new JPasswordField();
		txtPass.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtPass.setBorder(null);
		txtPass.setText("Password");
		txtPass.setBounds(5, 3, 244, 42);
		panel_2_1.add(txtPass);
		
		JPanel panel_2_2 = new JPanel();
		panel_2_2.setLayout(null);
		panel_2_2.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_2.setBackground(Color.WHITE);
		panel_2_2.setBounds(42, 64, 300, 50);
		panel.add(panel_2_2);
		
		txtName = new JTextField();
		txtName.setText("H??? V?? T??n");
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtName.setColumns(10);
		txtName.setBorder(null);
		txtName.setBounds(5, 3, 244, 42);
		panel_2_2.add(txtName);
		
		JLabel lblNewLabel_3_1_1_2 = new JLabel("New label");
		lblNewLabel_3_1_1_2.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\user1_50px.png"));
		lblNewLabel_3_1_1_2.setBounds(249, 0, 50, 50);
		panel_2_2.add(lblNewLabel_3_1_1_2);
		
		JPanel panel_2_3 = new JPanel();
		panel_2_3.setLayout(null);
		panel_2_3.setBorder(new LineBorder(new Color(0, 0, 0)));
		panel_2_3.setBackground(Color.WHITE);
		panel_2_3.setBounds(42, 184, 300, 50);
		panel.add(panel_2_3);
		
		txtUser = new JTextField();
		txtUser.setText("T??n ????ng Nh???p");
		txtUser.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		txtUser.setColumns(10);
		txtUser.setBorder(null);
		txtUser.setBounds(5, 3, 244, 42);
		panel_2_3.add(txtUser);
		
		JLabel lblNewLabel_3_1_1_3 = new JLabel("New label");
		lblNewLabel_3_1_1_3.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\user_50px.png"));
		lblNewLabel_3_1_1_3.setBounds(249, 0, 50, 50);
		panel_2_3.add(lblNewLabel_3_1_1_3);
		
		JLabel lblNewLabel_3_3 = new JLabel("");
		lblNewLabel_3_3.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\background.jpg"));
		lblNewLabel_3_3.setBounds(-13, 0, 480, 634);
		contentPane.add(lblNewLabel_3_3);
	}
}
