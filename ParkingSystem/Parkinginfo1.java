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

public class Parkinginfo1 extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	static JLabel lb1;

	static JTable table;
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Parkinginfo1 frame = new Parkinginfo1();
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
	public Parkinginfo1() {
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
		
		lb1 = new JLabel("New label");
		lb1.setFont(new Font("Bell MT", Font.PLAIN, 20));
		lb1.setForeground(new Color(255, 0, 0));
		lb1.setBounds(123, 41, 78, 18);
		contentPane.add(lb1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5360\u4F4D\u8BB0\u5F55\uFF1A");
		lblNewLabel_2.setForeground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(44, 78, 121, 18);
		contentPane.add(lblNewLabel_2);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(64, 109, 363, 156);
		contentPane.add(scrollPane);
		
		
	    table = new JTable();
	    String sql="select Cno,Parkinginfo.Pno from Parkinginfo,Carinfo where Carinfo.Pno=Parkinginfo.Pno";
	    Vector<Vector<String>> data = new Vector<Vector<String>>();//二维向量给定数据得知
	    try{
	    	PreparedStatement ps= Mainframe.link().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Vector<String> row = new Vector<String>();
			row.add(rs.getString("Cno"));
			row.add(rs.getString("Pno"));
		    data.add(row); //添加一行数据	
		    Mainframe.link().close();
			}
	    }
	    catch(SQLException ex){
	    	
	    }
	    /*用向量使数据库的查询结果加载到表中Jtable*/
	    Vector<String> name = new Vector<String>();//一维向量给定表头
	    name.add("车牌号");
	    name.add("车位号");
		table.setModel(new DefaultTableModel(data,name));
		scrollPane.setViewportView(table);
//		
	}
}
