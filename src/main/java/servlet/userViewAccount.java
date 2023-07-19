package servlet;

import java.io.IOException;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TrainException;
import Bean.customerBean;
import Utility.TrainUtil;

/**
 * Servlet implementation class userViewAccount
 */
@WebServlet("/userViewAccount")
public class userViewAccount extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		customerBean customer = TrainUtil.getCurrentCustomer(request);
		
		ServletContext sct = request.getServletContext();
try {
			
			sct.setAttribute("currentCustomer", customer);
			
			response.sendRedirect("accDetails.jsp");
			
			}
			catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			
	}
		
	}

	

}
