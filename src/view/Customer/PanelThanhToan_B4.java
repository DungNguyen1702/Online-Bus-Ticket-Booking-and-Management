package view.Customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAOCity;
import Models.Bill;
import Models.Bus;
import Models.City;
import Models.InfoCustomer;
import Models.Trip;
import controller.Customer.Buoc4Listener;

import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import java.sql.SQLException;

import javax.swing.JTextField;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;

public class PanelThanhToan_B4 extends JPanel {

	private JTextField txt_HoVaTen;
	private JTextField txt_SoDienThoai;
	private JTextField txt_DiaChi;
	private JTextField txt_LoaiXe;
	private JTextField txt_BenXeLen;
	private JTextField txt_GheNgoi;
	private JTextField txt_NgayLenXe;
	private JTextField txt_GiaTien;
	private JTextField txt_ThoiGian;
	public static ButtonGroup bg = new ButtonGroup();
	public JRadioButton rdbtn_NganHang = new JRadioButton("Ngân hàng");
	public JRadioButton rdbtn_TienMat = new JRadioButton("Tiền mặt");
	public FormBookTicket fbt;
	private InfoCustomer IC;
	private int NumberSelectedSeat;
	private Bill bl;
	private Bus bs;
	private Trip trip;
	private City ct;
	public JButton btn_DoiLai, btn_QuayLai, btn_XacNhan;
	
 	public void GUI()
	{
		setBounds(0,0,529,500);
		this.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.LIGHT_GRAY);
		panel.setBounds(24, 66, 484, 147);
		this.add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Thông tin khách hàng");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_1.setBounds(160, 0, 182, 34);
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Họ và tên ");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_2.setBounds(10, 34, 64, 17);
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Số điện thoại");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_3.setBounds(10, 74, 92, 17);
		panel.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Địa chỉ");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_4.setBounds(10, 102, 92, 34);
		panel.add(lblNewLabel_4);
		
		txt_HoVaTen = new JTextField();
		txt_HoVaTen.setEditable(false);
		txt_HoVaTen.setBounds(111, 32, 363, 25);
		panel.add(txt_HoVaTen);
		txt_HoVaTen.setColumns(10);
		
		txt_SoDienThoai = new JTextField();
		txt_SoDienThoai.setEditable(false);
		txt_SoDienThoai.setBounds(111, 68, 363, 25);
		panel.add(txt_SoDienThoai);
		txt_SoDienThoai.setColumns(10);
		
		txt_DiaChi = new JTextField();
		txt_DiaChi.setEditable(false);
		txt_DiaChi.setBounds(112, 109, 362, 25);
		panel.add(txt_DiaChi);
		txt_DiaChi.setColumns(10);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(24, 224, 484, 149);
		this.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_5 = new JLabel("Thông tin xe khách");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_5.setBounds(166, 11, 144, 17);
		panel_1.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("Ngày lên xe");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_6.setBounds(240, 33, 80, 26);
		panel_1.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("Bến xe lên");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_7.setBounds(10, 70, 80, 27);
		panel_1.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("Số ghế");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_8.setBounds(10, 108, 80, 25);
		panel_1.add(lblNewLabel_8);
		
		JLabel lblNewLabel_9 = new JLabel("Loại xe");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_9.setBounds(10, 39, 46, 14);
		panel_1.add(lblNewLabel_9);
		
		JLabel lblGiTin = new JLabel("Giá tiền");
		lblGiTin.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblGiTin.setBounds(250, 76, 46, 14);
		panel_1.add(lblGiTin);
		
		JLabel lblNewLabel_10 = new JLabel("Thời gian");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 14));
		lblNewLabel_10.setBounds(247, 109, 56, 23);
		panel_1.add(lblNewLabel_10);
		
		txt_LoaiXe = new JTextField();
		txt_LoaiXe.setEditable(false);
		txt_LoaiXe.setBounds(85, 33, 152, 26);
		panel_1.add(txt_LoaiXe);
		txt_LoaiXe.setColumns(10);
		
		txt_BenXeLen = new JTextField();
		txt_BenXeLen.setEditable(false);
		txt_BenXeLen.setBounds(84, 70, 153, 25);
		panel_1.add(txt_BenXeLen);
		txt_BenXeLen.setColumns(10);
		
		txt_GheNgoi = new JTextField();
		txt_GheNgoi.setEditable(false);
		txt_GheNgoi.setBounds(85, 109, 67, 25);
		panel_1.add(txt_GheNgoi);
		txt_GheNgoi.setColumns(10);
		
		txt_NgayLenXe = new JTextField();
		txt_NgayLenXe.setEditable(false);
		txt_NgayLenXe.setColumns(10);
		txt_NgayLenXe.setBounds(317, 33, 155, 26);
		panel_1.add(txt_NgayLenXe);
		
		txt_GiaTien = new JTextField();
		txt_GiaTien.setEditable(false);
		txt_GiaTien.setColumns(10);
		txt_GiaTien.setBounds(316, 70, 156, 25);
		panel_1.add(txt_GiaTien);
		
		txt_ThoiGian = new JTextField();
		txt_ThoiGian.setEditable(false);
		txt_ThoiGian.setColumns(10);
		txt_ThoiGian.setBounds(317, 108, 155, 25);
		panel_1.add(txt_ThoiGian);
		
		btn_DoiLai = new JButton("Đổi lại");
		btn_DoiLai.setFont(new Font("Tahoma", Font.BOLD, 11));
		btn_DoiLai.setBounds(155, 109, 82, 25);
		panel_1.add(btn_DoiLai);
		btn_DoiLai.addActionListener(new Buoc4Listener(this));
		
		JLabel lblNewLabel = new JLabel("Thanh toán");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 27));
		lblNewLabel.setBounds(194, 11, 209, 59);
		this.add(lblNewLabel);
		
		btn_QuayLai = new JButton("Quay lại");
		btn_QuayLai.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_QuayLai.setBounds(250, 422, 124, 39);
		btn_QuayLai.setBackground(new Color(255,244,164));
		this.add(btn_QuayLai);
		btn_QuayLai.addActionListener(new Buoc4Listener(this));
		
		btn_XacNhan = new JButton("Xác nhận");
		btn_XacNhan.setFont(new Font("Tahoma", Font.BOLD, 14));
		btn_XacNhan.setBounds(384, 422, 124, 39);
		btn_XacNhan.setBackground(new Color(255,244,164));
		this.add(btn_XacNhan);
		btn_XacNhan.addActionListener(new Buoc4Listener(this));
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(24, 384, 214, 105);
		add(panel_2);
		panel_2.setLayout(null);
		
		rdbtn_TienMat.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_TienMat.setBackground(Color.WHITE);
		rdbtn_TienMat.setBounds(6, 41, 109, 23);
		rdbtn_TienMat.addItemListener(new Buoc4Listener(this));
		rdbtn_TienMat.setSelected(true);
		panel_2.add(rdbtn_TienMat);
		rdbtn_NganHang.setFont(new Font("Tahoma", Font.PLAIN, 14));
		rdbtn_NganHang.setBackground(Color.WHITE);
		rdbtn_NganHang.setBounds(6, 67, 177, 31);
		rdbtn_NganHang.addItemListener(new Buoc4Listener(this));
		panel_2.add(rdbtn_NganHang);
		bg.add(rdbtn_NganHang);
		bg.add(rdbtn_TienMat);
		
		JLabel lblNewLabel_11 = new JLabel("Loại thanh toán");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.BOLD | Font.ITALIC, 14));
		lblNewLabel_11.setBounds(56, 11, 119, 23);
		panel_2.add(lblNewLabel_11);
	}
	
 	public void Init() throws SQLException
 	{
 		txt_BenXeLen.setText(ct.getParkingName());
 		txt_DiaChi.setText(IC.getHomeAddress());
 		txt_GheNgoi.setText(NumberSelectedSeat +"");
 		txt_GiaTien.setText(bl.getTotalPrice() +"");
 		txt_LoaiXe.setText(bs.getKindOfBus());
 		txt_HoVaTen.setText(IC.getRealName());
 		txt_NgayLenXe.setText(trip.getDateStart().toString());
 		txt_SoDienThoai.setText(IC.getPhoneNumber());
 		txt_ThoiGian.setText(trip.getTimeStart().toString());
 	}
 	
	public PanelThanhToan_B4(FormBookTicket fbt, InfoCustomer IC, int NumberSelectSeat, Bill bl, Bus bs, Trip trip ){
		this.GUI();
		this.fbt = fbt;
		this.IC = IC;
		this.NumberSelectedSeat = NumberSelectSeat;
		this.bl = bl;
		this.bs = bs;
		this.trip = trip;
		try {
			ct = DAOCity.getInstance().getParkingCityStartByTripID(trip.getTripID());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		try {
			Init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
}
