package controller;

import java.io.IOException;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.AESEncryption;
import model.DbConnection;
import model.User;

@WebServlet("/editProfile")
public class EditProfile extends HttpServlet{
	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String email = request.getParameter("email");
		
		DbConnection con = new DbConnection();
		User data = con.fetchByEmail(email);
		
		RequestDispatcher rd = request.getRequestDispatcher("View/EditProfile.jsp");
		request.setAttribute("user", data);
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
//		String password = request.getParameter("password");
//		String confirmPassword = request.getParameter("confirm-password");
//
//		String encryptedPassword = AESEncryption.encrypt(password);
//		String userImagePath = "userImage/"+email+".png";
//		
//		User user = new User(name, email, encryptedPassword, userImagePath);
//		DbConnection con = new DbConnection();
//		ResultSet data = con.checkAvailability(email);
//		
//		try {
//			if(!data.next()) {
//				if(password.equals(confirmPassword)) {
//					String message = con.registerUser(user);
//					if(message.equals("Successfully Added")) {
//						Part image = request.getPart("image");
//						String imagePath = getServletContext().getInitParameter("imagePath");
//						String finalPath = imagePath + userImagePath;
//						image.write(finalPath);
//						response.sendRedirect("index.jsp");
//					}	
//				}
//				else {
//					RequestDispatcher rd = request.getRequestDispatcher("/View/Register.jsp");
//					request.setAttribute("passMsg", "Please enter same password in both field.");
//					try {
//						rd.forward(request, response);
//					} catch (ServletException | IOException e) {
//						// TODO Auto-generated catch block
//						e.printStackTrace();
//					}
//				}
//			}
//			else {
//				RequestDispatcher rd = request.getRequestDispatcher("/View/Register.jsp");
//				request.setAttribute("emailMsg", "'"+email+"'"+" is already registered");
//				try {
//					rd.forward(request, response);
//				} catch (ServletException | IOException e) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//			}
//		} catch (SQLException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
	}
}
