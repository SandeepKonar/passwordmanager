package com.learning.passwordmanager.usermanagement_service.service;

import com.learning.passwordmanager.usermanagement_service.dto.LoginRequest;
import com.learning.passwordmanager.usermanagement_service.dto.LoginResponse;
import com.learning.passwordmanager.usermanagement_service.dto.SignupRequest;
import com.learning.passwordmanager.usermanagement_service.mapper.UserMapper;
import com.learning.passwordmanager.usermanagement_service.model.User;
import com.learning.passwordmanager.usermanagement_service.model.UserStatus;
import com.learning.passwordmanager.usermanagement_service.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    UserRepository userRepository;
    UserMapper userMapper;

    public UserServiceImpl(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    @Override
    public LoginResponse login(LoginRequest loginRequest) throws IllegalArgumentException {
        if (!StringUtils.hasText(loginRequest.getUsername()))
            throw new IllegalArgumentException("username cannot be empty");
        //TODO: call authentication Service
        return new LoginResponse(loginRequest.getUsername(), "");
    }

    @Override
    public void signup(SignupRequest signupRequest) {
        //TODO: add json schema validation
        User user = userMapper.signupRequestToUser(signupRequest);
        user.setStatus(UserStatus.ACT.getUserStatus());
        userRepository.save(user);
    }

    @Override
    public void removeUser(String username) {
        if (!StringUtils.hasText(username))
            throw new IllegalArgumentException("username cannot be empty");
        Optional<User> user = userRepository.findById(username);
        user.ifPresentOrElse( usr -> {
            userRepository.delete(usr);
        }, () -> {
            throw new RuntimeException("User not found with username " + username);
        });
    }
}
