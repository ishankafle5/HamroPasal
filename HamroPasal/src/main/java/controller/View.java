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

@WebServlet("/landing")
public class View extends HttpServlet{
	public void service(HttpServletRequest req, HttpServletResponse res) {
		DbConnection con = new DbConnection();
		ArrayList<Product> productList = con.fetchProducts();
		System.out.print("iiofas"+productList);
		RequestDispatcher rd = req.getRequestDispatcher("View/Landing.jsp");
		req.setAttribute("productList", productList);
		try {
			rd.forward(req, res);
		} catch (ServletException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
