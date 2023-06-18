package controller.Customer;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.JOptionPane;

import view.Customer.PanelThanhToan_B4;

public class Buoc4Listener implements ActionListener, ItemListener {
	private PanelThanhToan_B4 B4;

	public Buoc4Listener(PanelThanhToan_B4 B4) {
		this.B4 = B4;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		Object tmp = e.getSource();
		if(tmp == B4.btn_DoiLai)
		{
			B4.fbt.Lui2();
			B4.fbt.BuocTruocDo = 4;
		}
		else if(tmp == B4.btn_XacNhan)
		{
			if(!B4.rdbtn_NganHang.isSelected() && !B4.rdbtn_TienMat.isSelected())
			{
				JOptionPane.showMessageDialog(null, "Vui lòng chọn phương thức thanh toán phù hợp");
				return;
			}
			if(B4.rdbtn_NganHang.isSelected())
			{
				
				B4.fbt.bl.setPaymentMethod("Ngân hàng");
				System.out.println(B4.fbt.bl.getKindOfBook());
				B4.fbt.Buoc4Sang4A();
			}
			else {
				B4.fbt.bl.setPaymentMethod("Tiền mặt");
				B4.fbt.Sang5();
			}
		}
		else if(tmp == B4.btn_QuayLai)
		{
			B4.fbt.Buoc4Lui3();
		}
		else if(B4.rdbtn_NganHang.isSelected())
		{

			B4.rdbtn_TienMat.setSelected(false);
		}
		else if(B4.rdbtn_TienMat.isSelected())
		{

			B4.rdbtn_NganHang.setSelected(false);
		}
	}
	@Override
	public void itemStateChanged(ItemEvent e) {

	}
	
}
