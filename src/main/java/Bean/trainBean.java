package Bean;

import java.io.Serializable;

public class trainBean implements Serializable{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String trNo;
	private String fromStn;
	private String toStn;
	private String DepTime;
	private String ArrTime;
	private String duration;
	private String type;
	private double fare;
	
	public String getDepTime() {
		return DepTime;
	}
	public void setDepTime(String depTime) {
		DepTime = depTime;
	}
	public String getArrTime() {
		return ArrTime;
	}
	public void setArrTime(String arrTime) {
		ArrTime = arrTime;
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
	
	
	public String getTrNo() {
		return trNo;
	}
	public void setTrNo(String trNo) {
		this.trNo = trNo;
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
	
	public double getFare() {
		return fare;
	}
	public void setFare(double fare) {
		this.fare = fare;
	}
	
	

}
