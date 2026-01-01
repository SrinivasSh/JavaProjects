package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.model.Employee;

@RestController
public class DataSourceController {

	@Autowired
	JdbcTemplate jdbcTemplate;

	@GetMapping("/save")
	public String insertData() {
		jdbcTemplate.update("insert into employee values(?,?,?,?)", 10, "Wipro", "Vamsi", "Kerala");
		return "Data Saved";
	}

	@GetMapping("/update")
	public String updateData() {
		jdbcTemplate.update("update employee set company=? where empId=?", "Infosys", 9);
		return "Data  Updated Successfully!!";
	}

	@GetMapping("/delete")
	public String deleteData() {
		jdbcTemplate.update("delete from employee where empId=?", 5);
		return "Data Deleted!!";
	}

	@GetMapping("/get")
	public List<Employee> getData() {
		List<Employee> employee = jdbcTemplate.query("select * from employee",
				(rs, n) -> new Employee(rs.getInt(1), rs.getString(2), rs.getString(3), rs.getString(4)));
		return employee;
	}

}
