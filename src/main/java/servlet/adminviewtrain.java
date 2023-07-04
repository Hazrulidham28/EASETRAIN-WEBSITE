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
import javax.servlet.http.HttpSession;

import Utility.TrainUtil;

/**
 * Servlet implementation class userviewtrain
 */
@WebServlet("/adminviewtrain")
public class adminviewtrain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	trainService tservice = new trainServiceImpl();

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TrainUtil.validateUserAuthorization(request, userRole.ADMIN);
		
			try {
				List<trainBean> trains = tservice.getAllTrains();
				//request.getSession().setAttribute("trains", trains);
				
				
				if(trains != null && !trains.isEmpty()){
					
					HttpSession session = request.getSession();
					session.setAttribute("trains",trains);
					response.sendRedirect("adminviewtrip.jsp");
					
					
					
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("AccountTest.html");
					rd.include(request, response);
					
				}
				
			}catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			}
	}

	

}
