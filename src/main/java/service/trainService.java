package service;

import java.util.List;

import Bean.TrainException;

import Bean.trainBean;
//method for train service to add delete and update
//need more update..
public interface trainService {
	
	public String addTrain(trainBean train);
	public String deleteTrainById(String trainNo);
	public String updateTrain(trainBean train);
	public trainBean getTrainById(String trainNo) throws TrainException;
	public List<trainBean> getAllTrains() throws TrainException;
	
	
}
