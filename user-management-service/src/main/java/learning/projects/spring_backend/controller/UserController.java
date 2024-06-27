package learning.projects.spring_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.projects.spring_backend.domain.UserRequest;
import learning.projects.spring_backend.service.UserService;

@RestController
public class UserController {
	@Autowired
	UserService userService;

	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody UserRequest user) {
		userService.saveUser(user);
		return ResponseEntity.ok("User Saved Successfully");
	}
	
	@GetMapping("/user/{username}/token")
	public ResponseEntity<String> getToken(@PathVariable(name = "username", required = true) String username) {
		try {
			userService.loadUserByUsername(username);
			String token = userService.generateToken(username);
			return ResponseEntity.noContent().header("AUTH-TOKEN", token).build();
		} catch(UsernameNotFoundException e) {
			return new ResponseEntity<String>(e.getMessage(), HttpStatus.NOT_FOUND);
		}
	}
}
