package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signUp")
public class Home extends HttpServlet{

	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String username=req.getParameter("userName");
		String password=req.getParameter("password");
		
		
		//request scope
//		req.setAttribute("username", username);
//		req.setAttribute("password", password);
		
		//session scope
		
//		HttpSession session=req.getSession();
//		session.setAttribute("username", username);
//		session.setAttribute("password", password);
		
		ServletContext context=req.getServletContext();
		context.setAttribute("username", username);
		context.setAttribute("password", password);
		
		RequestDispatcher dispatcher=req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, resp);

	}

}
