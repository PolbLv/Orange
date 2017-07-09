package com.orangehrm.data;


public enum UserRole {
    ADMIN("Admin"),
    ESS("ESS");

    private final String role;


    private UserRole(String role) {
        this.role = role;
    }

    public String value() {
        return role;
    }
}
