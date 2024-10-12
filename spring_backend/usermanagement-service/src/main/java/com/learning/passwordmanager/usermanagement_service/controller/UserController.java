package com.learning.passwordmanager.usermanagement_service.controller;

import com.learning.passwordmanager.usermanagement_service.dto.SignupRequest;
import com.learning.passwordmanager.usermanagement_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/signup")
    public ResponseEntity<String> saveUser(@RequestBody SignupRequest request) {
        userService.signup(request);
        return ResponseEntity.status(HttpStatus.CREATED).body("User created Successfully.");
    }

    @DeleteMapping("/{username}")
    public ResponseEntity<String> saveUser(@PathVariable(name = "username") String username) {
        userService.removeUser(username);
        return ResponseEntity.status(HttpStatus.OK).body("User removed Successfully.");
    }
}
