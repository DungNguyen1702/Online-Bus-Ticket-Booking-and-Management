package view.Login;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Customer;
import controller.LogIn.FormLoginListenner;
import view.Customer.FormMainPage;

import javax.swing.JButton;
import java.awt.Color;
import java.awt.FlowLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Component;
import javax.swing.Box;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JPasswordField;

public class FormLogin extends JFrame {

	private JPanel contentPane;
	public JTextField txtAccount;
	public JPasswordField txtPassword;
	public JButton btnDangNhap;
	public Customer cus = new Customer(-1, "", "", "", null, "", "", "", "");
	public JPanel panel_DangNhap;
	public PanelDangKi panelDangKi;
	public PanelQuenMK panelQMK;
	public PanelResetPassword panelResetPassword;
	public JLabel lblQuenMK, lblDangKi;
	public static String accountAdmin = "Admin123";
	public static String passwordAdmin = "admin123";
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FormLogin frame = new FormLogin();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public void GUI()
	{
		setTitle("BusMap");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 538, 541);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(128, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(FormLogin.class.getResource("/photo/Graphicloads-Transport-Bus-4.96.png")));
		lblNewLabel_1.setBounds(56, 36, 96, 102);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_3 = new JLabel("GAVN");
		lblNewLabel_3.setForeground(new Color(0, 128, 128));
		lblNewLabel_3.setFont(new Font("Verdana", Font.BOLD, 55));
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_3.setBackground(new Color(128, 255, 255));
		lblNewLabel_3.setBounds(222, 36, 235, 102);
		contentPane.add(lblNewLabel_3);
		
		ImageIcon icon = new ImageIcon(FormLogin.class.getResource("/photo/enter.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(50, 50, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		panel_DangNhap = new JPanel();
		panel_DangNhap.setBackground(new Color(128,255,255));
		panel_DangNhap.setBounds(10, 149, 504, 345);
		contentPane.add(panel_DangNhap);
		panel_DangNhap.setLayout(null);
		
		JLabel lblNewLabel_2 = new JLabel("Đăng nhập");
		lblNewLabel_2.setBounds(145, 0, 216, 45);
		panel_DangNhap.add(lblNewLabel_2);
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(20, 48, 460, 155);
		panel_DangNhap.add(panel_2);
		panel_2.setBackground(new Color(128, 255, 255));
		panel_2.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(24, 31, 106, 34);
		panel_2.add(panel);
		panel.setBackground(new Color(0, 128, 192));
		
		JLabel lblNewLabel = new JLabel("Tài khoản: ");
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
		
		txtAccount = new JTextField();
		txtAccount.setBounds(155, 31, 275, 34);
		panel_2.add(txtAccount);
		txtAccount.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(24, 112, 106, 34);
		panel_2.add(panel_1);
		panel_1.setBackground(new Color(0, 128, 192));
		
		JLabel lblMtKhu = new JLabel("Mật khẩu: ");
		lblMtKhu.setFont(new Font("Times New Roman", Font.BOLD, 20));
		panel_1.add(lblMtKhu);
		
		txtPassword = new JPasswordField();
		txtPassword.setBounds(155, 112, 275, 34);
		panel_2.add(txtPassword);
		txtPassword.setColumns(10);
		
		btnDangNhap = new JButton("");
		btnDangNhap.setBounds(221, 213, 64, 64);
		panel_DangNhap.add(btnDangNhap);
		btnDangNhap.setBackground(new Color(128, 255, 255));
		
		btnDangNhap.setFocusPainted(false);
		btnDangNhap.setBorderPainted(false);
		
		btnDangNhap.setIcon(newIcon);
		
		lblQuenMK = new JLabel("<html><u>Quên mật khẩu ?</u></html>");
		lblQuenMK.setBounds(327, 229, 116, 26);
		panel_DangNhap.add(lblQuenMK);
		lblQuenMK.addMouseListener(new FormLoginListenner(this));
		lblQuenMK.setFont(new Font("Tahoma", Font.PLAIN, 15));
		
		lblDangKi = new JLabel("<html><u>Đăng ký tài khoản</u></html>");
		lblDangKi.setBounds(42, 226, 145, 32);
		panel_DangNhap.add(lblDangKi);
		lblDangKi.setHorizontalAlignment(SwingConstants.CENTER);
		lblDangKi.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblDangKi.addMouseListener(new FormLoginListenner(this));
		btnDangNhap.addActionListener(new FormLoginListenner(this));
		
		this.setVisible(true);
		
	}
	
	public void Init()
	{
		// Panel đăng kí
		this.panelDangKi = new PanelDangKi();
		this.panelDangKi.lblBack.addMouseListener(new FormLoginListenner(this));
		this.panelDangKi.btnCreate.addActionListener(new FormLoginListenner(this));
		this.add(panelDangKi);
		this.panelDangKi.setVisible(false);
		this.panelDangKi.Init();
		
		// Panel quên mật khẩu 
		this.panelQMK = new PanelQuenMK();
		this.panelQMK.lblBack.addMouseListener(new FormLoginListenner(this));
		this.panelQMK.btnFind.addActionListener(new FormLoginListenner(this));
		this.add(panelQMK);
		this.panelQMK.setVisible(false);
		this.panelQMK.Init();
		
		// Panel Reset Password
		this.panelResetPassword = new PanelResetPassword();
		this.panelResetPassword.lblBack.addMouseListener(new FormLoginListenner(this));
		this.panelResetPassword.btnChangePassword.addActionListener(new FormLoginListenner(this));
		this.add(panelResetPassword);
		this.panelResetPassword.setVisible(false);
		this.panelResetPassword.Init();
	}
	
	public FormLogin() {
		this.GUI();
		this.Init();
	}

	public void ResetData()
	{
		this.txtAccount.setText("");
		this.txtPassword.setText("");
	}
	
	// process Register
	public void lblDangKi_Selected()
	{
		this.panel_DangNhap.setVisible(false);
		this.panelDangKi.setVisible(true);
		this.panelDangKi.Init();
	}
	
	public void btnCreate_Selected()
	{
		this.panelDangKi.btnCreate_Selected();
		this.panelDangKi.setVisible(false);
		this.panel_DangNhap.setVisible(true);
	}
	
	// Process forget Password
	public void lblQuenMK_Selected()
	{
		this.panel_DangNhap.setVisible(false);
		this.panelQMK.setVisible(true);
		this.panelQMK.Init();
	}
	
	public void btnFind_Selected()
	{
		this.panelResetPassword.cus = this.panelQMK.cus;
		this.panelQMK.setVisible(false);
		this.panelResetPassword.setVisible(true);
		this.panelResetPassword.Init();
	}
	
	public void btnChangePassword_Selected()
	{
		try {
			this.panelResetPassword.ChangePassword();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		JOptionPane.showMessageDialog(null, "Mật khẩu đã được thay đổi");
		
		this.panelResetPassword.setVisible(false);
		this.panel_DangNhap.setVisible(true);
		this.ResetData();
	}
	
	// Proccess Back button 
	public void panelDangKiApanelQuenMK_lblBack_Selected()
	{
		this.panelDangKi.setVisible(false);
		this.panelQMK.setVisible(false);
		this.panel_DangNhap.setVisible(true);
		this.ResetData();
	}
	
	public void panelResetPassword_lblBack_Selected()
	{
		this.panelResetPassword.setVisible(false);
		this.panelQMK.setVisible(true);
	}
}
