package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import java.awt.SystemColor;
import java.awt.Font;
import java.awt.Color;

public class fee extends JFrame {

	private JPanel contentPane;
	private JLabel lblNewLabel;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					fee frame = new fee();
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
	public fee() {
		setBounds(100, 100, 532, 328);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(72, 93, 370, 95);
		contentPane.add(scrollPane);
		
		JTable table= new JTable();
		String sql="select* from fee";
	    Vector<Vector<String>> data = new Vector<Vector<String>>();//二维向量给定数据得知
	    try{
	    	PreparedStatement ps= Mainframe.link().prepareStatement(sql);
			ResultSet rs=ps.executeQuery();
			while(rs.next()){
			Vector<String> row = new Vector<String>();
			row.add(rs.getString("Pno"));
		    row.add(rs.getString("Cno"));
		    row.add(rs.getString("parkingtime"));
		    row.add(rs.getString("fee"));
		    data.add(row); //添加一行数据	
		    Mainframe.link().close();
			}
	    }
	    catch(SQLException ex){
	    	
	    }
	   
	    
		lblNewLabel = new JLabel("\u8BA1\u8D39\u4FE1\u606F\uFF1A");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(52, 57, 100, 23);
		contentPane.add(lblNewLabel);
		
		Vector<String> name = new Vector<String>();
	    name.add("车位号");
	    name.add("车牌号");
	    name.add("停车时间(h)");
	    name.add("停车费(￥)");
	    table.setModel(new DefaultTableModel(data,name));
		scrollPane.setViewportView(table);
		
	}
}
