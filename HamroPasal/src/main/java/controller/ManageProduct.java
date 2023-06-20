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
import model.Product;

/**
 * Servlet implementation class ViewProducts
 */
@WebServlet("/manageproducts")
public class ManageProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
   

	public void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ArrayList<Product> product = null;
		
		product=new DbConnection().fetchProducts();
		request.setAttribute("productList",product);
		RequestDispatcher rd = request.getRequestDispatcher("View/ManageProduct.jsp");
		rd.forward(request, response);
		
	}
	

}
