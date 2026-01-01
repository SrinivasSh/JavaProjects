package com.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dao.PersonRepository;
import com.model.Person;

@Service
public class PersonServiceImpl implements PersonService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public Person signUpPage(Person person) {
		Person savedPerson = personRepository.save(person);
		return savedPerson;
	}

}
