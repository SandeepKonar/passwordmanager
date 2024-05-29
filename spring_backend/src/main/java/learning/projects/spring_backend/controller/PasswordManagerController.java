package learning.projects.spring_backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import learning.projects.spring_backend.domain.App;
import learning.projects.spring_backend.service.PasswordManagerService;

@RestController
public class PasswordManagerController {
	@Autowired
	PasswordManagerService passwordManagerService;

	@PostMapping("/app")
	public ResponseEntity<String> saveApp(@RequestBody App request) {
		passwordManagerService.saveApp(request);
		return ResponseEntity.ok("save successful");
	}
}
