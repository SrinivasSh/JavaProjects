package com;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import com.Entity.User;

@SpringBootApplication
@EnableConfigurationProperties(User.class)   ///This will create a bean automatically for this class
public class ConfigurationPropertiesProjectApplication {

	public static void main(String[] args) {
		SpringApplication.run(ConfigurationPropertiesProjectApplication.class, args);
	}

}
