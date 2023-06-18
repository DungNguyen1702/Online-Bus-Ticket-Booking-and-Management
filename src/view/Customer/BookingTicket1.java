package view.Customer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;

import java.awt.Font;
import javax.swing.ButtonGroup;
import java.awt.Choice;
import java.awt.GridLayout;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.SwingConstants;
import javax.swing.border.SoftBevelBorder;

import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import Algorithm.floydWarshall;
import DAO.DAOCity;
import Models.Route;
import controller.Customer.BookingTicket1Listener;

import javax.swing.border.BevelBorder;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.border.LineBorder;
import java.awt.Scrollbar;

public class BookingTicket1 extends JPanel {
	public final ButtonGroup buttonGroup = new ButtonGroup();
	public JDateChooser txtNgayDi;
	public JDateChooser txtNgayVe;
	public JRadioButton rdbtnOneTrip, rdbtnRoundTrip;
	public Choice choice_TieuChi, choice_DiemDen, choice_DiemDi;
	public JButton btnSearch, btnViewTicket;
	public JLabel lblDiDen, lblDistanceMed, lblCostMed, lblTimeMed;
	public JTextField txtMap;
	public JButton btn_ChieuDi, btn_ChieuVe;
	
	// Data
	public List<List<Route>> listRoute;
	public List<LocalDate> listDate;
	public int CusID = 1;
	public String KindOfBook;
	
	public static final BookingTicket2 BOOKING_TICKET2 = new BookingTicket2();

	public BookingTicket1() {
		this.GUI();
		try {
			this.Init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void GUI()
	{
		//this.Form = Form;
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBackground(new Color(255, 255, 255));
		this.setBounds(0, 0, 529, 500);
		setLayout(null);
//		panel.setLayout(null);

		rdbtnOneTrip = new JRadioButton("Một chiều");
		rdbtnOneTrip.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnOneTrip);
		rdbtnOneTrip.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnOneTrip.setBounds(21, 22, 92, 23);
		rdbtnOneTrip.addActionListener(new BookingTicket1Listener(this));
		rdbtnOneTrip.setSelected(true);
		add(rdbtnOneTrip);

		rdbtnRoundTrip = new JRadioButton("Khứ hồi");
		rdbtnRoundTrip.setBackground(new Color(255, 255, 255));
		buttonGroup.add(rdbtnRoundTrip);
		rdbtnRoundTrip.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnRoundTrip.setBounds(115, 22, 80, 23);
		rdbtnRoundTrip.addActionListener(new BookingTicket1Listener(this));
		add(rdbtnRoundTrip);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1.setBounds(21, 65, 129, 55);
		add(panel_1);
		panel_1.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblDiemDi = new JLabel("Điểm đi");
		lblDiemDi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiemDi.setHorizontalAlignment(SwingConstants.CENTER);
		panel_1.add(lblDiemDi);

		choice_DiemDi = new Choice();
		panel_1.add(choice_DiemDi);

		JPanel panel_1_1 = new JPanel();
		panel_1_1.setBackground(new Color(255, 255, 255));
		panel_1_1.setBorder(new SoftBevelBorder(BevelBorder.LOWERED, null, null, null, null));
		panel_1_1.setBounds(171, 65, 129, 55);
		add(panel_1_1);
		panel_1_1.setLayout(new GridLayout(2, 1, 0, 0));

		JLabel lblDiemDi_1 = new JLabel("Điểm đến");
		lblDiemDi_1.setBackground(new Color(255, 255, 255));
		lblDiemDi_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblDiemDi_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		panel_1_1.add(lblDiemDi_1);

		choice_DiemDen = new Choice();
		panel_1_1.add(choice_DiemDen);

		JLabel lblNewLabel = new JLabel("Ngày đi");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(341, 21, 124, 26);
		add(lblNewLabel);

		JLabel lblNgayV = new JLabel("Ngày về");
		lblNgayV.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgayV.setBounds(341, 73, 124, 26);
		add(lblNgayV);

		txtNgayDi = new JDateChooser();
		txtNgayDi.setBounds(341, 49, 125, 26);
		txtNgayDi.setDateFormatString("dd/MM/yyyy");
		txtNgayDi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		JTextFieldDateEditor editor = (JTextFieldDateEditor) txtNgayDi.getDateEditor();
        editor.setEditable(false);
		add(txtNgayDi);

		txtNgayVe = new JDateChooser();
		txtNgayVe.setBounds(340, 99, 125, 26);
		txtNgayVe.setDateFormatString("dd/MM/yyyy");
		txtNgayVe.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		JTextFieldDateEditor editor1 = (JTextFieldDateEditor) txtNgayVe.getDateEditor();
        editor1.setEditable(false);
		add(txtNgayVe);

		btnSearch = new JButton("Tìm kiếm");
		btnSearch.setForeground(new Color(255, 255, 255));
		btnSearch.setBackground(new Color(0, 128, 192));
		btnSearch.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSearch.setBounds(21, 137, 104, 33);
		btnSearch.addActionListener(new BookingTicket1Listener(this));
		add(btnSearch);

		JLabel lblNewLabel_1 = new JLabel("Tiêu chí");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(341, 124, 72, 26);
		add(lblNewLabel_1);

		choice_TieuChi = new Choice();
		choice_TieuChi.setBounds(341, 150, 124, 33);
		add(choice_TieuChi);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(192, 192, 192));
		panel.setBounds(10, 221, 509, 268);
		add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel_2 = new JLabel("Bảng gợi ý");
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setBounds(114, 11, 258, 35);
		panel.add(lblNewLabel_2);

		JLabel lblNewLabel_3 = new JLabel("-Điểm đi - Điểm đến:");
		lblNewLabel_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(27, 43, 136, 35);
		panel.add(lblNewLabel_3);

		JLabel lblNewLabel_3_1 = new JLabel("-Các điểm phải đi qua: ");
		lblNewLabel_3_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3_1.setBounds(27, 89, 166, 35);
		panel.add(lblNewLabel_3_1);

		JLabel lblNewLabel_3_2 = new JLabel("-Khoảng cách trung bình:");
		lblNewLabel_3_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3_2.setBounds(27, 139, 166, 35);
		panel.add(lblNewLabel_3_2);

		JLabel lblNewLabel_3_3 = new JLabel("-Chi phí trung bình:");
		lblNewLabel_3_3.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3_3.setBounds(27, 185, 136, 35);
		panel.add(lblNewLabel_3_3);

		JLabel lblNewLabel_3_4 = new JLabel("-Thời gian ngồi xe :");
		lblNewLabel_3_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_3_4.setBounds(27, 231, 136, 35);
		panel.add(lblNewLabel_3_4);

		txtMap = new JTextField("");
		txtMap.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtMap.setHorizontalAlignment(SwingConstants.LEFT);
		txtMap.setEditable(false);
		
		JScrollPane temp = new JScrollPane(txtMap);
		temp.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_NEVER);
		temp.setBounds(189, 89, 294, 35);
		temp.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS);
		panel.add(temp);

		lblDistanceMed = new JLabel("");
		lblDistanceMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDistanceMed.setHorizontalAlignment(SwingConstants.LEFT);
		lblDistanceMed.setBounds(199, 139, 284, 35);
		panel.add(lblDistanceMed);

		lblCostMed = new JLabel("");
		lblCostMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCostMed.setHorizontalAlignment(SwingConstants.LEFT);
		lblCostMed.setBounds(173, 185, 310, 35);
		panel.add(lblCostMed);

		lblTimeMed = new JLabel("");
		lblTimeMed.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblTimeMed.setHorizontalAlignment(SwingConstants.LEFT);
		lblTimeMed.setBounds(159, 231, 324, 35);
		panel.add(lblTimeMed);

		lblDiDen = new JLabel("");
		lblDiDen.setHorizontalAlignment(SwingConstants.LEFT);
		lblDiDen.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblDiDen.setBounds(180, 43, 303, 35);
		panel.add(lblDiDen);

		btnViewTicket = new JButton("Danh sách vé");
		btnViewTicket.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnViewTicket.setForeground(new Color(255, 255, 255));
		btnViewTicket.setBackground(new Color(0, 128, 192));
		btnViewTicket.setBounds(169, 137, 129, 33);
		add(btnViewTicket);
		
		txtNgayVe.setEnabled(false);
		
		btn_ChieuDi = new JButton("Chiều đi");
		btn_ChieuDi.setBounds(21, 194, 104, 23);
		btn_ChieuDi.setVisible(false);
		btn_ChieuDi.addActionListener(new BookingTicket1Listener(this));
		add(btn_ChieuDi);
		
		btn_ChieuVe = new JButton("Chiều về");
		btn_ChieuVe.setBounds(171, 194, 104, 23);
		btn_ChieuVe.setVisible(false);
		btn_ChieuVe.addActionListener(new BookingTicket1Listener(this));
		add(btn_ChieuVe);
	}

	public void Init() throws SQLException
	{
		KindOfBook = "Một chiều";
		List<String> listCity = DAOCity.getInstance().getListCity();
		for(String item : listCity)
		{
			choice_DiemDen.add(item);
			choice_DiemDi.add(item);
		}
		choice_TieuChi.add("Ngắn nhất");
		choice_TieuChi.add("Ngồi xe ít nhất");
		choice_TieuChi.add("Rẻ nhất");
		listRoute = new ArrayList<>();
		
		List<Route> temp = new ArrayList<>();
		listRoute.add(temp);
		listRoute.add(temp);
		
		listDate = new ArrayList<>();
	}

	public void Fast(Boolean check) 
	{
		List<Route> listR = new ArrayList<>(); 
		floydWarshall Al = new floydWarshall();
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		String CityIDStart = "", CityIDEnd = "";
		
		try {
			CityIDStart = DAOCity.getInstance().getCityIDByName(diemDi);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			CityIDEnd = DAOCity.getInstance().getCityIDByName(diemDen);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}		
		
		try {
			listR = Al.distance(CityIDStart, CityIDEnd);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		listRoute.set(0, listR);
		
		if(check)
		{
			try {
				listR = Al.distance(CityIDEnd, CityIDStart);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			listRoute.set(1, listR);
		}
	}
	
	public void Cheap(Boolean check)
	{
		List<Route> listR = new ArrayList<>(); 
		floydWarshall Al = new floydWarshall();
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		String CityIDStart = "", CityIDEnd = "";
		
		try {
			CityIDStart = DAOCity.getInstance().getCityIDByName(diemDi);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			CityIDEnd = DAOCity.getInstance().getCityIDByName(diemDen);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			listR = Al.price(CityIDStart, CityIDEnd);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		listRoute.set(0, listR);
		
		if(check)
		{
			try {
				listR = Al.price(CityIDEnd, CityIDStart);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listRoute.set(1, listR);
		}
	}
	
	public void TimeLess(Boolean check)
	{
		List<Route> listR = new ArrayList<>(); 
		floydWarshall Al = new floydWarshall();
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		String CityIDStart = "", CityIDEnd = "";
		
		try {
			CityIDStart = DAOCity.getInstance().getCityIDByName(diemDi);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			CityIDEnd = DAOCity.getInstance().getCityIDByName(diemDen);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			listR = Al.duration(CityIDStart, CityIDEnd);
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		listRoute.set(0, listR);
		
		if(check)
		{
			try {
				listR = Al.duration(CityIDEnd, CityIDStart);
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			listRoute.set(1, listR);
		}
	}

	public void SetData(List<Route> list, String CityStart, String CityEnd) throws SQLException
	{
		floydWarshall Al = new floydWarshall();
		
		lblDiDen.setText(CityStart + " - " + CityEnd);
		
		txtMap.setText(Al.getMap(list));
		
		lblCostMed.setText(Al.getTotalPrice(list) + " VND");
		
		lblDistanceMed.setText(Al.getTotalDistance(list) + " Km");
		
		lblTimeMed.setText(Al.getTotalDuration(list) +" giờ");

	}

	public Boolean btnSearch_Check()
	{
		
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		
		if(diemDi.equals(diemDen))
		{
			JOptionPane.showMessageDialog(null, "Điểm đi không thể trùng điểm đến");
			return false;
		}
		
		return true;
	}
	
	public void btnSeach_Select()
	{
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		
		if(rdbtnRoundTrip.isSelected())
		{
			KindOfBook = "Khứ hồi";
			btn_ChieuDi.setVisible(true);
			btn_ChieuVe.setVisible(true);
		}
		
		
		String LuaChon = choice_TieuChi.getSelectedItem().toString();
		
		if(LuaChon.equals("Ngắn nhất"))
		{
			Fast(rdbtnRoundTrip.isSelected());
		}
		else if(LuaChon.equals("Rẻ nhất"))
		{
			Cheap(rdbtnRoundTrip.isSelected());
		}
		else if(LuaChon.equals("Ngồi xe ít nhất"))
		{
			TimeLess(rdbtnRoundTrip.isSelected());
		}
		
		try {
			SetData(listRoute.get(0),diemDi, diemDen);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void btnChieuVe_Select()
	{
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		
		try {
			SetData(listRoute.get(1), diemDen, diemDi);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
	
	public void btnChieuDi_Select()
	{
		String diemDi = choice_DiemDi.getSelectedItem().toString();
		String diemDen = choice_DiemDen.getSelectedItem().toString();
		
		try {
			SetData(listRoute.get(0), diemDi, diemDen);
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}

	public void rdbtnRoundTrip_isSelect()
	{
		KindOfBook = "Khứ hồi";
		txtNgayVe.setEnabled(true);
	}
	
	public void rdbtnOneTrip_isSelect()
	{
		KindOfBook = "Một chiều";
		btn_ChieuDi.setVisible(false);
		btn_ChieuVe.setVisible(false);
		txtNgayVe.setEnabled(false);
	}
}
