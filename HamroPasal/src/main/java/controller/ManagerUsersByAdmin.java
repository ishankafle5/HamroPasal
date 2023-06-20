package controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.DbConnection;

/**
 * Servlet implementation class ManagerUsersByAdmin
 */
@WebServlet("/manageusers")
public class ManagerUsersByAdmin extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		DbConnection conn=new DbConnection();
		ArrayList<model.User> user=conn.fetchUserData();
		for(int i=0;i<user.size();i++) {
//			System.out.print(u);
		}
			request.setAttribute("userList", user);
			RequestDispatcher rd=request.getRequestDispatcher("/View/ManageUsers.jsp");
			rd.forward(request, response);
		
	}


}
