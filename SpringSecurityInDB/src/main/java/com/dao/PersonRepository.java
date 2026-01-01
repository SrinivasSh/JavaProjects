package com.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.model.Person;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {

	public Person findByuserName(String name);

}
