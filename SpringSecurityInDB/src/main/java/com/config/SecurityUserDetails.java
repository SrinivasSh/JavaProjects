package com.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.dao.PersonRepository;
import com.model.Person;

@Service
public class SecurityUserDetails implements UserDetailsService {

	@Autowired
	PersonRepository personRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Person getUser = personRepository.findByuserName(username);
		return User.builder().username(getUser.getUserName()).password(getUser.getPassword()).build();
	}

}
