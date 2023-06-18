package controller.Customer;


import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Customer.FormBillDetail;

public class FormBillDetailListener implements MouseListener{

	FormBillDetail fbd;
	
	public FormBillDetailListener(FormBillDetail fbd) {
		this.fbd = fbd;
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() == fbd.lblBack)
		{
			fbd.dispose();
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
