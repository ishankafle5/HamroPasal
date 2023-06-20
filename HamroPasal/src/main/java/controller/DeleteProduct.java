package controller;

import java.awt.Window;

import java.io.IOException;
import java.sql.SQLException;
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
 * Servlet implementation class DeleteProduct
 */
@WebServlet("/deleteproducts")
public class DeleteProduct extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String id=request.getParameter("id");
		DbConnection con=new DbConnection();
		try {
			String msg=con.deleteParameter(id);
			if(msg==null) {
				System.out.print("THis message is nulllllllllllllll");
			}
			else {
				System.out.print(msg);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		response.sendRedirect("View/manageproducts.jsp");
		ArrayList<Product> product = new DbConnection().fetchProducts();
		request.setAttribute("productList",product);
		RequestDispatcher rd = request.getRequestDispatcher("View/ManageProduct.jsp");
		rd.forward(request, response);

//		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

}
