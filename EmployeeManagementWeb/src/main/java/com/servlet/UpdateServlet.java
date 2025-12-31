package com.servlet;

import java.io.IOException;

import com.dao.EmployeeDao;
import com.model.Employee;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/update")
public class UpdateServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		int empId = Integer.parseInt(req.getParameter("empId"));
		String name = req.getParameter("name");
		int age = Integer.parseInt(req.getParameter("age"));
		String email = req.getParameter("email");
		String phoneNumber = req.getParameter("phone Number");
		double salary = Double.parseDouble(req.getParameter("salary"));
		Employee employee = new Employee(empId, name, age, email, phoneNumber, salary);
		EmployeeDao employeeDao = new EmployeeDao();
		employeeDao.updateEmployee(employee);

		resp.sendRedirect("employees");

	}

}
