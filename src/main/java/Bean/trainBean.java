package Bean;

import java.io.Serializable;

public class trainBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String trNo;
	private String trName;
	private String fromStn;
	private String toStn;
	private int seat;
	private double fare;
	
	public String getTrNo() {
		return trNo;
	}
	public void setTrNo(String trNo) {
		this.trNo = trNo;
	}
	public String getTrName() {
		return trName;
	}
	public void setTrName(String trName) {
		this.trName = trName;
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
	public int getSeat() {
		return seat;
	}
	public void setSeat(int seat) {
		this.seat = seat;
	}
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	

}
