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
 * Servlet implementation class userloginServlet
 */
@WebServlet("/userloginServlet")
public class userloginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public userloginServlet() {
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
		
		//request email and password from user login html page
		String email=request.getParameter("email");
		String pass=request.getParameter("pass");
		
			//get response message
		
			String msg= TrainUtil.login(request, response, userRole.CUSTOMER, email, pass);
			
				//check if user has authenticate
				if(ResponseCode.SUCCESS.toString().equalsIgnoreCase(msg)) {
					RequestDispatcher rd = request.getRequestDispatcher("Homepage.html");
					rd.include(request, response);
					
					pw.println("<div class='div' style='color: white;'><p class='menu'>Successfully Login !</p></div>");
					
					
					
				}
				else {
					//return back to login page
					RequestDispatcher rd = request.getRequestDispatcher("StartUp.html");
					rd.include(request, response);
					pw.println("<div class='div' style='color: white;'><p class='menu'>Wrong email or password !</p></div>");
					
				}
	}

}
