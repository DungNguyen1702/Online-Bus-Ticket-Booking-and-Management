package view.Customer;

import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import controller.Customer.Buoc4AListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

public class PanelThanhToanBangNganHang extends JPanel {
	private JTextField txt_ChuTaiKhoan;
	private JTextField txt_SoTaiKhoan;
	private JTextField txt_GiaTien;
	private JTextField txt_TenNganHang;
	public FormBookTicket fbt;
	public JButton btn_XacNhan, btnQuayLai;
	
	public void GUI()
	{
		this.setBounds(167,0,529,500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(170,244,240));
		panel.setBounds(10, 38, 509, 451);
		add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(25, 175, 474, 223);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Chủ tài khoản\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(10, 32, 92, 26);
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Số tài khoản");
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(10, 82, 92, 26);
		panel_1.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_1_1 = new JLabel("Giá tiền");
		lblNewLabel_1_1_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_1_1.setBounds(10, 186, 92, 26);
		panel_1.add(lblNewLabel_1_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Tên ngân hàng");
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_1_2.setBounds(10, 136, 114, 26);
		panel_1.add(lblNewLabel_1_2);
		
		txt_ChuTaiKhoan = new JTextField();
		txt_ChuTaiKhoan.setEditable(false);
		txt_ChuTaiKhoan.setBounds(120, 32, 344, 26);
		panel_1.add(txt_ChuTaiKhoan);
		txt_ChuTaiKhoan.setColumns(10);
		
		txt_SoTaiKhoan = new JTextField();
		txt_SoTaiKhoan.setEditable(false);
		txt_SoTaiKhoan.setColumns(10);
		txt_SoTaiKhoan.setBounds(120, 82, 344, 26);
		panel_1.add(txt_SoTaiKhoan);
		
		txt_GiaTien = new JTextField();
		txt_GiaTien.setEditable(false);
		txt_GiaTien.setColumns(10);
		txt_GiaTien.setBounds(120, 186, 344, 26);
		panel_1.add(txt_GiaTien);
		
		txt_TenNganHang = new JTextField();
		txt_TenNganHang.setEditable(false);
		txt_TenNganHang.setColumns(10);
		txt_TenNganHang.setBounds(120, 136, 344, 26);
		panel_1.add(txt_TenNganHang);
		
		JLabel lblNewLabel_2 = new JLabel("Thông tin tài khoản ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 16));
		lblNewLabel_2.setBounds(155, 0, 187, 26);
		panel_1.add(lblNewLabel_2);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(25, 11, 474, 145);
		panel.add(panel_2);
		panel_2.setLayout(null);
		ImageIcon icon = new ImageIcon(PanelThanhToanBangNganHang.class.getResource("/photo/Bank.jpg"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(133, 123, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		JLabel lblNewLabel_3 = new JLabel();
		lblNewLabel_3.setBounds(173, 11, 133, 123);
		panel_2.add(lblNewLabel_3);
		lblNewLabel_3.setIcon(newIcon);
		
		JLabel lbl_Logo = new JLabel("GAVN");
		lbl_Logo.setHorizontalAlignment(SwingConstants.CENTER);
		lbl_Logo.setForeground(new Color(0, 128, 128));
		lbl_Logo.setFont(new Font("Verdana", Font.BOLD, 35));
		lbl_Logo.setBackground(new Color(128, 255, 255));
		lbl_Logo.setBounds(273, 48, 235, 59);
		panel_2.add(lbl_Logo);
		
		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(new ImageIcon(""));
		icon = new ImageIcon(PanelThanhToanBangNganHang.class.getResource("/photo/BusImage.png"));
		img = icon.getImage();
		newImg = img.getScaledInstance(133, 123, Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newImg);
		lblNewLabel_5.setBounds(10, 11, 158, 123);
		lblNewLabel_5.setIcon(newIcon);
		panel_2.add(lblNewLabel_5);
		
		
		
		btn_XacNhan = new JButton("Xác nhận\r\n");
		btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_XacNhan.setBounds(382, 409, 117, 31);
		btn_XacNhan.setBackground(new Color(255,224,164));
		btn_XacNhan.addActionListener(new Buoc4AListener(this));
		panel.add(btn_XacNhan);
		
		
		btnQuayLai = new JButton("Quay lại\r\n");
		btnQuayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnQuayLai.setBackground(new Color(255,224,164));
		btnQuayLai.setBounds(256, 409, 117, 31);
		btnQuayLai.addActionListener(new Buoc4AListener(this));
		panel.add(btnQuayLai);
		
		JLabel lblNewLabel = new JLabel("Thanh toán bằng ngân hàng");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 24));
		lblNewLabel.setBounds(124, 11, 346, 35);
		add(lblNewLabel);

	}
	
	public void Init()
	{
		txt_ChuTaiKhoan.setText("Nguyễn Văn Dũng");
		txt_GiaTien.setText(this.fbt.bl.getTotalPrice()+"");
		txt_SoTaiKhoan.setText("0435 8433 701");
		txt_TenNganHang.setText("TP Bank");
	}
	
	public PanelThanhToanBangNganHang(FormBookTicket fbt) {
		this.fbt = fbt;
		this.GUI();
		Init();
	}
}
