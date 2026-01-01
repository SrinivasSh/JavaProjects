package com.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {

	public Student findByName(String name);

	public Student findByAge(int age);

	public List<Student> findAllByAge(int age);

	public Student findByNameAndAge(String name, int age);

	public List<Student> findByNameOrAge(String name, int age);

	public List<Student> findByNameStartingWith(String name);

}
