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
import Bean.bookingDetailBean;
import Bean.customerBean;
import Bean.historyBean;
import Bean.trainBean;
import service.*;
import service.Implementation.BookingServiceImpl;
import Constant.userRole;
import Utility.TrainUtil;

/**
 * Servlet implementation class userviewRecord
 */
@WebServlet("/userviewRecord")
public class userviewRecord extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   BookingService book = new BookingServiceImpl();

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		

		try {
			
			HttpSession session = request.getSession();
			customerBean cust= TrainUtil.getCurrentCustomer(request);
			
			//get all booking made by customer using icnumber
			
			List<historyBean> booking = book.getAllBookingsByCustomerId(cust.getIcnum());
			
			
			if(booking != null && !booking.isEmpty()){
				
				
				session.setAttribute("booklist",booking);
				response.sendRedirect("ticketRecord.jsp");
				
				
				
			}else{
				response.sendRedirect("userviewtrain");
				
				
			}
			
		}catch(Exception e){
			
			throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
		}
		
		
	}

	
}
