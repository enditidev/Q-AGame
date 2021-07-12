import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import javax.swing.*;

import java.awt.*;

import java.awt.event.*;

import java.awt.image.BufferedImage;
import java.beans.Statement;
import java.io.IOException;
import java.sql.DriverManager;
import java.sql.ResultSet;




public class MenuPRO extends JFrame implements ActionListener
{
    private JLabel titleL;
    private JButton startB, helpB, exitB,rank;
    

    static JFrame frame1 = new JFrame();
    private JLabel lblVesion;
    public static String a;
    public static String b;

    public MenuPRO()
    {
    	try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
			java.sql.Statement stmt = conn.createStatement();
			String url = "select Name,user,point from Account where user ='"+DangNhap1.tendn+"'";
			
			//String url = "select Name,user,point from Account where user ='tumoi'";
			ResultSet rs = stmt.executeQuery(url);
			if(rs.next()) {
				a = rs.getString(1);
				b = rs.getString(3);
				//System.out.println(a);
				//System.out.println(b);
			}else {
				JOptionPane.showMessageDialog(null, "Sai tài khoản hoặc mật khẩu !");
			}
			conn.close();
			}catch(Exception e1) {
				System.out.println(e1);
			}
        frame1.getContentPane().setBackground(SystemColor.inactiveCaptionBorder);
        frame1.setSize(577,631);
        Container mainP = frame1.getContentPane();
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 650);


        titleL = new JLabel("WELCOME");
        titleL.setBounds(196, 13, 200, 50);
        startB = new JButton("Play");
        startB.setHorizontalAlignment(SwingConstants.LEFT);
        startB.setFont(new Font("Tahoma", Font.PLAIN, 30));
        startB.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
					Game1 frame = new Game1();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        startB.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\play_75px.png"));
        startB.setBounds(43, 197, 191, 83);
        helpB = new JButton("Profile");
        helpB.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		try {
        			Profile frame = new Profile();
					frame.setVisible(true);
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
        	}
        });
        helpB.setFont(new Font("Tahoma", Font.PLAIN, 30));
        helpB.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\profile_50px.png"));
        helpB.setBounds(304, 195, 191, 86);
        exitB = new JButton("Exit");
        exitB.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent e) {
        		System.exit(0);
        	}
        });
        exitB.setFont(new Font("Tahoma", Font.PLAIN, 30));
        exitB.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\close_window_75px.png"));
        exitB.setBounds(304, 434, 191, 86);
        frame1.getContentPane().setLayout(null);
        
     


        mainP.add(titleL);
        titleL.setFont(new Font("Freestyle Script", Font.BOLD, 50));

        mainP.add(startB);
        startB.setMnemonic(KeyEvent.VK_S);

        mainP.add(helpB);
        helpB.setMnemonic(KeyEvent.VK_H);
        

        mainP.add(exitB);
        exitB.setMnemonic(KeyEvent.VK_E);
        
        lblVesion = new JLabel("Vesion 1.0");
        lblVesion.setFont(new Font("Freestyle Script", Font.BOLD, 50));
        lblVesion.setBounds(359, 533, 200, 50);
        frame1.getContentPane().add(lblVesion);
        
        JButton helpB_1 = new JButton("Normal");
        helpB_1.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\pubg_50px.png"));
        helpB_1.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		try {
					Game g = new Game();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
        	}
        });
        helpB_1.setBackground(Color.WHITE);
        helpB_1.setMnemonic(KeyEvent.VK_H);
        helpB_1.setFont(new Font("Tahoma", Font.PLAIN, 30));
        helpB_1.setBounds(304, 314, 191, 86);
        frame1.getContentPane().add(helpB_1);
        
        JButton rank = new JButton("Rank");
        rank.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		try {
					Ranking frame = new Ranking();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
        		
        	}
        });
        rank.setIcon(new ImageIcon("C:\\Users\\PC DELL\\eclipse-workspace\\menuBarGame\\logo\\leaderboard_50px.png"));
        rank.setMnemonic(KeyEvent.VK_H);
        rank.setFont(new Font("Tahoma", Font.PLAIN, 30));
        rank.setBounds(43, 314, 191, 86);
        frame1.getContentPane().add(rank);
        
        JButton helpB_3 = new JButton("Info");
        helpB_3.addMouseListener(new MouseAdapter() {
        	@Override
        	public void mouseClicked(MouseEvent arg0) {
        		JOptionPane.showMessageDialog(null, "Fb: Nguyễn Duy Thành");
			}
        });
        helpB_3.setMnemonic(KeyEvent.VK_H);
        helpB_3.setFont(new Font("Tahoma", Font.PLAIN, 30));
        helpB_3.setBounds(43, 434, 191, 86);
        frame1.getContentPane().add(helpB_3);
        
        JLabel lblLogo_1_1 = new JLabel("");
        lblLogo_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 25));
        lblLogo_1_1.setBounds(365, 102, 50, 50);
        frame1.getContentPane().add(lblLogo_1_1);
        
        Label txtDiem = new Label("");
        txtDiem.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        txtDiem.setText("Point: "+b);
        txtDiem.setBackground(new Color(0, 128, 0));
        txtDiem.setBounds(149, 121, 266, 44);
        frame1.getContentPane().add(txtDiem);
        
        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBackground(new Color(0, 128, 0));
        panel.setBounds(0, 0, 559, 228);
        frame1.getContentPane().add(panel);
        
        Label txtName = new Label((String) null);
        txtName.setText(""+a);
        txtName.setFont(new Font("Times New Roman", Font.PLAIN, 30));
        txtName.setBackground(new Color(0, 128, 0));
        txtName.setBounds(152, 66, 266, 44);
        panel.add(txtName);


        startB.addActionListener(this);
        helpB.addActionListener(this);
        exitB.addActionListener(this);
        frame1.setVisible(true);


    }
    public void actionPerformed(ActionEvent e)
    {
    }

    public static void main(String[]args)
    {
        new MenuPRO();
    }
}