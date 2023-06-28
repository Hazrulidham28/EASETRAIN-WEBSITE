package servlet;

import java.io.IOException;

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
 * Servlet implementation class seatingServlet
 */
@WebServlet("/seatingServlet")
public class seatingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	trainService train= new trainServiceImpl();


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html");
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		
		try {
			
			String Seat=request.getParameter("btn");
			System.out.println(Seat);
			
			
			}
			catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			
	}
	}
}


