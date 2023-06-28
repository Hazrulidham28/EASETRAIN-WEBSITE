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
import Constant.userRole;
import Utility.TrainUtil;

/**
 * Servlet implementation class userPaymentServlet
 */
@WebServlet("/userPaymentServlet")
public class userPaymentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		ServletContext sct = request.getServletContext();
		customerBean cust= TrainUtil.getCurrentCustomer(request);
		
		
try {
			
			System.out.println(cust.getEmail());
			sct.setAttribute("currCust", cust);
			
			response.sendRedirect("Payment.jsp");
			//then go to servlet create booking history
			}
			catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			
	}
	}

	

}
