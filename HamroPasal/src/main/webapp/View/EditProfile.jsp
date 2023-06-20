
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@page import = "java.util.Date"%>

<!DOCTYPE html>
<html lang="en">

<head>
    <meta charset="UTF-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Document</title>

    <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
    <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/register.css">
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css">
</head>

<body>
	<c:set var = "time" value="<%=new Date().getTime() %>"/>
    <section class="sign-up" >
        <form action="${pageContext.request.contextPath}/updateProfile" method="POST" enctype="multipart/form-data">
            <div class="input-field">
                <h1>Edit Profile</h1>
                
                <span class="name">
                    <label for="name"><i class='bx bx-child'></i></label>
                    <input type="text" id="name" name="name" placeholder="Enter Full Name" required value="${user.name}">
                    <p>Name:</p>
                </span>
                <span class="email">
                    <label for="email"><i class='bx bxl-gmail'></i></label>
                    <input type="email" id="email" name="email"placeholder="Your Email Address" value="${user.email}"readonly>
                    <p>Email:</p>
                </span>
                <% if(request.getAttribute("emailMsg") != null){ %>
					<p class="message" style="color: red;margin-left: 70px;width: 300px;"><%= request.getAttribute("emailMsg")%></p>
				<%} %>
                <span class="password">
                    <label for="password"><i class='bx bx-dialpad-alt'></i></label>
                    <input type="text" id="password" name="password" placeholder="Enter Password" required value="${user.password}">
                    <p>Password:</p>
                </span>
                <span class="confirm-password">
                    <label for="confirm-password"><i class='bx bxs-key'></i></label>
                    <input type="text" name="confirm-password" id="confirm-password" placeholder="Re-Enter Password" required value="${user.password}">
                    <p>Confirm:</p>
                </span>
				<% if(request.getAttribute("passMsg") != null){ %>
					<p class="message" style="color: red;margin-left: 70px;width: 300px;"><%= request.getAttribute("passMsg")%></p>
				<%} %>
                <br>
                <input type="submit" value="Update">
            </div>

            <div class="image-field" id="image-field">
                <img src="${pageContext.request.contextPath}/userImage/11@11.png?v=${time}" class="showImage" width="200px" height="200px">
				<input type="file" id = "file" name="image" class="imageChooser" onchange="onImageChange()"/>
                <label for="file" id="upload-btn"><i class='bx bx-cloud-upload'></i>Choose Photo</label>
                <a href="${pageContext.request.contextPath}/index.jsp" class="return">Return to Home</a>
            </div>
        </form>
    </section>
    <script>
		function onImageChange(){
			var imageChooser = document.querySelector(".imageChooser");
			var showImage = document.querySelector(".showImage");
			showImage.src = URL.createObjectURL(imageChooser.files[0]);
		}
	</script>
</body>

</html>