package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import view.Customer.PanelThanhToanBangNganHang;

public class Buoc4AListener implements ActionListener{
	PanelThanhToanBangNganHang TTBNH;
	
	public Buoc4AListener(PanelThanhToanBangNganHang TTBNH) {
		this.TTBNH = TTBNH;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == TTBNH.btn_XacNhan)
		{
			TTBNH.fbt.Sang5();
		}
		else if(e.getSource() == TTBNH.btnQuayLai)
		{
			TTBNH.fbt.Buoc4ALui4();
		}
	}
}
