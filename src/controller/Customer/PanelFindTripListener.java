package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.Customer.PanelFindTrip;

public class PanelFindTripListener implements ActionListener, ListSelectionListener, MouseListener{

	PanelFindTrip gd;
	
	public PanelFindTripListener(PanelFindTrip gd) {
		this.gd = gd;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getSource() == gd.lblFind)
		{
			try {
				gd.lblFind_Select();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == gd.lblReset)
		{
			try {
				gd.ResetTable();
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

	@Override
	public void valueChanged(ListSelectionEvent e) {
		if(e.getSource() == gd.table.getSelectionModel())
		{
			int row = gd.table.getSelectedRow();
			if(row == -1) return;
			Object[] data = new Object[gd.table.getColumnCount()];
			for(int i = 0 ;i<gd.table.getColumnCount();i++)
			{
				data[i] = gd.table.getValueAt(row, i);
			}
			
			gd.RowTable_Select(data);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gd.btnBooking)
		{
			try {
				gd.btnBooking_Select();
			} catch (ClassNotFoundException | SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}

}
