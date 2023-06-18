package view.Customer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

import DAO.DAOTrip;
import Models.InfoCustomer;
import Models.Route;
import Models.Trip;
import controller.Customer.PanelTripListener;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelTrip extends JPanel {
	
	
	public JLabel lbl_NoiDi, lbl_NoiDen, lbl_KhoangCach, lbl_Time, lbl_SoGheConTrong;
	public JButton btnSelect;
	public Trip trip;
	public InfoCustomer IC;
	public JLabel lbl_Date, lblInputPrice, lblInputTripID, lblInputSeatNumber, lblInputTimeLine, lblInputCityStart, lblInputCityEnd, lblInputDistance; 
	public int CusID;
	public String KindOfBook;
	
	public void GUI()
	{
		setBackground(new Color(200, 200, 200));
		setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		this.setBounds(167, 127, 491, 148);
		setLayout(null);
		
		JLabel lblTimeLine = new JLabel("Giá phổ thông: ");
		lblTimeLine.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTimeLine.setHorizontalAlignment(SwingConstants.CENTER);
		lblTimeLine.setBounds(137, 12, 125, 18);
		add(lblTimeLine);
		
		JLabel lblStart = new JLabel("");
		ImageIcon icon = new ImageIcon(FormMainPage.class.getResource("/photo/Icons-Land-Vista-Map-Markers-Map-Marker-Marker-Outside-Chartreuse.16.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		lblStart.setIcon(scaledIcon);
		lblStart.setBounds(23, 38, 16, 30);
		add(lblStart);
		
		JLabel lblEnd = new JLabel("");
		ImageIcon icon2 = new ImageIcon(FormMainPage.class.getResource("/photo/Icons-Land-Vista-Map-Markers-Map-Marker-Flag-4-Right-Azure.16.png"));
		Image image2 = icon2.getImage();
		Image scaledImage2 = image2.getScaledInstance(16, 16, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
		lblEnd.setIcon(scaledIcon2);
		lblEnd.setBounds(23, 70, 16, 30);
		add(lblEnd);
		
		lbl_NoiDi = new JLabel("Nơi đi: ");
		lbl_NoiDi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_NoiDi.setBounds(49, 46, 68, 14);
		add(lbl_NoiDi);
		
		lbl_NoiDen = new JLabel("Nơi đến: ");
		lbl_NoiDen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_NoiDen.setBounds(49, 78, 68, 14);
		add(lbl_NoiDen);
		
		lbl_KhoangCach = new JLabel("Khoảng cách: ");
		lbl_KhoangCach.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_KhoangCach.setBounds(25, 106, 89, 22);
		add(lbl_KhoangCach);
		
		lbl_Date = new JLabel("");
		lbl_Date.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_Date.setBounds(237, 46, 244, 14);
		add(lbl_Date);
		
		lbl_Time = new JLabel("Giờ đi - giờ đến : ");
		lbl_Time.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_Time.setBounds(237, 78, 118, 14);
		add(lbl_Time);
		
		lbl_SoGheConTrong = new JLabel("Số ghế còn trống: ");
		lbl_SoGheConTrong.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_SoGheConTrong.setBounds(237, 110, 118, 18);
		add(lbl_SoGheConTrong);
		
		btnSelect = new JButton("Chọn");
		btnSelect.setBackground(new Color(255, 255, 0));
		btnSelect.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnSelect.setBounds(362, 10, 89, 23);
		btnSelect.addActionListener(new PanelTripListener(this));
		add(btnSelect);
		
		JLabel lbl_TripID = new JLabel("TripID: ");
		lbl_TripID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lbl_TripID.setBounds(23, 12, 56, 18);
		add(lbl_TripID);
		
		lblInputPrice = new JLabel("");
		lblInputPrice.setHorizontalAlignment(SwingConstants.CENTER);
		lblInputPrice.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputPrice.setBounds(246, 12, 109, 18);
		add(lblInputPrice);
		
		lblInputTripID = new JLabel("");
		lblInputTripID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputTripID.setBounds(77, 12, 56, 18);
		add(lblInputTripID);
		
		lblInputSeatNumber = new JLabel("");
		lblInputSeatNumber.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputSeatNumber.setBounds(355, 110, 108, 18);
		add(lblInputSeatNumber);
		
		lblInputTimeLine = new JLabel("");
		lblInputTimeLine.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputTimeLine.setBounds(345, 78, 136, 14);
		add(lblInputTimeLine);
		
		lblInputCityStart = new JLabel("");
		lblInputCityStart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputCityStart.setBounds(115, 46, 114, 14);
		add(lblInputCityStart);
		
		lblInputCityEnd = new JLabel("");
		lblInputCityEnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputCityEnd.setBounds(115, 78, 114, 14);
		add(lblInputCityEnd);
		
		lblInputDistance = new JLabel("");
		lblInputDistance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblInputDistance.setBounds(115, 106, 114, 22);
		add(lblInputDistance);
	}
	public void Init() throws SQLException
	{
		Object[] data = DAOTrip.getInstance().getInfoPanelTrip(trip.getTripID());
		
		this.lblInputTripID.setText(trip.getTripID() + "");
		this.lblInputCityStart.setText((String) data[0]);
		this.lblInputCityEnd.setText((String) data[1]);
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

		this.lbl_Date.setText(trip.getDateStart().format(formatter) + " - " + trip.getDateEnd().format(formatter));
		
		formatter = DateTimeFormatter.ofPattern("HH:mm");
		this.lblInputTimeLine.setText(trip.getTimeStart().format(formatter) + " - " + trip.getTimeEnd().format(formatter));
	
		this.lblInputDistance.setText((String) data[2] + " Km");
		
		this.lblInputPrice.setText((String) data[3] + " VND");
		
		this.lblInputSeatNumber.setText((String) data[4] + " Chỗ");
	}
	
	public PanelTrip(Trip t, InfoCustomer IC,int CusID, String KindOfBook) {
		this.trip = t;
		this.IC = IC;
		this.CusID = CusID;
		this.KindOfBook = KindOfBook;
		this.GUI();
		try {
			Init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

