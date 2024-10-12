package com.learning.passwordmanager.usermanagement_service.model;

public enum UserStatus {
    ACT("ACTIVE"),
    DEACT("DEACTIVE"),
    SUS("SUSPENDED");

    private String value;

    UserStatus(String value) {
        this.value = value;
    }

    public String getUserStatus() {
        return this.value;
    }
}
