package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.Entity.Student;
import com.repository.StudentRepository;

@Service
public class PageSortingService {

	@Autowired
	StudentRepository studentRepo;

	public Page<Student> getStudentByPage(int pageNumber, int size) {
		PageRequest pgRequest = PageRequest.of(pageNumber, size);
		return studentRepo.findAll(pgRequest);
	}

	public Page<Student> getStudentBySort(int pageNumber, int size) {
		Sort sortAsc = Sort.by("age").ascending();
		PageRequest pgRequest = PageRequest.of(pageNumber, size, sortAsc);
		return studentRepo.findAll(pgRequest);
	}

}
