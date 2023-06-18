package view.Login;

import java.awt.Color;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;

import view.Customer.FormBillDetail;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JTextField;

import DAO.DAOCustomer;
import Models.Customer;

public class PanelResetPassword extends JPanel {

	public JLabel lblBack;
	public JPasswordField txtPassword1;
	public JPasswordField txtPassword2;
	public JButton btnChangePassword;
	public Customer cus = new Customer();
	
	public void Init()
	{
		this.txtPassword1.setText("");
		this.txtPassword2.setText("");
	}
	
	public void GUI()
	{
		setBackground(new Color(128,255,255));
		setBounds(10, 149, 504, 345);
		setLayout(null);
		

		ImageIcon icon = new ImageIcon(FormBillDetail.class.getResource("/photo/BackButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblBack = new JLabel("");
		lblBack.setBounds(10, 22, 35, 35);
		lblBack.setIcon(newIcon);
		add(lblBack);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128,255,255));
		panel.setBounds(32, 67, 436, 222);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(33, 53, 94, 31);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(33, 137, 114, 31);
		panel.add(lblNewLabel_1_1);
		
		txtPassword1 = new JPasswordField();
		txtPassword1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPassword1.setBounds(177, 53, 249, 31);
		panel.add(txtPassword1);
		txtPassword1.setColumns(10);
		
		txtPassword2 = new JPasswordField();
		txtPassword2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPassword2.setColumns(10);
		txtPassword2.setBounds(177, 137, 249, 31);
		panel.add(txtPassword2);
		
		btnChangePassword = new JButton("Thay đổi mật khẩu");
		btnChangePassword.setBackground(new Color(128,255,255));
		btnChangePassword.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnChangePassword.setBounds(165, 299, 165, 36);
		add(btnChangePassword);
		
		JLabel lblNewLabel = new JLabel("Thay đổi mật khẩu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(143, 22, 233, 35);
		add(lblNewLabel);
	}
	
	public PanelResetPassword() {
		this.GUI();
	}
	
	public Boolean checkInput()
	{
		String pass1 = txtPassword1.getText();
		String pass2 = txtPassword2.getText();
		if(pass1.equals("") || pass2.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ 2 mật khẩu trên và dưới");
			return false;
		}
		if(!pass1.equals(pass2))
		{
			JOptionPane.showMessageDialog(null, "Mật khẩu trên và dưới không giống nhau");
			return false;
		}
		
		return true;
	}
	
	public void ChangePassword() throws ClassNotFoundException, SQLException
	{
		String password = txtPassword1.getText();
		cus.setPassword(password);
		DAOCustomer.getInstance().update(cus);
	}
}
