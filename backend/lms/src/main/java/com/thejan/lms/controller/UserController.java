package com.thejan.lms.controller;


import com.thejan.lms.entity.User;
import com.thejan.lms.service.UserService;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {

    private final UserService userService;



	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getUser(id).getEmail(), HttpStatus.OK);
	}

	@GetMapping("/userInfo")
	ResponseEntity<User> getUserInfo(Authentication auth) throws UsernameNotFoundException {
		User user = userService.getUser(auth.getName());
		return ResponseEntity.ok(user);
	}

}