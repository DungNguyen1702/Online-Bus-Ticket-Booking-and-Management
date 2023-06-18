package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import org.w3c.dom.events.MouseEvent;

import view.admin.PanelStatisticAll;

public class StatisticAllListener implements ActionListener, MouseListener{
	PanelStatisticAll gd;
	
	public StatisticAllListener(PanelStatisticAll gd) {
		this.gd = gd;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gd.cbTop)
		{
			try {
				gd.cbTop_picked();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mouseClicked(java.awt.event.MouseEvent e) {
		if(e.getSource() == gd.lblReset)
		{
			try {
				gd.btnReset_Click();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
	@Override
	public void mousePressed(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseReleased(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseEntered(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void mouseExited(java.awt.event.MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
