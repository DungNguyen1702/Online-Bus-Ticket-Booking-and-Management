package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import DAO.DAOTrip;
import Models.InfoCustomer;
import Models.Trip;

public class Test extends JFrame {

	private JPanel panel = new JPanel();
	private List<JPanel> listPanelTrip = new ArrayList<>();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Test frame = new Test();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	
	public void GUI()
	{
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBackground(new Color(255, 255, 255));
		setLayout(null);
		setBounds(0, 127, 529, 371);
		
		panel.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		panel.setBounds(167, 127, 529, 371);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
		
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 519, 360);
		add(scrollPane);
	
	}
	
	public void Init()
	{
		List<Trip> listTrip = new ArrayList<>();
		try {
			listTrip = DAOTrip.getInstance().getListByRouteAndDate("City007", "City030", LocalDate.of(2023,04,22));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		InfoCustomer IC = new InfoCustomer(0, "", "", "", "");
		int CusID = 1;
		String KindOfBook = "Khứ hồi";
		
		
		for(Trip item : listTrip)
		{
			listPanelTrip.add(new PanelTrip(item, IC, CusID, KindOfBook));
		}
		
		for (int i = 0; i<listTrip.size(); i++) {
			listPanelTrip.get(i).setPreferredSize(new Dimension(20,130));
			panel.add(listPanelTrip.get(i));
		}
	}
	
	public Test() {
		this.GUI();
		this.Init();
		
		
//		InfoCustomer IC = new InfoCustomer(0, "", "", "", "");
//		int CusID = 1;
//		String KindOfBook = "Khứ hồi";
//
//		try {
//			panel = new PanelListTrip("Đà Nẵng", "Khánh Hòa", LocalDate.of(2023,04,22), CusID, KindOfBook, IC );
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	//làkjefkcc
	}
}
