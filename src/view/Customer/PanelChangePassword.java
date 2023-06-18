package view.Customer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;

public class PanelChangePassword extends JPanel {
	public JTextField txt_Account;
	public JTextField txt_OldPassword;
	public JTextField txt_NewPassword1;
	public JTextField txt_NewPassword2;

	public void GUI()
	{
		setBackground(new Color(192, 192, 192));
		setBounds(40, 26, 290, 320);
		setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Tài khoản");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(20, 44, 62, 25);
		add(lblNewLabel);
		
		JLabel lblMtKhuC = new JLabel("Mật khẩu cũ");
		lblMtKhuC.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblMtKhuC.setBounds(20, 113, 75, 25);
		add(lblMtKhuC);
		
		JLabel lblNewLabel_1_1 = new JLabel("Mật khẩu mới");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1.setBounds(20, 182, 75, 25);
		add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Nhập lại mật khẩu");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_1_1_1.setBounds(20, 251, 102, 25);
		add(lblNewLabel_1_1_1);
		
		txt_Account = new JTextField();
		txt_Account.setEditable(false);
		txt_Account.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txt_Account.setBounds(120, 44, 160, 25);
		add(txt_Account);
		txt_Account.setColumns(10);
		
		txt_OldPassword = new JTextField();
		txt_OldPassword.setEditable(false);
		txt_OldPassword.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txt_OldPassword.setColumns(10);
		txt_OldPassword.setBounds(120, 113, 160, 25);
		add(txt_OldPassword);
		
		txt_NewPassword1 = new JTextField();
		txt_NewPassword1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txt_NewPassword1.setColumns(10);
		txt_NewPassword1.setBounds(120, 182, 160, 25);
		add(txt_NewPassword1);
		
		txt_NewPassword2 = new JTextField();
		txt_NewPassword2.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		txt_NewPassword2.setColumns(10);
		txt_NewPassword2.setBounds(120, 251, 160, 25);
		add(txt_NewPassword2);
	}
	
	public PanelChangePassword() {
		this.GUI();
	}
}
