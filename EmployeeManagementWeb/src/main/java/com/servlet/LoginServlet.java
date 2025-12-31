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
import jakarta.servlet.http.HttpSession;

@WebServlet("/login")
public class LoginServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		String email = req.getParameter("Email");
		String password = req.getParameter("Password");

		User user = new User(email, password);
		UserDao userDao = new UserDao();
		boolean validUser = userDao.validateUser(user);
		if (validUser) {
			HttpSession session=req.getSession();
			session.setAttribute("email",user.getEmail().split("@")[0]);

			RequestDispatcher reqDispatcher = req.getRequestDispatcher("employees");
			reqDispatcher.forward(req, resp);

		} else {
			RequestDispatcher reqDispatcher = req.getRequestDispatcher("index.html");
			reqDispatcher.forward(req, resp);
		}
	}

}
