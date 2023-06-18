package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;

public class DAOStatistic {
	public static DAOStatistic getInstance()
	{
		return new DAOStatistic();
	}
	
	public Object[] StatisticAll_Info() throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String command = "SELECT SUM(CONVERT(INT,T.Price)) AS N'Income', COUNT(*) AS N'NumTicket',\r\n"
				+ "(\r\n"
				+ "	SELECT COUNT(*)\r\n"
				+ "	FROM Customer\r\n"
				+ ")AS N'NumUser',\r\n"
				+ "(\r\n"
				+ "	SELECT COUNT(*)\r\n"
				+ "	FROM Bill\r\n"
				+ ") AS N'NumBill'\r\n"
				+ "FROM Ticket AS T";
		PreparedStatement psm = Conn.prepareStatement(command);
		
		int Income, NumBill, NumTicket, NumUser;
		Income = NumBill = NumTicket = NumUser = 0;

		
		ResultSet rs = psm.executeQuery();
		
		if(rs.next())
		{
			Income = rs.getInt(1);
			NumTicket = rs.getInt(2);
			NumUser = rs.getInt(3);
			NumBill = rs.getInt(4);
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return new Object[] {Income, NumBill, NumTicket, NumUser};
	}
	
	public ArrayList<Object[]> DataTopStatisticAll(int Top) throws SQLException
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
				+ "		WHERE TID1.RouteID = RW.RouteID\r\n"
				+ "	) AS table1\r\n"
				+ ")AS N'SaledTicket' \r\n"
				+ "FROM RouteWay AS RW \r\n"
				+ "JOIN TripInDay AS TID ON RW.RouteID = TID.RouteID\r\n"
				+ "JOIN City AS CS ON CS.CityID = RW.CityIDStart\r\n"
				+ "JOIN City AS CE ON CE.CityID = RW.CityIDEnd\r\n"
				+ "GROUP BY RW.CityIDStart, RW.CityIDEnd, RW.RouteID, TID.DateStart, cs.CityName, ce.CityName\r\n"
				+ "ORDER BY SaledTicket DESC";
		PreparedStatement psm = Conn.prepareStatement(command);
		
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
	
	public Object[] getStatisticByYearInAll(int Year) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		List<Object[]> list = new ArrayList<>();
		
		String command = "SELECT SUM(CONVERT(INT,T.Price)) AS N'Revenue', COUNT(T.TicketID) AS N'NumTicket'\r\n"
				+ "FROM Ticket AS T\r\n"
				+ "JOIN TripInDay AS TID ON TID.TripID = T.TripID\r\n"
				+ "WHERE YEAR(TID.DateStart) = ?";
		PreparedStatement psm = Conn.prepareStatement(command);
		
		psm.setInt(1, Year);
		
		long Revenue = 0;
		int  NumTicket = 0;
		
		ResultSet rs = psm.executeQuery();
		
		while(rs.next())
		{
			Revenue = rs.getLong(1);
			NumTicket = rs.getInt(2);
			
		}

		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return new Object[] {Revenue, NumTicket};
	}
}
