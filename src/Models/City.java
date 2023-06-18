package Models;

public class City {
	private String CityID;
	private String ParkingName;
	private String CityName;
	private String Address;
	
	public static City getInstance()
	{
		return new City();
	}
	public String getCityID() {
		return CityID;
	}
	public void setCityID(String cityID) {
		CityID = cityID;
	}
	public String getParkingName() {
		return ParkingName;
	}
	public void setParkingName(String parkingName) {
		ParkingName = parkingName;
	}
	public String getCityName() {
		return CityName;
	}
	public void setCityName(String cityName) {
		CityName = cityName;
	}
	public String getAddress() {
		return Address;
	}
	public void setAddress(String address) {
		Address = address;
	}
	public City()
	{
		
	}
	public City(String cityID, String parkingName, String cityName, String address) {
		super();
		CityID = cityID;
		ParkingName = parkingName;
		CityName = cityName;
		Address = address;
	}
	@Override
	public String toString() {
		return "City [CityID=" + CityID + ", ParkingName=" + ParkingName + ", CityName=" + CityName + ", Address="
				+ Address + "]";
	}
	public String changeIDFromIntToString(int ID)
	{
		if(ID >= 1 && ID <=9)
		{
			return "City00" + ID;
		}
		else if(ID >= 10 && ID <=99)
		{
			return "City0" + ID;
		}else 
		{
			return "City" + ID;
		}
	}
	
	public int changeIDFromStringToInt(String CityID)
	{
		return Integer.parseInt(CityID.substring(CityID.length() - 3));
	}
}
