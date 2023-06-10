package service;

import java.util.List;

import Bean.TrainException;
import Bean.customerBean;

public interface userService {

	public customerBean getUserByEmailId(String userEmailId) throws TrainException;

	public List<customerBean> getAllUsers() throws TrainException;

	public String updateUser(customerBean customer);

	public String deleteUser(customerBean customer);

	public String registerUser(customerBean customer);
	
	public customerBean loginUser(String username, String password) throws TrainException;
	
}
