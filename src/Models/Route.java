package Models;

import java.sql.Time;

public class Route {
	private int RouteID;
	private String BusID;
	private String CityIDStart;
	private String CityIDEnd;
	private int Price;
	private Time Duration;
	private int Distance;
	public int getRouteID() {
		return RouteID;
	}
	public void setRouteID(int routeID) {
		RouteID = routeID;
	}
	public String getBusID() {
		return BusID;
	}
	public void setBusID(String busID) {
		BusID = busID;
	}
	public String getCityIDStart() {
		return CityIDStart;
	}
	public void setCityIDStart(String cityIDStart) {
		CityIDStart = cityIDStart;
	}
	public String getCityIDEnd() {
		return CityIDEnd;
	}
	public void setCityIDEnd(String cityIDEnd) {
		CityIDEnd = cityIDEnd;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public Time getDuration() {
		return Duration;
	}
	public void setDuration(Time duration) {
		Duration = duration;
	}
	public int getDistance() {
		return Distance;
	}
	public void setDistance(int distance) {
		Distance = distance;
	}
	public Route(int routeID, String busID, String cityIDStart, String cityIDEnd, int price, Time duration,
			int distance) {
		super();
		RouteID = routeID;
		BusID = busID;
		CityIDStart = cityIDStart;
		CityIDEnd = cityIDEnd;
		Price = price;
		Duration = duration;
		Distance = distance;
	}
	@Override
	public String toString() {
		return "Route [RouteID=" + RouteID + ", BusID=" + BusID + ", CityIDStart=" + CityIDStart + ", CityIDEnd="
				+ CityIDEnd + ", Price=" + Price + ", Duration=" + Duration + ", Distance=" + Distance + "]";
	}
	public Route() {
		super();
		this.RouteID = 0;
	}
	
}
