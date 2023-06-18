package view.Customer;

import javax.swing.JPanel;

import java.awt.BorderLayout;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import Models.Bus;
import Models.Ticket;
import controller.Customer.BookTicketTang1Listener;
import controller.Customer.PanelSittingListener;

import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JTextField;
import javax.swing.JButton;

public class PanelSitting extends JPanel {
	public JTextField txtSitNumber;
	public Bus bus;
	public JPanel panel_1;
	public List<Ticket> BusyTickets;
	public List<Ticket> SelectedTicket;
	public JButton btn_Tang1, btn_Tang2;
	public FormBookTicket fbt;
	
	public PanelSitting(Bus bus, List<Ticket> BusyTickets, List<Ticket> SelectedTicket,FormBookTicket fbt) {
		this.BusyTickets = BusyTickets;
		this.SelectedTicket = SelectedTicket;
		this.bus = bus;
		this.fbt = fbt;
		this.GUI();
	}
	
	public void GUI()
	{
		this.setBounds(0, 0, 529,500);
		setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(128, 255, 255));
		panel.setBounds(23, 23, 483, 448);
		add(panel);
		panel.setLayout(null);
		
		panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 128));
		panel_1.setBounds(29, 70, 257, 318);
		panel.add(panel_1);
		panel_1.setLayout(new BorderLayout(1,1));
		if(bus.getKindOfBus().equals("Giường nằm"))
		{
			panel_1.add(new PanelTang1Giuong(this));
		}else
		{
			panel_1.add(new PanelTang1(this));
		}
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(315, 80, 138, 131);
		panel.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Chú thích");
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 0, 106, 35);
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(128, 255, 255));
		panel_3.setBounds(17, 40, 10, 10);
		panel_2.add(panel_3);
		
		JPanel panel_3_1 = new JPanel();
		panel_3_1.setBackground(new Color(255, 128, 128));
		panel_3_1.setBounds(17, 75, 10, 10);
		panel_2.add(panel_3_1);
		
		JPanel panel_3_2 = new JPanel();
		panel_3_2.setBackground(new Color(0, 255, 0));
		panel_3_2.setBounds(20, 110, 10, 10);
		panel_2.add(panel_3_2);
		
		JLabel lblNewLabel_1 = new JLabel("Còn trống");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1.setBounds(44, 34, 64, 21);
		panel_2.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Đã chọn");
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_1.setBounds(44, 71, 64, 19);
		panel_2.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Đang chọn");
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNewLabel_1_2.setBounds(44, 105, 76, 21);
		panel_2.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_2 = new JLabel("Số ghế chọn");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(296, 252, 90, 29);
		panel.add(lblNewLabel_2);
		
		txtSitNumber = new JTextField(SelectedTicket.size()+"");
		txtSitNumber.setFont(new Font("Tahoma", Font.PLAIN, 15));
		txtSitNumber.setBounds(389, 252, 64, 29);
		panel.add(txtSitNumber);
		
		JButton btnSelect = new JButton("Xác nhận");
		btnSelect.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnSelect.setBackground(new Color(255, 255, 0));
		btnSelect.setBounds(315, 298, 138, 37);
		panel.add(btnSelect);
		btnSelect.addActionListener(new PanelSittingListener(this));
		
		JButton btnBack = new JButton("Quay lại");
		btnBack.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		btnBack.setBackground(new Color(255, 255, 0));
		btnBack.setBounds(315, 351, 138, 37);
		btnBack.addActionListener(new PanelSittingListener(this));
		panel.add(btnBack);
		
		btn_Tang1 = new JButton("Tầng 1");
		btn_Tang1.setBounds(63, 399, 89, 23);
		if(bus.getKindOfBus().equals("1 tầng"))
		{
			btn_Tang1.setVisible(false);
		}
		btn_Tang1.addActionListener(new PanelSittingListener(this));
		panel.add(btn_Tang1);
		
		
		btn_Tang2 = new JButton("Tầng 2");
		btn_Tang2.setBounds(162, 399, 89, 23);
		if(bus.getKindOfBus().equals("1 tầng"))
		{
			btn_Tang2.setVisible(false);
		}
		btn_Tang2.addActionListener(new PanelSittingListener(this));
		panel.add(btn_Tang2);
		
		txtSitNumber.setEditable(false);
		
		JLabel lblNewLabel_3 = new JLabel("Chọn ghế");
		lblNewLabel_3.setBounds(183, 3, 162, 66);
		panel.add(lblNewLabel_3);
		lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 24));
	}
	
	public void IncTextNum() {
		int count = Integer.parseInt(txtSitNumber.getText());
		count++;
		txtSitNumber.setText(count+"");
	}
	public void DecTextNum() {
		int count = Integer.parseInt(txtSitNumber.getText());
		count--;
		txtSitNumber.setText(count+"");
	}
	public void Change_Tang1()
	{
		panel_1.removeAll();
		JPanel pn = new PanelTang1(this);
		panel_1.add(pn);
		panel_1.revalidate();
		panel_1.repaint();
	}
	public void Change_Tang2()
	{
		panel_1.removeAll();
		JPanel pn = new PanelTang2(this);
		panel_1.add(pn);
		panel_1.revalidate();
		panel_1.repaint();
	}
	public void Change_Tang1Giuong()
	{
		panel_1.removeAll();
		JPanel pn = new PanelTang1Giuong(this);
		panel_1.add(pn);
		panel_1.revalidate();
		panel_1.repaint();
	}
	public void Change_Tang2Giuong()
	{
		panel_1.removeAll();
		JPanel pn = new PanelTang2Giuong(this);
		panel_1.add(pn);
		panel_1.revalidate();
		panel_1.repaint();
	}
	public void AddToSelectedList(String seatN)
	{
		this.SelectedTicket.add(new Ticket(0, 0, seatN, "", 0,0));
	}
	public void RemoveFromSelectedList(String seatN)
	{
		for(int i = 0 ;i<this.SelectedTicket.size();i++)
		{
			if(this.SelectedTicket.get(i).getSeatNumber().equals(seatN))
			{
				this.SelectedTicket.remove(i);
			}
		}
	}

}
