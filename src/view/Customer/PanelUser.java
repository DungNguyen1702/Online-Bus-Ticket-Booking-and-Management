package view.Customer;

import java.awt.BorderLayout;
import java.awt.Checkbox;
import java.awt.Color;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import javax.swing.SwingConstants;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.DAOCustomer;
import Models.Customer;
import Models.myDate;
import controller.Customer.PanelUserListenner;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.ButtonGroup;

public class PanelUser extends JPanel {

	
	public JTextField txtName;
	public JDateChooser txtDateOfBirths;
	public JTextField txtAccount;
	public JTextField txtPhoneNumber;
	public JTextField txtEmail;
	public JTextField txtCitizenID;
	public JRadioButton radioMale,radioFemale;	
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JButton btnUpdate, btnDoiMK, btnLuu, btnCancel;
	public Customer cus = new Customer();
	public PanelChangePassword panelChangePassword;
	public JPanel panel;
	public String check;
	
	public void GUI()
	{
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 127, 529, 371);
		setLayout(null);
		
		panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(40, 26, 290, 320);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Họ và tên");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel.setBounds(26, 16, 67, 27);
		panel.add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setEditable(false);
		txtName.setBounds(103, 16, 166, 27);
		panel.add(txtName);
		txtName.setColumns(10);
		
		JLabel lblGiiTnh = new JLabel("Giới tính");
		lblGiiTnh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGiiTnh.setBounds(26, 59, 67, 27);
		panel.add(lblGiiTnh);
		
		JLabel lblNgy = new JLabel("Ngày sinh");
		lblNgy.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNgy.setBounds(26, 102, 67, 27);
		panel.add(lblNgy);
		
		JLabel lblaCh = new JLabel("Tài khoản");
		lblaCh.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblaCh.setBounds(26, 145, 67, 27);
		panel.add(lblaCh);
		
		JLabel lblSinThoai = new JLabel("SDT");
		lblSinThoai.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblSinThoai.setBounds(26, 188, 67, 27);
		panel.add(lblSinThoai);
		
		JLabel lblNewLabel_5 = new JLabel("Email");
		lblNewLabel_5.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_5.setBounds(26, 231, 67, 27);
		panel.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("CCCD");
		lblNewLabel_6.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblNewLabel_6.setBounds(26, 274, 67, 27);
		panel.add(lblNewLabel_6);
		
		txtDateOfBirths = new JDateChooser();
		txtDateOfBirths.setEnabled(false);
		txtDateOfBirths.setDateFormatString("dd/MM/yyyy");
		txtDateOfBirths.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtDateOfBirths.getDateEditor();
        editor.setEditable(false);
		txtDateOfBirths.setBounds(103, 102, 166, 27);
		panel.add(txtDateOfBirths);
		
		txtAccount = new JTextField();
		txtAccount.setEditable(false);
		txtAccount.setColumns(10);
		txtAccount.setBounds(103, 145, 166, 27);
		panel.add(txtAccount);
		
		txtPhoneNumber = new JTextField();
		txtPhoneNumber.setEditable(false);
		txtPhoneNumber.setColumns(10);
		txtPhoneNumber.setBounds(103, 188, 166, 27);
		panel.add(txtPhoneNumber);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(103, 231, 166, 27);
		panel.add(txtEmail);
		
		txtCitizenID = new JTextField();
		txtCitizenID.setEditable(false);
		txtCitizenID.setColumns(10);
		txtCitizenID.setBounds(103, 274, 166, 27);
		panel.add(txtCitizenID);
		
		radioMale = new JRadioButton("nam");
		radioMale.setEnabled(false);
		buttonGroup.add(radioMale);
		radioMale.setBackground(new Color(192, 192, 192));
		radioMale.setBounds(103, 61, 67, 23);
		panel.add(radioMale);
		
		radioFemale = new JRadioButton("nữ");
		radioFemale.setEnabled(false);
		buttonGroup.add(radioFemale);
		radioFemale.setBackground(new Color(192, 192, 192));
		radioFemale.setBounds(211, 61, 58, 23);
		panel.add(radioFemale);
		
		btnUpdate = new JButton("Cập nhập thông tin");
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnUpdate.setBackground(new Color(0, 128, 255));
		btnUpdate.setBounds(364, 43, 155, 38);
		btnUpdate.addActionListener(new PanelUserListenner(this));
		add(btnUpdate);
		
		btnDoiMK = new JButton("Đổi mật khẩu");
		btnDoiMK.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnDoiMK.setBackground(new Color(0, 128, 255));
		btnDoiMK.setBounds(364, 124, 155, 38);
		btnDoiMK.addActionListener(new PanelUserListenner(this));
		add(btnDoiMK);
		
		
		btnLuu = new JButton("Lưu");
		btnLuu.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnLuu.setBackground(new Color(0, 128, 255));
		btnLuu.setBounds(364, 205, 155, 38);
		btnLuu.setVisible(false);
		btnLuu.addActionListener(new PanelUserListenner(this));
		add(btnLuu);
		
		btnCancel = new JButton("Hủy");
		btnCancel.setFont(new Font("Tahoma", Font.BOLD, 11));
		btnCancel.setBackground(new Color(0, 128, 255));
		btnCancel.setBounds(364, 286, 155, 38);
		btnCancel.setVisible(false);
		btnCancel.addActionListener(new PanelUserListenner(this));
		add(btnCancel);
		

		this.panelChangePassword = new PanelChangePassword();
		this.panelChangePassword.setVisible(false);
		this.add(panelChangePassword);
	}
	
	public void Init()
	{
		this.txtAccount.setText(cus.getAccount());
		
		
		String dateString = cus.getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")); // Chuỗi ngày tháng cần chuyển đổi
        String pattern = "dd/MM/yyyy"; // Định dạng của chuỗi ngày tháng

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(dateString);
            this.txtDateOfBirths.setDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }

		this.txtName.setText(cus.getName());
		
		this.txtPhoneNumber.setText(cus.getTel());
		
		this.txtEmail.setText(cus.getEmail());

		this.txtCitizenID.setText(cus.getCitizenID());
		
		if(cus.getSex().equals("Nam"))
			radioMale.setSelected(true);
		else if(cus.getSex().equals("Nữ"))
			radioFemale.setSelected(true);
	}
	
	public PanelUser() 
	{
		this.GUI();
	}
	
	public Boolean checkUpdateInfo()
	{
		if(txtCitizenID.getText().equals("") || txtEmail.getText().equals("")||
				txtName.getText().equals("") || txtPhoneNumber.getText().equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin để cập nhập");
			return false;
		}
		try {
			myDate.changeToLocalDate(txtDateOfBirths.getDate());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin để cập nhập");
			return false;
		}
		if(txtEmail.getText().length()<=10)
		{
			JOptionPane.showMessageDialog(null, "Định dạng email bị sai vui lòng nhập lại");
			return false;	
		}
		
		if(!txtEmail.getText().substring(txtEmail.getText().length() - 10).equals("@gmail.com"))
		{
			JOptionPane.showMessageDialog(null, "Định dạng email bị sai vui lòng nhập lại");
			return false;
		}
		if(txtPhoneNumber.getText().length() != 10)
		{
			JOptionPane.showMessageDialog(null, "Số điện thoại bạn nhập vào không đúng vui lòng nhập lại");
			return false;
		}
		try {
			Integer.parseInt(txtPhoneNumber.getText());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào không đúng định dạng ( chỉ bao gồm số ) vui lòng nhập lại");
			return false;
		}
		
		
		return true;
	}
	
	public Boolean checkUpdatePassword()
	{
		String pass1 = panelChangePassword.txt_NewPassword1.getText();
		String pass2 = panelChangePassword.txt_NewPassword2.getText();
		
		if(pass1.equals("") || pass2.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng điền đầy đủ mật khẩu trên và dưới");
			return false;
		}
		
		if(!pass1.equals(pass2))
		{
			JOptionPane.showMessageDialog(null, "Mật khẩu trên và dưới không giống nhau vui lòng nhập lại");
			return false;
		}
		
		return true;
	}
	
	public void btnUpdate_Selected()
	{
		this.panel.setVisible(true);
		this.panelChangePassword.setVisible(false);
		check = "UI"; // Update Information
		
		this.txtCitizenID.setEditable(true);
		this.txtDateOfBirths.setEnabled(true);
		this.txtEmail.setEditable(true);
		this.txtName.setEditable(true);
		this.txtPhoneNumber.setEditable(true);
		this.radioFemale.setEnabled(true);
		this.radioMale.setEnabled(true);
		
		this.btnLuu.setVisible(true);
		this.btnCancel.setVisible(true);
	}
	
	public void btn_DoiMK_Selected()
	{
		check = "UP"; // Update Password
		this.panel.setVisible(false);
		this.panelChangePassword.setVisible(true);
		
		panelChangePassword.txt_Account.setText(cus.getAccount());
		panelChangePassword.txt_OldPassword.setText(cus.getPassword());
		panelChangePassword.txt_NewPassword1.setText("");
		panelChangePassword.txt_NewPassword2.setText("");
		
		this.btnLuu.setVisible(true);
		this.btnCancel.setVisible(true);
	}
	
	public void btn_Luu_Selected()
	{
		if(this.check.equals("UP"))
		{
			cus.setPassword(this.panelChangePassword.txt_NewPassword1.getText());
			try {
				DAOCustomer.getInstance().update(cus);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Mật khẩu mới đã được lưu");
		}
		else if(this.check.equals("UI"))
		{
			cus.setCitizenID(this.txtCitizenID.getText());
			cus.setEmail(this.txtEmail.getText());
			cus.setDateOfBirth(myDate.changeToLocalDate(txtDateOfBirths.getDate()));
			cus.setTel(this.txtPhoneNumber.getText());
			cus.setName(this.txtName.getText());
			if(radioFemale.isSelected())
			{
				cus.setSex("Nữ");
			}
			if(radioMale.isSelected())
			{
				cus.setSex("Nam");
			}
			
			try {
				DAOCustomer.getInstance().update(cus);
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			JOptionPane.showMessageDialog(null, "Thông tin mới đã được lưu");
		}
		this.btn_Cancel_Selected();
	}
	
	public void btn_Cancel_Selected()
	{
		this.btnLuu.setVisible(false);
		this.btnCancel.setVisible(false);
		
		this.panelChangePassword.setVisible(false);
		this.panel.setVisible(true);
		
		// Reset Data
		this.txtCitizenID.setText(cus.getCitizenID());
		String dateString = cus.getDateOfBirth().format(DateTimeFormatter.ofPattern("yyyy-MM-dd")); // Chuỗi ngày tháng cần chuyển đổi
        String pattern = "yyyy-MM-dd"; // Định dạng của chuỗi ngày tháng

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            Date date = dateFormat.parse(dateString);
            this.txtDateOfBirths.setDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }this.txtEmail.setText(cus.getEmail());
		this.txtName.setText(cus.getName());
		this.txtPhoneNumber.setText(cus.getTel());
		if(cus.getSex().equals("Nam"))
		{
			radioMale.setSelected(true);
			radioFemale.setSelected(false);
		}
		if(cus.getSex().equals("Nữ"))
		{
			radioMale.setSelected(false);
			radioFemale.setSelected(true);
		}
			
		// Set editable of textfield
		this.txtCitizenID.setEditable(false);
		this.txtDateOfBirths.setEnabled(false);
		this.txtEmail.setEditable(false);
		this.txtName.setEditable(false);
		this.txtPhoneNumber.setEditable(false);
		this.radioFemale.setEnabled(false);
		this.radioMale.setEnabled(false);
	}
	
}
