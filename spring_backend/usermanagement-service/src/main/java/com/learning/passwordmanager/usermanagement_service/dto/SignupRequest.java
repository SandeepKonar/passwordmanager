package com.learning.passwordmanager.usermanagement_service.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class SignupRequest {
    private String username;
    private String password;
    private String firstName;
    private String lastName;
    private SecurityQuestion securityQuestion;

    @Data
    @NoArgsConstructor
    public static class SecurityQuestion {
        private String question;
        private String answer;
    }
}
