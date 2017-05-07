package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.awt.event.ActionEvent;

public class Carinfo extends JFrame {

	private JPanel contentPane;
	private JTextField txtFdemocarinfoxlsx;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Carinfo frame = new Carinfo();
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
	public Carinfo() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 766, 322);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(14, 85, 720, 80);
		contentPane.add(scrollPane);
		
		JTable table= new JTable();
		String sql="select Carinfo.Cno,fee.Pno,arrivingtime,leavingtime,Sta from Carinfo,Parkinginfo,fee where Carinfo.Cno=fee.Cno and fee.Pno=Parkinginfo.Pno";
	    Vector<Vector<String>> data = new Vector<Vector<String>>();//二维向量给定数据得知
	    try{
	    	PreparedStatement ps= Mainframe.link().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Vector<String> row = new Vector<String>();
			row.add(rs.getString("Cno"));
		    row.add(rs.getString("Pno"));
		    row.add(rs.getString("arrivingtime"));
		    row.add(rs.getString("leavingtime"));
		    row.add(rs.getString("Sta"));
		    data.add(row); //添加一行数据	
		    Mainframe.link().close();
			}
	    }
	    catch(SQLException ex){
	    	
	    }
	   
		Vector<String> name = new Vector<String>();
	    name.add("车牌号");
	    name.add("车位号");
	    name.add("进入时间");
	    name.add("离开时间");
	    name.add("车位状态");
	    table.setModel(new DefaultTableModel(data,name));
		scrollPane.setViewportView(table);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u8F86\u4FE1\u606F\u8868");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(306, 46, 153, 18);
		contentPane.add(lblNewLabel);
		
		txtFdemocarinfoxlsx = new JTextField();
		txtFdemocarinfoxlsx.setText("F:/demo/Carinfo.xls");
		txtFdemocarinfoxlsx.setBounds(235, 208, 206, 24);
		contentPane.add(txtFdemocarinfoxlsx);
		txtFdemocarinfoxlsx.setColumns(10);
		
		JButton btnNewButton = new JButton("\u5BFC\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					ExportTable.exportTable(table, txtFdemocarinfoxlsx.getText());
					JOptionPane.showMessageDialog(null,"导入成功");
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		});
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton.setBounds(454, 208, 79, 25);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u8DEF\u5F84\uFF1A");
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(173, 211, 60, 18);
		contentPane.add(lblNewLabel_1);
		
	}
}
