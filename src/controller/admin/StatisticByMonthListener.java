package controller.admin;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import view.admin.PanelStatisticByMonth;

public class StatisticByMonthListener implements ActionListener{
	PanelStatisticByMonth gd;
	
	public StatisticByMonthListener(PanelStatisticByMonth gd) {
		this.gd = gd;
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource() == gd.cbMonth)
		{
			try {
				gd.cbMonth_Pick();
			} catch (ClassNotFoundException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
		if(e.getSource() == gd.cbTop)
		{
			try {
				gd.cbTop_Pick();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
		}
	}
}
