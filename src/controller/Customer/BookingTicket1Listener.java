package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import Algorithm.floydWarshall;
import DAO.DAOCity;
import DAO.DAORoute;
import Models.Route;
import view.Customer.BookingTicket1;

public class BookingTicket1Listener implements ActionListener{
	private BookingTicket1 BT1;
	
	
	public BookingTicket1Listener(BookingTicket1 BT1) {
		this.BT1 = BT1;
	}
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		
		if(tmp == BT1.btn_ChieuDi)
		{
			BT1.btnChieuDi_Select();
		}
		else if(tmp == BT1.btn_ChieuVe)
		{
			BT1.btnChieuVe_Select();
		}
		
		else if(tmp == BT1.btnSearch)
		{
			if(BT1.btnSearch_Check() == false) return;
			BT1.btnSeach_Select();
		}
		
		else if(BT1.rdbtnRoundTrip.isSelected())
		{
			BT1.rdbtnRoundTrip_isSelect();
		}
		else if(BT1.rdbtnOneTrip.isSelected())
		{
			BT1.rdbtnOneTrip_isSelect();
		}
	}

}
