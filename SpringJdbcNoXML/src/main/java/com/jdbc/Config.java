package com.jdbc;

import javax.sql.DataSource;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configuration
public class Config {

	@Bean("jdbcTemplate")
	public JdbcTemplate getJdbcTemplate() {
		DataSource datasource = getDataSource();
		return new JdbcTemplate(datasource);
	}

	@Bean
	public DataSource getDataSource() {
		return new DriverManagerDataSource("jdbc:mysql://localhost:3306/flm_hibernate", "root", "Srinivas@1998");
	}
}
