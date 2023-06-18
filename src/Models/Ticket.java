package Models;

public class Ticket {
	private int TicketID;
	private int BillID;
	private String SeatNumber;
	private String KindOfTicket;
	private int Price;
	private int TripID;
	public int getTicketID() {
		return TicketID;
	}
	public void setTicketID(int ticketID) {
		TicketID = ticketID;
	}
	public int getBillID() {
		return BillID;
	}
	public void setBillID(int billID) {
		BillID = billID;
	}
	public String getSeatNumber() {
		return SeatNumber;
	}
	public void setSeatNumber(String seatNumber) {
		SeatNumber = seatNumber;
	}
	public String getKindOfTicket() {
		return KindOfTicket;
	}
	public void setKindOfTicket(String kindOfTicket) {
		KindOfTicket = kindOfTicket;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public int getTripID() {
		return TripID;
	}
	public void setTripID(int tripID) {
		TripID = tripID;
	}
	@Override
	public String toString() {
		return "Ticket [TicketID=" + TicketID + ", BillID=" + BillID + ", SeatNumber=" + SeatNumber + ", KindOfTicket="
				+ KindOfTicket + ", Price=" + Price + ", TripID=" + TripID + "]";
	}
	public Ticket(int ticketID, int billID, String seatNumber, String kindOfTicket, int price, int tripID) {
		super();
		TicketID = ticketID;
		BillID = billID;
		SeatNumber = seatNumber;
		KindOfTicket = kindOfTicket;
		Price = price;
		TripID = tripID;
	}
	
}
