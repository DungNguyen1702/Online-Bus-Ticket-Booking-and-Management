package Tests;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import Algorithm.floydWarshall2;
import DAO.DAOBus;
import DAO.DAOCity;
import DAO.DAORoute;
import DAO.DAOTicket;
import DAO.DAOTrip;
import Models.Bus;
import Models.City;
import Models.Route;
import Models.Trip;

public class Test3 {
	
	public void changeString(String r)
	{
	
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Trip> listT = DAOTrip.getInstance().getListByRouteAndDate("City007", "City030", LocalDate.of(2023, 04, 22));
		for(Trip item : listT)
		{
			System.out.println(item);
		}
	}
}
