package servlet;

import service.trainService;
import service.Implementation.trainServiceImpl;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TrainException;
import Constant.userRole;
import Utility.TrainUtil;

/**
 * Servlet implementation class adminDeleteTrain
 */
@WebServlet("/adminDeleteTrain")
public class adminDeleteTrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private trainService trainservice = new trainServiceImpl();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		
		String trno=request.getParameter("train");
		
		System.out.println(trno);
		
		try {
			
			String message = trainservice.deleteTrainById(trno);
			
				if("SUCCESS".equalsIgnoreCase(message)) {
					
					
					response.sendRedirect("adminviewtrain");
					
				}
				else {
					response.sendRedirect("AdminHome.html");
				}
			
			
			
			
		}catch(Exception e) {
			throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
		}
	}

}
