package Bean;

import java.io.Serializable;

public class bookingDetailBean implements Serializable{

	/**
	 * 
	 */
	
	//to create object for history/booking details 
	//easier to store data to database
	
	private static final long serialVersionUID = 1L;
	
		private String transId;
		private String fromStn;//
		private String toStn;//
		private String date;//
		private String depTime;//
		private String arrTime;//
		private String duration;//
		private String type;// gold or plat
		private String email;
		private String trNo;//
		private String seat;
		private double amount;//
		
		public String getTrNo() {
			return trNo;
		}
		public void setTrNo(String trNo) {
			this.trNo = trNo;
		}
		
		
		
		public String getDepTime() {
			return depTime;
		}
		public void setDepTime(String depTime) {
			this.depTime = depTime;
		}
		public String getArrTime() {
			return arrTime;
		}
		public void setArrTime(String arrTime) {
			this.arrTime = arrTime;
		}
		public String getDuration() {
			return duration;
		}
		public void setDuration(String duration) {
			this.duration = duration;
		}
		public String getType() {
			return type;
		}
		public void setType(String type) {
			this.type = type;
		}
		
		
		
		
		public String getTransId() {
			return transId;
		}
		public void setTransId(String transId) {
			this.transId = transId;
		}
		public String getEmail() {
			return email;
		}
		public void setEmail(String email) {
			this.email = email;
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
		public String getSeat() {
			return seat;
		}
		public void setSeat(String seat) {
			this.seat = seat;
		}
		public double getAmount() {
			return amount;
		}
		public void setAmount(double amount) {
			this.amount = amount;
		}
		
		

}
