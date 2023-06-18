package controller.Customer;

import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import view.Customer.PanelSitting;
import view.Customer.PanelTang1;
import view.Customer.PanelTang1Giuong;
import view.Customer.PanelTang2Giuong;

public class BookTicketTang2GiuongListener implements MouseListener {

	private PanelTang2Giuong pnSit;
	
	public BookTicketTang2GiuongListener(PanelTang2Giuong pnSit) {
		// TODO Auto-generated constructor stub
		this.pnSit = pnSit;
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
		Object temp = e.getSource();
		if (temp == pnSit.pnG1){
			pnSit.ChooseSPG01();
		} else if (temp == pnSit.pnG2){
			System.out.println(2);
			pnSit.ChooseSPG02();
		} else if (temp == pnSit.pnG3){
			pnSit.ChooseSPG03();
		} else if (temp == pnSit.pnG4){
			pnSit.ChooseSPG04();
		} else if (temp == pnSit.pnG5){
			pnSit.ChooseSPG05();
		} else if (temp == pnSit.pnG6){
			pnSit.ChooseSPG06();
		} else if (temp == pnSit.pnG7){
			pnSit.ChooseSPG07();
		} else if (temp == pnSit.pnG8){
			pnSit.ChooseSPG08();
		} else if (temp == pnSit.pnG9){
			pnSit.ChooseSPG09();
		} else if (temp == pnSit.pnG10){
			pnSit.ChooseSPG10();
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
