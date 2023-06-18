
package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Robot;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DAOCity;
import DAO.DAORoute;
import DAO.DAOTrip;
import Models.City;
import Models.Route;
import Models.Trip;
import controller.admin.TripInDayListener;
import view.Customer.BookingTicket2;

import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JScrollPane;

public class PanelTripInDay extends JPanel {

	/**
	 * Create the panel.
	 */
	
	public JButton btnDelete, btnAdd, btnSave, btnCancel, btnFind;
	public JTextField txtTripID;
	public JTextField txtTimeStart;
	public JTextField txtDateStart;
	public JTextField txtTimeEnd;
	public JTextField txtDateEnd;
	public JTable table;
	public JLabel lblSearch, lblReset;
	public JComboBox<String> cbRouteID, cbCityStart, cbCityEnd, cbCityEndFind, cbCityStartFind;
	private JPanel panel_2;
	private JLabel lblNii_1;
	private JLabel lblNin_1;
	private JLabel lblNin_2;
	private JTextField txtDateFind;
	public DefaultTableModel dtm = new DefaultTableModel() {
	    @Override
	    public boolean isCellEditable(int row, int column) {
	        return false;
	    }
	};
	
	public void GUI()
	{
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		
		JLabel lblTripInDay = new JLabel("Thông tin chuyến đi hằng ngày");
		lblTripInDay.setForeground(Color.BLUE);
		lblTripInDay.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblTripInDay.setBounds(114, 0, 406, 34);
		add(lblTripInDay);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 33, 594, 165);
		add(panel);
		panel.setLayout(null);
		
		JLabel lblTripID = new JLabel("Mã chuyến đi");
		lblTripID.setBounds(10, 14, 84, 28);
		panel.add(lblTripID);
		lblTripID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtTripID = new JTextField();
		txtTripID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTripID.setBounds(104, 14, 177, 28);
		panel.add(txtTripID);
		txtTripID.setEditable(false);
		txtTripID.setColumns(10);
		
		JLabel lblStartCity = new JLabel("Thời gian đi");
		lblStartCity.setBounds(10, 52, 84, 28);
		panel.add(lblStartCity);
		lblStartCity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtTimeStart = new JTextField();
		txtTimeStart.setEditable(false);
		txtTimeStart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTimeStart.setBounds(104, 52, 177, 28);
		txtTimeStart.addFocusListener(new TripInDayListener(this));
		panel.add(txtTimeStart);
		txtTimeStart.setColumns(10);
		
		JLabel lblEndCity = new JLabel("Thời gian đến");
		lblEndCity.setBounds(10, 92, 84, 28);
		panel.add(lblEndCity);
		lblEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtDateStart = new JTextField();
		txtDateStart.setEditable(false);
		txtDateStart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDateStart.setBounds(374, 12, 199, 28);
		txtDateStart.addFocusListener(new TripInDayListener(this));
		panel.add(txtDateStart);
		txtDateStart.setColumns(10);
		
		JLabel lblDuration = new JLabel("Ngày đi");
		lblDuration.setBounds(291, 12, 51, 28);
		panel.add(lblDuration);
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtTimeEnd = new JTextField();
		txtTimeEnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtTimeEnd.setBounds(104, 92, 177, 28);
		panel.add(txtTimeEnd);
		txtTimeEnd.setEditable(false);
		txtTimeEnd.setColumns(10);
		
		JLabel lblBusID = new JLabel("Ngày về");
		lblBusID.setBounds(291, 52, 51, 28);
		panel.add(lblBusID);
		lblBusID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		txtDateEnd = new JTextField();
		txtDateEnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		txtDateEnd.setBounds(374, 52, 199, 28);
		panel.add(txtDateEnd);
		txtDateEnd.setEditable(false);
		txtDateEnd.setColumns(10);
		
		JLabel lblDistance = new JLabel("Mã lộ trình");
		lblDistance.setBounds(10, 132, 84, 28);
		panel.add(lblDistance);
		lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		
		cbRouteID = new JComboBox();
		cbRouteID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbRouteID.setBounds(104, 132, 86, 28);
		cbRouteID.addActionListener(new TripInDayListener(this));
		panel.add(cbRouteID);
		
		JLabel lblNii = new JLabel("Nơi đi");
		lblNii.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNii.setBounds(291, 92, 51, 28);
		panel.add(lblNii);
		
		JLabel lblNin = new JLabel("Nơi đến");
		lblNin.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNin.setBounds(291, 132, 51, 28);
		panel.add(lblNin);
		
		cbCityStart = new JComboBox();
		cbCityStart.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityStart.setBounds(374, 92, 199, 28);
		panel.add(cbCityStart);
		
		cbCityEnd = new JComboBox();
		cbCityEnd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityEnd.setBounds(374, 132, 199, 28);
		panel.add(cbCityEnd);
		
		btnFind = new JButton("Tìm");
		btnFind.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnFind.setBackground(Color.CYAN);
		btnFind.setBounds(200, 132, 78, 28);
		btnFind.addActionListener(new TripInDayListener(this));
		panel.add(btnFind);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 205, 594, 34);
		add(panel_1);
		panel_1.setLayout(null);
		
		btnAdd = new JButton("Thêm");
		btnAdd.setBounds(190, 0, 78, 28);
		panel_1.add(btnAdd);
		btnAdd.setBackground(new Color(255, 128, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.addActionListener(new TripInDayListener(this));
		
		btnSave = new JButton("Lưu");
		btnSave.setBounds(56, 0, 78, 28);
		panel_1.add(btnSave);
		btnSave.setBackground(Color.GREEN);
		btnSave.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnSave.addActionListener(new TripInDayListener(this));
		btnSave.setVisible(false);
		
		btnDelete = new JButton("Xóa");
		btnDelete.setBounds(324, 0, 78, 28);
		panel_1.add(btnDelete);
		btnDelete.setBackground(Color.RED);
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.addActionListener(new TripInDayListener(this));
		
		btnCancel = new JButton("Hủy");
		btnCancel.setBounds(458, 0, 78, 28);
		panel_1.add(btnCancel);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.addActionListener(new TripInDayListener(this));
		btnCancel.setVisible(false);
		
		dtm.addColumn("TripID");
		dtm.addColumn("Start Time");
		dtm.addColumn("End Time");
		dtm.addColumn("Start Date");
		dtm.addColumn("End Date");
		dtm.addColumn("Route ID");
		dtm.addColumn("Số lượng ghế đã đặt");
		
		dtm.addRow(new Object[] {null, null, null, null, null, null, null});
		
		table = new JTable(dtm);
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.getSelectionModel().addListSelectionListener(new TripInDayListener(this));
		 
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 289, 594, 254);
		add(scrollPane);
		
		panel_2 = new JPanel();
		panel_2.setBounds(10, 249, 594, 35);
		add(panel_2);
		panel_2.setLayout(null);
		
		lblNii_1 = new JLabel("Nơi đi");
		lblNii_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNii_1.setBounds(9, 0, 42, 28);
		panel_2.add(lblNii_1);
		
		lblNin_1 = new JLabel("Nơi đến");
		lblNin_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNin_1.setBounds(182, 0, 51, 28);
		panel_2.add(lblNin_1);
		
		lblNin_2 = new JLabel("Ngày");
		lblNin_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNin_2.setBounds(364, 0, 42, 28);
		panel_2.add(lblNin_2);
		
		cbCityStartFind = new JComboBox<>();
		cbCityStartFind.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityStartFind.setBounds(60, 0, 113, 28);
		panel_2.add(cbCityStartFind);
		
		cbCityEndFind = new JComboBox<>();
		cbCityEndFind.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityEndFind.setBounds(242, 0, 113, 28);
		panel_2.add(cbCityEndFind);
		
		txtDateFind = new JTextField();
		txtDateFind.setBounds(415, 0, 94, 28);
		panel_2.add(txtDateFind);
		txtDateFind.setColumns(10);
		
		ImageIcon icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/SearchButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblSearch = new JLabel("");
		lblSearch.setBounds(518, 0, 25, 28);
		lblSearch.setIcon(newIcon);
		lblSearch.addMouseListener(new TripInDayListener(this));
		panel_2.add(lblSearch);
		
		icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/reset.png"));
		img = icon.getImage();
		newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		newIcon = new ImageIcon(newImg);
		
		lblReset = new JLabel("");
		lblReset.setBounds(552, 0, 25, 28);
		lblReset.setIcon(newIcon);
		lblReset.addMouseListener(new TripInDayListener(this));
		panel_2.add(lblReset);
		this.setVisible(true);
	}
	
	public void Init()
	{
		this.SetCbRouteID();
		this.SetCbCityStartAndEnd();
	}
	
	public PanelTripInDay() {
		this.GUI();
		this.SetCbRouteID();
		this.SetCbCityStartAndEnd();
		this.SetListTable();
		this.setUnEditable();
	}

	public void SetCbRouteID()
	{
		cbRouteID.removeAllItems();
		List<Route> list = new ArrayList<>();
		try {
			list = DAORoute.getInstance().selectAll();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(Route item : list)
		{
			cbRouteID.addItem(item.getRouteID() + "");
		}
	}

	public void SetCbCityStartAndEnd()
	{
		cbCityEnd.removeAllItems();
		cbCityStart.removeAllItems();
		List<String> list = new ArrayList<>();
		try {
			list = DAOCity.getInstance().getListCity();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(String item : list)
		{
			cbCityStart.addItem(item);
			cbCityEnd.addItem(item);
			cbCityEndFind.addItem(item);
			cbCityStartFind.addItem(item);
		}
	}

	public void SetListTable()
	{
		int n = dtm.getRowCount();
		for(int i = 0; i<n;i++)
		{
			dtm.removeRow(0);
		}
		
		List<Object[]> list = new ArrayList<>();
		try {
			list = DAOTrip.getInstance().getListTID_Admin();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(Object[] item1 : list)
		{
			Trip item = (Trip) item1[0];
			dtm.addRow(new Object[] {item.getTripID(), item.getTimeStart().format(DateTimeFormatter.ofPattern("HH:mm")), item.getTimeEnd().format(DateTimeFormatter.ofPattern("HH:mm")), item.getDateStart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), item.getDateEnd().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), item.getRouteID(), (int) item1[1]});
		}
	}
	
	public void setListSearch(List<Object[]> list)
	{
		int n = dtm.getRowCount();
		for(int i = 0; i<n;i++)
		{
			dtm.removeRow(0);
		}
		
		for(Object[] item1 : list)
		{
			Trip item = (Trip) item1[0];
			dtm.addRow(new Object[] {item.getTripID(), item.getTimeStart().format(DateTimeFormatter.ofPattern("HH:mm")), item.getTimeEnd().format(DateTimeFormatter.ofPattern("HH:mm")), item.getDateStart().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), item.getDateEnd().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")), item.getRouteID(), (int) item1[1]});
		}
	}
	
	public void RowTable_Select(Object[] data)
	{
		this.txtTripID.setText((int) data[0] + "");
		String TimeStart = (String) data[1];
		String TimeEnd = (String) data[2];
		String DateStart = (String) data[3];
		String DateEnd = (String) data[4];
		int RouteID = (int) data[5];
		
		this.txtTimeStart.setText(TimeStart);
		this.txtTimeEnd.setText(TimeEnd);
		this.txtDateStart.setText(DateStart);
		this.txtDateEnd.setText(DateEnd);
		
		for(int i = 0 ; i < cbRouteID.getItemCount();i++)
		{
			if(cbRouteID.getItemAt(i).equals(RouteID + ""))
			{
				cbRouteID.setSelectedIndex(i);
				break;
			}
		}
		
		List<String> listCity = new ArrayList<>();
		try {
			listCity = DAORoute.getInstance().getNameCityStartAndEnd(RouteID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for(int i = 0; i<cbCityStart.getItemCount();i++)
		{
			if(cbCityStart.getItemAt(i).equals(listCity.get(0)))
			{
				cbCityStart.setSelectedIndex(i);
				break;
			}
		}
		
		for(int i = 0; i<cbCityEnd.getItemCount();i++)
		{
			if(cbCityEnd.getItemAt(i).equals(listCity.get(1)))
			{
				cbCityEnd.setSelectedIndex(i);
				break;
			}
		}
		
		
	}

	public void ResetData()
	{
		this.txtDateEnd.setText("");
		this.txtDateStart.setText("");
		this.txtTimeEnd.setText("");
		this.txtTimeStart.setText("");
		this.txtTripID.setText("");
	}
	
	public void setEditable()
	{
		this.txtTimeStart.setEditable(true);
		this.txtDateStart.setEditable(true);
		this.cbRouteID.setEnabled(true);
		this.cbCityEnd.setEnabled(true);
		this.cbCityStart.setEnabled(true);
		
		this.ResetData();
	}
	
	public void setUnEditable()
	{
		this.txtTimeStart.setEditable(false);
		this.txtDateStart.setEditable(false);
		this.cbRouteID.setEnabled(false);
		this.cbCityEnd.setEnabled(false);
		this.cbCityStart.setEnabled(false);
		
		this.ResetData();
	}

	public void cbRouteID_Select()
	{
		if(cbRouteID.getSelectedIndex()<0) return;
		int RouteID = Integer.parseInt(cbRouteID.getSelectedItem() + "");
		List<String> listCity = new ArrayList<>();
		try {
			listCity = DAORoute.getInstance().getNameCityStartAndEnd(RouteID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i =0 ; i < cbCityEnd.getItemCount();i++)
		{
			if(cbCityEnd.getItemAt(i).equals(listCity.get(1)))
			{
				cbCityEnd.setSelectedIndex(i);
				break;
			}
		}
		for(int i = 0 ; i<cbCityStart.getItemCount();i++)
		{
			if(cbCityStart.getItemAt(i).equals(listCity.get(0)))
			{
				cbCityStart.setSelectedIndex(i);
				break;
			}
		}
		if(!this.txtTimeStart.equals("")) this.txtTimeStart_lostFocus();
		if(!this.txtTimeStart.equals("") && !this.txtDateStart.equals("")) this.txtDateStart_lostFocus();
	}
	
	public void btnFind_Select()
	{
		String CityStart = (String)cbCityStart.getSelectedItem();
		String CityEnd = (String) cbCityEnd.getSelectedItem();
		
		String CityIDStart = "";
		try {
			CityIDStart = DAOCity.getInstance().getCityIDByName(CityStart);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		String CityIDEnd = "";
		try {
			CityIDEnd = DAOCity.getInstance().getCityIDByName(CityEnd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Route temp = new Route();
		try {
			temp = DAORoute.getInstance().getRouteByCityStart_End(CityIDStart, CityIDEnd);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(temp.getRouteID() == 0)
		{
			JOptionPane.showMessageDialog(null, "Không thể tìm thấy lộ trình phù hợp");
			return;
		}
		
		for(int i = 0; i<cbRouteID.getItemCount();i++)
		{
			if(cbRouteID.getItemAt(i).equals(temp.getRouteID()+""))
			{
				cbRouteID.setSelectedIndex(i);
				break;
			}
		}
	}
	
	public void txtDateStart_lostFocus()
	{
		if(this.txtDateStart.getText().equals("")) return;
		LocalDate dateStart = null;
		try {
			dateStart = LocalDate.parse(this.txtDateStart.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi định dạng ngày nhập vào không đúng định dạng ( dd/MM/yyyy - VD 05/05/2023 ) vui lòng nhập lại");
			return;
		}
		LocalTime timeStart = null;
		if(txtTimeStart.getText().equals("")) return;
		try {
			timeStart = LocalTime.parse(txtTimeStart.getText(), DateTimeFormatter.ofPattern("HH:mm"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định dạng giờ theo hệ thống ( HH:mm - VD 12:00 ) vui lòng nhập lại");
			return;
		}
		
		Route route = new Route();
		try {
			route = DAORoute.getInstance().selectByID((String)cbRouteID.getSelectedItem());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Time duration = route.getDuration(); 
		
		LocalDate dateEnd = null;
		dateEnd = Trip.getDateEnd(timeStart, duration.toLocalTime(), dateStart);
		
		this.txtDateEnd.setText(dateEnd.format(DateTimeFormatter.ofPattern("dd/MM/yyyy")));
		
	}
	
	public void txtTimeStart_lostFocus()
	{
		if(txtTimeStart.getText().equals("")) return;
		try {
			LocalTime.parse(txtTimeStart.getText(), DateTimeFormatter.ofPattern("HH:mm"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định dạng giờ theo hệ thống ( HH:mm - VD 12:00 ) vui lòng nhập lại");
			return;
		}
		
		LocalTime timeStart = LocalTime.parse(txtTimeStart.getText(), DateTimeFormatter.ofPattern("HH:mm"));
		Route route = new Route();
		try {
			route = DAORoute.getInstance().selectByID((String)cbRouteID.getSelectedItem());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Time duration = route.getDuration(); 
		
		LocalTime timeEnd = Trip.getTimeEnd(timeStart, duration.toLocalTime());
		
		this.txtTimeEnd.setText(timeEnd.format(DateTimeFormatter.ofPattern("HH:mm")));
	
		if(!txtDateStart.equals("")) this.txtDateStart_lostFocus();
	}
	
	public void btnAdd_Select()
	{
		this.setEditable();
		this.btnCancel.setVisible(true);
		this.btnSave.setVisible(true);
		this.btnDelete.setEnabled(false);
		this.btnAdd.setEnabled(false);
	}
	
	public void btnDelete_Select()
	{
		String ID = this.txtTripID.getText();
		try {
			DAOTrip.getInstance().deleteByID(Integer.parseInt(ID));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.dtm.removeRow(table.getSelectedRow());
	}
	
	public Boolean btnDelete_Check()
	{
		if(txtTripID.getText().equals("")) 
		{
			JOptionPane.showMessageDialog(null, "Vui lòng chọn chuyến đi có trong danh sách bên dưới để xóa");
			return false;
		}
		
		int ID = Integer.parseInt(this.txtTripID.getText());
		int BusySeat = 0;
		try {
			BusySeat = DAOTrip.getInstance().getCountBusySeat(ID);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		if(BusySeat > 0)
		{
			JOptionPane.showMessageDialog(null, "Không thể xóa chuyến đi này vì có " + BusySeat + " hàng khách đã đặt chỗ");
			return false;
		}
		
		return true;
	}
	
	public void btnSave_Select()
	{
		LocalDate dateStart = LocalDate.parse(this.txtDateStart.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalDate dateEnd = LocalDate.parse(this.txtDateEnd.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		LocalTime timeStart = LocalTime.parse(this.txtTimeStart.getText(), DateTimeFormatter.ofPattern("HH:mm"));
		LocalTime timeEnd = LocalTime.parse(this.txtTimeEnd.getText(), DateTimeFormatter.ofPattern("HH:mm"));
		int RouteID = Integer.parseInt((String) cbRouteID.getSelectedItem());
		
		try {
			DAOTrip.getInstance().insert(new Trip(RouteID, RouteID, timeStart, timeEnd, dateStart, dateEnd));
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		this.setUnEditable();
		this.btnCancel.setVisible(false);
		this.btnSave.setVisible(false);
		this.btnDelete.setEnabled(true);
		this.btnAdd.setEnabled(true);
		this.SetListTable();
	}
	
	public Boolean btnSave_Check()
	{
		String TimeStart = this.txtTimeStart.getText();
		String DateStart = this.txtDateStart.getText();
		if(TimeStart.equals("") || DateStart.equals(""))
		{
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin để thêm vào danh sách");
			return false;
		}
		
		try {
			LocalDate.parse(DateStart, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi định dạng ngày nhập vào không đúng vui lòng nhập lại theo đúng cấu trúc ( dd/MM/yyyy - VD : 05/05/2023 )");
			return false;
		}
		
		return true;
	}
	
	public void btnCancel_Select()
	{
		this.setUnEditable();
		this.btnCancel.setVisible(false);
		this.btnSave.setVisible(false);
		this.btnAdd.setEnabled(true);
		this.btnDelete.setEnabled(true);
	}
	
	public void lblFind_Select()
	{
		LocalDate date = null;
		try {
			date = LocalDate.parse(this.txtDateFind.getText(), DateTimeFormatter.ofPattern("dd/MM/yyyy"));
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Lỗi định dạng ngày tháng vui lòng nhập lại theo đúng định dạng ( dd/MM/yyyy - VD : 05/05/2023 ) ");
			return;
		}
		
		String CityStart = (String) cbCityStartFind.getSelectedItem();
		String CityEnd = (String) cbCityEndFind.getSelectedItem();
		
		List<Object[]> list = new ArrayList<>();
		
		try {
			list = DAOTrip.getInstance().getListTripBySearch_Admin(CityStart, CityEnd, date);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		this.setListSearch(list);
	}
}