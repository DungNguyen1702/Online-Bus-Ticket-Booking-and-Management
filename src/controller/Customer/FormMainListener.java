package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JOptionPane;

import view.Customer.BookingTicket1;
import view.Customer.BookingTicket2;
import view.Customer.FormMainPage;
import view.Customer.PanelUser;
import view.Login.FormLogin;

public class FormMainListener implements ActionListener, MouseListener{
	private FormMainPage formMain;
		
	public FormMainListener(FormMainPage formMain) {
		// TODO Auto-generated constructor stub
		this.formMain = formMain;
	}
			
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		if (tmp == formMain.btnAcc) {
			formMain.changeToAcc();
		} else
		if (tmp == formMain.btnBookTicket) {
			formMain.changeToBooking();
		} else
		if (tmp == formMain.btnBill) {
			formMain.changeToBill();
		} else
		if (tmp == formMain.bookingTicket1Panel.btnViewTicket) {
			if(formMain.BT1_btnViewTicket_Check() == false) return;
			formMain.BT1_btnViewTicket_Select();
		}
		if(tmp == formMain.btnLogOut)
		{
			formMain.dispose();
			new FormLogin();
		}
		if(tmp == formMain.btnSchedule)
		{
			formMain.changeToFindTrip();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
	
		if(e.getComponent() == formMain.bookingTicket2Panel.lblBack )
		{
			formMain.changeToBooking();
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
