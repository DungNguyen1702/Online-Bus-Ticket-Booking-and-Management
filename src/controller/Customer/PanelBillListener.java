package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Customer.FormBillDetail;
import view.Customer.PanelBill;

public class PanelBillListener implements ActionListener{
	
	PanelBill PB;
	
	public PanelBillListener(PanelBill PB) {
		this.PB = PB;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == PB.btn_Select)
		{
			new FormBillDetail(PB.bl, PB.listTicket);
		}
	}

}
