package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TrainException;
import Bean.trainBean;
import Constant.userRole;
import Utility.TrainUtil;
import service.trainService;
import service.Implementation.trainServiceImpl;

/**
 * Servlet implementation class adminCreateUpdate
 */
@WebServlet("/adminCreateUpdate")
public class adminCreateUpdate extends HttpServlet {
	private static final long serialVersionUID = 1L;
	trainService tservice = new trainServiceImpl();

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TrainUtil.validateUserAuthorization(request, userRole.ADMIN);
		
		ServletContext sct = request.getServletContext();
		
		trainBean train= new trainBean();
		//call updated data from html
		String trNum=request.getParameter("train_no");
	    String fromStn=request.getParameter("departure_station");
		String toStn=request.getParameter("arrival_station");
		String DepTime=request.getParameter("departure_time");
		String ArrTime=request.getParameter("arrival_time");
	    String duration=request.getParameter("duration");
		String type=request.getParameter("type");
		String fare=request.getParameter("fare");
		String date=request.getParameter("date");
		
		
        
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
        
		train.setTrNo(trNum);
        train.setFromStn(fromStn);
        train.setToStn(toStn);
        train.setDepTime(DepTime);
        train.setArrTime(ArrTime);
        train.setDuration(duration);
        train.setType(type);
        train.setFare(Double.parseDouble(fare));
        train.setDate(date);
        
        
        String updateNo=(String)sct.getAttribute("updateTrNo");
        
        String message = tservice.updateTrain(train,updateNo);
        sct.removeAttribute("updateTrNo");
        	if("SUCCESS".equalsIgnoreCase(message)) {
        		
        		
        		response.sendRedirect("adminviewtrain");
        		sct.removeAttribute("updateTrain");
        		
        		
        	}else {
        		response.sendRedirect("AdminHome.html");
        		
        		
        	}
        	
        }catch(Exception e) {
        	
        	throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
        	
        }
	

}}
