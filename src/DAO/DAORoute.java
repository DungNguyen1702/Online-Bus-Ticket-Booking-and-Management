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

public class DAORoute implements DAOInterface<Route,Integer>{

	private static DAORoute instance = new DAORoute();
	public static DAORoute getInstance()
	{
		return instance;
	}
	
	@Override
	public int insert(Route t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO RouteWay (CityIDStart, CityIDEnd, Distance, Duration, BusID, BasePrice) VALUES (?, ?, ?, ?, ?, ?)";
		PreparedStatement psm = con.prepareStatement(command);
		
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
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM RouteWay WHERE RouteID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t);
		
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
		
		psm.setInt(7, t.getRouteID());
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
			int RouteID = rs.getInt("RouteID");
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
		
		int ID = Integer.parseInt(t);
		
		psm.setInt(1, ID);
		
		ResultSet rs = psm.executeQuery();
		
		Route result = new Route(0,"","","",0,new Time(0,0,0),0);
		
		while(rs.next())
		{
			int RouteID = rs.getInt("RouteID");
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
			int RouteID = rs.getInt("RouteID");
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
		
		Route result = new Route(0,"","","",0,new Time(0,0,0),0);
		
		while(rs.next())
		{
			int RouteID = rs.getInt("RouteID");
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

	public List<Object[]> getListRouteAndCity() throws SQLException
	{
		List<Object[]> list = new ArrayList<>();
		
		Connection con = JDBCUtil.getConnection();
		Statement st = con.createStatement();
		String command = "SELECT RW.RouteID,  CS.CityName as 'CityNameStart', CE.CityName as 'CityNameEnd',  RW.Distance, RW.Duration, B.KindOfBus, RW.BasePrice \r\n"
				+ "FROM RouteWay AS RW\r\n"
				+ "JOIN City AS CS ON CS.CityID = RW.CityIDStart\r\n"
				+ "JOIN City AS CE ON CE.CityID = RW.CityIDEnd\r\n"
				+ "JOIN Bus AS B ON B.BusID = RW.BusID" ;
		
		ResultSet rs = st.executeQuery(command);
		while(rs.next())
		{
			String routeID = rs.getString("RouteID");
			String CityNameStart = rs.getString("CityNameStart");
			String CityNameEnd = rs.getString("CityNameEnd");
			int Distance = rs.getInt("Distance");
			Time time = rs.getTime("Duration");
			String BusID =rs.getString("KindOfBus");
			int Price = rs.getInt("BasePrice");
			
			Object[] temp = new Object[] {routeID, CityNameStart, CityNameEnd, Distance, time, BusID, Price};
			list.add(temp);
		}
		rs.close();
		st.close();
		JDBCUtil.closeConnection(con);
		return list;
	}

	public ArrayList<String> getNameCityStartAndEnd(int RouteID) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<String> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT CS.CityName AS 'CityStart', CE.CityName AS 'CityEnd' FROM RouteWay AS RW\r\n"
				+ "JOIN City AS CS ON RW.CityIDStart = CS.CityID\r\n"
				+ "JOIN City AS CE ON RW.CityIDEnd = CE.CityID\r\n"
				+ "WHERE RW.RouteID = " + RouteID;
		ResultSet rs = stmt.executeQuery(command);
		
		if(rs.next())
		{
			String temp1 = rs.getString("CityStart");
			String temp2 = rs.getString("CityEnd");
			
			list.add(temp1);
			list.add(temp2);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}
}
