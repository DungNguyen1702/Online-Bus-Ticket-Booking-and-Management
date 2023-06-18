package view.Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Ticket;
import controller.Customer.BookTicketTang1GiuongListener;
import controller.Customer.BookTicketTang2GiuongListener;

public class PanelTang2Giuong extends JPanel {

	public JPanel pnG1, pnG2, pnG3, pnG4, pnG5, pnG6, pnG7, pnG8, pnG9, pnG10; 
	public PanelSitting PS;
	/**
	 * Create the panel.
	 */
	public PanelTang2Giuong(PanelSitting PS) {
		this.PS = PS;
		this.GUI();
		MakeBusySeat();
		MakeSelectedSeat();
	}
	
	public void GUI()
	{
		this.setBounds(0,0, 257, 318);
		this.setBackground(new Color(255, 255, 128));
		this.setBounds(29, 39, 257, 318);
		this.setLayout(null);
		
		pnG1 = new JPanel();
		pnG1.setBackground(new Color(128, 255, 255));
		pnG1.setBounds(22, 31, 34, 26);
		this.add(pnG1);
		
		JLabel lblG1 = new JLabel("G11");
		lblG1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG1.add(lblG1);
		
		pnG2 = new JPanel();
		pnG2.setBackground(new Color(128, 255, 255));
		pnG2.setBounds(22, 88, 34, 26);
		this.add(pnG2);
		
		JLabel lblG2 = new JLabel("G12");
		lblG2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG2.add(lblG2);
		
		pnG3 = new JPanel();
		pnG3.setBackground(new Color(128, 255, 255));
		pnG3.setBounds(22, 145, 34, 26);
		this.add(pnG3);
		
		JLabel lblG3 = new JLabel("G13");
		lblG3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG3.add(lblG3);
		
		pnG4 = new JPanel();
		pnG4.setBackground(new Color(128, 255, 255));
		pnG4.setBounds(22, 202, 34, 26);
		this.add(pnG4);
		
		JLabel lblG4 = new JLabel("G14");
		lblG4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG4.add(lblG4);
		
		pnG5 = new JPanel();
		pnG5.setBackground(new Color(128, 255, 255));
		pnG5.setBounds(22, 259, 34, 26);
		this.add(pnG5);
		
		JLabel lblG5 = new JLabel("G15");
		lblG5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG5.add(lblG5);
		
		pnG6 = new JPanel();
		pnG6.setBackground(new Color(128, 255, 255));
		pnG6.setBounds(196, 31, 34, 26);
		this.add(pnG6);
		
		JLabel lblG6 = new JLabel("G16");
		lblG6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG6.add(lblG6);
		
		pnG7 = new JPanel();
		pnG7.setBackground(new Color(128, 255, 255));
		pnG7.setBounds(196, 88, 34, 26);
		this.add(pnG7);
		
		JLabel lblG7 = new JLabel("G17");
		lblG7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG7.add(lblG7);
		
		pnG8 = new JPanel();
		pnG8.setBackground(new Color(128, 255, 255));
		pnG8.setBounds(196, 145, 34, 26);
		this.add(pnG8);
		
		JLabel lblG8 = new JLabel("G18");
		lblG8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG8.add(lblG8);
		
		pnG9 = new JPanel();
		pnG9.setBackground(new Color(128, 255, 255));
		pnG9.setBounds(196, 202, 34, 26);
		this.add(pnG9);
		
		JLabel lblG9 = new JLabel("G19");
		lblG9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG9.add(lblG9);
		
		pnG10 = new JPanel();
		pnG10.setBackground(new Color(128, 255, 255));
		pnG10.setBounds(196, 259, 34, 26);
		this.add(pnG10);
		
		JLabel lblG10 = new JLabel("G20");
		lblG10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG10.add(lblG10);
		
		MouseListener ml = new BookTicketTang2GiuongListener(this);
		
		pnG1.addMouseListener(ml);
		pnG2.addMouseListener(ml);
		pnG3.addMouseListener(ml);
		pnG4.addMouseListener(ml);
		pnG5.addMouseListener(ml);
		pnG6.addMouseListener(ml);
		pnG7.addMouseListener(ml);
		pnG8.addMouseListener(ml);
		pnG9.addMouseListener(ml);
		pnG10.addMouseListener(ml);

	}
	
	public void MakeBusySeat()
	{
		for(Ticket item : PS.BusyTickets)
		{
			if(item.getSeatNumber().equals("G11"))
			{
				this.BusySeat(pnG1);
			}
			else if(item.getSeatNumber().equals("G12"))
			{
				this.BusySeat(pnG2);
			}
			else if(item.getSeatNumber().equals("G13"))
			{
				this.BusySeat(pnG3);
			}
			else if(item.getSeatNumber().equals("G14"))
			{
				this.BusySeat(pnG4);
			}
			else if(item.getSeatNumber().equals("G15"))
			{
				this.BusySeat(pnG5);
			}
			else if(item.getSeatNumber().equals("G16"))
			{
				this.BusySeat(pnG6);
			}
			else if(item.getSeatNumber().equals("G17"))
			{
				this.BusySeat(pnG7);
			}
			else if(item.getSeatNumber().equals("G18"))
			{
				this.BusySeat(pnG8);
			}
			else if(item.getSeatNumber().equals("G19"))
			{
				this.BusySeat(pnG9);
			}
			else if(item.getSeatNumber().equals("G20"))
			{
				this.BusySeat(pnG10);
			}
		}
	}
	
	public void MakeSelectedSeat()
	{
		for(Ticket item : PS.SelectedTicket)
		{
			if(item.getSeatNumber().equals("G11"))
			{
				this.SelectedSeat(pnG1);
			}
			else if(item.getSeatNumber().equals("G12"))
			{
				this.SelectedSeat(pnG2);
			}
			else if(item.getSeatNumber().equals("G13"))
			{
				this.SelectedSeat(pnG3);
			}
			else if(item.getSeatNumber().equals("G14"))
			{
				this.SelectedSeat(pnG4);
			}
			else if(item.getSeatNumber().equals("G15"))
			{
				this.SelectedSeat(pnG5);
			}
			else if(item.getSeatNumber().equals("G16"))
			{
				this.SelectedSeat(pnG6);
			}
			else if(item.getSeatNumber().equals("G17"))
			{
				this.SelectedSeat(pnG7);
			}
			else if(item.getSeatNumber().equals("G18"))
			{
				this.SelectedSeat(pnG8);
			}
			else if(item.getSeatNumber().equals("G19"))
			{
				this.SelectedSeat(pnG9);
			}
			else if(item.getSeatNumber().equals("G20"))
			{
				this.SelectedSeat(pnG10);
			}
		}
	}
	
	public void BusySeat(JPanel p)
	{
		Color r = new Color(255,128,128);
		p.setBackground(r);
	}
	
	public void SelectedSeat(JPanel p)
	{
		Color g = new Color(0,255,0);
		p.setBackground(g);
	}
	
	public Boolean CheckBusySeat(JPanel p)
	{
		Color r = new Color(255,128,128);
		if(p.getBackground().getRGB() == r.getRGB())
		{
			return true;
		}
		return false;
	}

	public void ChooseSPG01( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG1.getBackground().getRGB() == b.getRGB()) {
			pnG1.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G11");
		}
		else	
			if (pnG1.getBackground().getRGB() == g.getRGB()) {
				pnG1.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G11");
			}
	}
	public void ChooseSPG02( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG2.getBackground().getRGB() == b.getRGB()) {
			pnG2.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G12");
		}
		else	
			if (pnG2.getBackground().getRGB() == g.getRGB()) {
				pnG2.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G12");
			}
			
	}
	public void ChooseSPG03( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG3.getBackground().getRGB() == b.getRGB()) {
			pnG3.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G13");
		}
		else	
			if (pnG3.getBackground().getRGB() == g.getRGB()) {
				pnG3.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G13");
			}
			
	}
	public void ChooseSPG04( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG4.getBackground().getRGB() == b.getRGB()) {
			pnG4.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G14");
		}
		else	
			if (pnG4.getBackground().getRGB() == g.getRGB()) {
				pnG4.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G14");
			}
			
	}
	public void ChooseSPG05( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG5.getBackground().getRGB() == b.getRGB()) {
			pnG5.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G15");
		}
		else	
			if (pnG5.getBackground().getRGB() == g.getRGB()) {
				pnG5.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G15");
			}
			
	}
	public void ChooseSPG06( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG6.getBackground().getRGB() == b.getRGB()) {
			pnG6.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G16");
		}
		else	
			if (pnG6.getBackground().getRGB() == g.getRGB()) {
				pnG6.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G16");
			}
			
	}
	public void ChooseSPG07( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG7.getBackground().getRGB() == b.getRGB()) {
			pnG7.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G17");
		}
		else	
			if (pnG7.getBackground().getRGB() == g.getRGB()) {
				pnG7.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G17");
			}
			
	}
	public void ChooseSPG08( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG8.getBackground().getRGB() == b.getRGB()) {
			pnG8.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G18");
		}
		else	
			if (pnG8.getBackground().getRGB() == g.getRGB()) {
				pnG8.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G18");
			}
			
	}
	public void ChooseSPG09( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG9.getBackground().getRGB() == b.getRGB()) {
			pnG9.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G19");
		}
		else	
			if (pnG9.getBackground().getRGB() == g.getRGB()) {
				pnG9.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G19");
			}
			
	}
	public void ChooseSPG10( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG10.getBackground().getRGB() == b.getRGB()) {
			pnG10.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G20");
		}
		else	
			if (pnG10.getBackground().getRGB() == g.getRGB()) {
				pnG10.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G20");
			}
			
	}

}
