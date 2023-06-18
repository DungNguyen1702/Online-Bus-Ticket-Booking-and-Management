package Algorithm;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Models.Route;

public class Test {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		List<Route> list  = new ArrayList<>();
		floydWarshall al = new floydWarshall();
		list = al.distance("City017", "City027");
		System.out.println(al.getMap(list));
	}

}
