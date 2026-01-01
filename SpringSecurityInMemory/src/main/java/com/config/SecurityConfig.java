package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConfig {

	@Bean
	public UserDetailsService userDetailsService(PasswordEncoder passwordEncoder) {
		String encrypted = passwordEncoder.encode("Srinivas@!779");
		String encrypted1 = passwordEncoder.encode("SrinivasSh@!143");
		System.out.println(encrypted);
		System.out.println(encrypted1);
		UserDetails user = User.builder().username("Srinivas").password(encrypted).build();
		UserDetails user1 = User.builder().username("Shannu").password(encrypted1).build();
		return new InMemoryUserDetailsManager(user, user1);
	}

	@Bean
	public SecurityFilterChain defaultSecurityFilterChain(HttpSecurity http) throws Exception {
		http.authorizeHttpRequests(authorise -> authorise.requestMatchers("/hello", "/close").authenticated()
				.requestMatchers("/accessAll").permitAll().requestMatchers("/denyAll").denyAll())
				.formLogin(Customizer.withDefaults()).httpBasic(Customizer.withDefaults());
		return http.build();
	}

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
}
