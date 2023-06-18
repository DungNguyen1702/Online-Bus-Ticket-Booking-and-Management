package DAO;

import java.lang.reflect.Array;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;
import Models.Bus;
import Models.Route;
import Models.Ticket;

public class DAOTicket implements DAOInterface<Ticket,Integer>{

	public static DAOTicket getInstance()
	{
		return new DAOTicket();
	}
	
	@Override
	public int insert(Ticket t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO Ticket (BillID, SeatNumber, KindOfTicket, Price, TripID) VALUES (?,?,?,?,?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t.getBillID());
		psm.setString(2, t.getSeatNumber());
		psm.setString(3, t.getKindOfTicket());
		psm.setString(4, t.getPrice()+"");
		psm.setInt(5, t.getTripID());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM Ticket WHERE TicketID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(Ticket t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE Ticket SET BillID = ?, SeatNumber = ?, KindOfTicket = ?, Price = ?, TripID = ? WHERE TicketID = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(6, t.getTicketID());
		psm.setInt(1, t.getBillID());
		psm.setString(2, t.getSeatNumber());
		psm.setString(3, t.getKindOfTicket());
		psm.setString(4, t.getPrice()+"");
		psm.setInt(5, t.getTripID());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<Ticket> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Ticket> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Ticket";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Ticket>) list;
	}

	@Override
	public Ticket selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Ticket WHERE TicketID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, Integer.parseInt(t));
		
		ResultSet rs = psm.executeQuery();
		
		Ticket result = new Ticket(0, 0, "", "", 0, 0);
		
		if(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			result = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}
	
	@Override
	public ArrayList<Ticket> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Ticket> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM Ticket WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}

	public ArrayList<Ticket> selectByBillID(int BillID1) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Ticket> list = new ArrayList<>();
		
		String command = "SELECT * FROM Ticket WHERE BillID = ?" ;
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, BillID1);
		
		ResultSet rs = psm.executeQuery();
		
		while(rs.next())
		{
			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}
	
	public ArrayList<Ticket> getBusySeat(int TripID1) throws SQLException
	{
		List<Ticket> list = new ArrayList<>();
		
		Connection con = JDBCUtil.getConnection();
		Statement st = con.createStatement();
		String command = "SELECT T.* FROM Ticket AS T \r\n"
				+ "JOIN TripInDay AS TID ON TID.TripID = T.TripID\r\n"
				+ "JOIN Bill AS B ON B.billID = T.BillID\r\n"
				+ "WHERE TID.TripID = " + TripID1 + "\r\n"
				+ "AND B.Status1 <> N'Đã từ chối'" ;
		
		ResultSet rs = st.executeQuery(command);
		while(rs.next())
		{

			int TicketID = rs.getInt("TicketID");
			int BillID = rs.getInt("BillID");
			String SeatNumber = rs.getString("SeatNumber");
			String KindOfTicket = rs.getString("KindOfTicket");
			int Price = Integer.parseInt(rs.getString("Price"));
			int TripID = rs.getInt("TripID");
			
			Ticket temp = new Ticket(TicketID, BillID, SeatNumber, KindOfTicket, Price, TripID);
			list.add(temp);
		}
		rs.close();
		st.close();
		JDBCUtil.closeConnection(con);
		return (ArrayList<Ticket>) list;
	}
	
	public Object[] StatisticByMonth(int Month) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String command = "SELECT SUM(CONVERT (INT,T.Price)) AS N'TotalRevenue',\r\n"
				+ "	(\r\n"
				+ "		SELECT SUM(CONVERT(INT,T2.Price)) \r\n"
				+ "		FROM Ticket AS T2\r\n"
				+ "	) AS N'Total',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM(\r\n"
				+ "			SELECT DISTINCT T3.BillID\r\n"
				+ "			FROM Ticket AS T3\r\n"
				+ "			JOIN Bill AS B3 ON T3.BillID = B3.BillID\r\n"
				+ "			JOIN TripInDay AS TID3 ON TID3.TripID = T3.TripID\r\n"
				+ "            GROUP BY T3.BillID, T3.TicketID, T3.BillID, B3.BookDate,T3.TripID, TID3.DateStart\r\n"
				+ "			HAVING MONTH(TID3.DateStart) = ?\r\n"
				+ "		) AS Ttable3\r\n"
				+ "	) AS N'NumBill',\r\n"
				+ "	COUNT(*) AS N'NumTicket',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM Ticket AS T4\r\n"
				+ "		JOIN TripInDay AS TID4 ON TID4.TripID = T4.TripID\r\n"
				+ "		WHERE MONTH(TID4.DateStart) = ? AND T4.KindOfTicket = N'Hạng nhất'\r\n"
				+ "	) AS N'NumFirst',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM Ticket AS T4\r\n"
				+ "		JOIN TripInDay AS TID4 ON TID4.TripID = T4.TripID\r\n"
				+ "		WHERE MONTH(TID4.DateStart) = ? AND T4.KindOfTicket = N'Hạng trung'\r\n"
				+ "	) AS N'NumMiddle',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM Ticket AS T4\r\n"
				+ "		JOIN TripInDay AS TID4 ON TID4.TripID = T4.TripID\r\n"
				+ "		WHERE MONTH(TID4.DateStart) = ? AND T4.KindOfTicket = N'Hạng phổ thông'\r\n"
				+ "	) AS N'NumNormal'\r\n"
				+ "FROM Ticket AS T \r\n"
				+ "JOIN TripInDay AS TID ON TID.TripID = T.TripID\r\n"
				+ "WHERE MONTH(TID.DateStart) = ?\r\n";
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, Month);
		psm.setInt(2, Month);
		psm.setInt(3, Month);
		psm.setInt(4, Month);
		psm.setInt(5, Month);
		
		int Income, Percent, NumBill, NumTicket, NumFirst, NumMiddle, NumNormal;
		Income = NumBill = Percent = NumTicket = NumFirst = NumMiddle = NumNormal = 0;

		
		ResultSet rs = psm.executeQuery();
		
		if(rs.next())
		{
			Income = rs.getInt(1);
			Percent = rs.getInt(2);
			NumBill = rs.getInt(3);
			NumTicket = rs.getInt(4);
			NumFirst = rs.getInt(5);
			NumMiddle = rs.getInt(6);
			NumNormal = rs.getInt(7);
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return new Object[] {Income, Double.parseDouble(String.format("%.2f",  ((double)Income)/((double)Percent) * 100)), NumBill, NumTicket, NumFirst, NumMiddle, NumNormal};
	}

	public ArrayList<Object[]> DataByTop(int Month, int Top) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		List<Object[]> list = new ArrayList<>();
		
		String command = "SELECT DISTINCT(RW.RouteID), CS.CityName AS N'CityStart' , CE.CityName AS N'CityEnd', \r\n"
				+ "(\r\n"
				+ "	Select SUM(table1.quantity) \r\n"
				+ "	FROM \r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*) AS quantity\r\n"
				+ "		FROM Ticket AS T\r\n"
				+ "		JOIN TripInDay AS TID1 ON TID1.TripID = T.TripID\r\n"
				+ "		WHERE TID1.RouteID = RW.RouteID AND MONTH(TID1.DateStart) = ?\r\n"
				+ "	) AS table1\r\n"
				+ ")AS N'SaledTicket' \r\n"
				+ "FROM RouteWay AS RW \r\n"
				+ "JOIN TripInDay AS TID ON RW.RouteID = TID.RouteID\r\n"
				+ "JOIN City AS CS ON CS.CityID = RW.CityIDStart\r\n"
				+ "JOIN City AS CE ON CE.CityID = RW.CityIDEnd\r\n"
				+ "GROUP BY RW.CityIDStart, RW.CityIDEnd, RW.RouteID, TID.DateStart, cs.CityName, ce.CityName\r\n"
				+ "HAVING MONTH(TID.DateStart) = ?\r\n"
				+ "ORDER BY SaledTicket DESC";
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, Month);
		psm.setInt(2, Month);
		
		int RouteID,SaledTicket;
		String  CityStart, CityEnd;

		
		ResultSet rs = psm.executeQuery();
		
		while(rs.next() && list.size()<Top && rs.getInt(4) != 0)
		{
			RouteID = rs.getInt(1);
			CityStart = rs.getString(2);
			CityEnd = rs.getString(3);
			SaledTicket = rs.getInt(4);
			
			list.add(new Object[] {RouteID, CityStart, CityEnd, SaledTicket});
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Object[]>) list;
	}
	
	public ArrayList<Object[]> DataTopByYear(int Year, int Top) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		List<Object[]> list = new ArrayList<>();
		
		String command = "SELECT DISTINCT(RW.RouteID), CS.CityName AS N'CityStart' , CE.CityName AS N'CityEnd', \r\n"
				+ "(\r\n"
				+ "	Select SUM(table1.quantity) \r\n"
				+ "	FROM \r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*) AS quantity\r\n"
				+ "		FROM Ticket AS T\r\n"
				+ "		JOIN TripInDay AS TID1 ON TID1.TripID = T.TripID\r\n"
				+ "		WHERE TID1.RouteID = RW.RouteID AND YEAR(TID1.DateStart) = ?\r\n"
				+ "	) AS table1\r\n"
				+ ")AS N'SaledTicket' \r\n"
				+ "FROM RouteWay AS RW \r\n"
				+ "JOIN TripInDay AS TID ON RW.RouteID = TID.RouteID\r\n"
				+ "JOIN City AS CS ON CS.CityID = RW.CityIDStart\r\n"
				+ "JOIN City AS CE ON CE.CityID = RW.CityIDEnd\r\n"
				+ "GROUP BY RW.CityIDStart, RW.CityIDEnd, RW.RouteID, TID.DateStart, cs.CityName, ce.CityName\r\n"
				+ "HAVING YEAR(TID.DateStart) = ?\r\n"
				+ "ORDER BY SaledTicket DESC";
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, Year);
		psm.setInt(2, Year);
		
		int RouteID,SaledTicket;
		String  CityStart, CityEnd;

		
		ResultSet rs = psm.executeQuery();
		
		while(rs.next() && list.size()<Top && rs.getInt(4) != 0)
		{
			RouteID = rs.getInt(1);
			CityStart = rs.getString(2);
			CityEnd = rs.getString(3);
			SaledTicket = rs.getInt(4);
			
			list.add(new Object[] {RouteID, CityStart, CityEnd, SaledTicket});
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Object[]>) list;
	}
	
	public Object[] StatisticByYear(int year) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String command = "SELECT SUM(CONVERT (INT,T.Price)) AS N'TotalRevenue',\r\n"
				+ "	(\r\n"
				+ "		SELECT SUM(CONVERT(INT,T2.Price)) \r\n"
				+ "		FROM Ticket AS T2\r\n"
				+ "	) AS N'Total',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM(\r\n"
				+ "			SELECT DISTINCT T3.BillID\r\n"
				+ "			FROM Ticket AS T3\r\n"
				+ "			JOIN Bill AS B3 ON T3.BillID = B3.BillID\r\n"
				+ "			JOIN TripInDay AS TID3 ON TID3.TripID = T3.TripID\r\n"
				+ "            GROUP BY T3.BillID, T3.TicketID, T3.BillID, B3.BookDate,T3.TripID, TID3.DateStart\r\n"
				+ "			HAVING YEAR(TID3.DateStart) = ?\r\n"
				+ "		) AS Ttable3\r\n"
				+ "	) AS N'NumBill',\r\n"
				+ "	COUNT(*) AS N'NumTicket',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM Ticket AS T4\r\n"
				+ "		JOIN TripInDay AS TID4 ON TID4.TripID = T4.TripID\r\n"
				+ "		WHERE YEAR(TID4.DateStart) = ? AND T4.KindOfTicket = N'Hạng nhất'\r\n"
				+ "	) AS N'NumFirst',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM Ticket AS T4\r\n"
				+ "		JOIN TripInDay AS TID4 ON TID4.TripID = T4.TripID\r\n"
				+ "		WHERE YEAR(TID4.DateStart) = ? AND T4.KindOfTicket = N'Hạng trung'\r\n"
				+ "	) AS N'NumMiddle',\r\n"
				+ "	(\r\n"
				+ "		SELECT COUNT(*)\r\n"
				+ "		FROM Ticket AS T4\r\n"
				+ "		JOIN TripInDay AS TID4 ON TID4.TripID = T4.TripID\r\n"
				+ "		WHERE YEAR(TID4.DateStart) = ? AND T4.KindOfTicket = N'Hạng phổ thông'\r\n"
				+ "	) AS N'NumNormal'\r\n"
				+ "FROM Ticket AS T \r\n"
				+ "JOIN TripInDay AS TID ON TID.TripID = T.TripID\r\n"
				+ "WHERE YEAR(TID.DateStart) = ?";
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, year);
		psm.setInt(2, year);
		psm.setInt(3, year);
		psm.setInt(4, year);
		psm.setInt(5, year);
		
		int Income, Percent, NumBill, NumTicket, NumFirst, NumMiddle, NumNormal;
		Income = NumBill = Percent = NumTicket = NumFirst = NumMiddle = NumNormal = 0;

		
		ResultSet rs = psm.executeQuery();
		
		if(rs.next())
		{
			Income = rs.getInt(1);
			Percent = rs.getInt(2);
			NumBill = rs.getInt(3);
			NumTicket = rs.getInt(4);
			NumFirst = rs.getInt(5);
			NumMiddle = rs.getInt(6);
			NumNormal = rs.getInt(7);
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return new Object[] {Income,Double.parseDouble(String.format("%.2f",  ((double)Income)/((double)Percent) * 100)), NumBill, NumTicket, NumFirst, NumMiddle, NumNormal};
	}
}
