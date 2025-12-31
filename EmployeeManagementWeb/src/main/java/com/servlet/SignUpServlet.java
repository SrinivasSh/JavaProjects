package com.servlet;

import java.io.IOException;

import com.dao.UserDao;
import com.model.User;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/signup")
public class SignUpServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("Email");
		String password = req.getParameter("Password");
		String confirmPassword = req.getParameter("ConfirmPassword");

		User user = new User(email, password);
		UserDao userDao = new UserDao();
		userDao.saveUser(user);

		RequestDispatcher reqDispatcher = req.getRequestDispatcher("index.html");
		reqDispatcher.forward(req, resp);

	}

}
