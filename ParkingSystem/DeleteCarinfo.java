package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import java.awt.SystemColor;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class DeleteCarinfo extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DeleteCarinfo frame = new DeleteCarinfo();
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
	public DeleteCarinfo() {
		setBounds(100, 100, 440, 283);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8F66\u8F86\u8BB0\u5F55\u4FE1\u606F");
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(151, 13, 125, 18);
		contentPane.add(lblNewLabel);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(28, 44, 377, 95);
		contentPane.add(scrollPane);
		
		JTable table = new JTable();
	    String sql="select fee.Cno ,fee.Pno,Sta from Parkinginfo,fee where Parkinginfo.Pno=fee.Pno";
	    Vector<Vector<String>> data = new Vector<Vector<String>>();//二维向量给定数据得知
	    try{
	    	PreparedStatement ps= Mainframe.link().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Vector<String> row = new Vector<String>();
			row.add(rs.getString("Cno"));
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
	    name.add("车牌号");
	    name.add("车位号");
	    name.add("车位状态");
		table.setModel(new DefaultTableModel(data,name));
		scrollPane.setViewportView(table);
		
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			 String sql="delete fee where Cno=?";
			 String sql1="select fee where Cno=?";
			public void actionPerformed(ActionEvent e) {
				boolean s=false;
				try{
					PreparedStatement ps1 = Mainframe.link().prepareStatement(sql1);
					ps1.setString(1, textField.getText());
					ResultSet rs=ps1.executeQuery();
					s=rs.next();
				}
				catch(Exception ex1){
					
				}
				if(s==true){
				
				try {
					PreparedStatement ps = Mainframe.link().prepareStatement(sql);
					ps.setString(1, textField.getText());
					ps.execute();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}}
				else{
					JOptionPane.showMessageDialog(null, "该车没进入过停车场");
				}
				
			}
		});
		btnNewButton.setBounds(292, 165, 113, 27);
		contentPane.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBounds(151, 166, 125, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u5220\u9664\u7684\u8F66\u724C\u53F7\uFF1A");
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(28, 169, 128, 18);
		contentPane.add(lblNewLabel_1);
	}

}
