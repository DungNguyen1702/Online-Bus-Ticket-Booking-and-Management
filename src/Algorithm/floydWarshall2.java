package Algorithm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAORoute;
import Models.City;
import Models.Route;

public class floydWarshall2 {
	public void floydWarshall(int w[][],int P[][], int totalNode)
	{
		for ( int k = 0; k < totalNode; k++)
        {
            for ( int i = 0; i < totalNode; i++)
            {
                for (int j = 0; j < totalNode; j++)
                {
                    if ( w[i][j] > (w[i][k] + w[k][j])) 
                    {
                        w[i][j] = (w[i][k] + w[k][j]);
                        P[i][j] = k;    
                    }
                }
            }
        }
	}
	public Boolean ShowMap(int w[][],int P[][], int totalNode, int firstNode, int lastNode) throws SQLException
	{
		int tempFirst = firstNode;
		int k = P[firstNode-1][lastNode-1];
		// Phần kiểm tra có đường đi hay không
		while( k != lastNode -1)
		{
			if(k == 10000) return false;
			tempFirst = k+1;
			k = P[tempFirst-1][lastNode-1];
		}
		
		
		// Phần lấy ra đường đi 
//		k = P[firstNode-1][lastNode-1];
		int temp = w[firstNode-1][lastNode-1];		
//		System.out.println("Duong di ngan nhat tu "+ firstNode + "->"+lastNode);
//		int current = firstNode-1;
//	    String path = String.valueOf(firstNode);
//	    
//	    List<Route> list = new ArrayList<>();
//	    while (printShortestPath(current, P[current][lastNode-1], P, list) != lastNode-1) {
//	        current = P[current][lastNode-1];
//	        //path += " -> " + (current + 1);
//	    }
//	    System.out.println();
		System.out.println("Do dai cua duong di la: "+ temp);
		return true;
	}
	public int printShortestPath(int startNode, int endNode, int[][] P, List<Route> LR) throws SQLException {
	    int current = startNode;
	    String IDStart = "";
	    String IDEnd = "";
	    while (current != endNode) {
	        IDStart = City.getInstance().changeIDFromIntToString(current + 1);
	        IDEnd = City.getInstance().changeIDFromIntToString(P[current][endNode] + 1);
	        LR.add(DAORoute.getInstance().getRouteByCityStart_End(IDStart, IDEnd));
	    	current = P[current][endNode];
	    }
	    return current;
	}
}
