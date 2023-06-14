package service.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import Bean.TrainException;
import Bean.adminBean;

import Constant.ResponseCode;
import Constant.userRole;
import Utility.DBUtil;
import service.adminService;


public class adminServiceImpl implements adminService{
	
	
		//set table name based on uesr's role
		private final String TABLE_NAME;
		//auto set table name
		public adminServiceImpl(userRole userRole) {
			// TODO Auto-generated constructor stub
				//check the condition if the user role iss null then set the user role as admin 
				if(userRole == null) {
					userRole=userRole.ADMIN;
					
					
				}
				this.TABLE_NAME=userRole.toString();
		}
	
	@Override
	public  adminBean loginAdmin(String email, String password) throws TrainException {
		adminBean admin = null;
		// create string query as query for instruction to the database
		String query = "SELECT * FROM"+ TABLE_NAME +" WHERE EMAIL=? AND PASSWORD=?";
		try {
			//establish connection with databse from package util and retrieve thru instantiation 
			//establish connecttion tru DBUtil class 
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, email);
			ps.setString(2, password);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = new adminBean();
				admin.setName(rs.getString("username"));
				admin.setAddress(rs.getString("IcNum"));
				admin.setAdEmail(rs.getString("email"));
				admin.setPhoneNo(rs.getString("phoneNO"));
				admin.setPass(rs.getString("password"));

			} else {
				throw new TrainException(ResponseCode.UNAUTHORIZED);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return admin;
	}

}
