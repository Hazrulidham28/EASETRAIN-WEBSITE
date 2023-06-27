package service.Implementation;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.ArrayList;

import Bean.TrainException;
import Bean.trainBean;
import Constant.ResponseCode;
import Utility.DBUtil;
import service.trainService;

public class trainServiceImpl implements trainService{

	@Override
	public String addTrain(trainBean train) {
		String responseCode = ResponseCode.FAILURE.toString();
		//query instruction to insert train value 
		String query = "INSERT INTO TRAIN VALUES(?,?,?,?,?,?,?,?)";
		try {
			//establish connection thru DBUtil class
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setNString(1, train.getTrNo());
			ps.setString(2, train.getFromStn());
			ps.setString(3, train.getToStn());
			ps.setString(4, train.getDepTime());
			ps.setString(5, train.getArrTime());
			ps.setString(6, train.getDuration());
			ps.setString(7, train.getType());
			ps.setDouble(8, train.getFare());
			//need to change to execute();
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				//if rs is exists set response code to success
				responseCode = ResponseCode.SUCCESS.toString();
			}
			ps.close();
		} catch (SQLException | TrainException e) {
			responseCode += " : " + e.getMessage();
		}
		//return response code
		return responseCode;
	}
	
	@Override
	public String deleteTrainById(String trainNo) {
		String responseCode = ResponseCode.FAILURE.toString();
		String query = "DELETE FROM TRAIN WHERE trNo=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, trainNo);
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
	public String updateTrain(trainBean train) {
		String responseCode = ResponseCode.FAILURE.toString();
		String query = "UPDATE TRAIN SET TrNo=?, FromStn=?,ToStn=?,depTime=?,arrTime=?, duration=?,type=?,fare=? WHERE TrNo=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, train.getTrNo());
			ps.setString(2, train.getFromStn());
			ps.setString(3, train.getToStn());
			ps.setString(4, train.getDepTime());
			ps.setString(5, train.getArrTime());
			ps.setString(6, train.getDuration());
			ps.setString(7, train.getType());
			ps.setDouble(8, train.getFare());
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				responseCode = ResponseCode.SUCCESS.toString();
			}
			ps.close();
		} catch (SQLException | TrainException e) {
			responseCode += " : " + e.getMessage();
		}
		return responseCode;
	}

	@Override
	public trainBean getTrainById(String trainNo) throws TrainException {
		trainBean train = null;
		String query = "SELECT * FROM TRAIN WHERE TrNo=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, trainNo);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				train = new trainBean();
				train.setTrNo(rs.getString("TrNo"));
				train.setFromStn(rs.getString("FromStn"));
				train.setToStn(rs.getString("ToStn"));
				train.setDepTime(rs.getString("depTime"));
				train.setArrTime(rs.getString("arrTime"));
				train.setDuration(rs.getString("duration"));
				train.setType(rs.getString("type"));
				train.setFare(rs.getDouble("fare"));
				
				
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return train;
	}

	

	
	
}
