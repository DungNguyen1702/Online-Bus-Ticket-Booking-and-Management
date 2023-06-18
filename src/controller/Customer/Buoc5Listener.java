package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Customer.PanelCamOn_B5;

public class Buoc5Listener implements ActionListener{

	PanelCamOn_B5 B5;
	
	public Buoc5Listener(PanelCamOn_B5 b5) {
		this.B5 = b5;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getActionCommand().equals("Thoát"))
		{
			B5.fbt.KetThucBuoc5();
		}
	}

}
