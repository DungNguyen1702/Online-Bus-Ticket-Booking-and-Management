package view.Customer;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import DAO.DAOCity;
import DAO.DAOTrip;
import Models.InfoCustomer;
import Models.Route;
import Models.Trip;

public class PanelListTrip extends JPanel {

	private List<JPanel> listPanelTrip = new ArrayList<>();
	private JPanel panel = new  JPanel();

	// Data
	private String NameCityStart;
	private String NameCityEnd;
	private LocalDate date;
	private InfoCustomer IC;
	public int CusID;
	public String KindOfBook;

	
	/**
	 * @wbp.parser.constructor
	 */
	
	public PanelListTrip(String NameCityStart, String NameCityEnd, LocalDate date, int CusID, String KindOfBook, InfoCustomer IC) throws SQLException 
	{
		this.NameCityEnd = NameCityEnd;
		this.IC = IC;
		this.NameCityStart = NameCityStart;
		this.date = date;
		this.CusID = CusID;
		this.KindOfBook = KindOfBook;
		
		this.GUI();
		this.Init();
	}

	
	public void Init() throws SQLException
	{
		List<Trip> listTrip = new ArrayList<>();
		String CityIDStart = DAOCity.getInstance().getCityIDByName(NameCityStart);
		String CityIDEnd = DAOCity.getInstance().getCityIDByName(NameCityEnd);
		
		listTrip = DAOTrip.getInstance().getListByRouteAndDate(CityIDStart, CityIDEnd, date);		
		
		for(Trip item : listTrip)
		{
			listPanelTrip.add(new PanelTrip(item, IC, CusID, KindOfBook));
		}
		
		for (int i = 0; i<listTrip.size(); i++) {
			listPanelTrip.get(i).setPreferredSize(new Dimension(20,130));
			panel.add(listPanelTrip.get(i));
		}
	}
	
	public void GUI() throws SQLException
	{
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
	
}
