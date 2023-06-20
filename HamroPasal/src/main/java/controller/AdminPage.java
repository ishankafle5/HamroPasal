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
 * Servlet implementation class AdminPage
 */
@WebServlet("/admin-page")
public class AdminPage extends HttpServlet {
	public void service(HttpServletRequest request, HttpServletResponse response) {
		DbConnection con = new DbConnection();
		ArrayList<model.Order> order=con.fetchOrderList();
		for(model.Order neworder:order) {
		System.out.println(neworder.getOrderId()+" "+neworder.getProductId()+" "+neworder.getUserName()+" "+neworder.getProductName()+" "+neworder.getPriceEach());
		}
		request.setAttribute("orderList", order);
		RequestDispatcher rd= request.getRequestDispatcher("View/AdminPage.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}

}
