package view.admin;

import java.awt.Color;
import java.awt.Font;
import java.awt.HeadlessException;
import java.awt.Image;
import java.sql.SQLException;
import java.sql.Time;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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

import com.toedter.calendar.JDateChooser;
import com.toedter.calendar.JTextFieldDateEditor;

import DAO.DAOCity;
import DAO.DAOCustomer;
import Models.Customer;
import Models.myDate;
import controller.admin.RouteListener;
import controller.admin.UserListener;

import javax.swing.JTextField;
import javax.swing.JComboBox;

public class PanelUserAd extends JPanel {

	private JButton btnAdd, btnUpdate, btnDelete, btnCancel, btnReset;
	private JTextField textUserID;
	private JTextField textPassword;
	private JTextField textUserName;
	public DefaultTableModel dtm;
	private JTable table;

	private JComboBox<String> cbGender;
	private ArrayList<Customer> data = DAOCustomer.getInstance().selectAll();
	private JPanel panel;
	private JLabel lblNii;
	private JLabel lblSearch;
	private JTextField textFieldUserNameFind;
	private JTextField textName;
	private JDateChooser textDate;
	private JTextField textCCCD;
	private JTextField textEmail;
	private JTextField TextPhone;

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

	public JTextField getTextUserID() {
		return textUserID;
	}

	public void setTextUserID(JTextField textUserID) {
		this.textUserID = textUserID;
	}

	public JTextField getTextPassword() {
		return textPassword;
	}

	public void setTextPassword(JTextField textPassword) {
		this.textPassword = textPassword;
	}

	public JTextField getTextUserName() {
		return textUserName;
	}

	public void setTextUserName(JTextField textUserName) {
		this.textUserName = textUserName;
	}

	public DefaultTableModel getDtm() {
		return dtm;
	}

	public void setDtm(DefaultTableModel dtm) {
		this.dtm = dtm;
	}

	public JTable getTable() {
		return table;
	}

	public void setTable(JTable table) {
		this.table = table;
	}

	public ArrayList<Customer> getData() {
		return data;
	}

	public void setData(ArrayList<Customer> data) {
		this.data = data;
	}

	/**
	 * Create the panel.
	 */
	public PanelUserAd() throws ClassNotFoundException, SQLException {
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(188, 0, 614, 553);
		setLayout(null);

		JLabel lblUser = new JLabel("Thông tin tài khoản");
		lblUser.setForeground(new Color(0, 0, 255));
		lblUser.setFont(new Font("Tahoma", Font.BOLD, 25));
		lblUser.setBounds(177, 11, 259, 34);
		add(lblUser);

		JLabel lblUserID = new JLabel("Mã tài khoản");
		lblUserID.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserID.setBounds(20, 44, 84, 34);
		add(lblUserID);

		JLabel lblPassword = new JLabel("Mật khẩu");
		lblPassword.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblPassword.setBounds(332, 44, 84, 34);
		add(lblPassword);

		JLabel lblUserName = new JLabel("Tài khoản");
		lblUserName.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName.setBounds(20, 85, 84, 34);
		add(lblUserName);

		btnAdd = new JButton("Thêm");
		btnAdd.setBackground(new Color(255, 128, 0));
		btnAdd.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnAdd.setBounds(322, 211, 78, 28);
		add(btnAdd);

		btnUpdate = new JButton("Sửa");
		btnUpdate.setBackground(new Color(255, 0, 0));
		btnUpdate.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnUpdate.setBounds(425, 211, 78, 28);
		add(btnUpdate);

		btnDelete = new JButton("Xóa");
		btnDelete.setBackground(new Color(0, 128, 255));
		btnDelete.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnDelete.setBounds(526, 211, 78, 28);
		add(btnDelete);

		btnCancel = new JButton("Hủy");
		btnCancel.setEnabled(false);
		btnCancel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnCancel.setBackground(new Color(192, 192, 192));
		btnCancel.setBounds(214, 211, 78, 28);
		add(btnCancel);

		textUserID = new JTextField();
		textUserID.setEditable(false);
		textUserID.setColumns(10);
		textUserID.setBounds(128, 47, 131, 28);
		add(textUserID);

		textPassword = new JTextField();
		textPassword.setEditable(false);
		textPassword.setColumns(10);
		textPassword.setBounds(427, 48, 131, 28);
		add(textPassword);

		textUserName = new JTextField();
		textUserName.setEditable(false);
		textUserName.setColumns(10);
		textUserName.setBounds(128, 88, 131, 28);
		add(textUserName);

		table = new JTable();

		String[] columnNames = { "ID", "Tài khoản", "Mật khẩu", "Tên", "Ngày sinh", "SDT", "CCCD", "Email", "Giới tính" };

		dtm = new DefaultTableModel(columnNames, 0);

		for (int i = 0; i < data.size(); i++) {

			int ID = data.get(i).getCustomerID();
			String username = data.get(i).getAccount();
			String password = data.get(i).getPassword();
			String name = data.get(i).getName();
			String DOB = data.get(i).getDateOfBirth().toString();
			String Tel = data.get(i).getTel();
			String CCCD = data.get(i).getCitizenID();
			String email = data.get(i).getEmail();
			String gender = data.get(i).getSex();
			Object[] rowData = { ID, username, password, name, DOB, Tel, CCCD, email, gender };
			dtm.addRow(rowData);
		}

		table.setModel(dtm);

		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(10, 296, 594, 232);
		add(scrollPane);

		panel = new JPanel();
		panel.setLayout(null);
		panel.setBounds(10, 250, 594, 35);
		add(panel);

		lblNii = new JLabel("Tài khoản");
		lblNii.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNii.setBounds(98, 3, 68, 28);
		panel.add(lblNii);

		textFieldUserNameFind = new JTextField();
		textFieldUserNameFind.setColumns(10);
		textFieldUserNameFind.setBounds(234, 3, 109, 28);
		panel.add(textFieldUserNameFind);

		ImageIcon icon = new ImageIcon(PanelTripInDay.class.getResource("/photo/SearchButton.png"));
		Image img = icon.getImage();
		Image newImg = img.getScaledInstance(25, 25, Image.SCALE_SMOOTH);
		ImageIcon newIcon = new ImageIcon(newImg);

		lblSearch = new JLabel("");
		lblSearch.setBounds(379, 3, 25, 28);
		lblSearch.setIcon(newIcon);
		panel.add(lblSearch);

		btnReset = new JButton("Reset");
		btnReset.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnReset.setBackground(Color.LIGHT_GRAY);
		btnReset.setBounds(467, 2, 78, 28);
		panel.add(btnReset);

		btnReset.addActionListener(new UserListener(this));
		lblSearch.addMouseListener(new UserListener(this));

		JLabel lblUserName_1 = new JLabel("Tên");
		lblUserName_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName_1.setBounds(20, 124, 84, 34);
		add(lblUserName_1);

		JLabel lblUserName_2 = new JLabel("Ngày sinh");
		lblUserName_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName_2.setBounds(20, 163, 84, 34);
		add(lblUserName_2);

		textName = new JTextField();
		textName.setEditable(false);
		textName.setColumns(10);
		textName.setBounds(128, 127, 131, 28);
		add(textName);

		textDate = new JDateChooser();
		textDate.setDateFormatString("dd/MM/yyyy");
		JTextFieldDateEditor editor1 = (JTextFieldDateEditor) textDate.getDateEditor();
        editor1.setEditable(false);
		textDate.setEnabled(false);
		textDate.setBounds(128, 166, 131, 28);
		add(textDate);

		textCCCD = new JTextField();
		textCCCD.setEditable(false);
		textCCCD.setColumns(10);
		textCCCD.setBounds(427, 127, 131, 28);
		add(textCCCD);

		textEmail = new JTextField();
		textEmail.setEditable(false);
		textEmail.setColumns(10);
		textEmail.setBounds(427, 166, 131, 28);
		add(textEmail);

		TextPhone = new JTextField();
		TextPhone.setEditable(false);
		TextPhone.setColumns(10);
		TextPhone.setBounds(427, 88, 131, 28);
		add(TextPhone);

		JLabel lblSinThoi = new JLabel("Số điện thoại");
		lblSinThoi.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblSinThoi.setBounds(332, 85, 93, 34);
		add(lblSinThoi);

		JLabel lblCccd = new JLabel("CCCD");
		lblCccd.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblCccd.setBounds(332, 126, 84, 34);
		add(lblCccd);

		JLabel lblUserName_4 = new JLabel("Email");
		lblUserName_4.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName_4.setBounds(332, 165, 84, 34);
		add(lblUserName_4);

		JLabel lblUserName_5 = new JLabel("Giới tính");
		lblUserName_5.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblUserName_5.setBounds(20, 208, 70, 34);
		add(lblUserName_5);

		cbGender = new JComboBox<String>();
		cbGender.addItem("Nam");
		cbGender.addItem("Nữ");
		cbGender.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		cbGender.setBounds(89, 212, 64, 28);
		add(cbGender);

		SetTextUnEditable();
		table.getSelectionModel().addListSelectionListener(new UserListener(this));

		btnAdd.addActionListener(new UserListener(this));
		btnCancel.addActionListener(new UserListener(this));
		btnDelete.addActionListener(new UserListener(this));
		btnUpdate.addActionListener(new UserListener(this));
	}

	public JComboBox<String> getCbGender() {
		return cbGender;
	}

	public void setCbGender(JComboBox<String> cbGender) {
		this.cbGender = cbGender;
	}

	public JTextField getTextFieldUserNameFind() {
		return textFieldUserNameFind;
	}

	public void setTextFieldUserNameFind(JTextField textFieldUserNameFind) {
		this.textFieldUserNameFind = textFieldUserNameFind;
	}

	public JTextField getTextName() {
		return textName;
	}

	public void setTextName(JTextField textName) {
		this.textName = textName;
	}

	public JDateChooser getTextDate() {
		return textDate;
	}

	public void setTextDate(JDateChooser textDate) {
		this.textDate = textDate;
	}

	public JTextField getTextCCCD() {
		return textCCCD;
	}

	public void setTextCCCD(JTextField textCCCD) {
		this.textCCCD = textCCCD;
	}

	public JTextField getTextEmail() {
		return textEmail;
	}

	public void setTextEmail(JTextField textEmail) {
		this.textEmail = textEmail;
	}

	public JTextField getTextPhone() {
		return TextPhone;
	}

	public void setTextPhone(JTextField textPhone) {
		TextPhone = textPhone;
	}

	public void SetTextEditable() {
		textPassword.setEditable(true);
		textUserName.setEditable(true);
		textName.setEditable(true);
		textDate.setEnabled(true);
		TextPhone.setEditable(true);
		textCCCD.setEditable(true);
		textEmail.setEditable(true);
		cbGender.setEnabled(true);
	}

	public void SetTextUnEditable() {
		textPassword.setEditable(false);
		textUserName.setEditable(false);
		textUserID.setEditable(false);
		textName.setEditable(false);
		textDate.setEnabled(false);
		TextPhone.setEditable(false);
		textCCCD.setEditable(false);
		textEmail.setEditable(false);
		cbGender.setEnabled(false);
	}

	public void SetTextNull() {
		textUserID.setText("");
		textPassword.setText("");
		textUserName.setText("");
		textName.setText("");
		TextPhone.setText("");
		textCCCD.setText("");
		textEmail.setText("");
	}

	public void SetTextInfor(int index) {
		textUserID.setText(data.get(index).getCustomerID() + "");
		textPassword.setText(data.get(index).getPassword() + "");
		textUserName.setText(data.get(index).getAccount() + "");
		textName.setText(data.get(index).getName() + "");
		
		String dateString = data.get(index).getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
        String pattern = "dd/MM/yyyy"; // Định dạng của chuỗi ngày tháng
        SimpleDateFormat dateFormat = new SimpleDateFormat(pattern);
        try {
            java.util.Date date = dateFormat.parse(dateString);
            this.textDate.setDate(date);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
		TextPhone.setText(data.get(index).getTel() + "");
		textCCCD.setText(data.get(index).getCitizenID() + "");
		textEmail.setText(data.get(index).getEmail() + "");
		cbGender.setSelectedItem(data.get(index).getSex());
	}

	public void PressAdd() {
		SetTextNull();
		SetTextEditable();
		btnCancel.setEnabled(true);
		btnDelete.setEnabled(false);
		btnUpdate.setEnabled(false);
		btnAdd.setText("Lưu");
		textUserID.setText((data.get(data.size() - 1).getCustomerID() + 1) + "");
	}

	public void PressSaveAdd() throws HeadlessException, SQLException {
		int ID = Integer.parseInt(textUserID.getText());
		String UserName = textUserName.getText();
		String Password = textPassword.getText();
		String Name = textName.getText();
		String Email = textEmail.getText();
		String Tel = TextPhone.getText();
		String CitizenID = textCCCD.getText();
		String gender = cbGender.getSelectedItem().toString();
		LocalDate date = myDate.changeToLocalDate(textDate.getDate());

		if (UserName != null && Password != null && CheckInfor() == true) {
			try {
				DAOCustomer.getInstance()
						.insert(new Customer(ID, UserName, Password, Name, date, Tel, CitizenID, Email, gender));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			btnAdd.setText("Thêm");
			data.add(new Customer(ID, UserName, Password, Name, date, Tel, CitizenID, Email, gender));

			Object[] newRow = { ID, UserName, Password, Name, date, Tel, CitizenID, Email, gender };
			dtm.addRow(newRow);
			table.revalidate();
			table.repaint();

			btnDelete.setEnabled(true);
			btnUpdate.setEnabled(true);
			SetTextUnEditable();
			btnCancel.setEnabled(false);

		}

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

	public void PressDelete() {
		if (table.getSelectedRow() != -1) {
			try {
				int option = JOptionPane.showConfirmDialog(null, "Bạn có chắc chắn muốn xóa tài khoản này không?",
						"CẢNH BÁO", JOptionPane.YES_NO_OPTION, JOptionPane.WARNING_MESSAGE);
				if (option == 0) {
					DAOCustomer.getInstance().delete(Integer.parseInt(textUserID.getText()));
					SetTextNull();
					dtm.removeRow(table.getSelectedRow());
					dtm.fireTableDataChanged();
					table.revalidate();
					table.repaint();
				}
			} catch (NumberFormatException | ClassNotFoundException | SQLException e) {
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
		int selectedRow = table.getSelectedRow();
		if (selectedRow != -1) {
			int ID = Integer.parseInt(textUserID.getText());
			String UserName = textUserName.getText();
			String Password = textPassword.getText();
			String Name = textName.getText();
			String Email = textEmail.getText();
			String Tel = TextPhone.getText();
			String CitizenID = textCCCD.getText();
			String gender = cbGender.getSelectedItem().toString();
			LocalDate date = myDate.changeToLocalDate(textDate.getDate());
			
			try {
				DAOCustomer.getInstance().update(new Customer(ID, UserName, Password, Name, date, Tel, CitizenID, Email, gender));
			} catch (ClassNotFoundException | SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
//			try {
//				data = DAOCustomer.getInstance().selectAll();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (SQLException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}

			data.get(selectedRow).setCustomerID(ID);
			data.get(selectedRow).setAccount(UserName);
			data.get(selectedRow).setPassword(Password);
			data.get(selectedRow).setName(Name);
			data.get(selectedRow).setEmail(Email);
			data.get(selectedRow).setTel(Tel);
			data.get(selectedRow).setCitizenID(CitizenID);
			data.get(selectedRow).setSex(gender);
			data.get(selectedRow).setDateOfBirth(date);
			
			
			dtm.setValueAt(ID, selectedRow, 0);
			dtm.setValueAt(UserName, selectedRow, 1);
			dtm.setValueAt(Password, selectedRow, 2);
			dtm.setValueAt(Name, selectedRow, 3);
			dtm.setValueAt(myDate.changeToLocalDate(textDate.getDate()).format(DateTimeFormatter.ofPattern("yyyy-MM-dd")), selectedRow, 4);
			dtm.setValueAt(Tel, selectedRow, 5);
			dtm.setValueAt(CitizenID, selectedRow, 6);
			dtm.setValueAt(gender, selectedRow, 7);
			dtm.fireTableDataChanged();
			table.revalidate();
			table.repaint();

			btnUpdate.setText("Sửa");
			btnDelete.setEnabled(true);
			btnAdd.setEnabled(true);
			SetTextUnEditable();
			btnCancel.setEnabled(false);
		}
	}

	public void PressSearch() {
		String Username = textFieldUserNameFind.getText();
		if (!Username.isEmpty()) {
			int n = dtm.getRowCount();
			for (int i = 0; i < n; i++) {
				dtm.removeRow(0);
			}
			for (int i = 0; i < data.size(); i++) {
				if (Username.equals(data.get(i).getAccount())) {
					int ID = data.get(i).getCustomerID();
					String username = data.get(i).getAccount();
					String password = data.get(i).getPassword();
					String name = data.get(i).getName();
					String DOB = data.get(i).getDateOfBirth().toString();
					String Tel = data.get(i).getTel();
					String CCCD = data.get(i).getCitizenID();
					String email = data.get(i).getEmail();
					String gender = data.get(i).getSex();
					Object[] rowData = { ID, username, password, name, DOB, Tel, CCCD, email, gender };
					dtm.addRow(rowData);
				}
			}
			if (dtm.getRowCount() == 0) {
				JOptionPane.showMessageDialog(null, "Không thể tìm thấy tài khoản phù hợp");
				for (int i = 0; i < data.size(); i++) {
					int ID = data.get(i).getCustomerID();
					String username = data.get(i).getAccount();
					String password = data.get(i).getPassword();
					String name = data.get(i).getName();
					String DOB = data.get(i).getDateOfBirth().toString();
					String Tel = data.get(i).getTel();
					String CCCD = data.get(i).getCitizenID();
					String email = data.get(i).getEmail();
					String gender = data.get(i).getSex();
					Object[] rowData = { ID, username, password, name, DOB, Tel, CCCD, email, gender };
					dtm.addRow(rowData);
				}
				return;
			} else {

			}
			table.setModel(dtm);
			table.revalidate();
			table.repaint();
		} else {
			JOptionPane.showMessageDialog(null, "Dữ liệu tên tài khoản không được để trống!");
			return;
		}
	}

	public void PressReset() {
		int n = dtm.getRowCount();
		for (int i = 0; i < n; i++) {
			dtm.removeRow(0);
		}
		for (int i = 0; i < data.size(); i++) {
			int ID = data.get(i).getCustomerID();
			String username = data.get(i).getAccount();
			String password = data.get(i).getPassword();
			String name = data.get(i).getName();
			String DOB = data.get(i).getDateOfBirth().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
			String Tel = data.get(i).getTel();
			String CCCD = data.get(i).getCitizenID();
			String email = data.get(i).getEmail();
			String gender = data.get(i).getSex();
			Object[] rowData = { ID, username, password, name, DOB, Tel, CCCD, email, gender };
			dtm.addRow(rowData);
		}
		table.setModel(dtm);
		table.revalidate();
		table.repaint();
	}

	public Boolean CheckInfor() throws HeadlessException, SQLException {
		String UserName = textUserName.getText();
		String Password = textPassword.getText();
		String Name = textName.getText();
		String Email = textEmail.getText();
		String Tel = TextPhone.getText();
		String CitizenID = textCCCD.getText();
		
		if (CitizenID.length() < 12) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập CCCD đủ 12 số");
			return false;
		}
		try {
			myDate.changeToLocalDate(textDate.getDate());
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin tài khoản");
			return false;
		}
		
		if (Name.equals("") || Email.equals("") || Tel.equals("") || UserName.equals("")
				|| Password.equals("") || CitizenID.equals("")) {
			JOptionPane.showMessageDialog(null, "Vui lòng nhập đầy đủ thông tin tài khoản");
			return false;
		}
		if (Tel.length() != 10) {
			JOptionPane.showMessageDialog(null, "Số điện thoại nhập vào không phù hợp");
			return false;
		}
		

		try {
			Integer.parseInt(Tel);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định số điện thoại chỉ bao gồm số ");
			return false;
		}

		try {
			Long.parseLong(CitizenID);
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, "Bạn đã nhập sai định CCCD chỉ bao gồm số ");
			return false;
		}

		if (Email.length() <= 10) {
			JOptionPane.showMessageDialog(null, "Đia chỉ email nhập vào không phù hợp với định dạng");
			return false;
		}

		if (!Email.substring(Email.length() - 10).equals("@gmail.com")) {
			JOptionPane.showMessageDialog(null, "Đia chỉ email nhập vào không phù hợp với định dạng");
			return false;
		}
		if (DAOCustomer.getInstance().checkRegister(UserName) == false) {
			JOptionPane.showMessageDialog(null, "Tên tài khoản này đã tồn tại vui lòng chọn tài khoản khác");
			return false;
		}
		return true;
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
}
