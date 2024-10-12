package com.learning.passwordmanager.usermanagement_service.service;

import com.learning.passwordmanager.usermanagement_service.dto.LoginRequest;
import com.learning.passwordmanager.usermanagement_service.dto.LoginResponse;
import com.learning.passwordmanager.usermanagement_service.dto.SignupRequest;

public interface UserService {
    LoginResponse login(LoginRequest loginRequest) throws IllegalArgumentException;

    void signup(SignupRequest signupRequest);

    void removeUser(String username);
}
