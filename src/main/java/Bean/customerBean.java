package Bean;

import java.io.Serializable;

public class customerBean implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	private String username;
	private String icnum;
	private String email;
	private String phoneNum;
	private String pass;
	private String profilePic;
	private double walletBal;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getIcnum() {
		return icnum;
	}
	public void setIcnum(String icnum) {
		this.icnum = icnum;
	}
	public String getProfilePic() {
		return profilePic;
	}
	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}
	public double getWalletBal() {
		return walletBal;
	}
	public void setWalletBal(double walletBal) {
		this.walletBal = walletBal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public String getPass() {
		return pass;
	}
	public void setPass(String pass) {
		this.pass = pass;
	}
	
}
