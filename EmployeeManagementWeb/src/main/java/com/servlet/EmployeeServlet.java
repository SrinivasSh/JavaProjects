package com.servlet;

import java.io.IOException;
import java.util.List;

import com.dao.EmployeeDao;
import com.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/employees")
public class EmployeeServlet extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		doPost(req,resp);
	}
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		EmployeeDao employeeDao=new EmployeeDao();
		List<Employee> empList=employeeDao.getAllEmployes();
		 req.setAttribute("empList", empList);
		 
		RequestDispatcher reqDispatcher=req.getRequestDispatcher("employee.jsp");
		reqDispatcher.forward(req, resp);
	}
	
	

}
