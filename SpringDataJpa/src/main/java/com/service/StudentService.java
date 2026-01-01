package com.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.repository.StudentRepository;

@Service
public class StudentService {

	@Autowired
	StudentRepository studRepository;

	public void saveStudent(Student student) {
		studRepository.save(student);
	}

	public void saveAllStudents(List<Student> students) {
		studRepository.saveAll(students);
	}

	public Optional<Student> findStundentById(int id) {
		return studRepository.findById(id);
	}

	public List<Student> findAllStudents() {
		return studRepository.findAll();
	}

	public Student updateStudent(int id, Student updateStudent) {
		return studRepository.findById(id).map(student -> {
			student.setName(updateStudent.getName());
			student.setEmail(updateStudent.getEmail());
			student.setAge(updateStudent.getAge());
			return studRepository.save(student); // save updates
		}).orElseThrow(() -> new RuntimeException("Student not found with id: " + id));

	}

	public void deleteStudent(int id) {
		if (!studRepository.existsById(id)) {
			throw new RuntimeException("Student not found with id: " + id);
		}
		studRepository.deleteById(id);

	}

	public Student getStudentByName(String name) {
		return studRepository.findByName(name);

	}

	public Student getStudentByAge(int id) {
		return studRepository.findByAge(id);

	}

	public List<Student> getStudentsByAge(int id) {
		return studRepository.findAllByAge(id);

	}

	public Student getByNameAndAge(String name, int age) {
		return studRepository.findByNameAndAge(name, age);

	}

	public List<Student> getByNameOrAge(String name, int age) {
		return studRepository.findByNameOrAge(name, age);

	}

	public List<Student> getByStartingName(String name) {
		return studRepository.findByNameStartingWith(name);

	}

}
