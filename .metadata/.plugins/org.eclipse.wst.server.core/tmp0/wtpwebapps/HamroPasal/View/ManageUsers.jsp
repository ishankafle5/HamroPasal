<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
  <%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
      <%@ page import="java.util.Date" %>
  
    <!DOCTYPE html>
    <html>

    <head>
      <meta charset="UTF-8">
      <title>Insert title here</title>
      <style>
        .product-table {
          border-collapse: separate;
          border-spacing: 0;
          width: 100%;
          margin-top: 20px;
          border: 1px solid #ddd;
          border-radius: 5px;
          box-shadow: 0 0 10px rgba(0, 0, 0, 0.1);
        }

        .product-table th,
        .product-table td {
          padding: 12px 15px;
          text-align: left;
        }

        .product-table th {
          background-color: #0077cc;
          color: #fff;
          text-transform: uppercase;
          font-size: 14px;
          font-weight: 700;
          letter-spacing: 1px;
        }

        .product-table td {
          background-color: #f9f9f9;
          font-size: 14px;
          font-weight: 400;
          color: #555;
          border-top: 1px solid #ddd;
        }

        .product-table tr:hover {
          background-color: #f5f5f5;
        }

        .product-table img {
          max-width: 100px;
          max-height: 100px;
          display: block;
          margin: 0 auto;
        }

        .product-table a {
          color: #0077cc;
          text-decoration: none;
          margin-right: 10px;
        }

        .product-table a:hover {
          text-decoration: underline;
        }

        .product-table tr:nth-child(even) {
          background-color: #f5f5f5;
        }
      </style>
    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/navbar.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/AddProduct.css">
    <link rel="preconnect" href="https://fonts.googleapis.com">
    <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
    <link href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap" rel="stylesheet">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css" integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==" crossorigin="anonymous" referrerpolicy="no-referrer" />
      
    </head>

    <body>
    	 
	<header>
        <span class="logo">Hamro&nbsp;Pasal</span>
        <div class="right">
            <select name="category" id="category">
                <option value="all">Categories</option>
                <option value="shirt">Shirt</option>
                <option value="pants">Pants</option>
                <option value="shoes">Shoes</option>
            </select>
            <form action="" class="search-bar">
                <input type="text" class="search-field" placeholder="Search this Website">
                <input type="submit" id="search">
                <label for="search"><i class='bx bx-search-alt-2'></i></label>
            </form>
            <div class="icons">
                <div class="cart" onclick="cartClicked()">
                    <img src="${pageContext.request.contextPath}/View/Images/shopping-cart.png" alt="">
                </div>
                <div class="profile" onclick="profileClicked()">
                    <img src="${pageContext.request.contextPath}/View/Images/user.png" alt="">
                </div>
            </div>
        </div>
        <div class="profile-section">
        	<div class="top">
                <h1>User Profile</h1>
                <i class='bx bxl-xing' onclick="profileClicked()"></i>
            </div>
        	<% String email = null;
        	if(session.getAttribute("loggedInId") == null){ 
        	%>
            	<div class="middle">
	                <a href="${pageContext.request.contextPath}/View/AdminLogin.jsp">Login as Admin</a>
                	<a href="${pageContext.request.contextPath}/View/Login.jsp">Login as User</a>
        	<%} else{
        		email = session.getAttribute("loggedInId").toString();
        	%>
        		<h1>You are Logged In as <%= email %></h1>
        		<%if(session.getAttribute("adminEmail") != null){%>
        			<a href="${pageContext.request.contextPath}/index.jsp">Return to Home</a><br/>
        			<a href="${pageContext.request.contextPath}/View/AdminPage.jsp">Admin Page</a><br/>
        		<%}%>
        		
        		<%if(session.getAttribute("adminEmail") == null && session.getAttribute("loggedInId") != null){%>
         			<a href="${pageContext.request.contextPath}/editProfile?email=<%=email%> class="edit-profile-btn">Edit Profile</a><br/>
 
        		<%}%>
        		
        		<a href="${pageContext.request.contextPath}/logout">Log Out</a>
        	<%} %>
        	</div>
        </div>
        
        <div class="cart-section">
        	<div class="top">
                <h1>Cart Items</h1>
                <i class='bx bxl-xing' onclick="profileClicked()"></i>
            </div>
        	<div class="middle" id="middle">
				<div class="item">
					<img src="${pageContext.request.contextPath}/images/productImage/10.png"/>
					<span>
						<h3>Black Shirt</h3>
						<p>Price: 999</p>
					</span>
				</div>
            </div>
        	<div class="lower">
        		<span><p class="index">Total Price: </p><p class="total-price"></p></span>
        		<a href="" id = "order" onclick="clicked()">Order Now!</a>
        	</div>
        </div>
        <script>
            const profileClicked = () =>{
                const btn = document.querySelector(".profile")
                const mainDiv = document.querySelector(".profile-section")
                const cross = document.querySelector(".profile-section .top i")
                btn.addEventListener("click", ()=>{
                    mainDiv.classList.add("active");
                })
                cross.addEventListener("click", ()=>{
                    mainDiv.classList.remove("active");
                })
            }
            
            const cartClicked = () =>{
            	<%if(session.getAttribute("adminEmail") == null && session.getAttribute("loggedInId") != null){ %>
                const btn = document.querySelector(".cart")
                const mainDiv = document.querySelector(".cart-section")
                const cross = document.querySelector(".cart-section .top i")
                btn.addEventListener("click", ()=>{
                    mainDiv.classList.add("active");
                })
                cross.addEventListener("click", ()=>{
                    mainDiv.classList.remove("active");
                })
                
                
                let cartDisplay = document.getElementById("middle");
				let totalPriceDisp = document.querySelector(".lower .total-price");
                // Create an empty string to store the HTML content
                let cartHtml = "";
				let totalPrice = 0;
                // Loop through the cart object and generate HTML for each item
                cartItems.forEach((item) => {
                  cartHtml += `
                	<div class="item">
  						<img src=/HamroPasal/Images/`+item.image+`?v=${time}/>
  						<span>
  							<h3>`+item.name+`</h3>
	  						<p>Price: Rs. `+item.price+`</p>
	  					</span>
  					</div>
                  `;
                  totalPrice += parseInt(item.price);
                })
                // Set the innerHTML of the cart display element to the generated HTML content
                cartDisplay.innerHTML = cartHtml;
                totalPriceDisp.innerText = totalPrice;
                <%}else{%>
                	window.location.href = "./View/Login.jsp"
                <%}%>
            }
            
        </script>
    </header>
    <hr>
    <section class="admin-header" style="margin:10px 0">
    	<a href="${pageContext.request.contextPath}/View/AdminPage.jsp">Dashboard</a>
    	<a href="${pageContext.request.contextPath}/manageusers">Manage Users</a>
    	<a href="${pageContext.request.contextPath}/View/AddProduct.jsp">Add Product</a>
    	<a href="${pageContext.request.contextPath}/manageproducts">Edit Product</a>
    </section>
      <h1>Manage Users Here</h1>
      <div style="padding:50px;">
        <table class="product-table">
          <tr>          
            <th>User Name</th>
            <th>User Email</th>
            <th>User Image</th>
            <th>Delete</th>
          </tr>
          <c:forEach var="st" items="${userList}">
            <tr>
              <td>${st.name}</td>
              <td>${st.email}</td>
              <td><img src="Images/${st.imagePath}" alt="Images/${st.imagePath}" height="100px" width="100px"></td>
              <td>
                <div style="margin:10px;">
                </div>
                <div style="margin:10px;">
                  <a href="${pageContext.request.contextPath}/deleteuser?email=${st.email}">Delete</a>
                </div>
              </td>
            </tr>
          </c:forEach>
        </table>
      </div>
      <script>

      </script>
    </body>

    </html>