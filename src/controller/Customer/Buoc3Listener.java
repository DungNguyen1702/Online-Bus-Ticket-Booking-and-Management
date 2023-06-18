package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JOptionPane;

import view.Customer.PanelXacNhanThongTin_B3;

public class Buoc3Listener implements ActionListener{
	private PanelXacNhanThongTin_B3 B3;
	
	public Buoc3Listener(PanelXacNhanThongTin_B3 B3) {
		this.B3 = B3;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		Object temp  = e.getSource();
		if(temp == B3.btnConfirm)
		{
			if(B3.btnConfirm_Check() == false) return;
			
			if(B3.chkbx_XacNhan.isSelected()) {
				B3.OutputData();
				B3.fbt.Buoc3Sang4();
			}
			else
			{
				JOptionPane.showMessageDialog( null , "Hãy xác nhận lại những thông tin trên và tích vào ô xác nhận thông tin bên dưới !!");
				return;
			}
		}
		if(temp == B3.btnBack)
		{
			B3.OutputData();
			B3.fbt.Lui2();
			B3.fbt.BuocTruocDo = 3;
		}
	}
}
