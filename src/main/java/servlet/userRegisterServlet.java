package servlet;

import service.Implementation.userServiceImpl;
import service.userService;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Constant.userRole;
import Bean.customerBean;
import Bean.TrainException;

/**
 * Servlet implementation class userRegisterServlet
 */
@WebServlet("/userRegisterServlet")
public class userRegisterServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * Default constructor.
     */
    public userRegisterServlet() {
        // TODO Auto-generated constructor stub
    }

    private userService userService = new userServiceImpl(userRole.CUSTOMER);


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		
		response.setContentType("text/html");
		PrintWriter pw = response.getWriter();
		try {
		customerBean cust = new customerBean();
		
		cust.setEmail(request.getParameter("email"));
		cust.setIcnum(request.getParameter("Icno"));
		cust.setPass(request.getParameter("pass"));
		cust.setPhoneNum(request.getParameter("phonenum"));
		cust.setUsername(request.getParameter("uname"));
		
		String message = userService.registerUser(cust);
		
			if("SUCCESS".equalsIgnoreCase(message)) {
				
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
				pw.println("<div class='tab'><p1 class='menu'>Successfully Registered !</p1></div>");
			}
			else {
				RequestDispatcher rd = request.getRequestDispatcher("index.html");
				rd.include(request, response);
				
				
				
			}
		}catch (Exception e) {
			throw new TrainException(422, this.getClass().getName() + "_FAILED", e.getMessage());
		}
		
		
	}

}
