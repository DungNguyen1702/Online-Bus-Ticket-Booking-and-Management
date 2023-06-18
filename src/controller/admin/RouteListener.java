
package controller.admin;

import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import view.admin.PanelRouteAd;

public class RouteListener implements ActionListener, ListSelectionListener, MouseListener{

	private PanelRouteAd pnRouteAd;
	public RouteListener(PanelRouteAd pnRouteAd) {
		super();
		this.pnRouteAd = pnRouteAd;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		String t = e.getActionCommand();
		if (t.equals("Thêm")) {
			pnRouteAd.PressAdd();
		} else
		if (tmp == pnRouteAd.getBtnCancel()) {
			pnRouteAd.PressCancel();
		} else
		if (tmp == pnRouteAd.getBtnAdd()) {
			if (t.equals("Lưu")) {
				pnRouteAd.PressSaveAdd();
			}
		} else
		if (tmp == pnRouteAd.getBtnDelete()) {
			pnRouteAd.PressDelete();	
		}
		if (t.equals("Sửa")) {
			pnRouteAd.PressUpdate();
		} else
		if (tmp == pnRouteAd.getBtnUpdate()) {
			if(t.equals("Lưu")) {
				pnRouteAd.PressSaveUpdate();
			}
		} else
		if (tmp == pnRouteAd.getBtnReset()) {
			pnRouteAd.PressReset();
		}
		
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (! e.getValueIsAdjusting()) {
			int indexRow = pnRouteAd.getTable().getSelectedRow();
			if(indexRow == -1) return;
			pnRouteAd.SetTextInFor(indexRow);
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == pnRouteAd.getLblSearch()) {
			pnRouteAd.PressSearch();
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