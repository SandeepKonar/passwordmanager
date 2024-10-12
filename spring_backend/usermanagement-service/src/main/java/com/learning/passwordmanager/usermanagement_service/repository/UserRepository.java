package com.learning.passwordmanager.usermanagement_service.repository;

import com.learning.passwordmanager.usermanagement_service.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
}
