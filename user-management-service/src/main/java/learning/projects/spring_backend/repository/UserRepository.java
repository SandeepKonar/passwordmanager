package learning.projects.spring_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.projects.spring_backend.model.UserInfo;

@Repository
public interface UserRepository extends JpaRepository<UserInfo, Integer>{

	public UserInfo findByUsername(String username);
}
