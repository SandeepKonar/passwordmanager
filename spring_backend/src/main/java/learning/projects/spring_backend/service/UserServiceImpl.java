package learning.projects.spring_backend.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import learning.projects.spring_backend.domain.User;
import learning.projects.spring_backend.exception.DatabaseException;
import learning.projects.spring_backend.model.UserDetails;
import learning.projects.spring_backend.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	UserRepository userRepository;
	
	@Override
	public void saveUser(User user) {
		UserDetails userDetails = new UserDetails();
		userDetails.setUsername(user.getUsername());
		userDetails.setCredential(user.getCredential());
		try {
			userRepository.save(userDetails);
		}catch(Exception e) {
			throw new DatabaseException(e.getMessage());
		}
	}

}
