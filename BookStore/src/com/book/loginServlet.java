package com.book;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public loginServlet() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("In sign up servlet");
		
		response.setContentType("text/html");
		PrintWriter writer = response.getWriter();
		String alert = "Wrong credentials!\nPlease register.";
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		ServletContext servletContext = getServletContext();
		
		if(username.equals(servletContext.getInitParameter("username")) && 
				password.equals(servletContext.getInitParameter("password"))) {
			
			HttpSession httpSession = request.getSession(true);
			httpSession.setAttribute("username", username);
			RequestDispatcher rd = request.getRequestDispatcher("bookslist.html");
			rd.include(request, response);
		}
		else {
			writer.print("<script type=\"text/javascript\">");
			writer.print("alert('Invalid Username or Password');");
			writer.print("</script>");
			RequestDispatcher rd = request.getRequestDispatcher("signup.html");
			rd.include(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
