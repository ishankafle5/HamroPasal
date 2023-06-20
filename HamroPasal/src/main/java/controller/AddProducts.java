package controller;

import java.io.IOException;

import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

//import model.AESEncryption;
import model.DbConnection;
import model.Product;

@WebServlet("/addproduct")
@MultipartConfig
public class AddProducts extends HttpServlet {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public void service(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException {
		String prduct_name = request.getParameter("product_name");
		String product_price = request.getParameter("product_price");
		String product_quantity = request.getParameter("product_quantity");

		String productImagePath = "img";

//		 = new Product(0,prduct_name, product_price, product_quantity, productImagePath);
		DbConnection con = new DbConnection();

		String message = con.addProduct(prduct_name,product_price,product_quantity,productImagePath);

		System.out.println("Error is ;"+message);

		String localimagepath = "productImage/" + message + ".png";
		Part image = request.getPart("image");
		String imagePath = getServletContext().getInitParameter("imagePath");
		String finalPath = imagePath + localimagepath;
		image.write(finalPath);
//		response.sendRedirect("index.jsp");
		
		
//		System.out.print("Pth i ...."+localimagepath+".....");
//		Part image = request.getPart("image");
//		System.out.print(request.getPart("image"));
//		String imagePath = getServletContext().getInitParameter("productImage");
//		String finalPath = imagePath + localimagepath;
//		System.out.print(finalPath);
//		image.write(finalPath);

		String msg;
		try {
			msg = con.updateProdutImagePath(localimagepath, message);
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		Product product= new Product(message,prduct_name, product_price, product_quantity,localimagepath);
		System.out.println(product.getProductImagePath());
		System.out.println(product.getProductName());
		System.out.println(product.getProductPrice());
		System.out.println(product.getProductQuantity());
		
		response.sendRedirect("./View/AdminPage.jsp");
	}
}