package DAO;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.Month;
import java.util.ArrayList;
import java.util.List;

import BUS.JDBCUtil;
import Models.Bill;
import Models.Bus;
import Models.City;
import Models.Customer;
import Models.myDate;

public class DAOCustomer implements DAOInterface<Customer,Integer>{

	public static DAOCustomer getInstance()
	{
		return new DAOCustomer();
	}
	
	@Override
	public int insert(Customer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "INSERT INTO Customer (UserName, UserPassWord, RealName, CitizenID, DateOfBirth, PhoneNumber, Email, Sex) VALUES (?,?,?,?,?,?,?,?)";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setString(1, t.getAccount());
		psm.setString(2, t.getPassword());
		psm.setString(3, t.getName());
		psm.setString(4, t.getCitizenID());
		psm.setDate(5, Date.valueOf(t.getDateOfBirth()));
		psm.setString(6, t.getTel());
		psm.setString(7, t.getEmail());
		psm.setString(8, t.getSex());
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int delete(Integer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "DELETE FROM Customer WHERE CustomerID = ?";
		PreparedStatement psm = con.prepareStatement(command);
		
		psm.setInt(1, t);
		
		int executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public int update(Customer t) throws SQLException, ClassNotFoundException {
		
		Connection con = JDBCUtil.getConnection();
		
		String command = "UPDATE Customer SET UserPassWord = ?, RealName = ?, CitizenID = ?, DateOfBirth = ?, PhoneNumber = ?, Email = ?, Sex = ? WHERE CustomerID = ?";
		PreparedStatement psm = con.prepareStatement(command);
			
		psm.setInt(8, t.getCustomerID());
		psm.setString(1, t.getPassword());
		psm.setString(2, t.getName());
		psm.setString(3, t.getCitizenID());
		psm.setDate(4, Date.valueOf(t.getDateOfBirth()));
		psm.setString(5, t.getTel());
		psm.setString(6, t.getEmail());
		psm.setString(7, t.getSex());
		
		int executedRow = 0;
		executedRow = psm.executeUpdate(); 
		
		psm.close();
		
		JDBCUtil.closeConnection(con);
		return executedRow;
	}

	@Override
	public ArrayList<Customer> selectAll() throws SQLException, ClassNotFoundException {
		
		Connection Conn = JDBCUtil.getConnection(); 
		List<Customer> list = new ArrayList<>();
		
		//Bước 3 : Thực hiện câu lệnh truy vấn 
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT * FROM Customer";
		ResultSet rs = stmt.executeQuery(sqlCommand); 
		
		//Bước 4 : Xem thong tin cua bang
		while(rs.next())
		{
			int CustomerID = rs.getInt("CustomerID");
			String Account = rs.getString("UserName");
			String UserPassWord = rs.getString("UserPassWord");
			String Name = rs.getString("RealName");
			String CitizenID = rs.getString("CitizenID");
			LocalDate DateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
			String Tel = rs.getString("PhoneNumber");
			String Email = rs.getString("Email");
			String Sex = rs.getString("Sex");
			
			Customer temp = new Customer(CustomerID, Account, UserPassWord, Name, DateOfBirth, Tel, CitizenID, Email, Sex);
			list.add(temp);
		}
		
		rs.close();
		stmt.close();
		
		JDBCUtil.closeConnection(Conn);
		return (ArrayList<Customer>) list;
	}

	@Override
	public Customer selectByID(String t) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Customer WHERE CustomerID = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setInt(1, Integer.parseInt(t));
		
		ResultSet rs = psm.executeQuery();
		
		LocalDate date = LocalDate.of(2023,1, 1);
		Customer result = new Customer(0, "", "", "", date, "", "", "", "");
		
		while(rs.next())
		{
			int CustomerID = rs.getInt("CustomerID");
			String Account = rs.getString("UserName");
			String UserPassWord = rs.getString("UserPassWord");
			String Name = rs.getString("RealName");
			String CitizenID = rs.getString("CitizenID");
			LocalDate DateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
			String Tel = rs.getString("PhoneNumber");
			String Email = rs.getString("Email");
			String Sex = rs.getString("Sex");
			
			result = new Customer(CustomerID, Account, UserPassWord, Name, DateOfBirth, Tel, CitizenID, Email, Sex);
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	@Override
	public ArrayList<Customer> selectByCondition(String condition) throws SQLException, ClassNotFoundException {
		Connection Conn = JDBCUtil.getConnection(); 
		
		ArrayList<Customer> list = new ArrayList<>();
		
		Statement stmt = Conn.createStatement();
		String command = "SELECT * FROM Customer WHERE " + condition;
		ResultSet rs = stmt.executeQuery(command);
		
		while(rs.next())
		{
			int CustomerID = rs.getInt("CustomerID");
			String Account = rs.getString("UserName");
			String UserPassWord = rs.getString("UserPassWord");
			String Name = rs.getString("RealName");
			String CitizenID = rs.getString("CitizenID");
			LocalDate DateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
			String Tel = rs.getString("PhoneNumber");
			String Email = rs.getString("Email");
			String Sex = rs.getString("Sex");
			
			Customer temp = new Customer(CustomerID, Account, UserPassWord, Name, DateOfBirth, Tel, CitizenID, Email, Sex);
			list.add(temp);
		}

		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);
		return list;
	}
	
	public boolean checkInfoLogIn(Customer t) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Customer WHERE UserName = ? AND UserPassWord = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, t.getAccount());
		psm.setString(2, t.getPassword());
		
		ResultSet rs = psm.executeQuery();
		
		if(rs.next())
		{
			t.setAccount(rs.getString("UserName"));
			t.setPassword(rs.getString("UserPassWord")); 
			t.setCitizenID(rs.getString("CitizenID"));
			t.setCustomerID(rs.getInt("CustomerID"));
			t.setName(rs.getString("RealName"));
			t.setDateOfBirth(rs.getDate("DateOfBirth").toLocalDate());
			t.setTel(rs.getString("PhoneNumber"));
			t.setEmail(rs.getString("Email"));
			t.setSex(rs.getString("Sex"));
			
			rs.close();
			psm.close();
			JDBCUtil.closeConnection(Conn);
			
			return true;
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		
		return false;
	}
	
	// Nếu đã có rồi thì trả về giá trị false, chưa có thì trả về giá trị true
	public boolean checkRegister(String Account1) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Customer WHERE UserName = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, Account1);
		
		ResultSet rs = psm.executeQuery();
		
		if(rs.next())
		{
			return false;
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		
		return true;
	}

	public int getNextID() throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		Statement stmt = Conn.createStatement();
		String sqlCommand = "SELECT CustomerID FROM Customer";
		ResultSet rs = stmt.executeQuery(sqlCommand); 

		int result = 0;
				
		while(rs.next())
		{
			result = rs.getInt("Customer");
		}
		
		rs.close();
		stmt.close();
		JDBCUtil.closeConnection(Conn);

		return result + 1;
	}

	public Boolean checkAccountRegister(String account) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "SELECT * FROM Customer WHERE UserName = ?";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, account);
		
		ResultSet rs = psm.executeQuery();
		
		Boolean result = true;
		if(rs.next())
		{
			result = false;
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
	}

	public Boolean checkFindAccount(Customer cus) throws SQLException
	{
		Connection Conn = JDBCUtil.getConnection(); 
		
		String SqlCommand = "Select * FROM Customer WHERE UserName = ? AND CitizenID = ? AND PhoneNumber = ? AND Email = ?\r\n"
				+ "";
		PreparedStatement psm = Conn.prepareStatement(SqlCommand);
		
		psm.setString(1, cus.getAccount());
		psm.setString(2, cus.getCitizenID());
		psm.setString(3, cus.getTel());
		psm.setString(4, cus.getEmail());
		
		ResultSet rs = psm.executeQuery();
		
		Boolean result = false;
		if(rs.next())
		{
			int CustomerID = rs.getInt("CustomerID");
			String Account = rs.getString("UserName");
			String UserPassWord = rs.getString("UserPassWord");
			String Name = rs.getString("RealName");
			String CitizenID = rs.getString("CitizenID");
			LocalDate DateOfBirth = rs.getDate("DateOfBirth").toLocalDate();
			String Tel1 = rs.getString("PhoneNumber");
			String Email1 = rs.getString("Email");
			String Sex = rs.getString("Sex");
			
			cus.setValue(CustomerID, Account, UserPassWord, Name, DateOfBirth, Tel1, CitizenID, Email1, Sex);
			
			result = true;
		}
		
		rs.close();
		psm.close();
		JDBCUtil.closeConnection(Conn);
		return result;
		
	}
}
