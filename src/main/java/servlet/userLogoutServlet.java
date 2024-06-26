package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import Constant.userRole;
import Utility.TrainUtil;

/**
 * Servlet implementation class userLogoutServlet
 */
@WebServlet("/userLogoutServlet")
public class userLogoutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		
		response.setContentType("text/html");
		if(TrainUtil.isLoggedIn(request, userRole.CUSTOMER)) {
			
			//call logout
			TrainUtil.logout(response);
			
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
		}
		else {
			//else also redirect to index page
			RequestDispatcher rd=request.getRequestDispatcher("index.html");
			rd.include(request, response);
			
		}
	}

	

}
