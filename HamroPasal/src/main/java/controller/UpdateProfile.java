package controller;

import java.io.IOException;
import java.sql.ResultSet;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import model.AESEncryption;
import model.DbConnection;
import model.User;

@WebServlet("/updateProfile")
@MultipartConfig
public class UpdateProfile extends HttpServlet{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String name = request.getParameter("name");
		String email = request.getParameter("email");
		String password = request.getParameter("password");
		String confirmPassword = request.getParameter("confirm-password");

		String encryptedPassword = AESEncryption.encrypt(password);
		String userImagePath = "userImage/"+email+".png";
		
		
		User user = new User(name, email, encryptedPassword, userImagePath);
		DbConnection con = new DbConnection();
		if(password.equals(confirmPassword)) {
			String message = con.updateProfile(user);
			Part image = request.getPart("image");
			if(message.equals("Successfully Added") && image != null && image.getInputStream().available()>0) {
				String imagePath = getServletContext().getInitParameter("imagePath");
				String finalPath = imagePath + userImagePath;
				image.write(finalPath);
				try {
					Thread.sleep(5000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			response.sendRedirect("./index.jsp");
		}
		else {
			String[] arr = email.split("@");
			String a = arr[0];
			String b = arr[1];
			String encodedEmail = a+"\\@"+b;
			String path = "/editProfile?"+encodedEmail;
			RequestDispatcher rd = request.getRequestDispatcher(path);
			request.setAttribute("passMsg", "Please enter same password in both field.");
			try {
				rd.forward(request, response);
			} catch (ServletException | IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
