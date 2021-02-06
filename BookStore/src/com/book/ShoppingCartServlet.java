package com.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class ShoppingCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public ShoppingCartServlet() {
        super();
        
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In shopping servlet");
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		ServletContext servletContext = request.getServletContext();
		String username = null;
		int sum = 0;
		String[] prices = request.getParameterValues("book");
		
		for(String i : prices) {
			sum += Integer.parseInt(i);
		}
		
		HttpSession httpSession = request.getSession(true);
		username = (String) httpSession.getAttribute("username");
		
		String cardNumber = servletContext.getInitParameter("creditCardNumber");
		System.out.println(sum + username);			
		
		
		RequestDispatcher rd = request.getRequestDispatcher("homepage.html");
		rd.include(request, response);
		
		writer.print("<html>");
		writer.print("Name : " + username);
		writer.print("<br>Credit card number: " + cardNumber);
		writer.print("<br>Total cost: " + sum);
		writer.print("</html>");
		
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
