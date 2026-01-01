package com.security;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.model.Authority;
import com.model.Employee;
import com.repository.EmployeeRepository;

@Service
public class SecurityUserDetailsService implements UserDetailsService {

	@Autowired
	EmployeeRepository employeeRepository;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Employee employee = employeeRepository.findByEmail(username);
		List<GrantedAuthority> authorities = new ArrayList<>();

		List<Authority> authortiesFromDb = employee.getAuthorities();

		for (Authority authorityList : authortiesFromDb) {
			authorities.add(new SimpleGrantedAuthority("ROLE_" + authorityList.getRole()));
		}

		return User.builder().username(employee.getEmail()).password(employee.getPassword()).authorities(authorities)
				.build();
	}

}
