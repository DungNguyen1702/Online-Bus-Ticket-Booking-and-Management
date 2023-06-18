package view.admin;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;
import controller.admin.RouteListener;
import DAO.DAOBus;
import DAO.DAOCity;
import DAO.DAORoute;
import Models.Route;
import Models.Trip;

import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.Time;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTable;
import java.awt.Choice;
import javax.swing.JComboBox;

public class PanelRouteAd extends JPanel {
	private JTextField textFieldRoute;
	private JTextField textFieldDistance;
	private JTextField textFieldDuration;
	private JTextField textFieldPrice;
	private JComboBox<String> cbbStartCity, cbbEndCity, cbbBusID;
	private JTable table;
	private JButton btnAdd, btnUpdate, btnDelete, btnCancel;
	public DefaultTableModel dtm;
	private List<Object[]> data = DAORoute.getInstance().getListRouteAndCity();
	private List<String> listCity = DAOCity.getInstance().getListCity();
	private List<String> listBus = DAOBus.getInstance().getListBus();
	private JLabel lblSearch;
	
	private JComboBox<String> cbCityEndFind, cbCityStartFind;
	private JButton btnReset;

		
	public JTextField getTextFieldRoute() {
		return textFieldRoute;
	}

	public void setTextFieldRoute(JTextField textFieldRoute) {
		this.textFieldRoute = textFieldRoute;
	}

	public JTextField getTextFieldDistance() {
		return textFieldDistance;
	}

	public void setTextFieldDistance(JTextField textFieldDistance) {
		this.textFieldDistance = textFieldDistance;
	}

	public JTextField getTextFieldDuration() {
		return textFieldDuration;
	}

	public void setTextFieldDuration(JTextField textFieldDuration) {
		this.textFieldDuration = textFieldDuration;
	}

	public JTextField getTextFieldPrice() {
		return textFieldPrice;
	}

	public void setTextFieldPrice(JTextField textFieldPrice) {
		this.textFieldPrice = textFieldPrice;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public JButton getBtnAdd() {
		return btnAdd;
	}

	public void setBtnAdd(JButton btnAdd) {
		this.btnAdd = btnAdd;
	}

	public JButton getBtnUpdate() {
		return btnUpdate;
	}

	public void setBtnUpdate(JButton btnUpdate) {
		this.btnUpdate = btnUpdate;
	}

	public JButton getBtnDelete() {
		return btnDelete;
	}

	public void setBtnDelete(JButton btnDelete) {
		this.btnDelete = btnDelete;
	}

	public JButton getBtnCancel() {
		return btnCancel;
	}

	public void setBtnCancel(JButton btnCancel) {
		this.btnCancel = btnCancel;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public List<Object[]> getData() {
		return data;
	}

	public void setData(List<Object[]> data) {
		this.data = data;
	}

	

	
	public PanelRouteAd() throws ClassNotFoundException, SQLException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		
		JLabel lblRoute = new JLabel("Thông tin lịch trình");
		lblRoute.setForeground(new Color(0, 0, 255));
		lblRoute.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblRoute.setBounds(177, 11, 259, 34);
		add(lblRoute);
		
		JLabel lblRouteID = new JLabel("Mã lịch trình");
		lblRouteID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblRouteID.setBounds(37, 56, 84, 34);
		add(lblRouteID);
		
		JLabel lblStartCity = new JLabel("Điểm đi");
		lblStartCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblStartCity.setBounds(37, 101, 84, 34);
		add(lblStartCity);
		
		JLabel lblEndCity = new JLabel("Điểm đến");
		lblEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEndCity.setBounds(37, 146, 84, 34);
		add(lblEndCity);
		
		JLabel lblDistance = new JLabel("Khoảng cách");
		lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDistance.setBounds(37, 191, 84, 34);
		add(lblDistance);
		
		JLabel lblDuration = new JLabel("Thời gian");
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDuration.setBounds(349, 56, 84, 34);
		add(lblDuration);
		
		JLabel lblBusID = new JLabel("Mã xe buýt");
		lblBusID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBusID.setBounds(349, 101, 84, 34);
		add(lblBusID);
		
		JLabel lblGi = new JLabel("Giá");
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGi.setBounds(349, 146, 84, 34);
		add(lblGi);
		
		table = new JTable();
		
		
		
		table.getSelectionModel().addListSelectionListener( new RouteListener(this));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 282, 594, 246);
		add(scrollPane);
		
		textFieldRoute = new JTextField();
		textFieldRoute.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldRoute.setEditable(false);
		textFieldRoute.setBounds(141, 58, 96, 28);
		add(textFieldRoute);
		textFieldRoute.setColumns(10);
		
		textFieldDistance = new JTextField();
		textFieldDistance.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldDistance.setEditable(false);
		textFieldDistance.setColumns(10);
		textFieldDistance.setBounds(141, 192, 96, 28);
		add(textFieldDistance);
		
		textFieldDuration = new JTextField();
		textFieldDuration.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldDuration.setEditable(false);
		textFieldDuration.setColumns(10);
		textFieldDuration.setBounds(428, 58, 96, 28);
		add(textFieldDuration);
		
		textFieldPrice = new JTextField();
		textFieldPrice.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		textFieldPrice.setEditable(false);
		textFieldPrice.setColumns(10);
		textFieldPrice.setBounds(428, 147, 96, 28);
		add(textFieldPrice);
		
		 btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(255, 128, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(355, 192, 78, 28);
		add(btnAdd);
		
		 btnUpdate = new JButton("Sửa");
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(446, 192, 78, 28);
		add(btnUpdate);
		
		 btnDelete = new JButton("Xóa");
		btnDelete.setBackground(new Color(0, 128, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(534, 192, 78, 28);
		add(btnDelete);
		
		 btnCancel = new JButton("Hủy");
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setBounds(267, 192, 78, 28);
		add(btnCancel);
		
		
		
		 cbbStartCity = new JComboBox<String>();
		 cbbStartCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cbbStartCity.setBounds(141, 107, 130, 28);
		add(cbbStartCity);
		
		 cbbEndCity = new JComboBox<String>();
		 cbbEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cbbEndCity.setBounds(141, 149, 130, 28);
		add(cbbEndCity);
		
		cbbBusID = new JComboBox<String>();
		cbbBusID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		cbbBusID.setEnabled(false);
		cbbBusID.setBounds(428, 107, 96, 28);
		add(cbbBusID);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setBounds(10, 236, 594, 35);
		add(panel_2);
		
		JLabel lblNii_1 = new JLabel("Nơi đi");
		lblNii_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNii_1.setBounds(23, 3, 51, 28);
		panel_2.add(lblNii_1);
		
		JLabel lblNin_1 = new JLabel("Nơi đến");
		lblNin_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNin_1.setBounds(233, 3, 51, 28);
		panel_2.add(lblNin_1);
		
		cbCityStartFind = new JComboBox<String>();
		cbCityStartFind.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityStartFind.setBounds(97, 3, 113, 28);
		panel_2.add(cbCityStartFind);
		
		cbCityEndFind = new JComboBox<String>();
		cbCityEndFind.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbCityEndFind.setBounds(307, 3, 113, 28);
		panel_2.add(cbCityEndFind);
		
		ImageIcon icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/SearchButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblSearch = new JLabel("");
		lblSearch.setBounds(443, 3, 25, 28);
		lblSearch.setIcon(newIcon);
		panel_2.add(lblSearch);
		
		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(491, 3, 78, 28);
		panel_2.add(btnReset);
		Init();
		SetTextUnEditable();
		btnAdd.addActionListener(new RouteListener(this));
		btnCancel.addActionListener(new RouteListener(this));
		btnDelete.addActionListener(new RouteListener(this));
		btnUpdate.addActionListener(new RouteListener(this));
		lblSearch.addMouseListener(new RouteListener(this));
		btnReset.addActionListener(new RouteListener(this));
	}
	
	public JLabel getLblSearch() {
		return lblSearch;
	}

	public void setLblSearch(JLabel lblSearch) {
		this.lblSearch = lblSearch;
	}

	public JButton getBtnReset() {
		return btnReset;
	}

	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}

	public void SetTextUnEditable() {
		textFieldDistance.setEditable(false);
		textFieldDuration.setEditable(false);
		cbbStartCity.setEnabled(false);
		cbbEndCity.setEditable(false);
		textFieldPrice.setEditable(false);
		cbbEndCity.setEnabled(false);
		cbbBusID.setEnabled(false);
	}
	public void SetTextEditable() {
		cbbBusID.setEnabled(true);
		textFieldDistance.setEditable(true);
		textFieldDuration.setEditable(true);
		cbbStartCity.setEnabled(true);
		cbbEndCity.setEnabled(true);
		textFieldPrice.setEditable(true);
		cbbEndCity.setEnabled(true);
	}
	public void SetTextInFor(int index) {
		textFieldRoute.setText(data.get(index)[0]+"");
		cbbStartCity.setSelectedItem(data.get(index)[1]+"");
		cbbEndCity.setSelectedItem(data.get(index)[2]+"");
		textFieldDistance.setText(data.get(index)[3]+"");
		textFieldDuration.setText(data.get(index)[4]+"");
		cbbBusID.setSelectedItem(data.get(index)[5]+"");
		textFieldPrice.setText(data.get(index)[6]+"");
		
	}
	public void SetTextNull() {
		this.textFieldDistance.setText("");
		this.textFieldDuration.setText("");
		this.textFieldPrice.setText("");
		this.textFieldRoute.setText("");
	}
	public void PressAdd() {
		SetTextNull();
		SetTextEditable();
		btnCancel.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnAdd.setText("Lưu");
		textFieldRoute.setText((Integer.parseInt(data.get(data.size()-1)[0]+"")+1)+"");
	}
	public void PressSaveAdd() {
			int ID = Integer.parseInt(textFieldRoute.getText());
			String StartCity = cbbStartCity.getSelectedItem().toString();
			String EndCity = cbbEndCity.getSelectedItem().toString();
			
			if(StartCity.equals(EndCity))
			{
				JOptionPane.showMessageDialog(null, "Điểm đi không thể trùng điểm đến");
				return;
			}
			
			if(textFieldDuration.getText().equals("") || textFieldDistance.getText().equals("") || textFieldPrice.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin khoảng thời gian , giá cả , và khoảng cách");
				return;
			}
			
			int Distance = 0;
			try {
				Distance = Integer.parseInt(textFieldDistance.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi định dạng khoảng cách ( chỉ có thể nhập chữ số vào ) vui lòng nhập lại");
				return;
			}
			
			String KindOfBus = cbbBusID.getSelectedItem().toString();
			String BusID = "";
			try {
				BusID = DAOBus.getInstance().getBusIDByKindOfBus(KindOfBus);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int Price = 0 ;
			try {
				Price = Integer.parseInt(textFieldPrice.getText());	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi định dạng giá tiền ( chỉ có thể nhập chữ số vào ) vui lòng nhập lại");
				return;
			}
			
			
			btnAdd.setText("Thêm");
			
			Time time = null;
			
			try {
				time = Time.valueOf(LocalTime.parse(textFieldDuration.getText(), DateTimeFormatter.ofPattern("HH:mm:ss")));
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi định dạng giờ trong hệ thống ( HH:mm:ss - VD 12:00:00 ) vui lòng nhập lại");
				return;
			}
			
			try {
				DAORoute.getInstance().insert(new Route(ID, BusID, DAOCity.getInstance().getCityIDByName(StartCity),DAOCity.getInstance().getCityIDByName(EndCity), Price, time, Distance));
				data = DAORoute.getInstance().getListRouteAndCity();  
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PressReset();
			
			btnDelete.setEnabled(true);
			btnUpdate.setEnabled(true);
			SetTextUnEditable();
			btnCancel.setEnabled(false);
	}
	public void PressCancel() {
		btnCancel.setEnabled(false);
		btnDelete.setEnabled(true);
		btnUpdate.setEnabled(true);
		btnAdd.setEnabled(true);
		btnAdd.setText("Thêm");
		btnDelete.setText("Xóa");
		btnUpdate.setText("Sửa");
		SetTextUnEditable();
	}
	public void Init() throws SQLException
	{
		
		for(String item : listCity)
		{
			cbbStartCity.addItem(item);
			cbbEndCity.addItem(item);
			cbCityEndFind.addItem(item);
			cbCityStartFind.addItem(item);
		}
		for(String item : listBus)
		{
			cbbBusID.addItem(item);;
		}

		
		String[] columnNames = {"ID","Điểm đi","Điểm đến","Khoảng cách","Thời gian","Mã xe","Giá"};
		
		dtm = new DefaultTableModel(columnNames, 0);
		
		for (int i = 0; i < data.size(); i++)
		{
			Object[] rowData = data.get(i);
			dtm.addRow(rowData);
		}
		
		table.setModel(dtm);
	}
	public void PressDelete() {
		if (!textFieldRoute.getText().isEmpty()) {

			try {
				System.out.println(table.getSelectedRow());
				DAORoute.getInstance().delete(Integer.parseInt(textFieldRoute.getText()));
				
				if (table.getSelectedRow() != -1) {
					dtm.removeRow(table.getSelectedRow());
					table.revalidate();
					table.repaint();
				}
				data = DAORoute.getInstance().getListRouteAndCity(); 
			} catch (NumberFormatException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void PressUpdate() {
		if (table.getSelectedRow() != -1) {
			SetTextEditable();
			btnAdd.setEnabled(false);
			btnDelete.setEnabled(false);
			btnCancel.setEnabled(true);
			btnUpdate.setText("Lưu");
		}
	}
	public void PressSaveUpdate() {
		int selectedRowIndex = table.getSelectedRow();
		if (selectedRowIndex != -1) {
			
			data.get(selectedRowIndex)[0] = textFieldRoute.getText();
			data.get(selectedRowIndex)[1] = cbbStartCity.getSelectedItem().toString();
			data.get(selectedRowIndex)[2] = cbbEndCity.getSelectedItem().toString();
			data.get(selectedRowIndex)[3] = textFieldDistance.getText();
			data.get(selectedRowIndex)[4] = textFieldDuration.getText();
			data.get(selectedRowIndex)[5] = cbbBusID.getSelectedItem().toString();
			data.get(selectedRowIndex)[6] = textFieldPrice.getText();
			
			dtm.setValueAt(data.get(selectedRowIndex)[0], selectedRowIndex, 0);
			dtm.setValueAt(data.get(selectedRowIndex)[1], selectedRowIndex, 1);
			dtm.setValueAt(data.get(selectedRowIndex)[2], selectedRowIndex, 2);
			dtm.setValueAt(data.get(selectedRowIndex)[3], selectedRowIndex, 3);
			dtm.setValueAt(data.get(selectedRowIndex)[4], selectedRowIndex, 4);
			dtm.setValueAt(data.get(selectedRowIndex)[5], selectedRowIndex, 5);
			dtm.setValueAt(data.get(selectedRowIndex)[6], selectedRowIndex, 6);
			
			if(textFieldDuration.getText().equals("") || textFieldDistance.getText().equals("") || textFieldPrice.getText().equals(""))
			{
				JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin khoảng thời gian , giá cả , và khoảng cách");
				return;
			}
			
			int ID = Integer.parseInt(textFieldRoute.getText());
			String StartCity = cbbStartCity.getSelectedItem().toString();
			String EndCity = cbbEndCity.getSelectedItem().toString();
			
			if(StartCity.equals(EndCity))
			{
				JOptionPane.showMessageDialog(null, "Lỗi điểm đi không thể giống với điểm đến vui lòng chọn lại");
				return;
			}
			
			int Distance = 0;
			try {
				Distance = Integer.parseInt(textFieldDistance.getText());	
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi nhập khoảng cách ( chỉ bao gồm các chữ số ) vui lòng nhập lại");
				return;
			}
			String KindOfBus = cbbBusID.getSelectedItem().toString();
			String BusID = "";
			try {
				BusID = DAOBus.getInstance().getBusIDByKindOfBus(KindOfBus);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			int Price = 0;
			try {	
				Price = Integer.parseInt(textFieldPrice.getText());
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi nhập giá tiền ( chỉ bao gồm các chữ số ) vui lòng nhập lại");
				return;
			}
			String t = textFieldDuration.getText();
			Time time = null;
			try {
				time = Time.valueOf(LocalTime.parse(t, DateTimeFormatter.ofPattern("HH:mm:ss"))) ;
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, "Lỗi nhập sai định giờ trong hệ thống ( HH:mm:ss - VD 12:00:00 ) vui lòng nhập lại");
				return;
			}
			try {
				DAORoute.getInstance().update(new Route(ID, BusID, DAOCity.getInstance().getCityIDByName(StartCity),DAOCity.getInstance().getCityIDByName(EndCity), Price, time, Distance));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			PressReset();
			
			btnUpdate.setText("Sửa");
			btnDelete.setEnabled(true);
			btnAdd.setEnabled(true);
			SetTextUnEditable();
			btnCancel.setEnabled(false);
		}
	}
	public void PressSearch() {
		String StartCity = cbCityStartFind.getSelectedItem().toString();
		String EndCity = cbCityEndFind.getSelectedItem().toString();
		if(!StartCity.equals(EndCity)) {
			int n = dtm.getRowCount();
			for(int i = 0; i<n;i++)
			{
				dtm.removeRow(0);
			}
			
			for(int i = 0; i<data.size();i++)
			{
				if (StartCity.equals(data.get(i)[1]) && EndCity.equals(data.get(i)[2])) {
					Object[] rowData = data.get(i);
					dtm.addRow(rowData);
				}
			}
			if(dtm.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không thể tìm thấy lộ trình phù hợp");
				for (int i = 0; i < data.size(); i++)
				{
					
					Object[] rowData = data.get(i);
					dtm.addRow(rowData);
				}
				return;
			} else {
				
			}
			table.setModel(dtm);
			table.revalidate();
			table.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Điểm đi và điểm đến không được trùng nhau");
			return;
		}
	}
	public void PressReset() {
		int n = dtm.getRowCount();
		for(int i = 0; i<n;i++)
		{
			dtm.removeRow(0);
		}
		
		try {
			data = DAORoute.getInstance().getListRouteAndCity();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		for (int i = 0; i < data.size(); i++)
		{
			Object[] rowData = data.get(i);
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
		table.revalidate();
		table.repaint();
	}
}
