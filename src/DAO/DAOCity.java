package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;
import Models.Bill;
import Models.Bus;
import Models.City;

public class DAOCity implements DAOInterface<City,String>{

	private static DAOCity instance = new DAOCity();
	public static DAOCity getInstance()
	{
		return instance;
	}
	
	@Override
	public int insert(City t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO City (CityID, ParkingName, CityName, ParkingAddress) VALUES (?,?,?,?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t.getCityID());
		psm.setString(2, t.getParkingName());
		psm.setString(3, t.getCityName());
		psm.setString(4, t.getAddress());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(String t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM City WHERE CityID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(City t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE City SET ParkingName = ?, CityName = ?, ParkingAddress = ? WHERE CityID = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setString(4, t.getCityID());
		psm.setString(1, t.getParkingName());
		psm.setString(2, t.getCityName());
		psm.setString(3, t.getAddress());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<City> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<City> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM City";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			String CityID = rs.getString("CityID");
			String ParkingName = rs.getString("ParkingName");
			String CityName = rs.getString("CityName");
			String ParkingAddress = rs.getString("ParkingAddress");
			
			City temp = new City(CityID, ParkingName, CityName, ParkingAddress);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<City>) list;
	}

	@Override
	public City selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM City WHERE CityID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, t);
		
		ResultSet rs = psm.executeQuery();
		
		City result = new City("", "", "", "");
				
		while(rs.next())
		{
			String CityID = rs.getString("CityID");
			String ParkingName = rs.getString("ParkingName");
			String CityName = rs.getString("CityName");
			String ParkingAddress = rs.getString("ParkingAddress");
			
			result = new City(CityID, ParkingName, CityName, ParkingAddress);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	@Override
	public ArrayList<City> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<City> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM City WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			String CityID = rs.getString("CityID");
			String ParkingName = rs.getString("ParkingName");
			String CityName = rs.getString("CityName");
			String ParkingAddress = rs.getString("ParkingAddress");
			
			City temp = new City(CityID, ParkingName, CityName, ParkingAddress);
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public City getParkingCityStartByTripID(int TripID) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<City> list = new ArrayList<>();
		
		String SqlCommand = "SELECT C.* FROM City AS C\r\n"
				+ "JOIN RouteWay AS RW ON RW.CityIDStart = C.CityID\r\n"
				+ "JOIN TripInDay AS T ON T.RouteID = RW.RouteID\r\n"
				+ "WHERE T.TripID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, TripID);
		
		ResultSet rs = psm.executeQuery();
		
		City result = new City("", "", "", "");
		if(rs.next())
		{
			String CityID = rs.getString("CityID");
			String ParkingName = rs.getString("ParkingName");
			String CityName = rs.getString("CityName");
			String ParkingAddress =rs.getString("ParkingAddress");
	
			result = new City(CityID, ParkingName, CityName, ParkingAddress);
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}
	
	public ArrayList<String> getListCity() throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<String> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT CityName FROM City";
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			String ParkingName = rs.getString("CityName");
			
			list.add(ParkingName);
		}
		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public String getNameCityByID(String CityID) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		
		String SqlCommand = "SELECT CityName FROM City WHERE CityID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, CityID);
		
		ResultSet rs = psm.executeQuery();
		
		String result = "";
		if(rs.next())
		{
			String CityName = rs.getString("CityName");
			
			result = CityName;
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	public String getCityIDByName(String CityName) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT CityID FROM City WHERE CityName = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, CityName);
		
		ResultSet rs = psm.executeQuery();
		
		String result = "";
		if(rs.next())
		{
			String CityID = rs.getString("CityID");
			
			result = CityID;
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}
	
	
}
