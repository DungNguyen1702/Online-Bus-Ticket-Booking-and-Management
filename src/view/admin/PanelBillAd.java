package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.print.Book;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.LineBorder;
import javax.swing.table.DefaultTableModel;

import DAO.DAOBill;
import Models.Bill;
import controller.admin.BillListener;
import controller.admin.UserListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PanelBillAd extends JPanel {

	/**
	 * Create the panel.
	 */
	
	private JButton btnAccept, btnRefuse;
	private JTextField textBillID;
	private JTextField textFieldCusID;
	private JTextField textPayment;
	private JTextField textKind;
	private JTextField textDate;
	private JTextField textInForID;
	private JTextField textTotal;
	private JTextField textFieldStatus;
	
	private JComboBox<String> cbOption;
	private JButton btnReset;
	private JLabel lblSearch;
	
	public DefaultTableModel dtm;
	private JTable table;
	
	private ArrayList<Bill> data = DAOBill.getInstance().selectAll();
	
	public PanelBillAd() throws ClassNotFoundException, SQLException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);
		JLabel lblBill = new JLabel("Thông tin hóa đơn");
		lblBill.setForeground(Color.BLUE);
		lblBill.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblBill.setBounds(198, 11, 259, 34);
		add(lblBill);
		
		JLabel lblBillID = new JLabel("Mã hóa đơn");
		lblBillID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBillID.setBounds(37, 56, 84, 34);
		add(lblBillID);
		
		JLabel lblCustomerID = new JLabel("Mã khách hàng");
		lblCustomerID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblCustomerID.setBounds(37, 101, 84, 34);
		add(lblCustomerID);
		
		JLabel lblEndCity = new JLabel("Thanh toán");
		lblEndCity.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblEndCity.setBounds(37, 146, 84, 34);
		add(lblEndCity);
		
		JLabel lblDistance = new JLabel("Loại");
		lblDistance.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDistance.setBounds(37, 191, 84, 34);
		add(lblDistance);
		
		JLabel lblDuration = new JLabel("Thời gian");
		lblDuration.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblDuration.setBounds(349, 56, 84, 34);
		add(lblDuration);
		
		JLabel lblBusID = new JLabel("Mã thông tin");
		lblBusID.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblBusID.setBounds(349, 101, 84, 34);
		add(lblBusID);
		
		JLabel lblGi = new JLabel("Tổng tiền");
		lblGi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblGi.setBounds(349, 146, 84, 34);
		add(lblGi);
		
		textBillID = new JTextField();
		textBillID.setEditable(false);
		textBillID.setColumns(10);
		textBillID.setBounds(125, 59, 134, 28);
		add(textBillID);
		
		textFieldCusID = new JTextField();
		textFieldCusID.setEditable(false);
		textFieldCusID.setColumns(10);
		textFieldCusID.setBounds(125, 104, 134, 28);
		add(textFieldCusID);
		
		textPayment = new JTextField();
		textPayment.setEditable(false);
		textPayment.setColumns(10);
		textPayment.setBounds(125, 149, 134, 28);
		add(textPayment);
		
		textKind = new JTextField();
		textKind.setEditable(false);
		textKind.setColumns(10);
		textKind.setBounds(125, 194, 134, 28);
		add(textKind);
		
		textDate = new JTextField();
		textDate.setEditable(false);
		textDate.setColumns(10);
		textDate.setBounds(430, 56, 134, 28);
		add(textDate);
		
		textInForID = new JTextField();
		textInForID.setEditable(false);
		textInForID.setColumns(10);
		textInForID.setBounds(430, 101, 134, 28);
		add(textInForID);
		
		textTotal = new JTextField();
		textTotal.setEditable(false);
		textTotal.setColumns(10);
		textTotal.setBounds(430, 146, 134, 28);
		add(textTotal);
		
		 btnAccept = new JButton("Chấp nhận");
		 btnAccept.setEnabled(false);
		 btnAccept.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnAccept.setBackground(new Color(255, 128, 0));
		 btnAccept.setBounds(343, 233, 114, 28);
		add(btnAccept);
		
		 btnRefuse = new JButton("Từ chối");
		 btnRefuse.setEnabled(false);
		 btnRefuse.setFont(new Font("Tahoma", Font.PLAIN, 15));
		 btnRefuse.setBackground(Color.RED);
		 btnRefuse.setBounds(490, 233, 114, 28);
		add(btnRefuse);
		
		JLabel lblTrngThi = new JLabel("Trạng thái");
		lblTrngThi.setFont(new Font("Times New Roman", Font.PLAIN, 13));
		lblTrngThi.setBounds(349, 191, 84, 34);
		add(lblTrngThi);
		
		String[] columnNames = {"ID","Mã tài khoản","Thanh toán","Trạng thái","Loại đặt","Ngày","Mã thông tin","Tổng tiền"};
		
		dtm = new DefaultTableModel(columnNames, 0);
		
		for (int i = 0; i< data.size();i++) {
			 int BillID = data.get(i).getBillID();
			 int CustomerID = data.get(i).getCustomerID();
			 String PaymentMethod = data.get(i).getPaymentMethod();
			 String Status = data.get(i).getStatus();
			 String KindOfBook = data.get(i).getKindOfBook();
			 LocalDate BookDate = data.get(i).getBookDate();
			 int InfoID = data.get(i).getInfoID();
			 int TotalPrice = data.get(i).getTotalPrice();
			Object[] newRow = {BillID,CustomerID,PaymentMethod,Status,KindOfBook,BookDate,InfoID,TotalPrice};
			dtm.addRow(newRow);
		}
		
		table = new JTable();
		table.setModel(dtm);
		
		table.getSelectionModel().addListSelectionListener( new BillListener(this));
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(20, 276, 584, 252);
		add(scrollPane);
		
		
		textFieldStatus = new JTextField();
		textFieldStatus.setEditable(false);
		textFieldStatus.setColumns(10);
		textFieldStatus.setBounds(430, 194, 134, 28);
		add(textFieldStatus);
		
		btnAccept.addActionListener(new BillListener(this));
		btnRefuse.addActionListener(new BillListener(this));
		
		JPanel panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(27, 230, 278, 35);
		add(panel);
		
		ImageIcon icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/SearchButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);
		
		lblSearch = new JLabel("");
		lblSearch.setBounds(159, 3, 25, 28);
		lblSearch.setIcon(newIcon);
		panel.add(lblSearch);
		
		 btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(192, 3, 78, 28);
		panel.add(btnReset);
		
		cbOption = new JComboBox<String>();
		cbOption.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbOption.setBounds(8, 3, 143, 28);
		
		cbOption.addItem("Chưa thanh toán");
		cbOption.addItem("Đã chấp nhận");
		cbOption.addItem("Đã từ chối");
		
		panel.add(cbOption);
		
		btnReset.addActionListener(new BillListener(this));
		lblSearch.addMouseListener(new BillListener(this));
	}
	public void SetTextInfor(int index) {
		textBillID.setText(dtm.getValueAt(index, 0)+"");
		textFieldCusID.setText(dtm.getValueAt(index, 1)+"");
		textPayment.setText(dtm.getValueAt(index, 2)+"");
		textFieldStatus.setText(dtm.getValueAt(index, 3)+"");
		textKind.setText(dtm.getValueAt(index, 4)+"");
		textDate.setText(dtm.getValueAt(index, 5)+"");
		textInForID.setText(dtm.getValueAt(index, 6)+"");
		textTotal.setText(dtm.getValueAt(index, 7)+"");
//		btnAccept.setEnabled(true);
//		btnRefuse.setEnabled(true);
		if(!dtm.getValueAt(index, 3).equals("Chưa thanh toán")) {
			btnAccept.setEnabled(false);
			btnRefuse.setEnabled(false);
		} else {
			btnAccept.setEnabled(true);
			btnRefuse.setEnabled(true);
		}
	}
	
	public void PressAccept() {
		int selectedRow = table.getSelectedRow();
		if ( selectedRow != -1) {
			data.get(selectedRow).setStatus("Đã chấp nhận");
			try {
				DAOBill.getInstance().update(data.get(selectedRow));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dtm.setValueAt("Đã chấp nhận", selectedRow, 3);
			SetTextInfor(selectedRow);
			table.revalidate();
			table.repaint();
		}
	}
	
	public void PressRefuse() {
		int selectedRow = table.getSelectedRow();
		if ( selectedRow != -1) {
			data.get(selectedRow).setStatus("Đã từ chối");
			try {
				DAOBill.getInstance().update(data.get(selectedRow));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			dtm.setValueAt("Đã từ chối", selectedRow, 3);
			SetTextInfor(selectedRow);
			table.revalidate();
			table.repaint();
		}
	}
	
	public void PressSearch() {
		String option = cbOption.getSelectedItem().toString();
		int n = dtm.getRowCount();
		for(int i = 0; i<n;i++)
		{
			dtm.removeRow(0);
		}
		for (int i = 0; i< data.size();i++) {
			if (option.equals(data.get(i).getStatus())) {
				int BillID = data.get(i).getBillID();
				 int CustomerID = data.get(i).getCustomerID();
				 String PaymentMethod = data.get(i).getPaymentMethod();
				 String Status = data.get(i).getStatus();
				 String KindOfBook = data.get(i).getKindOfBook();
				 LocalDate BookDate = data.get(i).getBookDate();
				 int InfoID = data.get(i).getInfoID();
				 int TotalPrice = data.get(i).getTotalPrice();
				Object[] newRow = {BillID,CustomerID,PaymentMethod,Status,KindOfBook,BookDate,InfoID,TotalPrice};
				dtm.addRow(newRow);
			}
		}
		if(dtm.getRowCount() == 0) {
			JOptionPane.showMessageDialog(null, "Không thể tìm thấy hóa đơn phù hợp");
			for (int i = 0; i < data.size(); i++)
			{
				int BillID = data.get(i).getBillID();
				 int CustomerID = data.get(i).getCustomerID();
				 String PaymentMethod = data.get(i).getPaymentMethod();
				 String Status = data.get(i).getStatus();
				 String KindOfBook = data.get(i).getKindOfBook();
				 LocalDate BookDate = data.get(i).getBookDate();
				 int InfoID = data.get(i).getInfoID();
				 int TotalPrice = data.get(i).getTotalPrice();
				Object[] newRow = {BillID,CustomerID,PaymentMethod,Status,KindOfBook,BookDate,InfoID,TotalPrice};
				dtm.addRow(newRow);
			}
			return;
		} else {
			
		}
		table.setModel(dtm);
		table.revalidate();
		table.repaint();
	}
	public void PressReset() {
		int n = dtm.getRowCount();
		for(int i = 0; i<n;i++)
		{
			dtm.removeRow(0);
		}
		for (int i = 0; i < data.size(); i++)
		{
			int BillID = data.get(i).getBillID();
			 int CustomerID = data.get(i).getCustomerID();
			 String PaymentMethod = data.get(i).getPaymentMethod();
			 String Status = data.get(i).getStatus();
			 String KindOfBook = data.get(i).getKindOfBook();
			 LocalDate BookDate = data.get(i).getBookDate();
			 int InfoID = data.get(i).getInfoID();
			 int TotalPrice = data.get(i).getTotalPrice();
			Object[] newRow = {BillID,CustomerID,PaymentMethod,Status,KindOfBook,BookDate,InfoID,TotalPrice};
			dtm.addRow(newRow);
		}
	}
	
	public JButton getBtnReset() {
		return btnReset;
	}
	public void setBtnReset(JButton btnReset) {
		this.btnReset = btnReset;
	}
	public JLabel getLblSearch() {
		return lblSearch;
	}
	public void setLblSearch(JLabel lblSearch) {
		this.lblSearch = lblSearch;
	}
	public JButton getBtnAccept() {
		return btnAccept;
	}
	public void setBtnAccept(JButton btnAccept) {
		this.btnAccept = btnAccept;
	}
	public JButton getBtnRefuse() {
		return btnRefuse;
	}
	public void setBtnRefuse(JButton btnRefuse) {
		this.btnRefuse = btnRefuse;
	}
	public JTextField getTextTotal() {
		return textTotal;
	}
	public void setTextTotal(JTextField textTotal) {
		this.textTotal = textTotal;
	}
	public JTable getTable() {
		return table;
	}
	public void setTable(JTable table) {
		this.table = table;
	}
}