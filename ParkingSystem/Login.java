package ParkingSystem;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setBounds(100, 100, 542, 346);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8D26\u53F7\uFF1A");
		lblNewLabel.setForeground(new Color(255, 69, 0));
		lblNewLabel.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel.setBounds(119, 100, 72, 18);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5BC6\u7801\uFF1A");
		lblNewLabel_1.setForeground(new Color(255, 69, 0));
		lblNewLabel_1.setFont(new Font("华文隶书", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(119, 147, 72, 18);
		contentPane.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setText("2017001");
		textField.setBounds(176, 97, 171, 24);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(176, 144, 171, 24);
		contentPane.add(passwordField);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String sql="select*from Useinfo Where Uno= ? and Upwd = ?";
			try{
					PreparedStatement ps= Mainframe.link().prepareStatement(sql);
					ps.setString(1, textField.getText());
					ps.setString(2, new String(passwordField.getPassword()));
					ResultSet rs=ps.executeQuery();
					if(rs.next()){
						JOptionPane.showMessageDialog(null, "登陆成功！");
						Mainframe.T=false;
						if(Mainframe.T==false){
							Mainframe.mnNewMenu_2.setEnabled(true);
						    Mainframe.mnNewMenu_3.setEnabled(true);
					        Mainframe.mnNewMenu_4.setEnabled(true);
							Mainframe.mntmNewMenuItem_0.setEnabled(false);
							Mainframe.mntmNewMenuItem_1.setEnabled(true);
							Mainframe.mntmNewMenuItem_2.setEnabled(true);
							Mainframe.mntmNewMenuItem_4.setEnabled(true);
						}
						Mainframe.link().close();
						dispose();
					}
					else{
						JOptionPane.showMessageDialog(null, "用户名或者密码不正确");
					}
			   }catch(SQLException e1){
				
			}
						
			}
		});
		btnNewButton.setForeground(new Color(255, 69, 0));
		btnNewButton.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton.setBounds(228, 202, 86, 27);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u6E05\u7A7A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
			}
		});
		btnNewButton_1.setForeground(new Color(255, 69, 0));
		btnNewButton_1.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton_1.setBounds(372, 96, 79, 27);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u6E05\u7A7A");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				passwordField.setText("");
			}
		});
		btnNewButton_2.setForeground(new Color(255, 69, 0));
		btnNewButton_2.setFont(new Font("华文隶书", Font.PLAIN, 20));
		btnNewButton_2.setBounds(372, 143, 79, 27);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setForeground(new Color(0, 0, 139));
		lblNewLabel_2.setFont(new Font("华文新魏", Font.PLAIN, 18));
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\john\\Pictures\\1-101015101005.jpg"));
		lblNewLabel_2.setBounds(0, 0, 524, 299);
		contentPane.add(lblNewLabel_2);
	}
}
