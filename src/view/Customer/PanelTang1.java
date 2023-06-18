package view.Customer;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;

import Models.Ticket;
import controller.Customer.BookTicketTang1Listener;

public class PanelTang1 extends JPanel {

	public JPanel pnG1, pnG2, pnG3, pnG4, pnG5, pnG6, pnG7, pnG8, pnG9, pnG10, pnG11, pnG12, pnG13, pnG14, pnG15, pnG16, pnG17, pnG18; 
	public PanelSitting PS;
	/**
	 * Create the panel.
	 */
	public PanelTang1(PanelSitting PS) {
		this.PS = PS;
		this.GUI();
		MakeBusySeat();
		MakeSelectedSeat();
	}
	
	public void MakeBusySeat()
	{
		for(Ticket item : PS.BusyTickets)
		{
			if(item.getSeatNumber().equals("G01"))
			{
				this.BusySeat(pnG1);
			}
			else if(item.getSeatNumber().equals("G02"))
			{
				this.BusySeat(pnG2);
			}
			else if(item.getSeatNumber().equals("G03"))
			{
				this.BusySeat(pnG3);
			}
			else if(item.getSeatNumber().equals("G04"))
			{
				this.BusySeat(pnG4);
			}
			else if(item.getSeatNumber().equals("G05"))
			{
				this.BusySeat(pnG5);
			}
			else if(item.getSeatNumber().equals("G06"))
			{
				this.BusySeat(pnG6);
			}
			else if(item.getSeatNumber().equals("G07"))
			{
				this.BusySeat(pnG7);
			}
			else if(item.getSeatNumber().equals("G08"))
			{
				this.BusySeat(pnG8);
			}
			else if(item.getSeatNumber().equals("G09"))
			{
				this.BusySeat(pnG9);
			}
			else if(item.getSeatNumber().equals("G10"))
			{
				this.BusySeat(pnG10);
			}
			else if(item.getSeatNumber().equals("G11"))
			{
				this.BusySeat(pnG11);
			}
			else if(item.getSeatNumber().equals("G12"))
			{
				this.BusySeat(pnG12);
			}
			else if(item.getSeatNumber().equals("G13"))
			{
				this.BusySeat(pnG13);
			}
			else if(item.getSeatNumber().equals("G14"))
			{
				this.BusySeat(pnG14);
			}
			else if(item.getSeatNumber().equals("G15"))
			{
				this.BusySeat(pnG15);
			}
			else if(item.getSeatNumber().equals("G16"))
			{
				this.BusySeat(pnG16);
			}
			else if(item.getSeatNumber().equals("G17"))
			{
				this.BusySeat(pnG17);
			}
			else if(item.getSeatNumber().equals("G18"))
			{
				this.BusySeat(pnG18);
			}
		}
	}
	
	public void MakeSelectedSeat()
	{
		for(Ticket item : PS.SelectedTicket)
		{
			if(item.getSeatNumber().equals("G01"))
			{
				this.SelectedSeat(pnG1);
			}
			else if(item.getSeatNumber().equals("G02"))
			{
				this.SelectedSeat(pnG2);
			}
			else if(item.getSeatNumber().equals("G03"))
			{
				this.SelectedSeat(pnG3);
			}
			else if(item.getSeatNumber().equals("G04"))
			{
				this.SelectedSeat(pnG4);
			}
			else if(item.getSeatNumber().equals("G05"))
			{
				this.SelectedSeat(pnG5);
			}
			else if(item.getSeatNumber().equals("G06"))
			{
				this.SelectedSeat(pnG6);
			}
			else if(item.getSeatNumber().equals("G07"))
			{
				this.SelectedSeat(pnG7);
			}
			else if(item.getSeatNumber().equals("G08"))
			{
				this.SelectedSeat(pnG8);
			}
			else if(item.getSeatNumber().equals("G09"))
			{
				this.SelectedSeat(pnG9);
			}
			else if(item.getSeatNumber().equals("G10"))
			{
				this.SelectedSeat(pnG10);
			}
			else if(item.getSeatNumber().equals("G11"))
			{
				this.SelectedSeat(pnG11);
			}
			else if(item.getSeatNumber().equals("G12"))
			{
				this.SelectedSeat(pnG12);
			}
			else if(item.getSeatNumber().equals("G13"))
			{
				this.SelectedSeat(pnG13);
			}
			else if(item.getSeatNumber().equals("G14"))
			{
				this.SelectedSeat(pnG14);
			}
			else if(item.getSeatNumber().equals("G15"))
			{
				this.SelectedSeat(pnG15);
			}
			else if(item.getSeatNumber().equals("G16"))
			{
				this.SelectedSeat(pnG16);
			}
			else if(item.getSeatNumber().equals("G17"))
			{
				this.SelectedSeat(pnG17);
			}
			else if(item.getSeatNumber().equals("G18"))
			{
				this.SelectedSeat(pnG18);
			}
		}
	}
	
	public void GUI()
	{
		this.setBounds(29, 39, 257, 318);
		this.setBackground(new Color(255, 255, 128));
		this.setBounds(29, 39, 257, 318);
		this.setLayout(null);
		
		pnG1 = new JPanel();
		pnG1.setBackground(new Color(128, 255, 255));
		pnG1.setBounds(22, 23, 34, 26);
		this.add(pnG1);
		
		JLabel lblG1 = new JLabel("G01");
		lblG1.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG1.add(lblG1);
		
		pnG2 = new JPanel();
		pnG2.setBackground(new Color(128, 255, 255));
		pnG2.setBounds(22, 72, 34, 26);
		this.add(pnG2);
		
		JLabel lblG2 = new JLabel("G02");
		lblG2.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG2.add(lblG2);
		
		pnG3 = new JPanel();
		pnG3.setBackground(new Color(128, 255, 255));
		pnG3.setBounds(22, 121, 34, 26);
		this.add(pnG3);
		
		JLabel lblG3 = new JLabel("G03");
		lblG3.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG3.add(lblG3);
		
		pnG4 = new JPanel();
		pnG4.setBackground(new Color(128, 255, 255));
		pnG4.setBounds(22, 170, 34, 26);
		this.add(pnG4);
		
		JLabel lblG4 = new JLabel("G04");
		lblG4.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG4.add(lblG4);
		
		pnG5 = new JPanel();
		pnG5.setBackground(new Color(128, 255, 255));
		pnG5.setBounds(22, 219, 34, 26);
		this.add(pnG5);
		
		JLabel lblG5 = new JLabel("G05");
		lblG5.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG5.add(lblG5);
		
		pnG6 = new JPanel();
		pnG6.setBackground(new Color(128, 255, 255));
		pnG6.setBounds(22, 268, 34, 26);
		this.add(pnG6);
		
		JLabel lblG6 = new JLabel("G06");
		lblG6.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG6.add(lblG6);
		
		pnG7 = new JPanel();
		pnG7.setBackground(new Color(128, 255, 255));
		pnG7.setBounds(111, 23, 34, 26);
		this.add(pnG7);
		
		JLabel lblG7 = new JLabel("G07");
		lblG7.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG7.add(lblG7);
		
		pnG8 = new JPanel();
		pnG8.setBackground(new Color(128, 255, 255));
		pnG8.setBounds(111, 72, 34, 26);
		this.add(pnG8);
		
		JLabel lblG8 = new JLabel("G08");
		lblG8.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG8.add(lblG8);
		
		pnG9 = new JPanel();
		pnG9.setBackground(new Color(128, 255, 255));
		pnG9.setBounds(111, 121, 34, 26);
		this.add(pnG9);
		
		JLabel lblG9 = new JLabel("G09");
		lblG9.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG9.add(lblG9);
		
		pnG10 = new JPanel();
		pnG10.setBackground(new Color(128, 255, 255));
		pnG10.setBounds(111, 170, 34, 26);
		this.add(pnG10);
		
		JLabel lblG10 = new JLabel("G10");
		lblG10.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG10.add(lblG10);
		
		pnG11 = new JPanel();
		pnG11.setBackground(new Color(128, 255, 255));
		pnG11.setBounds(111, 219, 34, 26);
		this.add(pnG11);
		
		JLabel lblG11 = new JLabel("G11");
		lblG11.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG11.add(lblG11);
		
		pnG12 = new JPanel();
		pnG12.setBackground(new Color(128, 255, 255));
		pnG12.setBounds(111, 268, 34, 26);
		this.add(pnG12);
		
		JLabel lblG12 = new JLabel("G12");
		lblG12.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG12.add(lblG12);
		
		pnG13 = new JPanel();
		pnG13.setBackground(new Color(128, 255, 255));
		pnG13.setBounds(194, 23, 34, 26);
		this.add(pnG13);
		
		JLabel lblG13 = new JLabel("G13");
		lblG13.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG13.add(lblG13);
		
		pnG14 = new JPanel();
		pnG14.setBackground(new Color(128, 255, 255));
		pnG14.setBounds(194, 72, 34, 26);
		this.add(pnG14);
		
		JLabel lblG14 = new JLabel("G14");
		lblG14.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG14.add(lblG14);
		
		pnG15 = new JPanel();
		pnG15.setBackground(new Color(128, 255, 255));
		pnG15.setBounds(194, 121, 34, 26);
		this.add(pnG15);
		
		JLabel lblG15 = new JLabel("G15");
		lblG15.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG15.add(lblG15);
		
		pnG16 = new JPanel();
		pnG16.setBackground(new Color(128, 255, 255));
		pnG16.setBounds(194, 170, 34, 26);
		this.add(pnG16);
		
		JLabel lblG16 = new JLabel("G16");
		lblG16.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG16.add(lblG16);
		
		pnG17 = new JPanel();
		pnG17.setBackground(new Color(128, 255, 255));
		pnG17.setBounds(194, 219, 34, 26);
		this.add(pnG17);
		
		JLabel lblG17 = new JLabel("G17");
		lblG17.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG17.add(lblG17);
		
		pnG18 = new JPanel();
		pnG18.setBackground(new Color(128, 255, 255));
		pnG18.setBounds(194, 268, 34, 26);
		this.add(pnG18);
		
		JLabel lblG18 = new JLabel("G18");
		lblG18.setFont(new Font("Tahoma", Font.PLAIN, 13));
		pnG18.add(lblG18);
		
		MouseListener ml = new BookTicketTang1Listener(this);
		
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
		pnG11.addMouseListener(ml);
		pnG12.addMouseListener(ml);
		pnG13.addMouseListener(ml);
		pnG14.addMouseListener(ml);
		pnG15.addMouseListener(ml);
		pnG16.addMouseListener(ml);
		pnG17.addMouseListener(ml);
		pnG18.addMouseListener(ml);
		
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
			PS.AddToSelectedList("G01");
		}
		else	
			if (pnG1.getBackground().getRGB() == g.getRGB()) {
				pnG1.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G01");
			}
	}
	public void ChooseSPG02( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG2.getBackground().getRGB() == b.getRGB()) {
			pnG2.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G02");
		}
		else	
			if (pnG2.getBackground().getRGB() == g.getRGB()) {
				pnG2.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G02");
			}
			
	}
	public void ChooseSPG03( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG3.getBackground().getRGB() == b.getRGB()) {
			pnG3.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G03");
		}
		else	
			if (pnG3.getBackground().getRGB() == g.getRGB()) {
				pnG3.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G03");
			}
			
	}
	public void ChooseSPG04( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG4.getBackground().getRGB() == b.getRGB()) {
			pnG4.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G04");
		}
		else	
			if (pnG4.getBackground().getRGB() == g.getRGB()) {
				pnG4.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G04");
			}
			
	}
	public void ChooseSPG05( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG5.getBackground().getRGB() == b.getRGB()) {
			pnG5.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G05");
		}
		else	
			if (pnG5.getBackground().getRGB() == g.getRGB()) {
				pnG5.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G05");
			}
			
	}
	public void ChooseSPG06( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG6.getBackground().getRGB() == b.getRGB()) {
			pnG6.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G06");
		}
		else	
			if (pnG6.getBackground().getRGB() == g.getRGB()) {
				pnG6.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G06");
			}
			
	}
	public void ChooseSPG07( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG7.getBackground().getRGB() == b.getRGB()) {
			pnG7.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G07");
		}
		else	
			if (pnG7.getBackground().getRGB() == g.getRGB()) {
				pnG7.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G07");
			}
			
	}
	public void ChooseSPG08( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG8.getBackground().getRGB() == b.getRGB()) {
			pnG8.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G08");
		}
		else	
			if (pnG8.getBackground().getRGB() == g.getRGB()) {
				pnG8.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G08");
			}
			
	}
	public void ChooseSPG09( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG9.getBackground().getRGB() == b.getRGB()) {
			pnG9.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G09");
		}
		else	
			if (pnG9.getBackground().getRGB() == g.getRGB()) {
				pnG9.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G09");
			}
			
	}
	public void ChooseSPG10( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG10.getBackground().getRGB() == b.getRGB()) {
			pnG10.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G10");
		}
		else	
			if (pnG10.getBackground().getRGB() == g.getRGB()) {
				pnG10.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G10");
			}
			
	}
	public void ChooseSPG11( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG11.getBackground().getRGB() == b.getRGB()) {
			pnG11.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G11");
		}
		else	
			if (pnG11.getBackground().getRGB() == g.getRGB()) {
				pnG11.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G11");
			}
			
	}
	public void ChooseSPG12( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG12.getBackground().getRGB() == b.getRGB()) {
			pnG12.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G12");
		}
		else	
			if (pnG12.getBackground().getRGB() == g.getRGB()) {
				pnG12.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G12");
			}
			
	}
	public void ChooseSPG13( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG13.getBackground().getRGB() == b.getRGB()) {
			pnG13.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G13");
		}
		else	
			if (pnG13.getBackground().getRGB() == g.getRGB()) {
				pnG13.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G13");
			}
			
	}
	public void ChooseSPG14( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG14.getBackground().getRGB() == b.getRGB()) {
			pnG14.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G14");
		}
		else	
			if (pnG14.getBackground().getRGB() == g.getRGB()) {
				pnG14.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G14");
			}
			
	}
	public void ChooseSPG15( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG15.getBackground().getRGB() == b.getRGB()) {
			pnG15.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G15");
		}
		else	
			if (pnG15.getBackground().getRGB() == g.getRGB()) {
				pnG15.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G15");
			}
			
	}
	public void ChooseSPG16( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG16.getBackground().getRGB() == b.getRGB()) {
			pnG16.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G16");
		}
		else	
			if (pnG16.getBackground().getRGB() == g.getRGB()) {
				pnG16.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G16");
			}
			
	}
	public void ChooseSPG17( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG17.getBackground().getRGB() == b.getRGB()) {
			pnG17.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G17");
		}
		else	
			if (pnG17.getBackground().getRGB() == g.getRGB()) {
				pnG17.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G17");
			}
			
	}
	public void ChooseSPG18( ) {
		Color b = new Color(128, 255, 255);
		Color g = new Color(0,255,0);
		//Color r = new Color(255,128,128);
		if (pnG18.getBackground().getRGB() == b.getRGB()) {
			pnG18.setBackground(g);
			PS.IncTextNum();
			PS.AddToSelectedList("G18");
		}
		else	
			if (pnG18.getBackground().getRGB() == g.getRGB()) {
				pnG18.setBackground(b);
				PS.DecTextNum();
				PS.RemoveFromSelectedList("G18");
			}
	}

}
