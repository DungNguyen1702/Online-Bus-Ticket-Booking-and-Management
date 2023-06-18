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

public class DAOBus implements DAOInterface<Bus,String>{

	public static DAOBus getInstance()
	{
		return new DAOBus();
	}
	
	@Override
	public int insert(Bus t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO Bus (BusID, NumberOfSeat, KindOfBus) VALUES (?,?,?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t.getBusID());
		psm.setString(2, t.getNumberOfSeat() +"");
		psm.setString(3, t.getKindOfBus());
	
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(String t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM Bus WHERE BusID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(Bus t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE Bus SET NumberOfSeat = ?, KindOfBus = ? WHERE BusID = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setString(3, t.getBusID());
		psm.setString(1, t.getNumberOfSeat() +"");
		psm.setString(2, t.getKindOfBus());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<Bus> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Bus> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Bus";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			String BusID = rs.getString("BusID");
			int NumberOfSeat = Integer.parseInt(rs.getString("NumberOfSeat"));
			String KindOfBus = rs.getString("KindOfBus");
			
			Bus temp = new Bus(BusID, NumberOfSeat, KindOfBus);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Bus>) list;
	}

	@Override
	public Bus selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Bus WHERE BusID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, t);
		
		ResultSet rs = psm.executeQuery();
		
		Bus result = new Bus("", 0, ""); 
				
		while(rs.next())
		{
			String BusID = rs.getString("BusID");
			int NumberOfSeat = Integer.parseInt(rs.getString("NumberOfSeat"));
			String KindOfBus = rs.getString("KindOfBus");
			
			result = new Bus(BusID, NumberOfSeat, KindOfBus);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	@Override
	public ArrayList<Bus> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Bus> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM Bus WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			String BusID = rs.getString("BusID");
			int NumberOfSeat = Integer.parseInt(rs.getString("NumberOfSeat"));
			String KindOfBus = rs.getString("KindOfBus");
			
			Bus temp = new Bus(BusID, NumberOfSeat, KindOfBus);
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public String getKindOfBusByTripID(int TripID) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT KindOfBus FROM Bus AS B\r\n"
				+ "JOIN RouteWay AS RW ON RW.BusID = B.BusID\r\n"
				+ "JOIN TripInDay AS TID ON TID.RouteID = RW.RouteID\r\n"
				+ "WHERE TID.TripID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, TripID);
		
		ResultSet rs = psm.executeQuery();
		
		String result = "";
				
		if(rs.next())
		{
			result = rs.getString("KindOfBus");
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}
	
	public ArrayList<String> getListBus() throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<String> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT KindOfBus FROM Bus";
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			String IDname = rs.getString("KindOfBus");
			
			list.add(IDname);
		}
		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}
	
	public String getBusIDByKindOfBus(String KindOfBus) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT BusID FROM Bus WHERE KindOfBus = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, KindOfBus);
		
		ResultSet rs = psm.executeQuery();
		
		while(rs.next())
		{
			String IDname = rs.getString("BusID");
			
			return IDname;
		}
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return "";
	}
}
