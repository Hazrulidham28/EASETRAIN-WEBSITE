package service;

import Bean.TrainException;
import Bean.adminBean;
//method for admin login
public interface adminService {
	
	public adminBean loginAdmin(String email, String password) throws TrainException;

}
