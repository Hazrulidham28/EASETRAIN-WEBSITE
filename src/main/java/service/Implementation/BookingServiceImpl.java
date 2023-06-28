package service.Implementation;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import java.util.UUID;
import java.sql.PreparedStatement;
import java.util.ArrayList;

import Bean.TrainException;
import Bean.historyBean;
import Constant.ResponseCode;
import Utility.DBUtil;
import service.BookingService;

public class BookingServiceImpl implements BookingService{

	@Override
	public List<historyBean> getAllBookingsByCustomerId(String customerId) throws TrainException {
		List<historyBean> transactions = null;
		String query = "SELECT * FROM RESERVE WHERE EMAIL=?";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			ps.setString(1, customerId);
			ResultSet rs = ps.executeQuery();
			transactions = new ArrayList<historyBean>();
			while (rs.next()) {
				historyBean transaction = new historyBean();
				transaction.setTransId(rs.getString("transId"));
				transaction.setEmail(rs.getString("email"));
				transaction.setTrNo(rs.getString("TrNo"));
				transaction.setDate(rs.getString("date"));
				transaction.setFromStn(rs.getString("fromStn"));
				transaction.setToStn(rs.getString("toStn"));
				transaction.setSeat(rs.getString("seat"));
				transaction.setAmount(rs.getDouble("amount"));
				transaction.setDepTime(rs.getString("DepTime"));
				transaction.setArrTime(rs.getString("ArrTime"));
				transaction.setDuration(rs.getString("duration"));
				transaction.setType(rs.getString("type"));
				
				transactions.add(transaction);
			}

			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return transactions;
	}

	
	@Override
	public historyBean createHistory(historyBean details) throws TrainException {
		historyBean history = null;
		String query = "INSERT INTO RESERVE VALUES(?,?,?,?,?,?,?,?,?,?,?,?)";
		try {
			Connection con = DBUtil.getConnection();
			PreparedStatement ps = con.prepareStatement(query);
			String transactionId = UUID.randomUUID().toString();
			ps.setString(1, transactionId);
			ps.setString(2, details.getEmail());
			ps.setString(3, details.getTrNo());
			ps.setString(4, details.getDate());
			ps.setString(5, details.getFromStn());
			ps.setString(6, details.getToStn());
			ps.setString(7, details.getSeat());
			ps.setDouble(8, details.getAmount());
			ps.setString(9, details.getDepTime());
			ps.setString(10, details.getArrTime());
			ps.setString(11, details.getDuration());
			ps.setString(12, details.getType());
			
			int response = ps.executeUpdate();
			if (response > 0) {
				history = (historyBean) details;
				history.setTransId(transactionId);
			} else {
				throw new TrainException(ResponseCode.INTERNAL_SERVER_ERROR);
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println(e.getMessage());
			throw new TrainException(e.getMessage());
		}
		return history;
	}

	
}
