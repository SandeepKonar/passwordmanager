package learning.projects.spring_backend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import learning.projects.spring_backend.model.AppMetadataDetails;
import learning.projects.spring_backend.model.AppMetadataKey;

@Repository
public interface AppMetadataRepository extends JpaRepository<AppMetadataDetails, AppMetadataKey>{

}
