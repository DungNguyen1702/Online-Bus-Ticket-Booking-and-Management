package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.admin.PanelTripInDay;

public class TripInDayListener implements ActionListener, ListSelectionListener, MouseListener, FocusListener{
	PanelTripInDay TID;
	
	public TripInDayListener(PanelTripInDay TID) {
		this.TID = TID;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == TID.cbRouteID)
		{
			TID.cbRouteID_Select();
		}
		if(e.getSource() == TID.btnFind)
		{
			TID.btnFind_Select();
		}
		if(e.getSource() == TID.btnAdd)
		{
			TID.btnAdd_Select();
		}
		if(e.getSource() == TID.btnDelete)
		{
			if(TID.btnDelete_Check() == false) return;
			TID.btnDelete_Select();
		}
		if(e.getSource() == TID.btnSave)
		{
			if(TID.btnSave_Check() == false) return;
			TID.btnSave_Select();
		}
		if(e.getSource() == TID.btnCancel)
		{
			TID.btnCancel_Select();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() == TID.lblSearch)
		{
			TID.lblFind_Select();
		}
		if(e.getComponent() == TID.lblReset)
		{
			TID.SetListTable();
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
		if(e.getSource() == TID.table.getSelectionModel())
		{
			int row = TID.table.getSelectedRow();
			if(row == -1) return;
			Object[] data = new Object[TID.table.getColumnCount()];
			for(int i = 0 ;i<TID.table.getColumnCount();i++)
			{
				data[i] = TID.table.getValueAt(row, i);
			}
			
			TID.RowTable_Select(data);
		}
	}

	@Override
	public void focusGained(FocusEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void focusLost(FocusEvent e) {
		if(e.getComponent() == TID.txtDateStart)
		{
			TID.txtDateStart_lostFocus();
		}
		if(e.getComponent() == TID.txtTimeStart)
		{
			TID.txtTimeStart_lostFocus();
		}
	}

}
