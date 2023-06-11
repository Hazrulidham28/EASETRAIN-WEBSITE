package service.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Bean.TrainException;
import Bean.customerBean;
import Constant.ResponseCode;
import Constant.userRole;
import Utility.DBUtil;
import service.userService;

public class userServiceImpl implements userService {
	
	private final String TABLE_NAME;

	public userServiceImpl(userRole userRole) {
		// TODO Auto-generated constructor stub
		
			if(userRole == null) {
				userRole=userRole.CUSTOMER;
				
				
			}
			this.TABLE_NAME=userRole.toString();
	}

	@Override
	public customerBean getUserByEmailId(String customerEmailId) throws TrainException {
		customerBean customer = null;
		String query = "SELECT * FROM CUSTOMER WHERE Email=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerEmailId);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new customerBean();
				customer.setUsername(rs.getString("username"));
				customer.setIcnum(rs.getString("IcNum"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNum(rs.getString("phoneNum"));
				customer.setPass(rs.getString("pass"));
			} else {
				throw new TrainException(ResponseCode.NO_CONTENT);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return customer;
	}

	@Override
	public List<customerBean> getAllUsers() throws TrainException {
		List<customerBean> customers = null;
		String query = "SELECT * FROM  CUSTOMER";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			customers = new ArrayList<customerBean>();
			while (rs.next()) {
				customerBean customer = new customerBean();
				customer.setUsername(rs.getString("username"));
				customer.setIcnum(rs.getString("IcNum"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNum(rs.getString("phoneNum"));
				customer.setPass(rs.getString("pass"));
				customers.add(customer);
			}

			if (customers.isEmpty()) {
				throw new TrainException(ResponseCode.NO_CONTENT);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return customers;
	}

	@Override
	public String updateUser(customerBean customer) {
		String responseCode = ResponseCode.FAILURE.toString();
		String query = "UPDATE CUSTOMER SET ICNUM=?,USERNAME=?,EMAIL=?,PHONENO=? WHERE EMAIL=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customer.getUsername());
			ps.setString(2, customer.getIcnum());
			ps.setString(3, customer.getEmail());
			ps.setNString(4, customer.getPhoneNum());
			ps.setString(5, customer.getPass());
			int response = ps.executeUpdate();
			if (response > 0) {
				responseCode = ResponseCode.SUCCESS.toString();
			}
			ps.close();
		} catch (SQLException | TrainException e) {
			responseCode += " : " + e.getMessage();
		}
		return responseCode;
	}

	@Override
	public String deleteUser(customerBean customer) {
		String responseCode = ResponseCode.FAILURE.toString();
		String query = "DELETE FROM CUSTOMER WHERE MAILID=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customer.getEmail());

			int response = ps.executeUpdate();
			if (response > 0) {
				responseCode = ResponseCode.SUCCESS.toString();
			}
			ps.close();
		} catch (SQLException | TrainException e) {
			responseCode += " : " + e.getMessage();
		}
		return responseCode;
	}

	@Override
	public String registerUser(customerBean customer) {
		String responseCode = ResponseCode.FAILURE.toString();
		String query = "INSERT INTO customer VALUES(?,?,?,?,?)";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			
			ps.setString(1, customer.getIcnum());
			ps.setString(2, customer.getUsername());
			ps.setString(3, customer.getEmail());
			ps.setString(4,customer.getPhoneNum());
			ps.setString(5,customer.getPass());
			int i = ps.executeUpdate();
			if (i>0) {
				responseCode = ResponseCode.SUCCESS.toString();
			}
			ps.close();
		} catch (SQLException | TrainException e) {
			if (e.getMessage().toUpperCase().contains("ORA-00001")) {
				responseCode += " : " + "User With Id: " + customer.getEmail() + " is already registered ";
			} else {
				responseCode += " : " + e.getMessage();
			}
		}
		return responseCode;
	}

	@Override
	public customerBean loginUser(String email, String password) throws TrainException {
		customerBean customer = null;
		String query = "SELECT * FROM CUSTOMER WHERE EMAIL=? AND PASSWORD=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				customer = new customerBean();
				customer.setUsername(rs.getString("username"));
				customer.setIcnum(rs.getString("IcNum"));
				customer.setEmail(rs.getString("email"));
				customer.setPhoneNum(rs.getString("phoneNO"));
				customer.setPass(rs.getString("password"));

			} else {
				throw new TrainException(ResponseCode.UNAUTHORIZED);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return customer;
	}
	
}
