package servlet;

import service.*;
import service.Implementation.trainServiceImpl;
import Constant.*;
import Bean.TrainException;
import Bean.trainBean;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Utility.TrainUtil;

/**
 * Servlet implementation class userviewtrain
 */
@WebServlet("/userviewtrain")
public class userviewtrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	trainService tservice = new trainServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		
			try {
				List<trainBean> trains = tservice.getAllTrains();
				request.getSession().setAttribute("trains", trains);
				
				pw.println();
				if(trains != null && !trains.isEmpty()){
					
					RequestDispatcher rd = request.getRequestDispatcher("Buyticket.jsp");
					rd.include(request, response);
					rd.forward(request, response);
					
						for(trainBean train: trains) {
							
							pw.println("<table>");
					        pw.println("<tr>");
					        pw.println("<td><input type=\"checkbox\" name=\"train\" value=\""+train.getTrNo()+"\">"+train.getTrNo()+"</td>");
					        pw.println("<td>"+train.getDate()+"</td>");
					        pw.println("<td>"+train.getFromStn()+"</td>");
					        pw.println("<td>"+train.getToStn()+"</td>");
					        pw.println("<td>"+train.getDepTime()+"</td>");
					        pw.println("<td>"+train.getArrTime()+"</td>");
					        pw.println("<td>"+train.getDuration()+"</td>");
					        pw.println("<td>"+train.getType()+"</td>");
					        pw.println("<td>"+train.getFare()+"</td>");
					        pw.println("</tr>");
						}
					
				}else{}
				
			}catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			}
	}

	

}
