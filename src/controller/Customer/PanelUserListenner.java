package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import DAO.DAOCustomer;
import view.Customer.PanelUser;

public class PanelUserListenner implements ActionListener {
	
	PanelUser panelUser;
	DAO.DAOCustomer customer = DAO.DAOCustomer.getInstance();
	
	public PanelUserListenner(PanelUser panelUser) {
		this.panelUser = panelUser;
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		Object tmp = e.getSource();
		if (tmp == panelUser.btnUpdate) {
			panelUser.btnUpdate_Selected();
		}
		else if(tmp == panelUser.btnDoiMK)
		{
			panelUser.btn_DoiMK_Selected();
		}
		else if(tmp == panelUser.btnLuu)
		{
			if(panelUser.check.equals("UI"))
			{
				if(!panelUser.checkUpdateInfo())
				{
					return;
				}
			}
			if(panelUser.check.equals("UP"))
			{
				if(!panelUser.checkUpdatePassword())
				{
					return;
				}
			}
			panelUser.btn_Luu_Selected();
		}
		else if(tmp == panelUser.btnCancel)
		{
			panelUser.btn_Cancel_Selected();
		}
	}

}
