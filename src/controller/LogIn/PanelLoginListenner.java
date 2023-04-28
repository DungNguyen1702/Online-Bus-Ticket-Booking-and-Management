package controller.LogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.time.format.DateTimeFormatter;

import javax.swing.JOptionPane;

import DAO.DAOCustomer;
import Models.Customer;
import view.Customer.BookingTicket1;
import view.Customer.BookingTicket2;
import view.Customer.FormMainPage;
import view.Customer.PanelUser;
import view.Login.FormLogin;

public class PanelLoginListenner implements ActionListener{
	
	private FormLogin formLogin;
	public PanelLoginListenner(FormLogin f){
			this.formLogin = f;
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		Object tmp = e.getSource();
		if (tmp == formLogin.btnDangNhap) {
			
			String account  = formLogin.txtAccount.getText();
			String password = formLogin.txtPassword.getText();
			
			if(account.equals("") || password.equals(""))
			{
				JOptionPane.showMessageDialog(null, "Mời bạn nhập đầy đủ mật khẩu và tài khoản !!!");
				return;
			}
			
			formLogin.cus.setAccount(account);
			formLogin.cus.setPassword(password);
			
			boolean check = false;
			
			try {
				check = DAOCustomer.getInstance().checkInfoLogIn(formLogin.cus);
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			
			
			if (check) {

				((PanelUser)FormMainPage.userPanel).cus = formLogin.cus;
				
				((PanelUser)FormMainPage.userPanel).Init();;
				
				FormMainPage formMain = new FormMainPage(formLogin.cus);
//				formMain.userPanel = new PanelUser();
//				formMain.bookingTicket1Panel = new BookingTicket1();
//				formMain.bookingTicket2Panel = new BookingTicket2();
//				FormMainPage formMain = FormMainPage.FORM_MAIN_PAGE;
				formLogin.dispose();
			}
			else
			{
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tài khoản hoặc mật khẩu mời bạn nhập lại");
				return;
			}
		}
	}

}
