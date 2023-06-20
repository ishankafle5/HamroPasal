package model;

public class Order {
	
	String orderId;
	String productId;
	String productName;
	String userName;
	String priceEach;
	
	public Order(String orderId, String productId,String productName,String userName, String priceEach) {
		
		this.orderId=orderId;
		this.productId=productId;
		this.productName=productName;
		this.userName=userName;
		this.priceEach=priceEach;
	}

	public String getOrderId() {
		return orderId;
	}

	public void setOrderId(String orderId) {
		this.orderId = orderId;
	}

	public String getProductId() {
		return productId;
	}

	public void setProductId(String productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPriceEach() {
		return priceEach;
	}

	public void setPriceEach(String priceEach) {
		this.priceEach = priceEach;
	}
	
	
	
}
