<%@ page language="java" contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1" %>
    <!DOCTYPE html>
    <html>

    <head>
        <meta charset="ISO-8859-1">
        <title>Add Product</title>

        <link rel="stylesheet" href="https://unpkg.com/boxicons@latest/css/boxicons.min.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/navbar.css">
        <link rel="stylesheet" href="${pageContext.request.contextPath}/View/CSS/AddProduct.css">
        <link rel="preconnect" href="https://fonts.googleapis.com">
        <link rel="preconnect" href="https://fonts.gstatic.com" crossorigin>
        <link
            href="https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap"
            rel="stylesheet">
        <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css"
            integrity="sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ=="
            crossorigin="anonymous" referrerpolicy="no-referrer" />

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
                    <div class="cart">
                        <img src="${pageContext.request.contextPath}/View/Images/shopping-cart.png" alt="">
                    </div>
                    <div class="profile">
                        <a href="${pageContext.request.contextPath}/View/Register.jsp"><img
                                src="${pageContext.request.contextPath}/View/Images/user.png" alt=""></a>
                    </div>
                </div>
            </div>
        </header>
        <section class="admin-header">
            <a href="#">Dashboard</a>
            <a href="#">Add Product</a>
            <a href="#">Edit Product</a>
        </section>
        <form action="../addproduct" method="post" enctype="multipart/form-data">
            <label>Product Name</label>
            <input type='text' name='product_name' placeholder='Enter a product name'>
            <br>

            <label>Product quantity</label>
            <input type='text' name='product_quantity' placeholder='Enter a product quantity'>
            <br>
            <label>Product price</label>
            <input type='text' name='product_price' placeholder='Enter a product price'>
            <br>
            <label>Product Image</label>


            <div class="image-field" id="image-field">

                <img src="${pageContext.request.contextPath}/View/Images/profile-eg.png" class="showImage" width="200px"
                    height="240px">

                <input type="file" id="file" name="image" class="imageChooser" value="profile-eg.png"
                    onchange="onImageChange()" />

                <label for="file" id="upload-btn"><i class='bx bx-cloud-upload'></i>Choose Photo</label>

                <a href="${pageContext.request.contextPath}/index.jsp" class="return">Return to Home</a>

            </div>
            <button type="submit">Submit</button>

        </form>

        <script>
            function onImageChange() {

                var imageChooser = document.querySelector(".imageChooser");
                var showImage = document.querySelector(".showImage");
                showImage.src = URL.createObjectURL(imageChooser.files[0]);
                console.log(imageChooser.files[0]);
                console.log("hello");
            }
        </script>
    </body>
    </html>