package view.Login;

import java.awt.Color;

import javax.swing.JPanel;

import view.Customer.FormBillDetail;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

import DAO.DAOCustomer;
import Models.Customer;

public class PanelQuenMK extends JPanel {

	public JLabel lblBack;
	private JTextField txtAccount;
	private JTextField txtCCCD;
	private JTextField txtTel;
	private JTextField txtEmail;
	public Customer cus;
	public JButton btnFind;
	
	public void GUI()
	{
		setBackground(new Color(128,255,255));
		setBounds(10, 149, 504, 345);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128,255,255));
		panel.setBounds(22, 52, 460, 237);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(10, 21, 77, 30);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("CCCD");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(10, 76, 77, 30);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Số điện thoại");
		lblNewLabel_1_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_1.setBounds(10, 129, 84, 30);
		panel.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_1_2 = new JLabel("Email");
		lblNewLabel_1_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1_2.setBounds(10, 182, 77, 30);
		panel.add(lblNewLabel_1_1_2);
		
		txtAccount = new JTextField();
		txtAccount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtAccount.setBounds(97, 23, 353, 30);
		panel.add(txtAccount);
		txtAccount.setColumns(10);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(97, 76, 353, 30);
		panel.add(txtCCCD);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTel.setColumns(10);
		txtTel.setBounds(97, 129, 353, 30);
		panel.add(txtTel);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(97, 182, 353, 30);
		panel.add(txtEmail);
		
		JLabel lblNewLabel = new JLabel("Quên mật khẩu");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel.setBounds(163, 6, 196, 42);
		add(lblNewLabel);
		
		ImageIcon icon = new ImageIcon(FormBillDetail.class.getResource("/photo/BackButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblBack = new JLabel("");
		lblBack.setBounds(10, 10, 35, 35);
		lblBack.setIcon(newIcon);
		add(lblBack);
		
		btnFind = new JButton("Tìm tài khoản");
		btnFind.setBounds(189, 299, 136, 39);
		add(btnFind);
		btnFind.setBackground(new Color(128,255,255));
		btnFind.setFont(new Font("Times New Roman", Font.PLAIN, 16));
	}
	
	public PanelQuenMK() {
		this.GUI();
		this.Init();
	}
	
	public Boolean checkFindAccount() throws SQLException
	{
		String Account = txtAccount.getText();
		String Tel = txtTel.getText();
		String Email = txtEmail.getText();
		String CCCD = txtCCCD.getText();
		
		this.cus = new Customer(0, Account, "", "", null, Tel, CCCD, Email, "");
		
		if(Account.equals("") || Tel.equals("") || Email.equals("") || CCCD.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ thông tin để tìm tài khoản");
			return false;
		}
		try {
			Integer.parseInt(Tel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Số điện thoại bạn nhập vào bị sai không đúng với định dạng ( chỉ bao gồm số )");
			return false;
		}
		
		if(Tel.length() != 10)
		{
			JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào bị lỗi");
			return false;
		}
		
		if(!Email.substring(Email.length() - 10).equals("@gmail.com"))
		{
			JOptionPane.showMessageDialog(null, "Email nhập vào không đúng định dạng");
			return false;
		}
		
		if(!DAOCustomer.getInstance().checkFindAccount(cus))
		{
			JOptionPane.showMessageDialog(null, "Lỗi không thể tìm thấy tài khoản phù hợp");
			return false;
		}
		
		JOptionPane.showMessageDialog(null, "Đã tìm thấy tài khoản");
		
		return true;
	}

	public void Init()
	{
		this.txtAccount.setText("");
		this.txtCCCD.setText("");
		this.txtEmail.setText("");
		this.txtTel.setText("");
	}
}
