package controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.mysql.cj.Session;

import model.DbConnection;
import model.Product;

@WebServlet("/order")
public class Order extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) {
		String items = request.getParameter("items");
		items = items.substring(0, items.length() - 1);
		String[] orderItems = items.split(":");
		System.out.println(Arrays.toString(orderItems));
		DbConnection con = new DbConnection();
		Connection conn = null;
		PreparedStatement st = null;
		String query = "";
		
		int order_id = con.getMaxId();
		ArrayList<Product> orderedItems = new ArrayList<Product>();
		
		HttpSession session = request.getSession();
		int user_id = con.getUserId(session.getAttribute("loggedInId").toString());

		try {
			conn = con.getConnection();
			query =  "INSERT INTO orders (Order_Id, Product_Id, Customer_Id, Price_Each) VALUES (?,?,?,?)";
			st = conn.prepareStatement(query);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(int i = 0; i<orderItems.length; i++) {
			Product orderedProd = con.fetchProd(orderItems[i]);
			orderedItems.add(orderedProd);
		}
		
		
		for(int i = 0; i<orderedItems.size(); i++) {
			try {
				st.setString(1, Integer.toString(order_id));
				st.setString(2, orderedItems.get(i).getId());
				st.setString(3, Integer.toString(user_id));
				st.setString(4, orderedItems.get(i).getProductPrice());
				st.executeUpdate();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		try {
			response.sendRedirect("./index.jsp");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
