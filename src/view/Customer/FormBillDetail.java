package view.Customer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import DAO.DAOBill;
import DAO.DAOBus;
import DAO.DAOInfoCustomer;
import DAO.DAOTicket;
import DAO.DAOTrip;
import Models.Bill;
import Models.InfoCustomer;
import Models.Ticket;
import Models.Trip;
import controller.Customer.FormBillDetailListener;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Component;

public class FormBillDetail extends JFrame {

	private JPanel contentPane;

	// Data
	public Bill bl;
	public List<Ticket> listTicket;
	public InfoCustomer IC;
	private DefaultTableModel dtm;
	
	
	public JLabel lblBack;
	private JLabel lblNewLabel;
	private JPanel panel_1;
	private JPanel panel_2;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JPanel panel_3;
	private JPanel panel_4;
	private JScrollPane scrollPane;
	private JLabel lblNewLabel_3;
	public JTable table;
	private JPanel panel_5;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	private JLabel lblNewLabel_7;
	private JLabel lblNewLabel_8;
	private JLabel lblNewLabel_9;
	private JTextField txtBillID;
	private JTextField txtPaymentMethod;
	private JTextField txtPrice;
	private JTextField txtStatus;
	private JTextField txtBookDate;
	private JTextField txtEmail;
	private JLabel lblNewLabel_10;
	private JLabel lblNewLabel_11;
	private JLabel lblNewLabel_12;
	private JLabel lblNewLabel_13;
	private JTextField txtRealName;
	private JTextField txtTel;
	private JTextField txtAddress;
	private JPanel panel_7;
	private JLabel lblNewLabel_14;
	private JLabel lblNewLabel_15;
	private JLabel lblNewLabel_16;
	private JLabel lblNewLabel_17;
	private JLabel lblNewLabel_18;
	private JLabel lblNewLabel_19;
	private JLabel lblNewLabel_20;
	private JTextField txtStartCity;
	private JTextField txtEndCity;
	private JTextField txtParkingStart;
	private JTextField txtParkingEnd;
	private JTextField txtDate;
	private JTextField txtTime;
	private JTextField txtKindOfBus;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Bill l = DAOBill.getInstance().selectByID(1 +"");
					List<Ticket> listTicket = DAOTicket.getInstance().selectByBillID(1);
					
					FormBillDetail frame = new FormBillDetail(l, listTicket);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	public void GUI()
	{
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		//setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 827, 587);
		setVisible(true);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		dtm = new DefaultTableModel() {
			@Override
		    public boolean isCellEditable(int row, int column) {
		        return false;
		    }
		};
		
		dtm.addColumn("ID");
		dtm.addColumn("Số ghế");
		dtm.addColumn("Loại vé");
		dtm.addColumn("Giá tiền");
		
		table = new JTable(dtm);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.CYAN);
		panel.setBounds(56, 40, 704, 231);
		contentPane.add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(Color.LIGHT_GRAY);
		panel_1.setBounds(10, 11, 340, 209);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		lblNewLabel_1 = new JLabel("Thông tin hoá đơn");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_1.setBounds(114, 11, 124, 22);
		panel_1.add(lblNewLabel_1);
		
		lblNewLabel_5 = new JLabel("Bill ID");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_5.setBounds(10, 44, 61, 22);
		panel_1.add(lblNewLabel_5);
		
		lblNewLabel_6 = new JLabel("Phương thức thanh toán");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_6.setBounds(10, 79, 146, 22);
		panel_1.add(lblNewLabel_6);
		
		lblNewLabel_7 = new JLabel("Ngày thanh toán");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(10, 178, 103, 22);
		panel_1.add(lblNewLabel_7);
		
		lblNewLabel_8 = new JLabel("Trạng thái");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(10, 112, 96, 22);
		panel_1.add(lblNewLabel_8);
		
		lblNewLabel_9 = new JLabel("Giá tiền");
		lblNewLabel_9.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_9.setBounds(10, 145, 69, 22);
		panel_1.add(lblNewLabel_9);
		
		txtBillID = new JTextField();
		txtBillID.setEditable(false);
		txtBillID.setBounds(160, 44, 170, 22);
		panel_1.add(txtBillID);
		txtBillID.setColumns(10);
		
		txtPaymentMethod = new JTextField();
		txtPaymentMethod.setEditable(false);
		txtPaymentMethod.setColumns(10);
		txtPaymentMethod.setBounds(160, 79, 170, 22);
		panel_1.add(txtPaymentMethod);
		
		txtPrice = new JTextField();
		txtPrice.setEditable(false);
		txtPrice.setColumns(10);
		txtPrice.setBounds(160, 145, 170, 22);
		panel_1.add(txtPrice);
		
		txtStatus = new JTextField();
		txtStatus.setEditable(false);
		txtStatus.setColumns(10);
		txtStatus.setBounds(160, 112, 170, 22);
		panel_1.add(txtStatus);
		
		txtBookDate = new JTextField();
		txtBookDate.setEditable(false);
		txtBookDate.setColumns(10);
		txtBookDate.setBounds(160, 178, 170, 22);
		panel_1.add(txtBookDate);
		
		panel_2 = new JPanel();
		panel_2.setBackground(Color.LIGHT_GRAY);
		panel_2.setBounds(354, 11, 340, 209);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		lblNewLabel_2 = new JLabel("Thông tin khách hàng");
		lblNewLabel_2.setBounds(111, 11, 140, 22);
		lblNewLabel_2.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_2.add(lblNewLabel_2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBackground(Color.LIGHT_GRAY);
		panel_6.setBounds(0, 36, 340, 162);
		panel_2.add(panel_6);
		panel_6.setLayout(null);
		
		txtEmail = new JTextField();
		txtEmail.setEditable(false);
		txtEmail.setColumns(10);
		txtEmail.setBounds(93, 122, 237, 22);
		panel_6.add(txtEmail);
		
		lblNewLabel_10 = new JLabel("Email");
		lblNewLabel_10.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_10.setBounds(10, 122, 103, 22);
		panel_6.add(lblNewLabel_10);
		
		lblNewLabel_11 = new JLabel("Địa chỉ");
		lblNewLabel_11.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_11.setBounds(10, 86, 69, 22);
		panel_6.add(lblNewLabel_11);
		
		lblNewLabel_12 = new JLabel("Số điện thoại");
		lblNewLabel_12.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_12.setBounds(10, 50, 96, 22);
		panel_6.add(lblNewLabel_12);
		
		lblNewLabel_13 = new JLabel("Họ và tên ");
		lblNewLabel_13.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_13.setBounds(10, 14, 69, 22);
		panel_6.add(lblNewLabel_13);
		
		txtRealName = new JTextField();
		txtRealName.setEditable(false);
		txtRealName.setColumns(10);
		txtRealName.setBounds(93, 14, 237, 22);
		panel_6.add(txtRealName);
		
		txtTel = new JTextField();
		txtTel.setEditable(false);
		txtTel.setColumns(10);
		txtTel.setBounds(93, 50, 237, 22);
		panel_6.add(txtTel);
		
		txtAddress = new JTextField();
		txtAddress.setEditable(false);
		txtAddress.setColumns(10);
		txtAddress.setBounds(93, 86, 237, 22);
		panel_6.add(txtAddress);
		
		ImageIcon icon = new ImageIcon(FormBillDetail.class.getResource("/photo/BackButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(35, 35, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblBack = new JLabel("");
		lblBack.setBounds(23, 7, 35, 35);
		lblBack.setIcon(newIcon);
		getContentPane().add(lblBack);
		
		lblNewLabel = new JLabel("HOÁ ĐƠN");
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 30));
		lblNewLabel.setBounds(319, 7, 166, 35);
		contentPane.add(lblNewLabel);
		
		panel_3 = new JPanel();
		panel_3.setBackground(Color.CYAN);
		panel_3.setBounds(56, 282, 704, 255);
		contentPane.add(panel_3);
		panel_3.setLayout(null);
		
		panel_4 = new JPanel();
		panel_4.setBackground(Color.LIGHT_GRAY);
		panel_4.setBounds(354, 11, 340, 233);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 24, 320, 198);
		panel_4.add(scrollPane);
		
		lblNewLabel_3 = new JLabel("Thông tin vé");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblNewLabel_3.setBounds(128, 0, 88, 22);
		panel_4.add(lblNewLabel_3);
		
		panel_5 = new JPanel();
		panel_5.setBackground(Color.LIGHT_GRAY);
		panel_5.setBounds(10, 11, 340, 233);
		panel_3.add(panel_5);
		panel_5.setLayout(null);
		
		lblNewLabel_4 = new JLabel("Thông tin lịch trình");
		lblNewLabel_4.setBounds(106, 0, 127, 22);
		lblNewLabel_4.setFont(new Font("Tahoma", Font.BOLD, 12));
		panel_5.add(lblNewLabel_4);
		
		panel_7 = new JPanel();
		panel_7.setBackground(Color.LIGHT_GRAY);
		panel_7.setBounds(0, 25, 340, 197);
		panel_5.add(panel_7);
		panel_7.setLayout(null);
		
		lblNewLabel_14 = new JLabel("Điểm đi");
		lblNewLabel_14.setBounds(10, 9, 57, 22);
		lblNewLabel_14.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_14);
		
		lblNewLabel_15 = new JLabel("Điểm đến");
		lblNewLabel_15.setBounds(170, 9, 63, 22);
		lblNewLabel_15.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_15);
		
		lblNewLabel_16 = new JLabel("Ngày đi - Ngày đến");
		lblNewLabel_16.setBounds(10, 102, 113, 22);
		lblNewLabel_16.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_16);
		
		lblNewLabel_17 = new JLabel("Bến bắt đầu");
		lblNewLabel_17.setBounds(10, 40, 103, 22);
		lblNewLabel_17.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_17);
		
		lblNewLabel_18 = new JLabel("Bến kết thúc");
		lblNewLabel_18.setBounds(10, 71, 103, 22);
		lblNewLabel_18.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_18);
		
		lblNewLabel_19 = new JLabel("Giờ đi - giờ đến");
		lblNewLabel_19.setBounds(10, 133, 113, 22);
		lblNewLabel_19.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_19);
		
		lblNewLabel_20 = new JLabel("Loại xe");
		lblNewLabel_20.setBounds(10, 164, 113, 22);
		lblNewLabel_20.setFont(new Font("Tahoma", Font.PLAIN, 12));
		panel_7.add(lblNewLabel_20);
		
		txtStartCity = new JTextField();
		txtStartCity.setEditable(false);
		txtStartCity.setBounds(63, 9, 98, 22);
		panel_7.add(txtStartCity);
		txtStartCity.setColumns(10);
		
		txtEndCity = new JTextField();
		txtEndCity.setEditable(false);
		txtEndCity.setColumns(10);
		txtEndCity.setBounds(232, 9, 98, 22);
		panel_7.add(txtEndCity);
		
		txtParkingStart = new JTextField();
		txtParkingStart.setEditable(false);
		txtParkingStart.setColumns(10);
		txtParkingStart.setBounds(123, 40, 207, 22);
		panel_7.add(txtParkingStart);
		
		txtParkingEnd = new JTextField();
		txtParkingEnd.setEditable(false);
		txtParkingEnd.setColumns(10);
		txtParkingEnd.setBounds(123, 71, 207, 22);
		panel_7.add(txtParkingEnd);
		
		txtDate = new JTextField();
		txtDate.setEditable(false);
		txtDate.setColumns(10);
		txtDate.setBounds(123, 102, 207, 22);
		panel_7.add(txtDate);
		
		txtTime = new JTextField();
		txtTime.setEditable(false);
		txtTime.setColumns(10);
		txtTime.setBounds(123, 133, 207, 22);
		panel_7.add(txtTime);
		
		txtKindOfBus = new JTextField();
		txtKindOfBus.setEditable(false);
		txtKindOfBus.setColumns(10);
		txtKindOfBus.setBounds(123, 164, 207, 22);
		panel_7.add(txtKindOfBus);
	
		
		lblBack.addMouseListener(new FormBillDetailListener(this));
	}
	
	public void Init() throws ClassNotFoundException, SQLException
	{
		IC = DAOInfoCustomer.getInstance().selectByID(bl.getInfoID() +"");
		
		// Bill
		txtBillID.setText(bl.getBillID() + "");
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		txtBookDate.setText(bl.getBookDate().format(formatter));
		txtStatus.setText(bl.getStatus());
		txtPaymentMethod.setText(bl.getPaymentMethod());
		txtPrice.setText(bl.getTotalPrice() + " VND");
		
		// InfoCustomer
		txtRealName.setText(IC.getRealName());
		txtTel.setText(IC.getPhoneNumber());
		txtAddress.setText(IC.getHomeAddress());
		txtEmail.setText(IC.getEmail());
		
		// TripInDay
		Trip trip = DAOTrip.getInstance().selectByID(listTicket.get(0).getTripID() +"");
		
		txtStartCity.setText(DAOTrip.getInstance().getNameCityStart(trip.getTripID()));
		txtEndCity.setText(DAOTrip.getInstance().getNameCityEnd(trip.getTripID()));
		
		txtParkingStart.setText(DAOTrip.getInstance().getNameParkingStart(trip.getTripID()));
		txtParkingEnd.setText(DAOTrip.getInstance().getNameParkingEnd(trip.getTripID()));
		
		txtDate.setText(trip.getDateStart().format(formatter) + " - " + trip.getDateEnd().format(formatter));
		
		DateTimeFormatter formatTime = DateTimeFormatter.ofPattern("hh:mm");
		txtTime.setText(trip.getTimeStart().format(formatTime) + " - " + trip.getTimeEnd().format(formatTime));
		
		txtKindOfBus.setText(DAOBus.getInstance().getKindOfBusByTripID(trip.getTripID()));
		
		// Ticket
		int n = dtm.getRowCount();
		for(int i = 1; i<=n;i++)
		{
			dtm.removeRow(0);
		}
		
		for(Ticket item : listTicket)
		{
			dtm.addRow(new Object[] {item.getTicketID(), item.getSeatNumber(), item.getKindOfTicket(), item.getPrice() + " VND"});
		} 
		
	}
	
	public FormBillDetail(Bill bl, List<Ticket> listTicket) {
		setResizable(false);
		
		this.bl = bl;
		this.listTicket = listTicket;
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
