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
import Models.InfoCustomer;

public class DAOInfoCustomer implements DAOInterface<InfoCustomer,Integer>{

	public static DAOInfoCustomer getInstance()
	{
		return new DAOInfoCustomer();
	}
	
	@Override
	public int insert(InfoCustomer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO InfoCustomer (RealName, PhoneNumber, HomeAddress, Email) VALUES (?,?,?,?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t.getRealName());
		psm.setString(2, t.getPhoneNumber());
		psm.setString(3, t.getHomeAddress());
		psm.setString(4, t.getEmail());
		
		int executedRow = 0;
		executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM InfoCustomer WHERE InfoID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(InfoCustomer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE InfoCustomer SET RealName = ?, PhoneNumber = ?, HomeAddress = ?, Email = ? WHERE InfoID = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(5, t.getInfoID());
		psm.setString(1, t.getRealName());
		psm.setString(2, t.getPhoneNumber());
		psm.setString(3, t.getHomeAddress());
		psm.setString(4, t.getEmail());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<InfoCustomer> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<InfoCustomer> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM InfoCustomer";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			int InfoID = rs.getInt("InfoID");
			String RealName = rs.getString("RealName");
			String PhoneNumber = rs.getString("PhoneNumber");
			String HomeAddress = rs.getString("HomeAddress");
			String Email = rs.getString("Email");
			
			InfoCustomer temp = new InfoCustomer(InfoID, RealName, PhoneNumber, HomeAddress, Email);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<InfoCustomer>) list;
	}

	@Override
	public InfoCustomer selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM InfoCustomer WHERE InfoID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, Integer.parseInt(t));
		
		ResultSet rs = psm.executeQuery();
		
		InfoCustomer result = new InfoCustomer(0, "", "", "","");
				
		if(rs.next())
		{
			int InfoID = rs.getInt("InfoID");
			String RealName = rs.getString("RealName");
			String PhoneNumber = rs.getString("PhoneNumber");
			String HomeAddress = rs.getString("HomeAddress");
			String Email = rs.getString("Email");
			
			result = new InfoCustomer(InfoID, RealName, PhoneNumber, HomeAddress, Email);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	@Override
	public ArrayList<InfoCustomer> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<InfoCustomer> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM InfoCustomer WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			int InfoID = rs.getInt("InfoID");
			String RealName = rs.getString("RealName");
			String PhoneNumber = rs.getString("PhoneNumber");
			String HomeAddress = rs.getString("HomeAddress");
			String Email = rs.getString("Email");
			
			InfoCustomer temp = new InfoCustomer(InfoID, RealName, PhoneNumber, HomeAddress, Email);
		
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
		String sqlCommand = "SELECT InfoID FROM InfoCustomer";
		ResultSet rs = stmt.executeQuery(sqlCommand); 

		int result = 0;
				
		while(rs.next())
		{
			result = rs.getInt("InfoID");
		}
		
		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);

		return result + 1;
	}

	public int checkID(InfoCustomer t) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT InfoID FROM InfoCustomer AS IC\r\n"
				+ "WHERE IC.Email = ?\r\n"
				+ "AND IC.HomeAddress = ?\r\n"
				+ "AND IC.PhoneNumber = ?\r\n"
				+ "AND IC.RealName = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, t.getEmail());
		psm.setString(2, t.getHomeAddress());
		psm.setString(3, t.getPhoneNumber());
		psm.setString(4, t.getRealName());
		
		ResultSet rs = psm.executeQuery();
		
		int result = -1;
				
		if(rs.next())
		{
			result = rs.getInt("InfoID");
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	
}
