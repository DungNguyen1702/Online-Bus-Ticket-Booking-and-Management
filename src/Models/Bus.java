package Models;

public class Bus {
	private	String BusID;
	private int NumberOfSeat;
	private String KindOfBus;
	public String getBusID() {
		return BusID;
	}
	public void setBusID(String busID) {
		BusID = busID;
	}
	public int getNumberOfSeat() {
		return NumberOfSeat;
	}
	public void setNumberOfSeat(int numberOfSeat) {
		NumberOfSeat = numberOfSeat;
	}
	public String getKindOfBus() {
		return KindOfBus;
	}
	public void setKindOfBus(String kindOfBus) {
		KindOfBus = kindOfBus;
	}
	public Bus(String busID, int numberOfSeat, String kindOfBus) {
		super();
		BusID = busID;
		NumberOfSeat = numberOfSeat;
		KindOfBus = kindOfBus;
	}
	@Override
	public String toString() {
		return "Bus [BusID=" + BusID + ", NumberOfSeat=" + NumberOfSeat + ", KindOfBus=" + KindOfBus + "]";
	}
}
