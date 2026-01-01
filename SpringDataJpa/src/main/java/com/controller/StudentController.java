package com.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.Entity.Student;
import com.service.PageSortingService;
import com.service.StudentService;

@RestController
public class StudentController {

	@Autowired
	StudentService studentService;

	@Autowired
	PageSortingService pageSortingService;

	@PostMapping("/save")
	public void insertStudent(@RequestBody Student student) {
		studentService.saveStudent(student);
		System.out.println("Data inserted into db!..");
	}

	@PostMapping("/saveAll")
	public void insertAllStudents(@RequestBody List<Student> students) {
		studentService.saveAllStudents(students);
		System.out.println("Multiple Data inserted into db!..");
	}

	@GetMapping("/get")
	public Optional<Student> getStudent(@RequestParam(name = "id") int id) {
		Optional<Student> student = studentService.findStundentById(id);
		return student;

	}

	@GetMapping("/getAll")
	public List<Student> getAllStudent() {
		List<Student> student = studentService.findAllStudents();
		return student;

	}

	@PutMapping("/update")
	public Student updateStudnent(@RequestParam(name = "id") int id, @RequestBody Student student) {
		return studentService.updateStudent(id, student);

	}

	@DeleteMapping("/delete")
	public String removeStudnent(@RequestParam(name = "id") int id) {
		studentService.deleteStudent(id);
		return "Given Student data is deleted!..";

	}

	@GetMapping("/getByName")
	public Student retriveStudnentByName(@RequestParam(name = "name") String name) {
		return studentService.getStudentByName(name);

	}

	@GetMapping("/getByAge")
	public Student retriveStudnentByAge(@RequestParam(name = "age") int age) {
		return studentService.getStudentByAge(age);

	}

	@GetMapping("/getAllByAge")
	public List<Student> retriveAllStudnentByAge(@RequestParam(name = "age") int age) {
		return studentService.getStudentsByAge(age);

	}

	@GetMapping("/getByAgeName")
	public Student retriveByAgeName(@RequestParam(name = "name") String name, @RequestParam(name = "age") int age) {
		return studentService.getByNameAndAge(name, age);

	}

	@GetMapping("/getByAgeOrName")
	public List<Student> retriveByAgeOrName(@RequestParam(name = "name") String name,
			@RequestParam(name = "age") int age) {
		return studentService.getByNameOrAge(name, age);

	}

	@GetMapping("/getNameStarts")
	public List<Student> retriveByNameStarts(@RequestParam(name = "name") String name) {
		return studentService.getByStartingName(name);

	}

	@GetMapping("/getByPageNo")
	public Page<Student> retriveByPage(@RequestParam(name = "page") int page, @RequestParam(name = "size") int size) {
		return pageSortingService.getStudentByPage(page, size);

	}

	@GetMapping("/getByPageSorted")
	public Page<Student> retriveByPageSorted(@RequestParam(name = "page") int page,
			@RequestParam(name = "size") int size) {
		return pageSortingService.getStudentBySort(page, size);

	}

}
