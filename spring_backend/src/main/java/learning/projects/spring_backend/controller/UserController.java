package learning.projects.spring_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.projects.spring_backend.domain.User;
import learning.projects.spring_backend.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		userService.saveUser(user);
		return ResponseEntity.ok("User Saved Successfully");
	}
}
