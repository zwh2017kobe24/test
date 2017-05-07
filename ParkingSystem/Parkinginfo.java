package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.sql.rowset.Joinable;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JSlider;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import java.awt.SystemColor;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.util.Vector;

import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import javax.xml.bind.JAXB;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;

public class Parkinginfo extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static JLabel lblNewLabel_1;

	static JTable table;
	private JTextField textField;
	private JTextField textField_1;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parkinginfo frame = new Parkinginfo();
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
	public Parkinginfo() {
		setBounds(100, 100, 535, 401);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(0, 0, 0));
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u4F4D\u603B\u6570:");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(14, 41, 106, 18);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(new Color(255, 0, 0));
		lblNewLabel_1.setBounds(123, 41, 78, 18);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setForeground(new Color(255, 0, 0));
		btnNewButton.setFont(new Font("华文隶书", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {
			String sql1="select GetDate() as 到达时间";
			String sql="insert into Carinfo values(?,?,?,?)";
			String sql2="Judge ?";
			String sql3="insert into fee values(?,?,?,?)";
			String date;
			public void actionPerformed(ActionEvent e) {
				boolean s = false;
				try{
					PreparedStatement ps2= Mainframe.link().prepareStatement(sql2);
					ps2.setString(1, textField.getText());
					ResultSet rs2=ps2.executeQuery();
					s=rs2.next();
					Mainframe.link().close();
					}
				catch(Exception ex)
				{
					ex.printStackTrace();
				}
			if(s==true){
			try{
				PreparedStatement ps1= Mainframe.link().prepareStatement(sql1);
				
				ResultSet rs1=ps1.executeQuery();
				while(rs1.next()){
					 
					date=rs1.getString("到达时间");
				}
		
				PreparedStatement ps= Mainframe.link().prepareStatement(sql);
				PreparedStatement ps3= Mainframe.link().prepareStatement(sql3);
				ps.setString(1, textField_1.getText());
				ps.setString(2,date );
			    ps.setDate(3,null);
			    ps.setString(4, textField.getText());
			    ps.execute();
			    
			   
				ps3.setString(1, textField.getText());
				ps3.setString(2, textField_1.getText());
				ps3.setInt(3,0 );
			    ps3.setInt(4,0);
			    ps3.execute();
				
				
					JOptionPane.showMessageDialog(null, "占位成功开始计时");
				
				Mainframe.link().close();
				dispose();
			}
				catch(SQLException ex){
					ex.printStackTrace();
				}}
			else{
				JOptionPane.showMessageDialog(null, "车位不存在或者被占用");
			}
			}
		});
		btnNewButton.setBounds(381, 252, 72, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u8F66\u4F4D\u60C5\u51B5\uFF1A");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 78, 121, 18);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(96, 98, 319, 116);
		contentPane.add(scrollPane);
		
		
	    table = new JTable();
	    String sql="select* from Parkinginfo";
	    Vector<Vector<String>> data = new Vector<Vector<String>>();//二维向量给定数据得知
	    try{
	    	PreparedStatement ps= Mainframe.link().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Vector<String> row = new Vector<String>();
			row.add(rs.getString("Pno"));
		    row.add(rs.getString("Sta"));
		    data.add(row); //添加一行数据	
		    Mainframe.link().close();
			}
	    }
	    catch(SQLException ex){
	    	
	    }
	    /*用向量使数据库的查询结果加载到表中Jtable*/
	    Vector<String> name = new Vector<String>();//一维向量给定表头
	    name.add("车位号");
	    name.add("空闲");
		table.setModel(new DefaultTableModel(data,name));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(242, 281, 97, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("\u8BF7\u9009\u62E9\u505C\u8F66\u8F66\u4F4D:");
		lblNewLabel_3.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(86, 284, 154, 18);
		contentPane.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(242, 227, 97, 24);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u8BF7\u8F93\u5165\u8F66\u724C\u53F7:");
		lblNewLabel_4.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(107, 222, 133, 35);
		contentPane.add(lblNewLabel_4);
//		
	}
}
