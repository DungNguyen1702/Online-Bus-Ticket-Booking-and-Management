package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.admin.AdminForm;

public class FormAdminListener implements ActionListener {
	private AdminForm adminForm;

	public FormAdminListener(AdminForm adminForm) {
		super();
		this.adminForm = adminForm;
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		if (tmp == adminForm.getBtnRoute()) {
			adminForm.PnRouteAdSelected();
		} else if (tmp == adminForm.getBtnTripInDay()) {
			adminForm.PnTripSelected();
		} else if (tmp == adminForm.getBtnUser()) {
			adminForm.PnUserADSelected();
		} else if (tmp == adminForm.getBtnBill()) {
			adminForm.PnBillAdSelected();
		} else if (tmp == adminForm.getBtnSignOut()) {
			adminForm.SignOut();
		}
		if(tmp == adminForm.menuQuanLy)
		{
			adminForm.Management_Select();
		}
		if(tmp == adminForm.menuThongKe)
		{
			adminForm.Statistic_Select();
		}
		if(tmp == adminForm.btnLogOut_2)
		{
			adminForm.SignOut();
		}
		if(tmp == adminForm.btnStatisticByMonth)
		{
			adminForm.btnStatisticByMonth_Selected();
		}
		if(tmp == adminForm.btnStatisticByYear)
		{
			adminForm.btnStatisticByYear_Selected();
		}
		if(tmp == adminForm.btnStatisticAll)
		{
			adminForm.btnStatisticAll_Select();
		}
	}
}
