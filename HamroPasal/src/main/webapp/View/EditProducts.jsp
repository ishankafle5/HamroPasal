<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Add Product</title>

	<link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/navb.css">
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
        	<a href="" class="dropbtn section">Category</a>
        	<div class="dropdown-content">
          		<a href="./category?by=price">By Price</a>
          		<a href="./category?by=sale">By Sales</a>
        	</div>
        	
            <script>
    			const select = document.querySelector(".dropbtn")
    			const option = document.querySelector(".dropdown-content")
		        		
		    	select.addEventListener("mouseenter", ()=>{
    				option.style.display = "block";
    				option.style.top="80px";
    				option.style.opacity = "1";
    			})
    			option.addEventListener("mouseleave", ()=>{
    				option.style.top="-20%";
    				option.style.opacity = "0";
    			})
			</script>
	
            <form action="${pageContext.request.contextPath}/search" class="search-bar">
                <input type="text" name = "item-name" class="search-field" placeholder="Search this Website" onclick="searchClicked()">
                <input type="submit" id="search">
                <label for="search"><i class='bx bx-search-alt-2'></i></label>
            </form>
            <script>
            	const searchClicked = ()=>{
            		document.querySelector(".search-result").style.top="70px";
            		document.querySelector(".search-result").style.opacity="1";
            	}
            </script>
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
    <hr>
    
    <div class="add-product-form">
        <form action="updateproductData" method="post" enctype="multipart/form-data">
            <div class="top">
                <div class="left2">
               	 	<span>
                        <label for="prod-name">Product Id:</label><br>
                        <input type="text" placeholder="Product Name" id="prod-name" value="${productDetails.id}" name="product_id" required readonly>
                    </span>
                    <span>
                        <label for="prod-name">Product Name:</label><br>
                        <input type="text" placeholder="Product Name" id="prod-name" value="${productDetails.productName}" name="product_name" required>
                    </span>
    
                    <span>
                        <label for="prod-price">Product Price:</label><br>
                        <input type="number" placeholder="Product Price" id="prod-price"  value="${productDetails.productPrice}" name='product_price' required>
                    </span>
    
                    <span>
                        <label for="prod-quantity">Product Quantity:</label><br>
                        <input type="number" placeholder="Product Quantity" id="prod-quantity" value="${productDetails.productQuantity}"  name='product_quantity' required>
                    </span>
                </div>
                <div class="right2">
                    <label for="prod-image" class="img-section">
                        <img src="Images/${productDetails.productImagePath}" alt="Images/${productDetails.productImagePath}" class="showImage">
                    </label>
                    <input type="file" id = "prod-image file" name="image" class="imageChooser" value ="profile-eg.png" onchange="onImageChange()"/>
                </div>
            </div>
            <div class="bottom">
                <button type="submit" value="Add Product">Update Product</button>
                <a href="#">Cancle</a>
                
            </div>
        </form>
    </div>
    <script>
		function onImageChange(){
			var imageChooser = document.querySelector(".imageChooser");
			var showImage = document.querySelector(".showImage");
			showImage.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
</body>
</html>