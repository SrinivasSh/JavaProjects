package com;

import java.io.IOException;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/signUp")
public class SignUp extends HttpServlet{
	
	
	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String userName=req.getParameter("userName");
		String password=req.getParameter("password");
		
//		resp.setContentType("text/html");
//		PrintWriter writer=resp.getWriter();
//		writer.append("Hi "+ userName + " you are successfully login");
		
		req.setAttribute("username", userName);
		req.setAttribute("password", password);
		RequestDispatcher dispatcher=req.getRequestDispatcher("result.jsp");
		dispatcher.forward(req, resp);
		
		
	}

}
