package com.servlet;

import java.io.IOException;

import com.dao.EmployeeDao;
import com.model.Employee;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


@WebServlet("/addEmployee")
public class AddEmployee extends HttpServlet{

	
	private static final long serialVersionUID = 1L;
	
	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		
		String name=req.getParameter("name");
		int age=Integer.parseInt(req.getParameter("age"));
		String email=req.getParameter("email");
		String phoneNumber=req.getParameter("phone Number");
		double salary=Double.parseDouble(req.getParameter("salary"));
		
		Employee employee =new Employee(name,age,email,phoneNumber,salary);
		EmployeeDao employeeDao=new EmployeeDao();
		employeeDao.saveEmployee(employee);
		
		RequestDispatcher reqDispatcher=req.getRequestDispatcher("employees");
		reqDispatcher.forward(req, resp);
		
		
		
		
	}

}
