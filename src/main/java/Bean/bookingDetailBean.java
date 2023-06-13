package Bean;

import java.io.Serializable;

public class bookingDetailBean implements Serializable{

	/**
	 * 
	 */
	
	//to create object for history/booking details 
	//easier to store data to database
	
	private static final long serialVersionUID = 1L;
	
		private String userName;
		private String icNum;
		private String phoneNum;
		private String fromStn;
		private String toStn;
		private String date;
		private int seat;
		private double amount;
		
		public String getUserName() {
			return userName;
		}
		public void setUserName(String userName) {
			this.userName = userName;
		}
		public String getIcNum() {
			return icNum;
		}
		public void setIcNum(String icNum) {
			this.icNum = icNum;
		}
		public String getPhoneNum() {
			return phoneNum;
		}
		public void setPhoneNum(String phoneNum) {
			this.phoneNum = phoneNum;
		}
		public String getFromStn() {
			return fromStn;
		}
		public void setFromStn(String fromStn) {
			this.fromStn = fromStn;
		}
		public String getToStn() {
			return toStn;
		}
		public void setToStn(String toStn) {
			this.toStn = toStn;
		}
		public String getDate() {
			return date;
		}
		public void setDate(String date) {
			this.date = date;
		}
		public int getSeat() {
			return seat;
		}
		public void setSeat(int seat) {
			this.seat = seat;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		

}
