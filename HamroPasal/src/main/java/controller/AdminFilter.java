package controller;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;	
import javax.servlet.http.HttpSession;

@WebFilter(urlPatterns={"/View/AdminPage.jsp", "/View/AddProduct.jsp", "/View/EditProduct.jsp","/manageusers","/View/ManageUsers.jsp","/View/ManageProducts.jsp", "/admin-page"})
public class AdminFilter implements Filter {

	@Override
	public void init(FilterConfig filterConfig) throws ServletException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
			throws IOException, ServletException {
		
		HttpSession session = ((HttpServletRequest)request).getSession();
		System.out.print(session.getAttribute("adminEmail"));
		if(session.getAttribute("adminEmail") == null) {
			System.out.println("Error Error ");
			System.out.println(session.getAttribute("adminEmail"));
			session.setAttribute("loginError","Do login First!");
			((HttpServletResponse)response).sendRedirect("../View/AdminLogin.jsp");
		}
		else {
			chain.doFilter(request, response);
		}
	}

	@Override
	public void destroy() {
		// TODO Auto-generated method stub
		
	}
	
}