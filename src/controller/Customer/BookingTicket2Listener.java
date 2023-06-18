package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import view.Customer.BookingTicket2;

public class BookingTicket2Listener implements ActionListener, MouseListener {
	private BookingTicket2 bookingTicket2;
	
	public BookingTicket2Listener (BookingTicket2 bookingTicket2) {
		this.bookingTicket2 = bookingTicket2;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object tmp = e.getSource();
		if(tmp == bookingTicket2.btn_ChieuDi)
		{
			try {
				bookingTicket2.ChieuDi_Selected();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		else if(tmp == bookingTicket2.btn_ChieuVe)
		{
			try {
				bookingTicket2.ChieuVe_Selected();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mouseClicked(MouseEvent e) {
	
		if(e.getComponent() == bookingTicket2.lblSearch)
		{
			if(bookingTicket2.Searchlbl_Check() == false) return;
			try {
				bookingTicket2.Searchlbl_Selected();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
