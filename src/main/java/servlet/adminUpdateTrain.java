package servlet;

import java.io.IOException;

import service.trainService;
import service.Implementation.trainServiceImpl;
import javax.servlet.http.*;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TrainException;
import Bean.trainBean;

/**
 * Servlet implementation class adminUpdateTrain
 */
@WebServlet("/adminUpdateTrain")
public class adminUpdateTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       trainService trainservice = new trainServiceImpl();
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		
		ServletContext sct = request.getServletContext();
		String trno=request.getParameter("train");
		sct.setAttribute("updateTrNo", trno);
		
		try {
		//get train by using train number at trainservice
		trainBean trainupdate=trainservice.getTrainById(trno);
		//test data to console
		System.out.println(trainupdate.getFromStn());
		
		sct.setAttribute("updateTrain" ,trainupdate);
		response.sendRedirect("updateTrainpage.jsp");
		
		}
		catch(Exception e) {
			
			throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
		}
		
	}

}
