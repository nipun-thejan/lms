package com.thejan.lms;

import com.thejan.lms.repository.CourseRepository;
import com.thejan.lms.repository.StudentRepository;
import lombok.AllArgsConstructor;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@SpringBootApplication
@AllArgsConstructor
public class LmsApplication {

	StudentRepository studentRepository;
	CourseRepository courseRepository;

	public static void main(String[] args) {

		SpringApplication.run(LmsApplication.class, args);
	}





	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}
