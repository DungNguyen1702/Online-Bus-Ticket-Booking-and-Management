package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;
import Models.Bill;
import Models.myDate;

public class DAOBill implements DAOInterface<Bill,Integer>{

	public static DAOBill getInstance()
	{
		return new DAOBill();
	}
	
	@Override
	public int insert(Bill t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO Bill (CustomerID, PaymentMethod, Status1, KindOfBook, BookDate, InfoID, TotalPrice) VALUES (?, ?, ?, ?, ?, ?, ?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t.getCustomerID());
		psm.setString(2, t.getPaymentMethod());
		psm.setString(3, t.getStatus());
		psm.setString(4, t.getKindOfBook());
		psm.setDate(5, Date.valueOf(t.getBookDate()));
		psm.setInt(6, t.getInfoID());
		psm.setString(7, t.getTotalPrice() + "");
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM Bill WHERE BillID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(Bill t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE Bill SET CustomerID =? , PaymentMethod = ?, Status1 = ?, KindOfBook = ?, BookDate = ?, InfoID = ?, TotalPrice = ? WHERE BillID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(8, t.getBillID());
		psm.setInt(1, t.getCustomerID());
		psm.setString(2, t.getPaymentMethod());
		psm.setString(3, t.getStatus());
		psm.setString(4, t.getKindOfBook());
		psm.setDate(5, Date.valueOf(t.getBookDate()));
		psm.setInt(6, t.getInfoID());
		psm.setString(7, t.getTotalPrice() + "");
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<Bill> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Bill> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Bill";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			int BillID = rs.getInt("BillID");
			int CustomerID = rs.getInt("CustomerID");
			String PaymentMethod = rs.getString("PaymentMethod");
			String Status1 = rs.getString("Status1");
			String KindOfBook = rs.getString("KindOfBook");
			LocalDate BookDate = rs.getDate("BookDate").toLocalDate();
			int InfoID = rs.getInt("InfoID");
			int Price = Integer.parseInt(rs.getString("TotalPrice"));
			
			Bill temp = new Bill(BillID, CustomerID, PaymentMethod, Status1, KindOfBook, BookDate, InfoID, Price);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
				
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Bill>) list;
	}

	@Override
	public Bill selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Bill WHERE BillID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, Integer.parseInt(t));
		
		ResultSet rs = psm.executeQuery();
		
		Bill result = new Bill(0, 0, "", "", "", LocalDate.of(2023, 4, 20), 0, 0); 
				
		while(rs.next())
		{
			int BillID = rs.getInt("BillID");
			int CustomerID = rs.getInt("CustomerID");
			String PaymentMethod = rs.getString("PaymentMethod");
			String Status1 = rs.getString("Status1");
			String KindOfBook = rs.getString("KindOfBook");
			LocalDate BookDate = rs.getDate("BookDate").toLocalDate();
			int InfoID = rs.getInt("InfoID");
			int Price = Integer.parseInt(rs.getString("TotalPrice"));

			result = new Bill(BillID, CustomerID, PaymentMethod, Status1, KindOfBook, BookDate, InfoID, Price);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	@Override
	public ArrayList<Bill> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Bill> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM Bill WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			int BillID = rs.getInt("BillID");
			int CustomerID = rs.getInt("CustomerID");
			String PaymentMethod = rs.getString("PaymentMethod");
			String Status1 = rs.getString("Status1");
			String KindOfBook = rs.getString("KindOfBook");
			LocalDate BookDate = rs.getDate("BookDate").toLocalDate();
			int InfoID = rs.getInt("InfoID");
			int Price = Integer.parseInt(rs.getString("TotalPrice"));
			
			Bill temp = new Bill(BillID, CustomerID, PaymentMethod, Status1, KindOfBook, BookDate, InfoID, Price);
			
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}
	
	public ArrayList<Bill> selectByCusID(int CusID) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Bill> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM Bill WHERE CustomerID = " + CusID;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			int BillID = rs.getInt("BillID");
			int CustomerID = rs.getInt("CustomerID");
			String PaymentMethod = rs.getString("PaymentMethod");
			String Status1 = rs.getString("Status1");
			String KindOfBook = rs.getString("KindOfBook");
			LocalDate BookDate = rs.getDate("BookDate").toLocalDate();
			int InfoID = rs.getInt("InfoID");
			int Price = Integer.parseInt(rs.getString("TotalPrice"));
			
			Bill temp = new Bill(BillID, CustomerID, PaymentMethod, Status1, KindOfBook, BookDate, InfoID, Price);
			
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public int getNextID() throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT BillID FROM Bill";
		ResultSet rs = stmt.executeQuery(sqlCommand); 

		int result = 0;
				
		while(rs.next())
		{
			result = rs.getInt("BillID");
		}
		
		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);

		return result + 1;
	}

	public Object[] getInfoForPanelBill(int BillID) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT CS.CityName AS N'CityNameStart', CE.CityName AS N'CityNameEnd', RW.Distance, RW.Duration\r\n"
				+ "FROM Bill AS B\r\n"
				+ "JOIN Ticket AS T ON T.BillID = B.BillID\r\n"
				+ "JOIN TripInDay AS TID ON TID.TripID = T.TripID\r\n"
				+ "JOIN RouteWay as RW ON RW.RouteID =TID.RouteID\r\n"
				+ "JOIN City AS CS ON CS.CityID = RW.CityIDStart\r\n"
				+ "JOIN City AS CE ON CE.CityID = RW.CityIDEnd\r\n"
				+ "WHERE B.BillID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, BillID);
		
		ResultSet rs = psm.executeQuery();
		
		Object[] result = null; 
				
		if(rs.next())
		{
			String NameCityStart = rs.getString("CityNameStart");
			String NameCityEnd = rs.getString("CityNameEnd");
			int Distance = rs.getInt("Distance");
			String duration = rs.getTime("Duration").toLocalTime().getHour() +"";
			
			result = new Object[] {NameCityStart, NameCityEnd, Distance, duration};
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}
}
