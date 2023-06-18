package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.admin.PanelBillAd;

public class BillListener implements ActionListener, ListSelectionListener, MouseListener{

	private PanelBillAd panelBillAd;
	public BillListener(PanelBillAd panelBillAd) {
		super();
		this.panelBillAd = panelBillAd;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (! e.getValueIsAdjusting()) {
			int indexRow = panelBillAd.getTable().getSelectedRow();
			if(indexRow == -1) return;
			panelBillAd.SetTextInfor(indexRow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		if (tmp == panelBillAd.getBtnAccept()) {
			panelBillAd.PressAccept();
		} else
		if (tmp == panelBillAd.getBtnRefuse()) {
			panelBillAd.PressRefuse();
		} else
		if (tmp == panelBillAd.getBtnReset()) {
			panelBillAd.PressReset();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == panelBillAd.getLblSearch()) {
			panelBillAd.PressSearch();
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
