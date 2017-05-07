package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.SystemColor;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import java.awt.Font;
import java.awt.Color;

public class Leaving extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Leaving frame = new Leaving();
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
	public Leaving() {
		setBounds(100, 100, 491, 271);
		contentPane = new JPanel();
		contentPane.setBackground(SystemColor.activeCaption);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		textField = new JTextField();
		textField.setBounds(168, 46, 144, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("\u79BB\u5F00");
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			String sql="exec insertCarinfo ?";
			String sql1="exec insertfee ?";
			String sql2="exec updatefee ?";
			String sql3="exec updatesta ?";
			String sql4="select Cno,parkingtime,fee from fee where Cno=?";
			String sql5="select Cno from Carinfo where Cno=?";
			public void actionPerformed(ActionEvent e) {
				boolean s = false;
				try{
					PreparedStatement ps5= Mainframe.link().prepareStatement(sql5);
					ps5.setString(1, textField.getText());
					ResultSet rs5=ps5.executeQuery();
					s=rs5.next();
					Mainframe.link().close();
				}
				catch(SQLException ex2){
					ex2.printStackTrace();
				}
				if(s==true){
				try
				{	
					PreparedStatement ps= Mainframe.link().prepareStatement(sql);
					PreparedStatement ps1= Mainframe.link().prepareStatement(sql1);
					PreparedStatement ps2= Mainframe.link().prepareStatement(sql2);
					PreparedStatement ps3= Mainframe.link().prepareStatement(sql3);
					PreparedStatement ps4= Mainframe.link().prepareStatement(sql4);
					ps.setString(1, textField.getText());
					ps.execute();					
					
					ps1.setString(1,textField.getText());
					ps1.execute();
					
					ps2.setString(1,textField.getText());
					ps2.execute();
					
				
					ps3.setString(1,textField.getText());
					ps3.execute();
					
					
					Vector<Vector<String>> data = new Vector<Vector<String>>();
					JScrollPane scrollPane = new JScrollPane();
					scrollPane.setBounds(92, 122, 296, 39);
					contentPane.add(scrollPane);
					ps4.setString(1,textField.getText());
					ResultSet rs4=ps4.executeQuery();
					while(rs4.next())
					{
						Vector<String> row = new Vector<String>();
						row.add(rs4.getString("Cno"));
						row.add(rs4.getString("parkingtime"));
						row.add(rs4.getString("fee"));
					    data.add(row); //添加一行数据	
					}
					table = new JTable();
					Vector<String> name = new Vector<String>();//一维向量给定表头
				    name.add("车牌号");
				    name.add("停车时间(h)");
				    name.add("费用(元)");
					table.setModel(new DefaultTableModel(data,name));
					scrollPane.setViewportView(table);
					btnNewButton.setEnabled(false);
					Mainframe.link().close();
				}
				catch(SQLException ex){
					ex.printStackTrace();
				}}
				else{
					JOptionPane.showMessageDialog(null, "该车不存在车库");
					System.exit(0);
				}
					
			}
		});
	
		btnNewButton.setBounds(326, 45, 84, 27);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u8F66\u724C\u53F7\uFF1A");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 49, 153, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D39\u7528\u5982\u4E0B\uFF1A");
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(53, 91, 100, 18);
		contentPane.add(lblNewLabel_1);
		
		
		
		
	}
}
