package Models;

import java.sql.Date;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;

public class Trip {
	private int TripID;
	private int RouteID;
	private LocalTime TimeStart;
	private LocalTime TimeEnd;
	private LocalDate DateStart;
	private LocalDate DateEnd;
	public int getTripID() {
		return TripID;
	}
	public void setTripID(int tripID) {
		TripID = tripID;
	}
	public int getRouteID() {
		return RouteID;
	}
	public void setRouteID(int routeID) {
		RouteID = routeID;
	}
	public LocalTime getTimeStart() {
		return TimeStart;
	}
	public void setTimeStart(LocalTime timeStart) {
		TimeStart = timeStart;
	}
	public LocalTime getTimeEnd() {
		return TimeEnd;
	}
	public void setTimeEnd(LocalTime timeEnd) {
		TimeEnd = timeEnd;
	}
	public LocalDate getDateStart() {
		return DateStart;
	}
	public void setDateStart(LocalDate dateStart) {
		DateStart = dateStart;
	}
	public LocalDate getDateEnd() {
		return DateEnd;
	}
	public void setDateEnd(LocalDate dateEnd) {
		DateEnd = dateEnd;
	}
	@Override
	public String toString() {
		return "Trip [TripID=" + TripID + ", RouteID=" + RouteID + ", TimeStart=" + TimeStart + ", TimeEnd=" + TimeEnd
				+ ", DateStart=" + DateStart + ", DateEnd=" + DateEnd + "]";
	}
	public Trip(int tripID, int routeID, LocalTime timeStart, LocalTime timeEnd, LocalDate dateStart, LocalDate dateEnd) {
		super();
		TripID = tripID;
		RouteID = routeID;
		TimeStart = timeStart;
		TimeEnd = timeEnd;
		DateStart = dateStart;
		DateEnd = dateEnd;
	}
	public Trip() {
		super();
	}
	
	public static LocalTime getTimeEnd(LocalTime TimeStart, LocalTime Duration)
	{
		LocalTime TimeEnd = null;
		
		int minutes = TimeStart.getMinute() + Duration.getMinute();
		
		int hour = TimeStart.getHour() + Duration.getHour();
		
		if(minutes>=60)
		{
			hour ++;
			minutes -= 60;
		}
		
		while(hour>=24)
		{
			hour -= 24;
		}
		
		TimeEnd = LocalTime.of(hour, minutes);
		
		return TimeEnd;
	}
	
	public static LocalDate getDateEnd(LocalTime TimeStart, LocalTime Duration, LocalDate DateStart)
	{
		LocalDate DateEnd = null;
		
		int minutes = TimeStart.getMinute() + Duration.getMinute();
		
		int hour = TimeStart.getHour() + Duration.getHour();
		
		int date = DateStart.getDayOfMonth();
		int month = DateStart.getMonthValue();
		int year = DateStart.getYear();
		
		if(minutes>=60)
		{
			hour ++;
			minutes -= 60;
		}
		
		while(hour>=24)
		{
			hour -= 24;
			date ++;
			
			if(date>myDate.getNumberDateOfMonth(month, year))
			{
				date -= myDate.getNumberDateOfMonth(month, year);
				month ++;
				if(month>12)
				{
					month = 1;
					year ++;
				}
			}
		}
		
		DateEnd =LocalDate.of(year, month, date);
		
		return DateEnd;
	}
}
