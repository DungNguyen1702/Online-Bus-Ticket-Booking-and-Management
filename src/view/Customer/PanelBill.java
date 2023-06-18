package view.Customer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.border.BevelBorder;
import javax.swing.border.LineBorder;

import DAO.DAOBill;
import DAO.DAOTicket;
import DAO.DAOTrip;
import Models.Bill;
import Models.Ticket;
import controller.Customer.PanelBillListener;

import javax.swing.UIManager;

public class PanelBill extends JPanel {
	
	public JTextField txtBillID;
	public JTextField txtNameCityStart;
	public JTextField txtNameCityEnd;
	public JTextField txtDistance;
	public JTextField txtDuration;
	public JTextField txtPrice;
	public JTextField txtSituation;
	public JButton btn_Select;
	public JTextField txtBookDate;
	
	public Bill bl;
	public List<Ticket> listTicket;

	public void GUI()
	{
		setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		this.setBounds(167, 127, 491, 132);
		setLayout(null);
		
		JLabel lbMaHoaDon = new JLabel("Mã hóa đơn");
		lbMaHoaDon.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbMaHoaDon.setBounds(10, 11, 68, 14);
		add(lbMaHoaDon);
		
		txtBillID = new JTextField();
		txtBillID.setEditable(false);
		txtBillID.setBounds(89, 8, 51, 20);
		add(txtBillID);
		txtBillID.setColumns(10);
		
		btn_Select = new JButton("Chi tiết");
		btn_Select.setBackground(new Color(255, 255, 0));
		btn_Select.setForeground(new Color(0, 0, 0));
		btn_Select.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		btn_Select.setBounds(379, 7, 89, 23);
		btn_Select.addActionListener(new PanelBillListener(this));
		add(btn_Select);
		
		JLabel lblStart = new JLabel("");
		ImageIcon icon = new ImageIcon(FormMainPage.class.getResource("/photo/Icons-Land-Vista-Map-Markers-Map-Marker-Marker-Outside-Chartreuse.16.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblStart.setIcon(scaledIcon);
		lblStart.setBounds(7, 36, 16, 30);
		add(lblStart);
		
		JLabel lblEnd = new JLabel("");
		ImageIcon icon2 = new ImageIcon(FormMainPage.class.getResource("/photo/Icons-Land-Vista-Map-Markers-Map-Marker-Flag-4-Right-Azure.16.png"));
		Image image2 = icon2.getImage();
		Image scaledImage2 = image2.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		lblEnd.setIcon(scaledIcon2);
		lblEnd.setBounds(5, 72, 16, 30);
		add(lblEnd);
		
		JLabel lblDiemDi = new JLabel("Điểm đi");
		lblDiemDi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDiemDi.setBounds(30, 44, 51, 14);
		add(lblDiemDi);
		
		JLabel lbDiemDen = new JLabel("Điểm đến");
		lbDiemDen.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbDiemDen.setBounds(26, 80, 51, 14);
		add(lbDiemDen);
		
		txtNameCityStart = new JTextField();
		txtNameCityStart.setEditable(false);
		txtNameCityStart.setBounds(88, 41, 96, 20);
		add(txtNameCityStart);
		txtNameCityStart.setColumns(10);
		
		txtNameCityEnd = new JTextField();
		txtNameCityEnd.setEditable(false);
		txtNameCityEnd.setColumns(10);
		txtNameCityEnd.setBounds(88, 77, 96, 20);
		add(txtNameCityEnd);
		
		JLabel lblKhoangCach = new JLabel("Khoảng cách");
		lblKhoangCach.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblKhoangCach.setBounds(191, 44, 77, 14);
		add(lblKhoangCach);
		
		JLabel lblThoiGian = new JLabel("Thời gian");
		lblThoiGian.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblThoiGian.setBounds(191, 80, 77, 14);
		add(lblThoiGian);
		
		txtDistance = new JTextField();
		txtDistance.setEditable(false);
		txtDistance.setColumns(10);
		txtDistance.setBounds(265, 41, 57, 20);
		add(txtDistance);
		
		txtDuration = new JTextField();
		txtDuration.setEditable(false);
		txtDuration.setColumns(10);
		txtDuration.setBounds(265, 77, 57, 20);
		add(txtDuration);
		
		JLabel lblGiaVe = new JLabel("Giá vé");
		lblGiaVe.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGiaVe.setBounds(330, 44, 45, 14);
		add(lblGiaVe);
		
		JLabel lblTinhTrang = new JLabel("Tình trạng");
		lblTinhTrang.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTinhTrang.setBounds(330, 80, 63, 14);
		add(lblTinhTrang);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(391, 41, 90, 20);
		add(txtPrice);
		
		txtSituation = new JTextField();
		txtSituation.setEditable(false);
		txtSituation.setColumns(10);
		txtSituation.setBounds(391, 77, 90, 20);
		add(txtSituation);
		
		JLabel lbMaHoaDon_1 = new JLabel("Ngày đặt");
		lbMaHoaDon_1.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lbMaHoaDon_1.setBounds(150, 11, 68, 14);
		add(lbMaHoaDon_1);
		
		txtBookDate = new JTextField();
		txtBookDate.setEditable(false);
		txtBookDate.setColumns(10);
		txtBookDate.setBounds(208, 8, 161, 20);
		add(txtBookDate);
	}
	
	public void Init() throws ClassNotFoundException, SQLException
	{
		Object[] data = DAOBill.getInstance().getInfoForPanelBill(bl.getBillID());
		
		txtBillID.setText(bl.getBillID() + "");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtBookDate.setText(bl.getBookDate().format(formatter));
		
		listTicket = DAOTicket.getInstance().selectByBillID(bl.getBillID());
		
		Ticket ticket1 = listTicket.get(0);
		String NameCityStart = (String) data[0];
		String NameCityEnd = (String) data[1];
		
		txtNameCityEnd.setText(NameCityEnd);
		txtNameCityStart.setText(NameCityStart);
		
		txtDistance.setText( (int) data[2] + " Km");
		txtPrice.setText(bl.getTotalPrice() + " VND");
		txtSituation.setText(bl.getStatus());
		
		txtDuration.setText( data[3]  + "Giờ");
	}
	
	public void btnSelect_Selected()
	{
		
	}
	
	public PanelBill(Bill bill) {
		this.bl = bill;
		this.GUI();
		try {
			this.Init();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
