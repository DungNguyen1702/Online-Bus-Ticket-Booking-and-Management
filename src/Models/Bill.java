package Models;

import java.sql.Date;
import java.time.LocalDate;

public class Bill {
	private int BillID;
	private int CustomerID;
	private String PaymentMethod;
	private String Status;
	private String KindOfBook;
	private LocalDate BookDate;
	private int InfoID;
	private int TotalPrice;
	public int getBillID() {
		return BillID;
	}
	public void setBillID(int billID) {
		BillID = billID;
	}
	public int getCustomerID() {
		return CustomerID;
	}
	public void setCustomerID(int customerID) {
		CustomerID = customerID;
	}
	public String getPaymentMethod() {
		return PaymentMethod;
	}
	public void setPaymentMethod(String paymentMethod) {
		PaymentMethod = paymentMethod;
	}
	public String getStatus() {
		return Status;
	}
	public void setStatus(String status) {
		Status = status;
	}
	public String getKindOfBook() {
		return KindOfBook;
	}
	public void setKindOfBook(String kindOfBook) {
		KindOfBook = kindOfBook;
	}
	public LocalDate getBookDate() {
		return BookDate;
	}
	public void setBookDate(LocalDate bookDate) {
		BookDate = bookDate;
	}
	public int getInfoID() {
		return InfoID;
	}
	public void setInfoID(int infoID) {
		InfoID = infoID;
	}
	public int getTotalPrice() {
		return TotalPrice;
	}
	public void setTotalPrice(int totalPrice) {
		TotalPrice = totalPrice;
	}
	public Bill(int billID, int customerID, String paymentMethod, String status, String kindOfBook, LocalDate bookDate,
			int infoID, int totalPrice) {
		super();
		BillID = billID;
		CustomerID = customerID;
		PaymentMethod = paymentMethod;
		Status = status;
		KindOfBook = kindOfBook;
		BookDate = bookDate;
		InfoID = infoID;
		TotalPrice = totalPrice;
	}
	@Override
	public String toString() {
		return "Bill [BillID=" + BillID + ", CustomerID=" + CustomerID + ", PaymentMethod=" + PaymentMethod
				+ ", Status=" + Status + ", KindOfBook=" + KindOfBook + ", BookDate=" + BookDate + ", InfoID=" + InfoID
				+ ", TotalPrice=" + TotalPrice + "]";
	}
}
