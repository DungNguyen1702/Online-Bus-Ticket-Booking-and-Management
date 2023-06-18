package Models;

import java.sql.Date;
import java.time.LocalDate;

public class Customer {
	private int CustomerID;
	private String Account;
	private String Password;
	private String Name;
	private LocalDate DateOfBirth;
	private String Tel;
	private String CitizenID;
	private String Email;
	private String Sex;
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getAccount() {
		return Account;
	}
	public void setAccount(String account) {
		Account = account;
	}
	public String getPassword() {
		return Password;
	}
	public void setPassword(String password) {
		Password = password;
	}
	public String getName() {
		return Name;
	}
	public void setName(String name) {
		Name = name;
	}
	public LocalDate getDateOfBirth() {
		return DateOfBirth;
	}
	public void setDateOfBirth(LocalDate dateOfBirth) {
		DateOfBirth = dateOfBirth;
	}
	public String getTel() {
		return Tel;
	}
	public void setTel(String tel) {
		Tel = tel;
	}
	public String getCitizenID() {
		return CitizenID;
	}
	public void setCitizenID(String citizenID) {
		CitizenID = citizenID;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public String getSex() {
		return Sex;
	}
	public void setSex(String sex) {
		Sex = sex;
	}
	
	public void setValue(int customerID, String account, String password, String name, LocalDate dateOfBirth, String tel, String citizenID, String email, String sex) {
		CustomerID = customerID;
		Account = account;
		Password = password;
		Name = name;
		DateOfBirth = dateOfBirth;
		Tel = tel;
		CitizenID = citizenID;
		Email = email;
		Sex = sex;
	}
	public Customer(int customerID, String account, String password, String name, LocalDate dateOfBirth, String tel,
			String citizenID, String email, String sex) {
		super();
		CustomerID = customerID;
		Account = account;
		Password = password;
		Name = name;
		DateOfBirth = dateOfBirth;
		Tel = tel;
		CitizenID = citizenID;
		Email = email;
		Sex = sex;
	}
	public Customer() {
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Customer [CustomerID=" + CustomerID + ", Account=" + Account + ", Password=" + Password + ", Name="
				+ Name + ", DateOfBirth=" + DateOfBirth + ", Tel=" + Tel + ", CitizenID=" + CitizenID + ", Email="
				+ Email + ", Sex=" + Sex + "]";
	}
	
}
