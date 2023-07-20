package servlet;

import java.io.IOException;
import java.util.*;
import java.text.*;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import Bean.trainBean;
import Constant.userRole;
import service.trainService;
import service.Implementation.trainServiceImpl;
/**
 * Servlet implementation class adminAddTrainServlet
 */
@WebServlet("/adminAddTrainServlet")
public class adminAddTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  

	private trainService trainservice = new trainServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		//call attribure from jsp form
		String trNum=request.getParameter("train_no");
	    String fromStn=request.getParameter("departure_station");
		String toStn=request.getParameter("arrival_station");
		String DepTime=request.getParameter("departure_time");
		String ArrTime=request.getParameter("arrival_time");
	    String duration;
		String type=request.getParameter("type");
		String fare=request.getParameter("fare");
		String date=request.getParameter("date");
		
		System.out.println(trNum);
		System.out.println(date);
		System.out.println(DepTime);
		
		try {
		SimpleDateFormat simpleDateFormat=new SimpleDateFormat("HH:mm");
		Date date1 = simpleDateFormat.parse(DepTime);
        Date date2 = simpleDateFormat.parse(ArrTime);
     // Calculating the difference in milliseconds
        long differenceInMilliSeconds
            = Math.abs(date2.getTime() - date1.getTime());
  
        // Calculating the difference in Hours
        long differenceInHours = (differenceInMilliSeconds / (60 * 60 * 1000)) % 24;
  
        // Calculating the difference in Minutes
        long differenceInMinutes = (differenceInMilliSeconds / (60 * 1000)) % 60;
        
        duration=differenceInHours + "hours " + differenceInMinutes + "min";
       
       
        trainBean train = new trainBean();
			
		train.setTrNo(trNum);
		train.setFromStn(fromStn);
		train.setToStn(toStn);
		train.setDepTime(DepTime);
		train.setArrTime(ArrTime);
		train.setDuration(duration);
		train.setType(type);
		train.setFare(Double.parseDouble(fare));
		train.setDate(date);
		
		String message = trainservice.addTrain(train);
		
			if("SUCCESS".equalsIgnoreCase(message)) {
				RequestDispatcher rd = request.getRequestDispatcher("adminaddtrain.jsp");
				rd.include(request, response);
				
			}else {
				RequestDispatcher rd = request.getRequestDispatcher("adminaddtrain.jsp");
				rd.include(request, response);
				
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
	
			
	
	
	

}
