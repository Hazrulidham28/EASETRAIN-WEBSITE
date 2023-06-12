package service;

import Bean.TrainException;
import Bean.adminBean;

public interface adminService {
	
	public adminBean loginAdmin(String email, String password) throws TrainException;

}
