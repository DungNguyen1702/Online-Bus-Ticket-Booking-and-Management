package Algorithm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOCity;
import DAO.DAORoute;
import Models.City;
import Models.Route;

public class getMatrix2 {
	public String distance(String CityIDStart , String CityIDEnd, List<Route> listR) throws ClassNotFoundException, SQLException
	{
		List<City> list_City = DAOCity.getInstance().selectAll();
		List<Route> list_Route = DAORoute.getInstance().selectAll();
		int totalNode = list_City.size();
		int firstNode = City.getInstance().changeIDFromStringToInt(CityIDStart);
		int lastNode = City.getInstance().changeIDFromStringToInt(CityIDEnd);
		
		// SET Ma Tran Ban Dau
		int w[][] = new int [totalNode][totalNode];
		int P[][] = new int [totalNode][totalNode];
		for ( int i = 0; i < totalNode; i++) {
			for (int j = 0; j < totalNode; j++) {
				w[i][j] = 10000;
				P[i][j] = 10000;
			}
		}
		
		// Set He so cho Ma Tran
		for(int i = 0; i< list_Route.size(); i++)
		{
			int IDStart = Integer.parseInt(list_Route.get(i).getCityIDStart().substring(4, 7));
			int IDEnd = Integer.parseInt(list_Route.get(i).getCityIDEnd().substring(4, 7));
			
			w[IDStart-1][IDEnd-1] = list_Route.get(i).getDistance();
			P[IDStart-1][IDEnd-1] = IDEnd-1;
		}
		
		
		// Kiem tra ma tran
//		System.out.println();
//		System.out.println();
//		for(int i = 0 ;i < totalNode ;i++)
//		{
//			for(int j = 0 ;j < totalNode; j ++)
//			{
//				if(w[i][j] == 10000) System.out.print("0 ");
//				else System.out.print(w[i][j] + " ");
//			}
//			System.out.println();
//		}
		
		floydWarshall2 temp = new floydWarshall2();
		System.out.println();
		System.out.println();
		for(int i = 0 ;i < totalNode ;i++)
		{
			for(int j = 0 ;j < totalNode; j ++)
			{
				if(w[i][j] == 10000) System.out.print("0 ");
				else System.out.print(P[i][j] + " ");
			}
			System.out.println();
		}
		
		temp.floydWarshall(w, P, totalNode);
		
		Boolean check = temp.ShowMap(w, P, totalNode, firstNode, lastNode);
		
		if(check)
		{
			int current = firstNode - 1;
			String NameCity = DAOCity.getInstance().getNameCityByID(CityIDStart);
			String StringIDNext = "";
			String StringIDFirst;
			//System.out.println(P[22][16] + " " + w[22][16]);
			while (temp.printShortestPath(current, P[current][lastNode-1], P, listR) != lastNode-1) {
				current = P[current][lastNode-1];
			}
			
//			StringIDFirst = listR.get(listR.size() - 1).getCityIDEnd();
//			StringIDNext = CityIDEnd;
//			
//			listR.add(DAORoute.getInstance().getRouteByCityStart_End(StringIDFirst, StringIDNext));
//			
			NameCity = DAOCity.getInstance().getNameCityByID(CityIDStart);
			String result = NameCity ;
			for(Route item  : listR)
			{
				result += " -> ";
				result += DAOCity.getInstance().getNameCityByID(item.getCityIDEnd());
				System.out.println(result);
			}
			return result;
		}else
		{
			return "Không tìm thấy lộ trình hợp lệ";
		}
	}
	
	public void price() throws ClassNotFoundException, SQLException
	{
		List<City> list_City = DAOCity.getInstance().selectAll();
		List<Route> list_Route = DAORoute.getInstance().selectAll();
		int totalNode = list_City.size(), firstNode = 25, lastNode = 17;
		
		// SET Ma Tran Ban Dau
		int w[][] = new int [totalNode][totalNode];
		int P[][] = new int [totalNode][totalNode];
		for ( int i = 0; i < totalNode; i++) {
			for (int j = 0; j < totalNode; j++) {
				w[i][j] = 10000;
				P[i][j] = 10000;
			}
		}
		
		// Set He so cho Ma Tran
		for(int i = 0; i< list_Route.size(); i++)
		{
			int IDStart = Integer.parseInt(list_Route.get(i).getCityIDStart().substring(4, 7));
			int IDEnd = Integer.parseInt(list_Route.get(i).getCityIDEnd().substring(4, 7));
			
			w[IDStart-1][IDEnd-1] = list_Route.get(i).getPrice()/1000;
			P[IDStart-1][IDEnd-1] = IDEnd-1;
		}
		
		// Kiem tra ma tran
		System.out.println();
		System.out.println();
		for(int i = 0 ;i < totalNode ;i++)
		{
			for(int j = 0 ;j < totalNode; j ++)
			{
				if(w[i][j] == 10000) System.out.print("0 ");
				else System.out.print(w[i][j] + " ");
			}
			System.out.println();
		}
		
		floydWarshall2 temp = new floydWarshall2();
		temp.floydWarshall(w, P, totalNode);
		temp.ShowMap(w, P, totalNode, firstNode, lastNode);
	}
	
	public void duration() throws ClassNotFoundException, SQLException
	{
		List<City> list_City = DAOCity.getInstance().selectAll();
		List<Route> list_Route = DAORoute.getInstance().selectAll();
		int totalNode = list_City.size(), firstNode = 22, lastNode = 17;
		
		// SET Ma Tran Ban Dau
		int w[][] = new int [totalNode][totalNode];
		int P[][] = new int [totalNode][totalNode];
		for ( int i = 0; i < totalNode; i++) {
			for (int j = 0; j < totalNode; j++) {
				w[i][j] = 10000;
				P[i][j] = 10000;
			}
		}
		
		// Set He so cho Ma Tran
		for(int i = 0; i< list_Route.size(); i++)
		{
			int IDStart = Integer.parseInt(list_Route.get(i).getCityIDStart().substring(4, 7));
			int IDEnd = Integer.parseInt(list_Route.get(i).getCityIDEnd().substring(4, 7));
			
			w[IDStart-1][IDEnd-1] = list_Route.get(i).getDuration().getHours();
			P[IDStart-1][IDEnd-1] = IDEnd-1;
		}
		
		// Kiem tra ma tran
		System.out.println();
		System.out.println();
		for(int i = 0 ;i < totalNode ;i++)
		{
			for(int j = 0 ;j < totalNode; j ++)
			{
				if(w[i][j] == 10000) System.out.print("0 ");
				else System.out.print(w[i][j] + " ");
			}
			System.out.println();
		}
		
		floydWarshall2 temp = new floydWarshall2();
		temp.floydWarshall(w, P, totalNode);
		temp.ShowMap(w, P, totalNode, firstNode, lastNode);
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		getMatrix2 gm = new getMatrix2();
		
		// Hàm ShowMap trả về true nếu có đường còn nếu không có đường thì trả về false
		List<Route> listRoute = new ArrayList<>();
		System.out.println(gm.distance("City017", "City028", listRoute));
		//gm.distance("City023", "City017", listRoute);
		for(Route item : listRoute)
		{
			System.out.println(item.toString());
		}
		//gm.duration();
//		gm.price();
	}
}
