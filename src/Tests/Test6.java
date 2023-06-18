package Tests;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import DAO.DAOCity;
import DAO.DAORoute;
import Models.City;
import Models.Route;

public class Test6 {
	public void printPath(int P[][], int i, int j, List<Route> ListR) throws SQLException {
	    if (P[i][j] == -1) {
	    	System.out.print(i + " ");
	        if (i != j) {
	        	System.out.print(j + " ");
	        }
	        
	        String IDStart = City.getInstance().changeIDFromIntToString(i+1);
	        String IDEnd = City.getInstance().changeIDFromIntToString(j+1);
	        System.out.println(DAORoute.getInstance().getRouteByCityStart_End(IDStart, IDEnd));
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
	    for (int i = 0; i < totalNode; i++) {
	        for (int j = 0; j < totalNode; j++) {
	            if (i != j) {
	            	List<Route> temp = new ArrayList<>();
	                System.out.println("Đường đi từ " + i + " đến " + j + ": ");
	                printPath(P, i, j, temp);
	                System.out.println();
	            }
	        }
	    }
	    
	    //printPath(P, firstNode, lastNode, ListR);
	    
//	    for(Route item : ListR)
//	    {
//	    	System.out.println(item.toString());
//	    }
	}
	
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
	} 
	
	
}
