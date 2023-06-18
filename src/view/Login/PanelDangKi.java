package view.Login;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.DAOCustomer;
import Models.Customer;
import Models.myDate;
import view.Customer.FormBillDetail;

import javax.swing.JRadioButton;

public class PanelDangKi extends JPanel {
	private JTextField txtName;
	private JTextField txtTel;
	private JTextField txtEmail;
	private JDateChooser txtDOB;
	private JTextField txtCCCD;
	private JTextField txtAccount;
	private JPasswordField txtPassword;
	public JRadioButton rdbtnMale, rdbtnFemale;
	public JLabel lblBack;
	public JButton btnCreate;
	private ButtonGroup btngrp = new ButtonGroup();
	public String accountAdmin = FormLogin.accountAdmin;

	public void GUI()
	{
		this.setBackground(new Color(128,255,255));
		setBounds(10, 149, 504, 345);
		setLayout(null);
		
		JLabel blblDangKi = new JLabel("Đăng kí");
		blblDangKi.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		blblDangKi.setBounds(198, 10, 120, 40);
		add(blblDangKi);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128,255,255));
		panel.setBounds(10, 52, 484, 262);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblHoTen = new JLabel("Họ và tên");
		lblHoTen.setBounds(10, 21, 72, 19);
		panel.add(lblHoTen);
		lblHoTen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblSex = new JLabel("Giới tính");
		lblSex.setBounds(10, 61, 97, 19);
		panel.add(lblSex);
		lblSex.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblTel = new JLabel("Số điện thoại");
		lblTel.setBounds(10, 101, 97, 19);
		panel.add(lblTel);
		lblTel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblEmail = new JLabel("Email");
		lblEmail.setBounds(10, 141, 97, 19);
		panel.add(lblEmail);
		lblEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblDOB = new JLabel("Ngày sinh");
		lblDOB.setBounds(10, 181, 64, 19);
		panel.add(lblDOB);
		lblDOB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblCCCD = new JLabel("CCCD");
		lblCCCD.setBounds(10, 221, 64, 19);
		panel.add(lblCCCD);
		lblCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblNewLabel_1 = new JLabel("Tài khoản");
		lblNewLabel_1.setBounds(250, 181, 72, 19);
		panel.add(lblNewLabel_1);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JLabel lblMạtKhau = new JLabel("Mật khẩu");
		lblMạtKhau.setBounds(250, 221, 72, 19);
		panel.add(lblMạtKhau);
		lblMạtKhau.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtName = new JTextField();
		txtName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtName.setBounds(110, 17, 364, 27);
		panel.add(txtName);
		txtName.setColumns(10);
		
		txtTel = new JTextField();
		txtTel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTel.setColumns(10);
		txtTel.setBounds(110, 93, 364, 27);
		panel.add(txtTel);
		
		txtEmail = new JTextField();
		txtEmail.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtEmail.setColumns(10);
		txtEmail.setBounds(110, 133, 364, 27);
		panel.add(txtEmail);
		
		txtDOB = new JDateChooser();
		txtDOB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDOB.setDateFormatString("dd/MM/yyyy");
		txtDOB.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtDOB.getDateEditor();
        editor.setEditable(false);
		txtDOB.setBounds(81, 177, 159, 27);
		panel.add(txtDOB);
		
		txtCCCD = new JTextField();
		txtCCCD.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtCCCD.setColumns(10);
		txtCCCD.setBounds(81, 217, 159, 27);
		panel.add(txtCCCD);
		
		txtAccount = new JTextField();
		txtAccount.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtAccount.setColumns(10);
		txtAccount.setBounds(315, 177, 159, 27);
		panel.add(txtAccount);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtPassword.setColumns(10);
		txtPassword.setBounds(315, 217, 159, 27);
		panel.add(txtPassword);
		
		rdbtnMale = new JRadioButton("Nam");
		rdbtnMale.setBackground(new Color(128,255,255));
		rdbtnMale.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnMale.setBounds(110, 60, 103, 21);
		btngrp.add(rdbtnMale);
		panel.add(rdbtnMale);
		
		rdbtnFemale = new JRadioButton("Nữ");
		rdbtnFemale.setBackground(new Color(128,255,255));
		rdbtnFemale.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnFemale.setBounds(305, 60, 103, 21);
		btngrp.add(rdbtnFemale);
		panel.add(rdbtnFemale);
		
		btnCreate = new JButton("Tạo tài khoản");
		btnCreate.setBackground(Color.CYAN);
		btnCreate.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnCreate.setBounds(198, 314, 120, 31);
		add(btnCreate);
		
		ImageIcon icon = new ImageIcon(FormBillDetail.class.getResource("/photo/BackButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblBack = new JLabel("");
		lblBack.setBounds(10, 10, 35, 35);
		lblBack.setIcon(newIcon);
		add(lblBack);
	}
	
	public void Init()
	{
		this.rdbtnMale.setSelected(true);
		this.txtAccount.setText("");
		this.txtCCCD.setText("");
		this.txtEmail.setText("");
		this.txtName.setText("");
		this.txtPassword.setText("");
		this.txtTel.setText("");
	}
	
	public PanelDangKi() {
		this.GUI();
		this.Init();
	}

	public Boolean checkInfo() throws SQLException
	{
		String Name = txtName.getText();
		String Email = txtEmail.getText();
		String Tel = txtTel.getText();
		String Account = txtAccount.getText();
		String Password = txtPassword.getText();
		String CitizenID = txtCCCD.getText();
		
		if(Name.equals("") || Email.equals("") || Tel.equals("") || 
				Account.equals("") || Password.equals("") || CitizenID.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin tài khoản");
			return false;
		}
		try {
			myDate.changeToLocalDate(txtDOB.getDate());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin tài khoản");
			return false;
		}
		if(Tel.length() != 10)
		{
			JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào không phù hợp");
			return false;
		}
		
		
		try {
			Integer.parseInt(Tel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định số điện thoại chỉ bao gồm số ");
			return false;
		}
		
		try {
			Integer.parseInt(CitizenID);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định CCCD chỉ bao gồm số ");
			return false;
		}
		
		if(Email.length()<=10)
		{
			JOptionPane.showMessageDialog(null, "Đia chỉ email nhập vào không phù hợp với định dạng");
			return false;
		}
		
		if(!Email.substring(Email.length() - 10).equals("@gmail.com"))
		{
			JOptionPane.showMessageDialog(null, "Đia chỉ email nhập vào không phù hợp với định dạng");
			return false;
		}
		if(DAOCustomer.getInstance().checkRegister(Account) == false)
		{
			JOptionPane.showMessageDialog(null, "Tên tài khoản này đã tồn tại vui lòng chọn tài khoản khác");
			return false;
		}
		if(Account.equals(accountAdmin))
		{
			JOptionPane.showMessageDialog(null, "Tên tài khoản này đã tồn tại vui lòng chọn tài khoản khác");
			return false;
		}
		return true;
	}

	public void btnCreate_Selected()
	{
		String Name = txtName.getText();
		String Email = txtEmail.getText();
		String Tel = txtTel.getText();
		String Account = txtAccount.getText();
		String Password = txtPassword.getText();
		String CitizenID = txtCCCD.getText();
		String Sex = "Nam";
		LocalDate date = myDate.changeToLocalDate(txtDOB.getDate());
		
		if(rdbtnFemale.isSelected())
		{
			Sex = "Nữ";
		}
		if(rdbtnMale.isSelected())
		{
			Sex = "Nam";
		}
		
		Customer temp = new Customer(0, Account, Password, Name, date, Tel, CitizenID, Email, Sex);
		try {
			DAOCustomer.getInstance().insert(temp);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Tài khoản đã được tạo");
	}
}
