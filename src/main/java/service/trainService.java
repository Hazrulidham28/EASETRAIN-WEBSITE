package service;

import java.util.List;

import Bean.TrainException;

import Bean.trainBean;

public interface trainService {
	
	public String addTrain(trainBean train);
	public String deleteTrainById(String trainNo);
	public String updateTrain(trainBean train);
	public trainBean getTrainById(String trainNo) throws TrainException;
	
	
	
}
