package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.DbConnection;

@WebServlet("/login")
public class Login extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		
		DbConnection con = new DbConnection();
		ResultSet record = con.checkLoginDetails(email, password);
		
		if(record != null) {
			HttpSession session = request.getSession();
			session.removeAttribute("adminEmail");
			session.setAttribute("loggedInId", email);
			session.setMaxInactiveInterval(5*60);
			
			response.sendRedirect("index.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("StudentProfile.jsp");
//			request.setAttribute("table", record);
//			request.setAttribute("id", id );
//			request.setAttribute("name", name );
//			request.setAttribute("gender", gender );
//			rd.forward(request, response);
			
		}
		else {
			response.setContentType("text/html");
			response.sendRedirect("View/Login.jsp");
//			RequestDispatcher rd = request.getRequestDispatcher("Login.jsp");
//			request.setAttribute("LoginMessage", "Failed");
//			rd.forward(request, response);
		}
	}
}
