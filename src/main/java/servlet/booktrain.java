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
 * Servlet implementation class booktrain
 */
@WebServlet("/booktrain")
public class booktrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	trainService train= new trainServiceImpl();
   

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		
		try {
		
		String TrNo=request.getParameter("train");
		System.out.println(TrNo);
		
		
		trainBean trains =train.getTrainById(TrNo);
		ServletContext sct = request.getServletContext();
		System.out.println(trains.getFromStn());
		
		//store train obj to servlet context for temporary
		sct.setAttribute("trainBook", trains);
		response.sendRedirect("seatingPage.jsp");
		}
		catch(Exception e){
			
			throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
		}
		
		
		
		
		
		
	}

}
