package view.Customer;

import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Models.Customer;
import Models.myDate;
import controller.Customer.FormMainListener;

import javax.swing.JTable;
import javax.swing.JScrollBar;
import java.awt.Color;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

import java.awt.Font;
import java.awt.Image;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.text.Normalizer.Form;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.Window.Type;

public class FormMainPage extends JFrame {

	public JPanel contentPane;
	public JButton btnAcc,btnBookTicket,btnBill,btnLogOut, btnSchedule;
	public JPanel body;
	public Customer cus;
	
	public PanelUser userPanel ;
	public BookingTicket1 bookingTicket1Panel ;
	public BookingTicket2 bookingTicket2Panel ;
	public PanelFindTrip panelFindTrip;
	public PanelFindTripTop panelFindTripTop;
	public PanelUserTop panelUserTop;
	public PanelWelcome PW;
	public PanelMainTop panelMainTop;
	public PanelListBill panelListBill;
	
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					FormMainPage frame = new FormMainPage();
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	
	public void GUI()
	{

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 710, 535);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelMenu = new JPanel();
		panelMenu.setBackground(new Color(0, 255, 255));
		panelMenu.setBounds(0, 0, 167, 498);
		contentPane.add(panelMenu);
		panelMenu.setLayout(null);
		
		btnAcc = new JButton("Tài khoản");
		btnAcc.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Custom-Icon-Design-Silky-Line-User-User.32.png")));
		btnAcc.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnAcc.setHorizontalAlignment(SwingConstants.LEFT);
		btnAcc.setBackground(new Color(0, 128, 192));
		btnAcc.setBounds(10, 38, 147, 53);
		panelMenu.add(btnAcc);
		
		btnBookTicket = new JButton("Đặt vé ");
		btnBookTicket.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Icons8-Ios7-Cinema-Ticket.32.png")));
		btnBookTicket.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBookTicket.setHorizontalAlignment(SwingConstants.LEFT);
		btnBookTicket.setBackground(new Color(0, 128, 192));
		btnBookTicket.setBounds(10, 220, 147, 53);
		panelMenu.add(btnBookTicket);
		
		btnBill = new JButton("Hóa đơn");
		btnBill.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Icons8-Ios7-Finance-Bill.32.png")));
		
		btnBill.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnBill.setHorizontalAlignment(SwingConstants.LEFT);
		btnBill.setBackground(new Color(0, 128, 192));
		btnBill.setBounds(10, 311, 147, 53);
		panelMenu.add(btnBill);
		
		btnLogOut = new JButton("Đăng xuất");
		btnLogOut.setIcon(new ImageIcon(FormMainPage.class.getResource("/photo/Github-Octicons-Sign-out-24.32.png")));
		btnLogOut.setHorizontalAlignment(SwingConstants.LEFT);
		btnLogOut.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnLogOut.setBackground(new Color(0, 128, 192));
		btnLogOut.setBounds(10, 402, 147, 53);
		panelMenu.add(btnLogOut);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(167, 142, 546, 356);
		panelMenu.add(panel_2);
		
		ImageIcon icon = new ImageIcon(PanelFindTripTop.class.getResource("/photo/Schedule.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(40, 55, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		 btnSchedule = new JButton("Lịch trình");
		btnSchedule.setIcon(scaledIcon);
		btnSchedule.setHorizontalAlignment(SwingConstants.LEFT);
		btnSchedule.setFont(new Font("Times New Roman", Font.PLAIN, 16));
		btnSchedule.setBackground(new Color(0, 128, 192));
		btnSchedule.setBounds(10, 129, 147, 53);
		btnSchedule.addActionListener(new FormMainListener(this));
		panelMenu.add(btnSchedule);
		
//		JPanel pn3 = new PanelUser();
//		JPanel pn4 = new PanelUserTop();
//		
//		
		body = new JPanel();
		body.setBounds(167, 0, 529,500);
		body.setBackground(Color.BLACK);
		body.setLayout(null);
//		body.add(pn4);
//		body.add(pn3);
		contentPane.add(body);
	}
	
	public void Init()
	{
		// Init Panel
		this.userPanel = new PanelUser();
		this.bookingTicket1Panel = new BookingTicket1();
		this.bookingTicket2Panel = new BookingTicket2();
		this.panelFindTrip = new PanelFindTrip(this.cus.getCustomerID());
		this.panelFindTripTop = new PanelFindTripTop();
		this.panelUserTop = new PanelUserTop();
		this.PW = new PanelWelcome();
		this.panelMainTop = new PanelMainTop();
		this.panelListBill = new PanelListBill(this.cus.getCustomerID());
		
		ActionListener m = new FormMainListener(this);
		btnAcc.addActionListener(m);
		btnBookTicket.addActionListener(m);
		btnBill.addActionListener(m);
		btnLogOut.addActionListener(m);
		((BookingTicket1)bookingTicket1Panel).btnViewTicket.addActionListener(m);
		((BookingTicket2)bookingTicket2Panel).lblBack.addMouseListener(new FormMainListener(this));
		
		// Add panel
		this.body.add(PW);
		this.body.add(panelUserTop);
		this.body.add(userPanel);
		this.body.add(bookingTicket1Panel);
		this.body.add(bookingTicket2Panel);
		this.body.add(panelFindTrip);
		this.body.add(panelFindTripTop);
		this.body.add(panelMainTop);
		this.body.add(panelListBill);

		// SetVisibile
		PW.setVisible(true);
		panelUserTop.setVisible(true);
		userPanel.setVisible(false);
		bookingTicket1Panel.setVisible(false);
		bookingTicket2Panel.setVisible(false);
		panelFindTrip.setVisible(false);
		panelFindTripTop.setVisible(false);
		panelMainTop.setVisible(false);
		panelListBill.setVisible(false);
		
		
		setVisible(true);
	}
	
	public FormMainPage(Customer Cus) {
		this.cus = Cus;
		this.GUI();
		this.Init();
		
	}
	
	public void changeToAcc() {
		
		PW.setVisible(false);
		panelUserTop.setVisible(true);
		userPanel.setVisible(true);
		bookingTicket1Panel.setVisible(false);
		bookingTicket2Panel.setVisible(false);
		panelFindTrip.setVisible(false);
		panelFindTripTop.setVisible(false);
		panelMainTop.setVisible(false);
		panelListBill.setVisible(false);
	}
	
	public void changeToBooking() {
		PW.setVisible(false);
		panelUserTop.setVisible(false);
		userPanel.setVisible(false);
		bookingTicket1Panel.setVisible(true);
		bookingTicket2Panel.setVisible(false);
		panelFindTrip.setVisible(false);
		panelFindTripTop.setVisible(false);
		panelMainTop.setVisible(false);
		panelListBill.setVisible(false);
	}
	
	public void changeToBill() {
		
		try {
			this.panelListBill.Init();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		PW.setVisible(false);
		panelUserTop.setVisible(false);
		userPanel.setVisible(false);
		bookingTicket1Panel.setVisible(false);
		bookingTicket2Panel.setVisible(false);
		panelFindTrip.setVisible(false);
		panelFindTripTop.setVisible(false);
		panelMainTop.setVisible(true);
		panelListBill.setVisible(true);
		
	}
	
	public void changeToListTicket() throws SQLException {
		
		// SetData
		((BookingTicket2)this.bookingTicket2Panel).KindOfBook = ((BookingTicket1)this.bookingTicket1Panel).KindOfBook;
		((BookingTicket2)this.bookingTicket2Panel).listDate = ((BookingTicket1)this.bookingTicket1Panel).listDate;
		((BookingTicket2)this.bookingTicket2Panel).CusID = ((BookingTicket1)this.bookingTicket1Panel).CusID;
		((BookingTicket2)this.bookingTicket2Panel).listRoute = ((BookingTicket1)this.bookingTicket1Panel).listRoute;
		
		((BookingTicket2)this.bookingTicket2Panel).Init();
		
		
		// SetEvent
		PW.setVisible(false);
		panelUserTop.setVisible(false);
		userPanel.setVisible(false);
		bookingTicket1Panel.setVisible(false);
		bookingTicket2Panel.setVisible(true);
		panelFindTrip.setVisible(false);
		panelFindTripTop.setVisible(false);
		panelMainTop.setVisible(false);
		panelListBill.setVisible(false);
		
	}
	
	public void changeToFindTrip()
	{
		PW.setVisible(false);
		panelUserTop.setVisible(false);
		userPanel.setVisible(false);
		bookingTicket1Panel.setVisible(false);
		bookingTicket2Panel.setVisible(false);
		panelFindTrip.setVisible(true);
		panelFindTripTop.setVisible(true);
		try {
			panelFindTrip.Init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		panelMainTop.setVisible(false);
		panelListBill.setVisible(false);
	}

	public Boolean BT1_btnViewTicket_Check()
	{
//		String DateGo = bookingTicket1Panel.txtNgayDi.getDate();
//		String DateBack = bookingTicket1Panel.txtNgayVe.getText();
		
		java.util.Date dateGo = bookingTicket1Panel.txtNgayDi.getDate();
		java.util.Date dateBack = bookingTicket1Panel.txtNgayVe.getDate();
		
		
		String KindOfBook = bookingTicket1Panel.KindOfBook;
		
		if(bookingTicket1Panel.listRoute.get(0).size() == 0)
		{
			JOptionPane.showMessageDialog(null, "Vui lòng tìm kiếm chuyến đi phù hợp trước");
			return false;
		}
		
		try {
			myDate.changeToLocalDate(dateGo);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ ngày đi");
			return false;
		}
		if(KindOfBook.equals("Khứ hồi"))
		{
			try {
				myDate.changeToLocalDate(dateBack);
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ ngày về");
				return false;
			}
			
		}
		
		bookingTicket1Panel.listDate = new ArrayList<>();	
		
		
		
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		bookingTicket1Panel.listDate.add(myDate.changeToLocalDate(dateGo));	
		
		LocalDate DateGo1 = bookingTicket1Panel.listDate.get(0);
		
		if(LocalDate.now().compareTo(DateGo1) > 0)
		{
			JOptionPane.showMessageDialog(null, "Không thể nhập ngày đi nhỏ hơn ngày hiện tại");
			return false;
		}
		
		if(KindOfBook.equals("Khứ hồi"))
		{
			if(bookingTicket1Panel.listRoute.get(1).size() == 0)
			{
				JOptionPane.showMessageDialog(null, "Vui lòng tìm kiếm lại để lấy danh sách chiều về");
				return false;
			}
			
			
			bookingTicket1Panel.listDate.add(myDate.changeToLocalDate(dateBack));		
			List<LocalDate> listDate = bookingTicket1Panel.listDate;
			
			
			if(listDate.get(1).compareTo(listDate.get(0)) < 0)
			{
				JOptionPane.showMessageDialog(null, "Ngày về không thể nhỏ hơn ngày đi");
				return false;
			}
		}
		
		return true;
	}
	
	public void BT1_btnViewTicket_Select()
	{
		bookingTicket1Panel.CusID = cus.getCustomerID();
		try {
			changeToListTicket();
		} catch (SQLException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
	}
}
