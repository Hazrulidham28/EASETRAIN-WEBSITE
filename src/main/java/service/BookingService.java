package service;

import java.util.List;

import Bean.TrainException;
import Bean.historyBean;

public interface BookingService {

	public List<historyBean> getAllBookingsByCustomerId(String customerEmailId) throws TrainException;

	public historyBean createHistory(historyBean bookingDetails) throws TrainException;
}
