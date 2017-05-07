package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;

public class AddPark extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddPark frame = new AddPark();
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
	public AddPark() {
		setBounds(100, 100, 514, 288);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5DF2\u6709\u505C\u8F66\u4F4D\u8868");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(178, 32, 120, 18);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(101, 54, 285, 104);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
	    String sql="select * from Parkinginfo";
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
	    name.add("车位状态");
		table.setModel(new DefaultTableModel(data,name));
		scrollPane.setViewportView(table);
		
		textField = new JTextField();
		textField.setBounds(201, 171, 124, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u6DFB\u52A0");
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			String sql="insert into Parkinginfo values(?,?)";
			String sql1="select Pno where Pno=?";
			public void actionPerformed(ActionEvent e) {
				
				try {
					PreparedStatement ps = Mainframe.link().prepareStatement(sql);
					ps.setString(1,textField.getText());
					ps.setString(2, "Y");
				    ps.execute();
				} catch (SQLException e1) {
					JOptionPane.showMessageDialog(null,"该车场已存在");
				}
					
				}
				
		});
		btnNewButton.setBounds(339, 171, 72, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u6DFB\u52A0\u505C\u8F66\u4F4D\u53F7:");
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(73, 171, 125, 18);
		contentPane.add(lblNewLabel_1);
		
	}
}
