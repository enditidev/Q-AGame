
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFileChooser;
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
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import javax.swing.SwingConstants;
import java.awt.Label;

import javax.swing.JTextField;


public class Game1 extends JFrame {
	

	private JPanel contentPane;
	public static String hoten = "";
	public static String point = "";
	public static String tendn = "";
	public static String abc = "";
	public static int diem = 0;
	public static String c = "";
	public static String cc = "";
	public static String cauhoi = "";
	public static String ques = "";
	public static String ans = "";
	
	public static String nguoidungnhapvao = "";
	public static String a = "";
	public static String aa = "";
	public static String aaa = "";
	public static String aaaa = "";
    // Queue and Stack
    private Queue<File> queue = new LinkedList<> ();
    private Stack<File> stack = new Stack<File> ();
    private int isStack;
    private JTextField txtanswer;
    public String nhap;
    
    private int question_num = 0;

    static ArrayList<String> quess = new ArrayList<String>();
    static ArrayList<String> anss = new ArrayList<String>();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Game1 frame = new Game1();
					//Music music = new Music();
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
	public Game1() {
		String[] questionType= {};
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery("select ques from question");
			while(rs.next()) {
				cauhoi = rs.getString(1);
				List<String> list = new ArrayList<String>(Arrays.asList(questionType));
				if(!(list.contains(cauhoi))) {
					list.add(cauhoi);
				}
				questionType = list.toArray(questionType);
			}
			// Select câu hỏi đầu tiên 
			ResultSet rs2 = stmt.executeQuery("select ques from question");
			rs2.next();
			cc = rs2.getString(1);
			// Select điểm
			ResultSet rs3 = stmt.executeQuery("select point from Account where user='"+DangNhap1.tendn+"'");
			//ResultSet rs3 = stmt.executeQuery("select point from Account where user='thanh'");
				//int rsaa = stmt2.executeUpdate("update taikhoan set point ='"+bc+"' where tendn ='"+eotihLogin.tendn+"'");
			if(rs3.next()){
				diem = rs3.getInt(1);
			}else {
				System.out.println("Không lấy được điểm");
			}
			conn.close();
			}catch(Exception e1) {
				System.out.println(e1);
			}
		
		//setIconImage(Toolkit.getDefaultToolkit().getImage("G:\\Logo EOTIH\\logo.png"));
		setTitle("GAMESHOW");
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 501, 495);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		Menu menuBar = new Menu((JPanel) null);
		menuBar.setBounds(0, 0, 490, 22);
		contentPane.add(menuBar);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(0, 128, 0));
		panel.setBounds(0, 52, 490, 327);
		contentPane.add(panel);
		panel.setLayout(null);
		
		Label lblDiem = new Label("Point:");
		lblDiem.setForeground(Color.WHITE);
		lblDiem.setBounds(316, 283, 174, 44);
		panel.add(lblDiem);
		lblDiem.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblDiem.setBackground(new Color(0, 128, 0));
		
		Label label = new Label("Question:");
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label.setBounds(10, 10, 133, 44);
		panel.add(label);
		
		Label label_1 = new Label("Answer:");
		label_1.setForeground(Color.WHITE);
		label_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		label_1.setBounds(20, 182, 133, 44);
		panel.add(label_1);
		
		txtanswer = new JTextField();
		txtanswer.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		txtanswer.setBounds(159, 182, 265, 44);
		panel.add(txtanswer);
		txtanswer.setColumns(10);
		
		Label lblcauhoi = new Label(c);
		lblcauhoi.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblcauhoi.setText(cc);
		lblcauhoi.setBounds(89, 83, 327, 44);
		panel.add(lblcauhoi);
		
		JButton btnSubmit = new JButton("Play");
		
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				txtanswer.setEnabled(true);
            String listcauhoi = null;
            String[] cauhoinhapvao = {  };
            String listcautraloi = null;
            String[] cautraloinhapvao = {  };
            String type = "Toan";
			nguoidungnhapvao = txtanswer.getText();
			
			try {
				Class.forName("com.mysql.cj.jdbc.Driver");
				java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
				PreparedStatement stmt = conn.prepareStatement("select a.ques,b.ans from question a,answer b where a.theloai=? and a.questionid = b.answerid");
				stmt.setString(1, type);
				ResultSet rs = stmt.executeQuery();
				while(rs.next()) {
					listcauhoi= rs.getString(1);
    				listcautraloi = rs.getString(2);
    				
    				List<String> queslist = new ArrayList<String>(Arrays.asList(cauhoinhapvao));
    				List<String> anlist = new ArrayList<String>(Arrays.asList(cautraloinhapvao));
    				
    				queslist.add(listcauhoi); 
    				anlist.add(listcautraloi);
    				
    		        cauhoinhapvao = queslist.toArray(cauhoinhapvao);
    		        cautraloinhapvao = anlist.toArray(cautraloinhapvao);
    		        //System.out.println(listcauhoi);
    		        //System.out.println(listcautraloi);
				}
				}catch(Exception e1) {
					System.out.println(e1);
				}
			for (int i = 0; i < cauhoinhapvao.length; i++) {
				quess.add(cauhoinhapvao[i]);
            } 
            for (int i = 0; i < cautraloinhapvao.length; i++) { 
            	anss.add(cautraloinhapvao[i]);
            }
			}});
		btnSubmit.setBounds(250, 392, 160, 44);
		contentPane.add(btnSubmit);
		
		JButton cucarot = new JButton("Next");
		cucarot.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				nguoidungnhapvao = txtanswer.getText();
				if (nguoidungnhapvao.equalsIgnoreCase(anss.get(question_num))) {
		            question_num++;
		            diem++;
		            lblDiem.setText("Score: " +diem);
		            //int rs = stmt.executeUpdate("update Account set Name ='"+textName.getText()+"',email = '"+textEmail.getText()+"',password ='"+passwordnew.getText()+"' where user ='"+DangNhap1.tendn+"'");
		           try
		            {
		            	Class.forName("com.mysql.cj.jdbc.Driver");
						java.sql.Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/duythanh","root","duythanh123");
						Statement stmt = conn.createStatement();
						int rs = stmt.executeUpdate("update Account set point ='"+diem+"' where user ='"+DangNhap1.tendn+"'");
						conn.close();
		            }catch(Exception e1) {
						System.out.println(e1);
					}
		            try {
		            	lblcauhoi.setText(quess.get(question_num));
		            	JOptionPane.showMessageDialog(null, "Đúng rồi !!!!");
		            }
		            catch (IndexOutOfBoundsException exception) {
		            	lblcauhoi.setText("You are Champion!!!");
		            	txtanswer.setEnabled(false);
		            }
		        } else {
		        	JOptionPane.showMessageDialog(null, "Bạn trả lời chưa chính xác. Vui lòng trả lời lại");
		        }
			}
		});
		cucarot.setBounds(28, 392, 160, 44);
		contentPane.add(cucarot);
	
}	
}
