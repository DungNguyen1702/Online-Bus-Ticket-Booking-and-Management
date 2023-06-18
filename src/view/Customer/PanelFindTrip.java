package view.Customer;

import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JComboBox;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.DAOCity;
import DAO.DAOTrip;
import Models.InfoCustomer;
import Models.Trip;
import Models.myDate;
import controller.Customer.PanelFindTripListener;
import controller.admin.TripInDayListener;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;

public class PanelFindTrip extends JPanel {
	private JDateChooser txtDate;
	private JComboBox<String> cbCityStart, cbCityEnd;
	public JButton btnBooking;
	public JLabel lblFind, lblReset;
	public DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	public JTable table;
	public InfoCustomer IC;
	public int CusID;
	
	private void GUI()
	{
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 127, 529, 371);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(10, 10, 509, 64);
		add(panel);
		panel.setLayout(null);
		
		cbCityStart = new JComboBox<>();
		cbCityStart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityStart.setBounds(6, 33, 141, 27);
		panel.add(cbCityStart);
		
		cbCityEnd = new JComboBox<>();
		cbCityEnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityEnd.setBounds(153, 33, 141, 27);
		panel.add(cbCityEnd);
		
		txtDate = new JDateChooser();
		txtDate.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDate.setBounds(300, 33, 133, 27);
		txtDate.setDateFormatString("dd/MM/yyyy");
		
		JTextFieldDateEditor editor1 = (JTextFieldDateEditor) txtDate.getDateEditor();
        editor1.setEditable(false);
		panel.add(txtDate);
		
		ImageIcon icon = new ImageIcon(PanelFindTripTop.class.getResource("/photo/SearchButton.png"));
		Image image = icon.getImage();
		Image scaledImage = image.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		ImageIcon scaledIcon = new ImageIcon(scaledImage);
		
		lblFind = new JLabel("");
		lblFind.setBounds(439, 33, 27, 27);
		lblFind.setIcon(scaledIcon);
		lblFind.addMouseListener(new PanelFindTripListener(this));
		panel.add(lblFind);
		
		 icon = new ImageIcon(PanelFindTripTop.class.getResource("/photo/reset.png"));
		 image = icon.getImage();
		 scaledImage = image.getScaledInstance(27, 27, Image.SCALE_SMOOTH);
		 scaledIcon = new ImageIcon(scaledImage);
		
		 lblReset = new JLabel("");
		lblReset.setBounds(472, 33, 27, 27);
		lblReset.setIcon(scaledIcon);
		lblReset.addMouseListener(new PanelFindTripListener(this));
		panel.add(lblReset);
		
		JLabel lblNewLabel = new JLabel("Điểm đi");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel.setBounds(42, 4, 72, 25);
		panel.add(lblNewLabel);
		
		JLabel lblimn = new JLabel("Điểm đến");
		lblimn.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblimn.setBounds(183, 4, 87, 25);
		panel.add(lblimn);
		
		JLabel lblNgyi = new JLabel("Ngày đi");
		lblNgyi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNgyi.setBounds(326, 4, 87, 25);
		panel.add(lblNgyi);
		
		btnBooking = new JButton("Đặt vé");
		btnBooking.setBackground(Color.GREEN);
		btnBooking.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		btnBooking.setBounds(414, 4, 85, 25);
		btnBooking.addActionListener(new PanelFindTripListener(this));
		panel.add(btnBooking);
		
		dtm.addColumn("ID Trip");
		dtm.addColumn("Điểm đi");
		dtm.addColumn("Điểm đến");
		dtm.addColumn("Ngày đi");
		dtm.addColumn("Giờ đi");
		dtm.addColumn("Số ghế trống");
		dtm.addColumn("Loại xe");
		
		table = new JTable(dtm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.getSelectionModel().addListSelectionListener(new PanelFindTripListener(this));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 79, 509, 282);
		add(scrollPane);
	}

	public PanelFindTrip(int CusID){
		this.CusID = CusID;
		this.GUI();
		try {
			this.Init();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void Init() throws SQLException {
		List<String> listCity = DAOCity.getInstance().getListCity();
		for(String item : listCity)
		{
			this.cbCityEnd.addItem(item);
			this.cbCityStart.addItem(item);
		}
		this.ResetTable();
		this.IC = new InfoCustomer(0, "", "", "", "");
	}
	
	public void ResetTable() throws SQLException
	{
		String dateString = LocalDate.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String pattern = "dd/MM/yyyy"; // Định dạng của chuỗi ngày tháng

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date = dateFormat.parse(dateString);
            this.txtDate.setDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
		this.ClearTable();
		List<Object[]> listObject = DAOTrip.getInstance().getDataForPanelFindTripInCustomer();
		
		for(Object[] item : listObject)
		{
			int TripID = Integer.parseInt(item[0] + "");
			String CityStart = item[1] + "";
			String CityEnd = item[2] + "";
			LocalDate dateStart = LocalDate.parse(item[3] + "");
			LocalTime timeStart = LocalTime.parse(item[4] + "");
			int leftSeat = Integer.parseInt(item[5] + "");
			String KindOfBus = item[6] + "";
			dtm.addRow(new Object[] {TripID, CityStart, CityEnd, dateStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), timeStart.format(DateTimeFormatter.ofPattern("HH:mm")), leftSeat, KindOfBus});
		}
	}

	public void RowTable_Select(Object[] data)
	{
		String CityStart = data[1] + "";
		String CityEnd = data[2] + "";
		
		LocalDate date = LocalDate.parse(data[3] + "", DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		
		for(int i = 0 ; i < cbCityStart.getItemCount();i++)
		{
			if(cbCityStart.getItemAt(i).equals(data[1]))
			{
				cbCityStart.setSelectedIndex(i);
				break;
			}
		}
		
		for(int i = 0 ; i < cbCityEnd.getItemCount();i++)
		{
			if(cbCityEnd.getItemAt(i).equals(data[2]))
			{
				cbCityEnd.setSelectedIndex(i);
				break;
			}
		}
		
		String dateString = date.format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String pattern = "dd/MM/yyyy"; // Định dạng của chuỗi ngày tháng

        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date1 = dateFormat.parse(dateString);
            this.txtDate.setDate(date1);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
	}

	private void ClearTable()
	{
		int n = table.getRowCount();
		for(int i = 0 ; i < n ; i ++)
		{
			dtm.removeRow(0);
		}
	}
	
	public void lblFind_Select() throws SQLException
	{
		
		String CityStart1 = cbCityStart.getSelectedItem() + "";
		String CityEnd1 = cbCityEnd.getSelectedItem() + "";
		LocalDate dateStart1 = null;
		
		if(CityStart1.equals(CityEnd1))
		{
			JOptionPane.showMessageDialog(null, "Lỗi địa điểm đi không thể trùng với địa điểm đến");
			return;
		}
		
		try {
			dateStart1 = myDate.changeToLocalDate(txtDate.getDate());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng chọn ngày phù hợp");
		}
		
		
		this.ClearTable();
		
		List<Object[]> list = DAOTrip.getInstance().getDataByFindInCustomer(CityStart1, CityEnd1, dateStart1);
		
		for(Object[] item : list)
		{
			int TripID = Integer.parseInt(item[0] + "");
			String CityStart = item[1] + "";
			String CityEnd = item[2] + "";
			LocalDate dateStart = LocalDate.parse(item[3] + "");
			LocalTime timeStart = LocalTime.parse(item[4] + "");
			int leftSeat = Integer.parseInt(item[5] + "");
			String KindOfBus = item[6] + "";
			dtm.addRow(new Object[] {TripID, CityStart, CityEnd, dateStart.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), timeStart.format(DateTimeFormatter.ofPattern("HH:mm")), leftSeat, KindOfBus});
		}
	}

	public void btnBooking_Select() throws ClassNotFoundException, SQLException
	{
		if(table.getSelectedRow() <0) return;
		int row = table.getSelectedRow();
		int TripID = Integer.parseInt(dtm.getValueAt(row, 0) + "");
		Trip Trip = DAOTrip.getInstance().selectByID(TripID + "");
		new FormBookTicket(Trip, IC, CusID, "Một chiều");
	}


}
