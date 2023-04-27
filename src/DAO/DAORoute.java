package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;
import Models.City;
import Models.Route;
import Models.Ticket;

public class DAORoute implements DAOInterface<Route>{

	private static DAORoute instance = new DAORoute();
	public static DAORoute getInstance()
	{
		return instance;
	}
	
	@Override
	public int insert(Route t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO RouteWay (RouteID, CityIDStart, CityIDEnd, Distance, Duration, BusID, BasePrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t.getRouteID());
		psm.setString(2, t.getCityIDStart());
		psm.setString(3, t.getCityIDEnd());
		psm.setString(4, t.getDistance() +"");
		psm.setTime(5, t.getDuration());
		psm.setString(6, t.getBusID());
		psm.setString(7, t.getPrice() + "");
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(Route t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM RouteWay WHERE RouteID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t.getRouteID());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(Route t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE RouteWay SET CityIDStart = ?, CityIDEnd = ?, Distance = ?, Duration = ?, BusID = ?, BasePrice = ? WHERE RouteID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(7, t.getRouteID());
		psm.setString(1, t.getCityIDStart());
		psm.setString(2, t.getCityIDEnd());
		psm.setString(3, t.getDistance() +"");
		psm.setTime(4, t.getDuration());
		psm.setString(5, t.getBusID());
		psm.setString(6, t.getPrice() + "");
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<Route> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Route> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM RouteWay";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			String RouteID = rs.getString("RouteID");
			String CityIDStart = rs.getString("CityIDStart");
			String CityIDEnd = rs.getString("CityIDEnd");
			int Distance = Integer.parseInt(rs.getString("Distance"));
			Time Duration = rs.getTime("Duration");
			String BusID = rs.getString("BusID");
			int Price = Integer.parseInt(rs.getString("BasePrice"));
			Route temp = new Route(RouteID, BusID, CityIDStart, CityIDEnd, Price, Duration, Distance);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
				
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Route>) list;
	}

	@Override
	public Route selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM RouteWay WHERE RouteID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, t);
		
		ResultSet rs = psm.executeQuery();
		
		Route result = new Route("","","","",0,new Time(0,0,0),0);
		
		while(rs.next())
		{
			String RouteID = rs.getString("RouteID");
			String CityIDStart = rs.getString("CityIDStart");
			String CityIDEnd = rs.getString("CityIDEnd");
			int Distance = Integer.parseInt(rs.getString("Distance"));
			Time Duration = rs.getTime("Duration");
			String BusID = rs.getString("BusID");
			int Price = Integer.parseInt(rs.getString("BasePrice"));
			result = new Route(RouteID, BusID, CityIDStart, CityIDEnd, Price, Duration, Distance);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	@Override
	public ArrayList<Route> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Route> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM RouteWay WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			String RouteID = rs.getString("RouteID");
			String CityIDStart = rs.getString("CityIDStart");
			String CityIDEnd = rs.getString("CityIDEnd");
			int Distance = Integer.parseInt(rs.getString("Distance"));
			Time Duration = rs.getTime("Duration");
			String BusID = rs.getString("BusID");
			int Price = Integer.parseInt(rs.getString("BasePrice"));
			Route temp = new Route(RouteID, BusID, CityIDStart, CityIDEnd, Price, Duration, Distance);
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public Route getRouteByCityStart_End (String CityIDStart1, String CityIDEnd1) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM RouteWay WHERE CityIDStart = ? AND CityIDEnd = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, CityIDStart1);
		psm.setString(2, CityIDEnd1);
		
		ResultSet rs = psm.executeQuery();
		
		Route result = new Route("","","","",0,new Time(0,0,0),0);
		
		while(rs.next())
		{
			String RouteID = rs.getString("RouteID");
			String CityIDStart = rs.getString("CityIDStart");
			String CityIDEnd = rs.getString("CityIDEnd");
			int Distance = Integer.parseInt(rs.getString("Distance"));
			Time Duration = rs.getTime("Duration");
			String BusID = rs.getString("BusID");
			int Price = Integer.parseInt(rs.getString("BasePrice"));
			result = new Route(RouteID, BusID, CityIDStart, CityIDEnd, Price, Duration, Distance);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}


}
