package com.flexivebackend.Flexive;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

@SpringBootApplication
@CrossOrigin(origins = "*", allowedHeaders = "*")
public class FlexiveApplication {

	public static void main(String[] args) {
		SpringApplication.run(FlexiveApplication.class, args);
	}

}
