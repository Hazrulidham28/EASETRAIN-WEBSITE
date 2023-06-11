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
		String query = "INSERT INTO TRAIN VALUES(?,?,?,?,?,?)";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setNString(1, train.getTrName());
			ps.setString(2, train.getTrName());
			ps.setString(3, train.getFromStn());
			ps.setString(4, train.getToStn());
			ps.setLong(5, train.getSeat());
			ps.setDouble(6, train.getFare());
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
		String query = "UPDATE TRAIN SET TrName=?, FromStn=?,ToStn=?,seats=?,fare=? WHERE TrNo=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, train.getTrName());
			ps.setString(2, train.getFromStn());
			ps.setString(3, train.getToStn());
			ps.setLong(4, train.getSeat());
			ps.setDouble(5, train.getFare());
			ps.setString(6, train.getTrNo());
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
				train.setFare(rs.getDouble("fare"));
				train.setFromStn(rs.getString("FromStn"));
				train.setToStn(rs.getString("ToStn"));
				train.setTrName(rs.getString("TrName"));
				train.setTrNo(rs.getString("TrNo"));
				train.setSeat(rs.getInt("seats"));
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return train;
	}

	@Override
	public List<trainBean> getAllTrains() throws TrainException {
		List<trainBean> trains = null;
		String query = "SELECT * FROM TRAIN";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ResultSet rs = ps.executeQuery();
			trains = new ArrayList<trainBean>();
			while (rs.next()) {
				trainBean train = new trainBean();
				train.setFare(rs.getDouble("fare"));
				train.setFromStn(rs.getString("FromStn"));
				train.setToStn(rs.getString("ToStn"));
				train.setTrName(rs.getString("Trname"));
				train.setTrNo(rs.getString("TrNo"));
				train.setSeat(rs.getInt("seats"));
				trains.add(train);
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return trains;
	}

	@Override
	public List<trainBean> getTrainsBetweenStations(String fromStation, String toStation) throws TrainException {
		List<trainBean> trains = null;
		String query = "SELECT * FROM TRAIN WHERE ";

		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, "%" + fromStation + "%");
			ps.setString(2, "%" + toStation + "%");
			ResultSet rs = ps.executeQuery();
			trains = new ArrayList<trainBean>();
			while (rs.next()) {
				trainBean train = new trainBean();
				train.setFare(rs.getDouble("fare"));
				train.setFromStn(rs.getString("FromStn"));
				train.setToStn(rs.getString("ToStn"));
				train.setTrName(rs.getString("TrName"));
				train.setTrNo(rs.getString("TrNo"));
				train.setSeat(rs.getInt("seats"));
				trains.add(train);
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return trains;
	}
	
}
