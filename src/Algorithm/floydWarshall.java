package Algorithm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOCity;
import DAO.DAORoute;
import Models.City;
import Models.Route;


public class floydWarshall {
	
	public static floydWarshall getInstance()
	{
		return new floydWarshall();
	}
	
	public void printPath(int P[][], int i, int j, List<Route> ListR) throws SQLException {
	    if (P[i][j] == -1) {
	    	
//	    	System.out.print(i + " ");
//	        if (i != j) {
//	        	System.out.print(j + " ");
//	        }
	        
	        String IDStart = City.getInstance().changeIDFromIntToString(i+1);
	        String IDEnd = City.getInstance().changeIDFromIntToString(j+1);
	        
//	        System.out.println(DAORoute.getInstance().getRouteByCityStart_End(IDStart, IDEnd));
	        
	        ListR.add(DAORoute.getInstance().getRouteByCityStart_End(IDStart, IDEnd));
	        
	        return;
	    }
	    printPath(P, i, P[i][j], ListR);
	    printPath(P, P[i][j], j, ListR);
	    
	}

	public void floydWarshall(int w[][], int P[][], int totalNode, int firstNode, int lastNode, List<Route> ListR) throws SQLException {
	    // khởi tạo ma trận P với giá trị -1
	    for (int i = 0; i < totalNode; i++) {
	        for (int j = 0; j < totalNode; j++) {
	            P[i][j] = -1;
	        }
	    }
	    
	    // thực hiện thuật toán Floyd-Warshall
	    for (int k = 0; k < totalNode; k++) {
	        for (int i = 0; i < totalNode; i++) {
	            for (int j = 0; j < totalNode; j++) {
	                if (w[i][k] != Integer.MAX_VALUE && w[k][j] != Integer.MAX_VALUE && w[i][j] > w[i][k] + w[k][j]) {
	                    w[i][j] = w[i][k] + w[k][j];
	                    P[i][j] = k;
	                }
	            }
	        }
	    }
	    
	    // in ra đường đi ngắn nhất từ mỗi đỉnh đến tất cả các đỉnh còn lại
//	    for (int i = 0; i < totalNode; i++) {
//	        for (int j = 0; j < totalNode; j++) {
//	            if (i != j) {
//	            	List<Route> temp = new ArrayList<>();
//	                System.out.println("Đường đi từ " + i + " đến " + j + ": ");
//	                printPath(P, i, j, temp);
//	                System.out.println();
//	            }
//	        }
//	    }
	    
	    printPath(P, firstNode, lastNode, ListR);
	    
//	    for(Route item : ListR)
//	    {
//	    	System.out.println(item.toString());
//	    }
	}
	
	public List<Route> distance(String CityIDStart, String CityIDEnd) throws ClassNotFoundException, SQLException
	{
		List<City> list_City = DAOCity.getInstance().selectAll();
		List<Route> list_Route = DAORoute.getInstance().selectAll();
		int totalNode = list_City.size();
		int firstNode = City.getInstance().changeIDFromStringToInt(CityIDStart) - 1;
		int lastNode = City.getInstance().changeIDFromStringToInt(CityIDEnd) - 1;
		
		// SET Ma Tran Ban Dau
		int w[][] = new int [totalNode][totalNode];
		int P[][] = new int [totalNode][totalNode];
		for ( int i = 0; i < totalNode; i++) {
			for (int j = 0; j < totalNode; j++) {
				w[i][j] = Integer.MAX_VALUE;
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

		List<Route> list = new ArrayList<>();
		floydWarshall(w,P,totalNode, firstNode, lastNode, list);
		
		return list;
	}

	public List<Route> price(String CityIDStart, String CityIDEnd) throws ClassNotFoundException, SQLException
	{
		List<City> list_City = DAOCity.getInstance().selectAll();
		List<Route> list_Route = DAORoute.getInstance().selectAll();
		int totalNode = list_City.size();
		int firstNode = City.getInstance().changeIDFromStringToInt(CityIDStart) - 1;
		int lastNode = City.getInstance().changeIDFromStringToInt(CityIDEnd) - 1;
		
		// SET Ma Tran Ban Dau
		int w[][] = new int [totalNode][totalNode];
		int P[][] = new int [totalNode][totalNode];
		for ( int i = 0; i < totalNode; i++) {
			for (int j = 0; j < totalNode; j++) {
				w[i][j] = Integer.MAX_VALUE;
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

		List<Route> list = new ArrayList<>();
		floydWarshall(w,P,totalNode, firstNode, lastNode, list);
		
		return list;
	}
	
	public List<Route> duration(String CityIDStart, String CityIDEnd) throws ClassNotFoundException, SQLException
	{
		List<City> list_City = DAOCity.getInstance().selectAll();
		List<Route> list_Route = DAORoute.getInstance().selectAll();
		int totalNode = list_City.size();
		int firstNode = City.getInstance().changeIDFromStringToInt(CityIDStart) - 1;
		int lastNode = City.getInstance().changeIDFromStringToInt(CityIDEnd) - 1;
		
		// SET Ma Tran Ban Dau
		int w[][] = new int [totalNode][totalNode];
		int P[][] = new int [totalNode][totalNode];
		for ( int i = 0; i < totalNode; i++) {
			for (int j = 0; j < totalNode; j++) {
				w[i][j] = Integer.MAX_VALUE;
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

		List<Route> list = new ArrayList<>();
		floydWarshall(w,P,totalNode, firstNode, lastNode, list);
		
		return list;
	}
	
	public String getMap(List<Route> list) throws SQLException
	{
		String CityName = DAOCity.getInstance().getNameCityByID(list.get(0).getCityIDStart());
		String result = CityName ;
		if(list.get(0).getDistance() == 0) return "Không có đường đi thích hợp";
		for(Route item : list)
		{
			CityName = DAOCity.getInstance().getNameCityByID(item.getCityIDEnd());
			result += " -> ";
			result += CityName;
		}
		return result;
	}

	public int getTotalDistance(List<Route> list)
	{
		int Total = 0;
		for(Route item : list)
		{
			Total += item.getDistance();
		}
		return Total;
	}
	
	public int getTotalPrice(List<Route> list)
	{
		int Total = 0;
		for(Route item : list)
		{
			Total += item.getPrice();
		}
		return Total;
	}
	
	public int getTotalDuration(List<Route> list)
	{
		int Total = 0;
		for(Route item : list)
		{
			Total += item.getDuration().getHours();
		}
		return Total;
	}
}
