package learning.projects.spring_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.projects.spring_backend.model.UserDetails;

@Repository
public interface UserRepository extends JpaRepository<UserDetails, Integer>{

	public UserDetails findByUsername(String username);
}
