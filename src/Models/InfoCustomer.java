package Models;

public class InfoCustomer {
	private int infoID;
	private String realName;
	private String PhoneNumber;
	private String HomeAddress;
	private String Email;
	public int getInfoID() {
		return infoID;
	}
	public void setInfoID(int infoID) {
		this.infoID = infoID;
	}
	public String getRealName() {
		return realName;
	}
	public void setRealName(String realName) {
		this.realName = realName;
	}
	public String getPhoneNumber() {
		return PhoneNumber;
	}
	public void setPhoneNumber(String phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	public String getHomeAddress() {
		return HomeAddress;
	}
	public void setHomeAddress(String homeAddress) {
		HomeAddress = homeAddress;
	}
	public String getEmail() {
		return Email;
	}
	public void setEmail(String email) {
		Email = email;
	}
	public InfoCustomer(int infoID, String realName, String phoneNumber, String homeAddress, String email) {
		super();
		this.infoID = infoID;
		this.realName = realName;
		PhoneNumber = phoneNumber;
		HomeAddress = homeAddress;
		Email = email;
	}
	@Override
	public String toString() {
		return "InfoCustomer [infoID=" + infoID + ", realName=" + realName + ", PhoneNumber=" + PhoneNumber
				+ ", HomeAddress=" + HomeAddress + ", Email=" + Email + "]";
	}
}
