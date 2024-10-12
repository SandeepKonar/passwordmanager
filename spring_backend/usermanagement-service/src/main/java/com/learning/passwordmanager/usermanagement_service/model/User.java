package com.learning.passwordmanager.usermanagement_service.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity(name = "users")
public class User {
    @Id
    @Column(unique = true)
    private String username;
    private String password; //encrypted
    private String firstName;
    private String lastName;
    private String status;
    private String secretQuestion;
    private String secretAnswer; //encrypted
}
