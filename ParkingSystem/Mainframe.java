package ParkingSystem;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JMenuBar;
import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.SystemColor;


public class Mainframe extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static Connection link(){
		String driverName = "com.microsoft.sqlserver.jdbc.SQLServerDriver"; //¼ÓÔØJDBCÇý¶¯
		String dbURL = "jdbc:sqlserver://localhost:1433; DatabaseName=HomeDB"; //Á¬½Ó·þÎñÆ÷ºÍÊý¾Ý¿âtest
		String userName = "zwh2017kobe24"; //Ä¬ÈÏÓÃ»§Ãû
		String userPwd = "zhaiwenhao960320"; //ÃÜÂë
		Connection conn =null ;
		try {
				Class.forName(driverName);
				conn = DriverManager.getConnection(dbURL, userName, userPwd);
				System.out.println("Connection Successful!"); //Èç¹ûÁ¬½Ó³É¹¦ ¿ØÖÆÌ¨Êä³öConnection Successful!
		    }
		catch (Exception e){
				e.printStackTrace();
			}
		 return conn;
	}
	static JMenu menu;
	static JMenuItem mntmNewMenuItem_4;
	static JMenu mnNewMenu_2 ;
	static JMenu mnNewMenu_3;
	static JMenu mnNewMenu_4;
	static JMenuItem mntmNewMenuItem_0;
	static JMenuItem mntmNewMenuItem_1;
	static JMenuItem mntmNewMenuItem_2;
	static boolean T=true;
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			
			public void run() {
				
				try {
				    Mainframe frame = new Mainframe();
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
	public Mainframe() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 736, 473);
		
		
		JMenuBar menuBar = new JMenuBar();
		menuBar.setBackground(new Color(112, 128, 144));
		setJMenuBar(menuBar);
		
		JMenu menu = new JMenu("\u7528\u6237");
		menu.setForeground(new Color(0, 0, 0));
		menu.setBackground(new Color(240, 248, 255));
		menu.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		menuBar.add(menu);
		
	    mntmNewMenuItem_0 = new JMenuItem("\u767B\u5F55");
	    mntmNewMenuItem_0.setBackground(new Color(204, 204, 255));
	    mntmNewMenuItem_0.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_0.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Login f=new Login();
				f.setVisible(true);
			}
		});
		menu.add(mntmNewMenuItem_0);
		
		mntmNewMenuItem_1 = new JMenuItem("\u4FEE\u6539\u5BC6\u7801");
		mntmNewMenuItem_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_1.setEnabled(false);
		menu.add(mntmNewMenuItem_1);
		
	    mntmNewMenuItem_2 = new JMenuItem("\u6CE8\u9500");
	    mntmNewMenuItem_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
	    mntmNewMenuItem_2.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		Mainframe.T=true;
	    		if(Mainframe.T==true){
					Mainframe.mnNewMenu_3.setEnabled(false);
				    Mainframe.mnNewMenu_4.setEnabled(false);
					Mainframe.mntmNewMenuItem_0.setEnabled(true);
					Mainframe.mntmNewMenuItem_1.setEnabled(false);
					Mainframe.mntmNewMenuItem_2.setEnabled(false);
				    Mainframe.mntmNewMenuItem_4.setEnabled(false);
				}
	    	}
	    });
	    mntmNewMenuItem_2.setEnabled(false);
		menu.add(mntmNewMenuItem_2);
		
		JMenuItem mntmNewMenuItem_3 = new JMenuItem("\u9000\u51FA");
		mntmNewMenuItem_3.setBackground(new Color(204, 204, 255));
		mntmNewMenuItem_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		menu.add(mntmNewMenuItem_3);
		
		JMenu mnNewMenu_1 = new JMenu("\u8F66\u4F4D\u60C5\u51B5");
		mnNewMenu_1.setForeground(new Color(0, 0, 0));
		mnNewMenu_1.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_1);
		
		JMenuItem mntmNewMenuItem = new JMenuItem("\u505C\u8F66\u5165\u53E3");
		mntmNewMenuItem.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String sql=" select count(Pno) as ÊýÁ¿ from Parkinginfo";
				String sql1=" select* from Parkinginfo";
				PreparedStatement ps;
				try {
					ps = Mainframe.link().prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					Mainframe.link();
					Parkinginfo f= new Parkinginfo();
					
				
					while(rs.next())
					{
						String s1=rs.getString("ÊýÁ¿");
						Parkinginfo.lblNewLabel_1.setText(s1);
					}
					f.setVisible(true);
					Mainframe.link().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem);
		
	    mntmNewMenuItem_4 = new JMenuItem("\u7BA1\u7406\u5458\u67E5\u8BE2\u5165\u53E3");
	    mntmNewMenuItem_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
	    mntmNewMenuItem_4.addActionListener(new ActionListener() {
	    	public void actionPerformed(ActionEvent e) {
	    		String sql=" select count(Pno) as ÊýÁ¿ from Parkinginfo";
				String sql1=" select* from Parkinginfo";
				PreparedStatement ps;
				try {
					ps = Mainframe.link().prepareStatement(sql);
					ResultSet rs=ps.executeQuery();
					Mainframe.link();
					Parkinginfo1 f= new Parkinginfo1();
					while(rs.next())
					{
						String s1=rs.getString("ÊýÁ¿");
						Parkinginfo1.lb1.setText(s1);
					}
					f.setVisible(true);
					Mainframe.link().close();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
	    	}
	    });
		mntmNewMenuItem_4.setEnabled(false);
		mnNewMenu_1.add(mntmNewMenuItem_4);
		
		JMenuItem mntmNewMenuItem_7 = new JMenuItem("\u7F34\u8D39\u79BB\u5F00\u5165\u53E3");
		mntmNewMenuItem_7.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Leaving f=new Leaving();
				f.setVisible(true);
			}
		});
		mnNewMenu_1.add(mntmNewMenuItem_7);
		
	    mnNewMenu_2 = new JMenu("\u8BA1\u8D39\u7CFB\u7EDF");
	    mnNewMenu_2.setEnabled(false);
		mnNewMenu_2.setForeground(new Color(0, 0, 0));
		mnNewMenu_2.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_2);
		
		JMenuItem mntmNewMenuItem_6 = new JMenuItem("\u67E5\u770B\u505C\u8F66\u8D39\u8BB0\u5F55");
		mntmNewMenuItem_6.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mntmNewMenuItem_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				fee f=new fee();
				f.setVisible(true);
			}
		});
		mnNewMenu_2.add(mntmNewMenuItem_6);
		
	    mnNewMenu_3 = new JMenu("\u8F66\u8F86\u4FE1\u606F\u67E5\u8BE2\u7CFB\u7EDF");
		mnNewMenu_3.setEnabled(false);
		mnNewMenu_3.setForeground(new Color(0, 0, 0));
		mnNewMenu_3.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_3);
		
		JMenuItem mntmNewMenuItem_5 = new JMenuItem("\u8F66\u8F86\u5B9E\u65F6\u8BB0\u5F55\u8868");
		mntmNewMenuItem_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Carinfo f=new Carinfo();
				f.setVisible(true);
			}
		});
		mntmNewMenuItem_5.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_3.add(mntmNewMenuItem_5);
		
	    mnNewMenu_4 = new JMenu("\u8F66\u8F86\u4FE1\u606F\u7BA1\u7406");
		mnNewMenu_4.setEnabled(false);
		mnNewMenu_4.setForeground(new Color(0, 0, 0));
		mnNewMenu_4.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 20));
		menuBar.add(mnNewMenu_4);
		
		JMenuItem mntmNewMenuItem_8 = new JMenuItem("\u5220\u9664\u79BB\u5F00\u8F66\u8F86\u4FE1\u606F");
		mntmNewMenuItem_8.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DeleteCarinfo f=new DeleteCarinfo();
				f.setVisible(true);
			}
		});
		mntmNewMenuItem_8.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_4.add(mntmNewMenuItem_8);
		
		JMenuItem mntmNewMenuItem_9 = new JMenuItem("\u589E\u52A0\u505C\u8F66\u573A");
		mntmNewMenuItem_9.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				AddPark f=new AddPark();
				f.setVisible(true);
			}
		});
		mntmNewMenuItem_9.setFont(new Font("Î¢ÈíÑÅºÚ", Font.PLAIN, 18));
		mnNewMenu_4.add(mntmNewMenuItem_9);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u6B22\u8FCE\u4F7F\u7528\u505C\u8F66\u573A\u7BA1\u7406\u7CFB\u7EDF\uFF01");
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("»ªÎÄÁ¥Êé", Font.PLAIN, 34));
		lblNewLabel_1.setBackground(Color.WHITE);
		lblNewLabel_1.setBounds(168, 13, 421, 24);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setBackground(new Color(128, 128, 128));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\john\\Pictures\\timg.jpg"));
		lblNewLabel.setBounds(0, 0, 718, 400);
		contentPane.add(lblNewLabel);
	}
}
