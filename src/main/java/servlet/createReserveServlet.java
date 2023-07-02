package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.*;
import Bean.TrainException;
import Constant.userRole;
import Utility.TrainUtil;
import service.BookingService;
import service.Implementation.BookingServiceImpl;

/**
 * Servlet implementation class createReserveServlet
 */
@WebServlet("/createReserveServlet")
public class createReserveServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    private BookingService booking = new BookingServiceImpl();
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter pw = response.getWriter();
		response.setContentType("text/html");
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		
		ServletContext sct = request.getServletContext();
		
		try {
			
			customerBean user =(customerBean) sct.getAttribute("currCust");
			trainBean train= (trainBean)sct.getAttribute("trainBook");
			String seat=(String)sct.getAttribute("seat");
			//String userIc =(String) request.getSession().getAttribute("mailid");
				
				//store to historybean
				historyBean book= new historyBean();
				book.setFromStn(train.getFromStn());
				book.setToStn(train.getToStn());
				book.setDate(train.getDate());
				book.setDepTime(train.getDepTime());
				book.setArrTime(train.getArrTime());
				book.setDuration(train.getDuration());
				book.setType(train.getType());
				book.setIcNo(user.getIcnum());
				book.setTrNo(train.getTrNo());
				book.setSeat(seat);
				book.setAmount(train.getFare());
				
				//save data to reservation
				historyBean reservation= booking.createHistory(book);
				
				response.sendRedirect("userviewtrain");
			}
			catch(Exception e){
				
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
			
			}
		
	}

}
