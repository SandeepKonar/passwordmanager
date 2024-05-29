package learning.projects.spring_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.projects.spring_backend.model.AppDetails;

@Repository
public interface AppRepository extends JpaRepository<AppDetails, Integer> {
	
}
