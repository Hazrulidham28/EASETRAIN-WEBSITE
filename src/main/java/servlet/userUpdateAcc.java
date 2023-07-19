package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Bean.TrainException;
import service.*;
import service.Implementation.userServiceImpl;
import Bean.customerBean;
import Constant.userRole;
import Utility.TrainUtil;

/**
 * Servlet implementation class userUpdateAcc
 */
@WebServlet("/userUpdateAcc")
public class userUpdateAcc extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private userService userservice = new userServiceImpl(userRole.CUSTOMER);
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		TrainUtil.validateUserAuthorization(request, userRole.CUSTOMER);
		ServletContext sct = request.getServletContext();
			String username=request.getParameter("uname");
			String icnumber=request.getParameter("Icno");
			String email=request.getParameter("email");
			String phoneNo=request.getParameter("phonenum");
			
			//check value in var
			System.out.println(username);
			
			
			
			try {
				customerBean cust=TrainUtil.getCurrentCustomer(request);
				
				cust.setUsername(username);
				cust.setIcnum(icnumber);
				cust.setEmail(email);
				cust.setPhoneNum(phoneNo);
				
				System.out.println("Username in Bean "+cust.getUsername());
				System.out.println("IC in Bean "+cust.getIcnum());
				//pass object to the usersercice method
				String message= userservice.updateUser(cust);
				
				if("SUCCESS".equalsIgnoreCase(message)) {
					
					request.getSession().setAttribute("updateSuccess", 1);
					
					//update current customer in servlet context
					sct.setAttribute(userRole.CUSTOMER.toString(), cust);
					//remove old current customer data
					sct.removeAttribute("currentCustomer");
					response.sendRedirect("userViewAccount");
					
					
					//add session for prompt
				}
				else {
					//set value to 2 if failed
					request.getSession().setAttribute("updateSuccess", 2);
					System.out.println("failed");
					//failed go to home
					//need to update condition for prompt in accDetails.jsp
					response.sendRedirect("userViewAccount");
					
					
					
				}
				
				
				
				
			}catch(Exception e){
				throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());}
	}

}
