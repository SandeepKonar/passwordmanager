package com.learning.passwordmanager.passwordmgmtservice.repository;

import com.learning.passwordmanager.passwordmgmtservice.model.ProtectedResource;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProtectedResourceRepository extends JpaRepository<ProtectedResource, String> {
    Optional<ProtectedResource> findByResourceName(String resourceName);
    void deleteByResourceName(String resourceName);
}
