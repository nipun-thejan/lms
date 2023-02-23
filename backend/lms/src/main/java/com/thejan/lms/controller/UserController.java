package com.thejan.lms.controller;


import com.thejan.lms.entity.User;
import com.thejan.lms.service.UserService;
import com.thejan.lms.utils.RegisterRequest;
import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@AllArgsConstructor
@RestController
@RequestMapping("api/v1/user")
public class UserController {


    UserService userService;

	@GetMapping("/{id}")
	public ResponseEntity<String> findById(@PathVariable Long id) {
		return new ResponseEntity<>(userService.getUser(id).getEmail(), HttpStatus.OK);
	}

	@GetMapping("/profile/{email}")
	public ResponseEntity<RegisterRequest> getProfileByEmail(@PathVariable String email){
		return new ResponseEntity<>(userService.getProfile(email), HttpStatus.OK);
	}
	@GetMapping("/profile/{id}")
	public ResponseEntity<RegisterRequest> getProfileById(@PathVariable Long id){
		return new ResponseEntity<>(userService.getProfile(id).toString(), HttpStatus.OK);
	}



//    @PostMapping("/register")
//	public ResponseEntity<HttpStatus> createUser(@Valid @RequestBody User user) {
//		userService.saveUser(user);
//		return new ResponseEntity<>(HttpStatus.CREATED);
//	}

}