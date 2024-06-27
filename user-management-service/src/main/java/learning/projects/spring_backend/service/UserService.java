package learning.projects.spring_backend.service;

import org.springframework.security.core.userdetails.UserDetailsService;

import learning.projects.spring_backend.domain.UserRequest;

public interface UserService extends UserDetailsService {
	public void saveUser(UserRequest user);
	public String generateToken(String username);
}
