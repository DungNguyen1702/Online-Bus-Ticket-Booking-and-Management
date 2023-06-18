package controller.LogIn;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
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
import view.admin.AdminForm;

public class FormLoginListenner implements ActionListener, MouseListener{
	
	private FormLogin formLogin;
	public FormLoginListenner(FormLogin f){
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
			
			
			if(account.equals(FormLogin.accountAdmin) && password.equals(FormLogin.passwordAdmin))
			{
				try {
					new AdminForm();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				formLogin.dispose();
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
			
			
			if (check == false){	
				JOptionPane.showMessageDialog(null, "Bạn đã nhập sai tài khoản hoặc mật khẩu mời bạn nhập lại");
				return;
			}
			
			
			FormMainPage formMain = new FormMainPage(formLogin.cus);
			formMain.userPanel.cus = formLogin.cus;
			formMain.userPanel.Init();
			
			formLogin.dispose();
		
		}
		
		if(tmp == formLogin.panelDangKi.btnCreate)
		{
			Boolean check = false;
			try {
				check = formLogin.panelDangKi.checkInfo();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(check == false)
			{
				return;
			}
			formLogin.btnCreate_Selected();
		}
		if(tmp == formLogin.panelQMK.btnFind)
		{
			Boolean check = false;
			try {
				check = formLogin.panelQMK.checkFindAccount();
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			if(check == false)
			{
				return ;
			}
			formLogin.btnFind_Selected();
		}
		if(tmp == formLogin.panelResetPassword.btnChangePassword)
		{
			Boolean check = false;
			check = formLogin.panelResetPassword.checkInput();
			if(check == false)
			{
				return;
			}
			formLogin.btnChangePassword_Selected();
		}
	}
	
	@Override
	public void mouseClicked(MouseEvent e) {
		if(e.getComponent() ==  formLogin.lblDangKi)
		{
			formLogin.lblDangKi_Selected();
		}
		if(e.getComponent() == formLogin.lblQuenMK)
		{
			formLogin.lblQuenMK_Selected();
		}
		if(e.getComponent() == formLogin.panelDangKi.lblBack)
		{
			formLogin.panelDangKiApanelQuenMK_lblBack_Selected();
		}
		if(e.getComponent() == formLogin.panelQMK.lblBack)
		{
			formLogin.panelDangKiApanelQuenMK_lblBack_Selected();
		}
		if(e.getComponent() == formLogin.panelResetPassword.lblBack)
		{
			formLogin.panelResetPassword_lblBack_Selected();
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
