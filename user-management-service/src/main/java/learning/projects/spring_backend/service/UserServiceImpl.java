package learning.projects.spring_backend.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import learning.projects.spring_backend.domain.UserRequest;
import learning.projects.spring_backend.exception.DatabaseException;
import learning.projects.spring_backend.model.UserInfo;
import learning.projects.spring_backend.repository.UserRepository;
import learning.projects.spring_backend.util.JWTUtils;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	@Autowired
	JWTUtils jwtUtils;
	@Autowired
	PasswordEncoder passwordEncoder;
	
	@Override
	public void saveUser(UserRequest user) {
		UserInfo userDetails = new UserInfo();
		userDetails.setUsername(user.getUsername());
		userDetails.setCredential(user.getCredential());
		try {
			userRepository.save(userDetails);
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}
	
	@Override
	public String generateToken(String username) {
		Map<String, String> claims = new HashMap<>();
		claims.put("username", username);
		return jwtUtils.generateToken(claims);
	}
	
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserInfo user = userRepository.findByUsername(username);
		if(user == null)
			throw new UsernameNotFoundException(String.format("user not found with username %s", username));
		return new User(user.getUsername(),user.getCredential(), new ArrayList<>());
	}

}
