package com.thejan.lms;

import com.thejan.lms.repository.CourseRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class LmsApplication {

	CourseRepository courseRepository;

	public static void main(String[] args) {

		SpringApplication.run(LmsApplication.class, args);
	}


}
