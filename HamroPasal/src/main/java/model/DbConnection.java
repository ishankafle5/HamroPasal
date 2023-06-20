package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DbConnection {
	public Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.cj.jdbc.Driver");
		Connection connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/HamroPasal","root","");
		return connection;
	}
	
	public String registerUser(User user) {
		String message;
		try {
			String query="INSERT INTO users (Name, Email, Password, Image) VALUES (?,?,?,?)";
			Connection connection=getConnection();
			PreparedStatement st=connection.prepareStatement(query);
			
			st.setString(1, user.getName());
			st.setString(2, user.getEmail());
			st.setString(3, user.getPassword());
			st.setString(4, user.getImagePath());
			int rows = st.executeUpdate();
			if(rows>=1) {
				message = "Successfully Added";
			}
			else {
				message = "Something is missing";
			}
			connection.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			message = e.getMessage();
		}
		catch(SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}
	
	public ResultSet checkAvailability(String email) {
		String query = "Select * from users where email = ?";
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return data;
	}
	
	public ResultSet checkLoginDetails(String email, String password) {
		try {
			Connection con = getConnection();
			String query = "Select * from users where email =?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			ResultSet table = st.executeQuery();

			if(table.next()) {
				String encryptedPassword = table.getString(4);
				String decryptedPassword = AESEncryption.decrypt(encryptedPassword);
				if(password.equals(decryptedPassword)) {
					return table;
				}
				else {
					return null;
				}
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public User fetchByEmail(String email) {
		Connection con = null;
		User user = null;
		try {
			con = getConnection();
			String query = "Select * from Users where email =?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			ResultSet table = st.executeQuery();
			
			if(table.next()) {
				String name = table.getString(2);
				String email2 = table.getString(3);
				String encryptedPassword = table.getString(4);
				String decryptedPassword = AESEncryption.decrypt(encryptedPassword);
				String imagePath = table.getString(5);
				
				user = new User(name, email2, decryptedPassword, imagePath);
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user;
	}

	public String updateProfile(User user) {
		String message;
		try {
			
			String query="UPDATE users set name=?, password=?, image=? where email = ?";
		
			Connection connection=getConnection();
			
			PreparedStatement st=connection.prepareStatement(query);
			
			st.setString(1, user.getName());
			st.setString(2, user.getPassword());
			st.setString(3, user.getImagePath());
			st.setString(4, user.getEmail());
			
			int rows = st.executeUpdate();
			if(rows>=1) {
				message = "Successfully Added";
			}
			else {
				message = "Something is missing";
			}
			connection.close();
		}
		catch(ClassNotFoundException e){
			e.printStackTrace();
			message = e.getMessage();	
		}
		catch(SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}
	
	public ResultSet adminLogin(String email, String password) {
		try {
			Connection con = getConnection();
			String query = "Select * from admin where email =? and password=?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			st.setString(2, password);
			ResultSet table = st.executeQuery();

			if(table.next()) {
				return table;
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public String addProduct(String name,String productPrice,String quantity,String imagePath) {

		String message = null;
		try {
//			String name = product.getProductName();
//			String quantity = product.getProductQuantity();
//			String productPrice = product.getProductPrice();
//			String imagePath = product.getProductImagePath();
			String query = "INSERT INTO product (product_name, product_price, product_quantity) VALUES ('" + name
					+ "','" + productPrice + "','" + quantity + "');";
			
			Connection connection = getConnection();
			PreparedStatement st;
			st = connection.prepareStatement(query);
			
			int rows = st.executeUpdate();
			if (rows >= 1) {
				String findId = "Select max(product_id) from product;";

				st = connection.prepareStatement(findId);

				ResultSet data = st.executeQuery();
				
				while (data.next()) {
					message = (data.getString(1));
				}
			} else {
				message = "Something is missing";
			}
			connection.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
			message = e.getMessage();
		} catch (SQLException e) {
			e.printStackTrace();
			message = e.getMessage();
		}
		return message;
	}

	public String updateProdutImagePath(String path, String id) throws ClassNotFoundException, SQLException {
		String updateQuery = "Update product set product_image='" + path + "' where product_id='" + id + "';";
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(updateQuery);
		int rows = st.executeUpdate();
		return "Successfully added";
	}
	
	public int getMaxId() {
		Connection con = null;
		ResultSet id = null;
		int order_id = 0;
		try {
			con = getConnection();
			String query = "Select max(Order_Id) from orders";
			PreparedStatement st = con.prepareStatement(query);
			id = st.executeQuery();
			while(id.next()) {
				if(id.getString(1)!=null) {
					order_id = Integer.parseInt(id.getString(1));
				}
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return order_id+1;
	}
	
	public int getUserId(String email) {
		Connection con = null;
		ResultSet id = null;
		int user_id = 0;
		try {
			con = getConnection();
			String query = "Select Id from users where email = ?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, email);
			id = st.executeQuery();
			while(id.next()) {
				user_id = Integer.parseInt(id.getString(1));
			}
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return user_id;
	}
	
	public Product fetchProd(String id) {
		Connection con = null;
		Product product = null;
		try {
			con = getConnection();
			String query = "Select * from Product where product_id =?";
			PreparedStatement st = con.prepareStatement(query);
			st.setString(1, id);
			ResultSet table = st.executeQuery();
			
			if(table.next()) {
				String prod_id = table.getString(1);
				String name = table.getString(2);
				String price = table.getString(3);
				String quantity = table.getString(4);
				String imagePath = table.getString(5);
				
				product = new Product(prod_id, name, price, quantity, imagePath);
			}
			else {
				return null;
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return product;
	}
	
	public ArrayList<Product> fetchProducts() {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection conn = null;
		try {
			conn = getConnection();
			String query = "Select * from product";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet data = st.executeQuery();
			
			while(data.next()) {
				String productId=data.getString(1);
				String productName=data.getString(2);
				String productImagePath=data.getString(3);
				String productQuantity=data.getString(4);
				String productPrice=data.getString(5);
				
				productList.add(new Product(productId, productName, productImagePath, productQuantity, productPrice));
				
			}
			
			return productList;
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Product> searchByName(String name) {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection conn = null;
		try {
			conn = getConnection();
			String query = "Select * from product where Product_Name LIKE '%"+name+"%'";
			PreparedStatement st = conn.prepareStatement(query);
			ResultSet data = st.executeQuery();
			
			while(data.next()) {
				String productId=data.getString(1);
				String productName=data.getString(2);
				String productImagePath=data.getString(3);
				String productQuantity=data.getString(4);
				String productPrice=data.getString(5);
				
				productList.add(new Product(productId, productName, productImagePath, productQuantity, productPrice));
				
			}
			
			return productList;
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public ArrayList<Product> sortBy(String sortBy) {
		ArrayList<Product> productList = new ArrayList<Product>();
		Connection conn = null;
		try {
			conn = getConnection();
			
			if(sortBy.equals("price")) {
				String query = "select * from product order by Product_Price;";
				PreparedStatement st = conn.prepareStatement(query);
				ResultSet data = st.executeQuery();
				while(data.next()) {
					String productId=data.getString(1);
					String productName=data.getString(2);
					String productImagePath=data.getString(3);
					String productQuantity=data.getString(4);
					String productPrice=data.getString(5);
					
					productList.add(new Product(productId, productName, productImagePath, productQuantity, productPrice));
					
				}
				return productList;
			}
			else if(sortBy.equals("sale")) {
				
			}
		} 
		catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
			return null;
		}
		finally{
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return productList;
	}
	
	public ArrayList<Order> fetchOrderList() {
		String query="select orders.Order_Id, product.Product_Id, product.Product_Name, product.Product_Price, users.Email from orders join product on product.Product_Id = orders.Product_Id join users on users.Id = orders.Customer_Id;";
		
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		ArrayList<Order> order=new ArrayList<Order>();
		
		try {
			while (data.next()) {
				String orderId = data.getString(1);
				String productId = data.getString(2);
				String userId = data.getString(3);
				String quantity = data.getString(4);
				String totalPrice = data.getString(5);
				Order neworder = new Order(orderId, productId, userId, quantity, totalPrice);

				order.add(neworder);
			}
			
			return order;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	public Product fetchOneRow(String id) {
		String query = "Select * from product where product_id='" + id + "'";
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.print("His is fetch");
		Product product;
		try {

			while (data.next()) {

				String productId = data.getString(1);
				String productName = data.getString(2);
				String  productQuantity= data.getString(3);
				String productPrice = data.getString(4);
				String productImagePath = data.getString(5);
				System.out.print(productId);
				System.out.print(productName);
				System.out.print(productImagePath);
				System.out.print(productQuantity);
				System.out.print(productPrice);
				product = new Product(id, productName, productQuantity, productPrice, productImagePath);
				return product;

			}

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public Boolean updateProductsData(Product product) throws ClassNotFoundException, SQLException {
		String id=product.getId();
		
		String name=product.getProductName();
		String quantity=product.getProductQuantity();
		String price=product.getProductPrice();
		
//		String updateQuery = "Update products set product_name='" + name + "' and product_quantity='" + quantity + "' and product_price='" + price + "' where product_id='" + id + "';";
		String updateQuery="Update product set product_name='"+name+"', product_quantity='"+quantity+"' , product_price='"+price+"' where product_id='"+id+"'";
		System.out.println(updateQuery);
		Connection con = getConnection();
		PreparedStatement st = con.prepareStatement(updateQuery);
		int rows = st.executeUpdate();
		System.out.print("This is rws:"+rows);
		if(rows>=0) {
			
			return true;
		}
		
		return false;
	}
	
	public String deleteParameter(String id) throws SQLException {
		String query = "Delete from product where product_id='" + id + "';";
		System.out.print(query);
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			int rows = st.executeUpdate();
			return "Successfully Deleted";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	

	public ArrayList<User> fetchUserData() {
		String query="Select * from users";
		
		ResultSet data = null;
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			data = st.executeQuery();
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		
		ArrayList<User> user=new ArrayList<User>();
		
		try {

			while (data.next()) {
				String id = data.getString(1);
				String name = data.getString(2);
				String email = data.getString(3);
				String password = data.getString(4);
				String Image = data.getString(5);
				
				User newuser = new User(name, email, password, Image);
				user.add(newuser);
			}
			return user;


		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		
	}
	
	
	public String deleteUser(String email) {
		String query = "Delete from users where email='" + email + "';";
		System.out.print(query);
		try {
			Connection con = getConnection();
			PreparedStatement st = con.prepareStatement(query);
			int rows = st.executeUpdate();
			return "Successfully Deleted";
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
		// TODO Auto-generated method stub
	}

	
}
