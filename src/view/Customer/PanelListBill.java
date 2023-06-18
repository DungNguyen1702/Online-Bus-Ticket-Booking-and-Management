package view.Customer;

import java.awt.Color;
import java.awt.Dimension;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;
import javax.swing.border.LineBorder;

import DAO.DAOBill;
import Models.Bill;

public class PanelListBill extends JPanel {

	/**
	 * Create the panel.
	 */
	private int numBill = 0;
	private int cusID = -1;
	public List<JPanel> listPanel = new  ArrayList<>();
	public JPanel panel = new JPanel();
	public List<Bill> listBill;

	public void GUI()
	{
		this.setBackground(new Color(255, 255, 255));
		this.setBounds(0, 127, 529, 371);
		this.setLayout(null);
		
		panel.setBorder(new LineBorder(new Color(130, 135, 144), 1, true));
		panel.setBounds(167, 127, 529, 371);
		panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
			
		JScrollPane scrollPane = new JScrollPane(panel);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(0, 0, 519, 360);
		add(scrollPane);
	}

	public void Init() throws ClassNotFoundException, SQLException
	{
		
		listBill = DAOBill.getInstance().selectByCusID(cusID);
		listPanel = new ArrayList<>();
		
		for (Bill item : listBill) {
			listPanel.add(new PanelBill(item));
			
		}
		
		panel.removeAll();
		panel.revalidate();
		panel.repaint();
		
		for (int i = 0; i<listBill.size(); i++) {
			listPanel.get(i).setPreferredSize(new Dimension(20,130));
			panel.add(listPanel.get(i));
		}
	}
	
	public PanelListBill(int cusID ) {
		this.cusID = cusID;
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
