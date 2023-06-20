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

@WebServlet("/category")
public class Category extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		DbConnection con = new DbConnection();
		String sortBy = req.getParameter("by");
		ArrayList<Product> productList = con.sortBy(sortBy);
		RequestDispatcher rd = req.getRequestDispatcher("View/CategoryPage.jsp");
		req.setAttribute("productList", productList);
		try {
			rd.forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}