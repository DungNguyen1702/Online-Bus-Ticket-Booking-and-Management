package Tests;

import java.sql.*;
import java.text.SimpleDateFormat;

import BUS.JDBCUtil;
import DAO.DAOBill;
import DAO.DAOCustomer;
import DAO.DAORoute;
import DAO.DAOTicket;
import DAO.DAOTrip;
import Models.Bill;
import Models.Customer;
import Models.Route;
import Models.Trip;
import Models.myDate;

public class Test4 {
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		DAOTrip.InsertTrip(5);
		DAOTrip.InsertTrip(6);
	}
}
