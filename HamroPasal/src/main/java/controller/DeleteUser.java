package controller;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbConnection;

/**
 * Servlet implementation class DeleteUser
 */
@WebServlet("/deleteuser")
public class DeleteUser extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String email=request.getParameter("email");
		DbConnection con=new DbConnection();
		String msg=con.deleteUser(email);
		if(msg==null) {
			System.out.print("THis message is nulllllllllllllll");
		}
		else {
			System.out.print(msg);
		}
		response.sendRedirect("manageusers");
	}
}
