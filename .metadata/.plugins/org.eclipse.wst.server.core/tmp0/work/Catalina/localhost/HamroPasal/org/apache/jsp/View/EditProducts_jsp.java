/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.0.36
 * Generated at: 2023-05-07 19:39:03 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.View;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;

public final class EditProducts_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = null;
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
        throws java.io.IOException, javax.servlet.ServletException {

final java.lang.String _jspx_method = request.getMethod();
if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSPs only permit GET POST or HEAD");
return;
}

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html; charset=ISO-8859-1");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta charset=\"ISO-8859-1\">\r\n");
      out.write("<title>Add Product</title>\r\n");
      out.write("\r\n");
      out.write("\t<link rel=\"stylesheet\" href=\"https://unpkg.com/boxicons@latest/css/boxicons.min.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/CSS/navb.css\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/CSS/AddProduct.css\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.googleapis.com\">\r\n");
      out.write("    <link rel=\"preconnect\" href=\"https://fonts.gstatic.com\" crossorigin>\r\n");
      out.write("    <link href=\"https://fonts.googleapis.com/css2?family=Mochiy+Pop+One&family=Poppins:wght@100;200;300;400;500;600;700;800;900&display=swap\" rel=\"stylesheet\">\r\n");
      out.write("    <link rel=\"stylesheet\" href=\"https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.3.0/css/all.min.css\" integrity=\"sha512-SzlrxWUlpfuzQ+pcUCosxcglQRNAq/DZjVsC0lE40xsADsfeQoEypE+enwcOiGjk/bSuGGKHEyjSoQ1zVisanQ==\" crossorigin=\"anonymous\" referrerpolicy=\"no-referrer\" />\r\n");
      out.write("\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\t<header>\r\n");
      out.write("        <span class=\"logo\">Hamro&nbsp;Pasal</span>\r\n");
      out.write("        <div class=\"right\">\r\n");
      out.write("            <select name=\"category\" id=\"category\">\r\n");
      out.write("                <option value=\"all\">Categories</option>\r\n");
      out.write("                <option value=\"shirt\">Shirt</option>\r\n");
      out.write("                <option value=\"pants\">Pants</option>\r\n");
      out.write("                <option value=\"shoes\">Shoes</option>\r\n");
      out.write("            </select>\r\n");
      out.write("            <form action=\"\" class=\"search-bar\">\r\n");
      out.write("                <input type=\"text\" class=\"search-field\" placeholder=\"Search this Website\">\r\n");
      out.write("                <input type=\"submit\" id=\"search\">\r\n");
      out.write("                <label for=\"search\"><i class='bx bx-search-alt-2'></i></label>\r\n");
      out.write("            </form>\r\n");
      out.write("            <div class=\"icons\">\r\n");
      out.write("                <div class=\"cart\" onclick=\"cartClicked()\">\r\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/Images/shopping-cart.png\" alt=\"\">\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"profile\" onclick=\"profileClicked()\">\r\n");
      out.write("                    <img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/Images/user.png\" alt=\"\">\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <div class=\"profile-section\">\r\n");
      out.write("        \t<div class=\"top\">\r\n");
      out.write("                <h1>User Profile</h1>\r\n");
      out.write("                <i class='bx bxl-xing' onclick=\"profileClicked()\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("        \t");
 String email = null;
        	if(session.getAttribute("loggedInId") == null){ 
        	
      out.write("\r\n");
      out.write("            \t<div class=\"middle\">\r\n");
      out.write("\t                <a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/AdminLogin.jsp\">Login as Admin</a>\r\n");
      out.write("                \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/Login.jsp\">Login as User</a>\r\n");
      out.write("        \t");
} else{
        		email = session.getAttribute("loggedInId").toString();
        	
      out.write("\r\n");
      out.write("        \t\t<h1>You are Logged In as ");
      out.print( email );
      out.write("</h1>\r\n");
      out.write("        \t\t");
if(session.getAttribute("adminEmail") != null){
      out.write("\r\n");
      out.write("        \t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/index.jsp\">Return to Home</a><br/>\r\n");
      out.write("        \t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/AdminPage.jsp\">Admin Page</a><br/>\r\n");
      out.write("        \t\t");
}
      out.write("\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t");
if(session.getAttribute("adminEmail") == null && session.getAttribute("loggedInId") != null){
      out.write("\r\n");
      out.write("         \t\t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/editProfile?email=");
      out.print(email);
      out.write(" class=\"edit-profile-btn\">Edit Profile</a><br/>\r\n");
      out.write(" \r\n");
      out.write("        \t\t");
}
      out.write("\r\n");
      out.write("        \t\t\r\n");
      out.write("        \t\t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/logout\">Log Out</a>\r\n");
      out.write("        \t");
} 
      out.write("\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        \r\n");
      out.write("        <div class=\"cart-section\">\r\n");
      out.write("        \t<div class=\"top\">\r\n");
      out.write("                <h1>Cart Items</h1>\r\n");
      out.write("                <i class='bx bxl-xing' onclick=\"profileClicked()\"></i>\r\n");
      out.write("            </div>\r\n");
      out.write("        \t<div class=\"middle\" id=\"middle\">\r\n");
      out.write("\t\t\t\t<div class=\"item\">\r\n");
      out.write("\t\t\t\t\t<img src=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/images/productImage/10.png\"/>\r\n");
      out.write("\t\t\t\t\t<span>\r\n");
      out.write("\t\t\t\t\t\t<h3>Black Shirt</h3>\r\n");
      out.write("\t\t\t\t\t\t<p>Price: 999</p>\r\n");
      out.write("\t\t\t\t\t</span>\r\n");
      out.write("\t\t\t\t</div>\r\n");
      out.write("            </div>\r\n");
      out.write("        \t<div class=\"lower\">\r\n");
      out.write("        \t\t<span><p class=\"index\">Total Price: </p><p class=\"total-price\"></p></span>\r\n");
      out.write("        \t\t<a href=\"\" id = \"order\" onclick=\"clicked()\">Order Now!</a>\r\n");
      out.write("        \t</div>\r\n");
      out.write("        </div>\r\n");
      out.write("        <script>\r\n");
      out.write("            const profileClicked = () =>{\r\n");
      out.write("                const btn = document.querySelector(\".profile\")\r\n");
      out.write("                const mainDiv = document.querySelector(\".profile-section\")\r\n");
      out.write("                const cross = document.querySelector(\".profile-section .top i\")\r\n");
      out.write("                btn.addEventListener(\"click\", ()=>{\r\n");
      out.write("                    mainDiv.classList.add(\"active\");\r\n");
      out.write("                })\r\n");
      out.write("                cross.addEventListener(\"click\", ()=>{\r\n");
      out.write("                    mainDiv.classList.remove(\"active\");\r\n");
      out.write("                })\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("            const cartClicked = () =>{\r\n");
      out.write("            \t");
if(session.getAttribute("adminEmail") == null && session.getAttribute("loggedInId") != null){ 
      out.write("\r\n");
      out.write("                const btn = document.querySelector(\".cart\")\r\n");
      out.write("                const mainDiv = document.querySelector(\".cart-section\")\r\n");
      out.write("                const cross = document.querySelector(\".cart-section .top i\")\r\n");
      out.write("                btn.addEventListener(\"click\", ()=>{\r\n");
      out.write("                    mainDiv.classList.add(\"active\");\r\n");
      out.write("                })\r\n");
      out.write("                cross.addEventListener(\"click\", ()=>{\r\n");
      out.write("                    mainDiv.classList.remove(\"active\");\r\n");
      out.write("                })\r\n");
      out.write("                \r\n");
      out.write("                \r\n");
      out.write("                let cartDisplay = document.getElementById(\"middle\");\r\n");
      out.write("\t\t\t\tlet totalPriceDisp = document.querySelector(\".lower .total-price\");\r\n");
      out.write("                // Create an empty string to store the HTML content\r\n");
      out.write("                let cartHtml = \"\";\r\n");
      out.write("\t\t\t\tlet totalPrice = 0;\r\n");
      out.write("                // Loop through the cart object and generate HTML for each item\r\n");
      out.write("                cartItems.forEach((item) => {\r\n");
      out.write("                  cartHtml += `\r\n");
      out.write("                \t<div class=\"item\">\r\n");
      out.write("  \t\t\t\t\t\t<img src=/HamroPasal/Images/`+item.image+`?v=");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${time}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/>\r\n");
      out.write("  \t\t\t\t\t\t<span>\r\n");
      out.write("  \t\t\t\t\t\t\t<h3>`+item.name+`</h3>\r\n");
      out.write("\t  \t\t\t\t\t\t<p>Price: Rs. `+item.price+`</p>\r\n");
      out.write("\t  \t\t\t\t\t</span>\r\n");
      out.write("  \t\t\t\t\t</div>\r\n");
      out.write("                  `;\r\n");
      out.write("                  totalPrice += parseInt(item.price);\r\n");
      out.write("                })\r\n");
      out.write("                // Set the innerHTML of the cart display element to the generated HTML content\r\n");
      out.write("                cartDisplay.innerHTML = cartHtml;\r\n");
      out.write("                totalPriceDisp.innerText = totalPrice;\r\n");
      out.write("                ");
}else{
      out.write("\r\n");
      out.write("                \twindow.location.href = \"./View/Login.jsp\"\r\n");
      out.write("                ");
}
      out.write("\r\n");
      out.write("            }\r\n");
      out.write("            \r\n");
      out.write("        </script>\r\n");
      out.write("    </header>\r\n");
      out.write("    <hr>\r\n");
      out.write("    <section class=\"admin-header\" style=\"margin:10px 0\">\r\n");
      out.write("    \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/AdminPage.jsp\">Dashboard</a>\r\n");
      out.write("    \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/manageusers\">Manage Users</a>\r\n");
      out.write("    \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/View/AddProduct.jsp\">Add Product</a>\r\n");
      out.write("    \t<a href=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${pageContext.request.contextPath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("/manageproducts\">Edit Product</a>\r\n");
      out.write("    </section>\r\n");
      out.write("    <hr>\r\n");
      out.write("    \r\n");
      out.write("    <div class=\"add-product-form\">\r\n");
      out.write("        <form action=\"updateproductData\" method=\"post\" enctype=\"multipart/form-data\">\r\n");
      out.write("            <div class=\"top\">\r\n");
      out.write("                <div class=\"left2\">\r\n");
      out.write("               \t \t<span>\r\n");
      out.write("                        <label for=\"prod-name\">Product Id:</label><br>\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Product Name\" id=\"prod-name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productDetails.id}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"product_id\" required readonly>\r\n");
      out.write("                    </span>\r\n");
      out.write("                    <span>\r\n");
      out.write("                        <label for=\"prod-name\">Product Name:</label><br>\r\n");
      out.write("                        <input type=\"text\" placeholder=\"Product Name\" id=\"prod-name\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productDetails.productName}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name=\"product_name\" required>\r\n");
      out.write("                    </span>\r\n");
      out.write("    \r\n");
      out.write("                    <span>\r\n");
      out.write("                        <label for=\"prod-price\">Product Price:</label><br>\r\n");
      out.write("                        <input type=\"number\" placeholder=\"Product Price\" id=\"prod-price\"  value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productDetails.productPrice}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" name='product_price' required>\r\n");
      out.write("                    </span>\r\n");
      out.write("    \r\n");
      out.write("                    <span>\r\n");
      out.write("                        <label for=\"prod-quantity\">Product Quantity:</label><br>\r\n");
      out.write("                        <input type=\"number\" placeholder=\"Product Quantity\" id=\"prod-quantity\" value=\"");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productDetails.productQuantity}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\"  name='product_quantity' required>\r\n");
      out.write("                    </span>\r\n");
      out.write("                </div>\r\n");
      out.write("                <div class=\"right2\">\r\n");
      out.write("                    <label for=\"prod-image\" class=\"img-section\">\r\n");
      out.write("                        <img src=\"Images/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productDetails.productImagePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" alt=\"Images/");
      out.write((java.lang.String) org.apache.jasper.runtime.PageContextImpl.proprietaryEvaluate("${productDetails.productImagePath}", java.lang.String.class, (javax.servlet.jsp.PageContext)_jspx_page_context, null));
      out.write("\" class=\"showImage\">\r\n");
      out.write("                    </label>\r\n");
      out.write("                    <input type=\"file\" id = \"prod-image file\" name=\"image\" class=\"imageChooser\" value =\"profile-eg.png\" onchange=\"onImageChange()\"/>\r\n");
      out.write("                </div>\r\n");
      out.write("            </div>\r\n");
      out.write("            <div class=\"bottom\">\r\n");
      out.write("                <button type=\"submit\" value=\"Add Product\">Update Product</button>\r\n");
      out.write("                <a href=\"#\">Cancle</a>\r\n");
      out.write("                \r\n");
      out.write("            </div>\r\n");
      out.write("        </form>\r\n");
      out.write("    </div>\r\n");
      out.write("    <script>\r\n");
      out.write("\t\tfunction onImageChange(){\r\n");
      out.write("\t\t\tvar imageChooser = document.querySelector(\".imageChooser\");\r\n");
      out.write("\t\t\tvar showImage = document.querySelector(\".showImage\");\r\n");
      out.write("\t\t\tshowImage.src = URL.createObjectURL(imageChooser.files[0]);\r\n");
      out.write("\t\t}\r\n");
      out.write("\t</script>\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}