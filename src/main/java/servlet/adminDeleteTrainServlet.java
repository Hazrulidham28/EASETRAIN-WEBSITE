package servlet;

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

import Bean.TrainException;
import Bean.trainBean;
import Constant.userRole;
import Utility.TrainUtil;
import service.trainService;
import service.Implementation.trainServiceImpl;

/**
 * Servlet implementation class adminDeleteTrainServlet
 */
@WebServlet("/adminDeleteTrainServlet")
public class adminDeleteTrainServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	trainService tservice = new trainServiceImpl();
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TrainUtil.validateUserAuthorization(request, userRole.ADMIN);
		
			try {
				List<trainBean> trains = tservice.getAllTrains();
				//request.getSession().setAttribute("trains", trains);
					trainBean train1= trains.get(0);
					//System.out.println(train1.getTrNo());
					
				
				if(trains != null && !trains.isEmpty()){
					
					HttpSession session = request.getSession();
					session.setAttribute("trains",trains);
					response.sendRedirect("adminDeleteTrain.jsp");
					
					
				}else{
					RequestDispatcher rd = request.getRequestDispatcher("AccountTest.html");
					rd.include(request, response);
					
				}
				
			}catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			}
	}
	

}
