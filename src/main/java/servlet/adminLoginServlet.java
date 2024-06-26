package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Constant.ResponseCode;
import Constant.userRole;
import Utility.TrainUtil;

/**
 * Servlet implementation class adminLoginServlet
 */
@WebServlet("/adminLoginServlet")
public class adminLoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public adminLoginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter pw=response.getWriter();
		response.setContentType("text/html");
		
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
			
			//msg to gain response code for login
			String msg= TrainUtil.adminlogin(request, response, userRole.ADMIN, email, pass);
			
				//check if user has authenticate
				if(ResponseCode.SUCCESS.toString().equalsIgnoreCase(msg)) {
					
					response.sendRedirect("adminviewtrain");
					//print div class to inform that login is successfull
					pw.println("<div class='div' style='color: white;'><p class='menu'>Successfully Login !</p></div>");
					
					
					
				}
				else {
					//redirect to adminlogin.html
					RequestDispatcher rd = request.getRequestDispatcher("AdminLogin.html");
					rd.include(request, response);
					//print div class to inform unsuccessfull of login 
					pw.println("<div class='div' style='color: white;'><p class='menu'>Wrong email or password !</p></div>");
					
				}
	}

}
