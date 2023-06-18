package controller.admin;

import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.sql.SQLException;

import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.plaf.basic.BasicInternalFrameTitlePane.TitlePaneLayout;

import view.admin.PanelUserAd;

public class UserListener implements ActionListener, ListSelectionListener, MouseListener{

	private PanelUserAd panelUserAd;
	public UserListener(PanelUserAd panelUserAd) {
		super();
		this.panelUserAd = panelUserAd;
	}

	@Override
	public void valueChanged(ListSelectionEvent e) {
		// TODO Auto-generated method stub
		if (! e.getValueIsAdjusting()) {
			int indexRow = panelUserAd.getTable().getSelectedRow();
			if(indexRow == -1) return;
			panelUserAd.SetTextInfor(indexRow);
		}
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		String t = e.getActionCommand();
		if (t.equals("Thêm")) {
			panelUserAd.PressAdd();
		} else
		if (tmp == panelUserAd.getBtnAdd()) {
			if (t.equals("Lưu")) {
				try {
					panelUserAd.PressSaveAdd();
				} catch (HeadlessException | SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			}
		} else
		if (tmp == panelUserAd.getBtnCancel()) {
			panelUserAd.PressCancel();
		} else
		if (tmp == panelUserAd.getBtnDelete()) {
			panelUserAd.PressDelete();
		} else
		if (t.equals("Sửa")) {
			panelUserAd.PressUpdate();
		} else
		if (tmp == panelUserAd.getBtnUpdate()) {
			if (t.equals("Lưu")) {
				panelUserAd.PressSaveUpdate();
			}
		} else
		if (tmp == panelUserAd.getBtnReset()) {
			panelUserAd.PressReset();
		}
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		if (e.getComponent() == panelUserAd.getLblSearch()) {
			panelUserAd.PressSearch();
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
