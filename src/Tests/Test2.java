package Tests;

import java.sql.Date;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import DAO.DAOBus;
import DAO.DAOCity;
import DAO.DAOCustomer;
import DAO.DAORoute;
import DAO.DAOTrip;
import Models.Bus;
import Models.City;
import Models.Customer;
import Models.myDate;
import view.Login.FormLogin;

public class Test2 {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		LocalTime time = LocalTime.parse("07:12", DateTimeFormatter.ofPattern("HH:mm"));
		System.out.println(time.format(DateTimeFormatter.ofPattern("HH:mm")));
	}
}
