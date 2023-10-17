package com.example.sistema.models.enums;

public enum UserRole {
    ADMIN("ADMIN"),
    USER("USER"),
    SELLER("SELLER");

    private String role;

    UserRole(String role) {
        this.role = role;
    }

    public String getRole() {
        return role;
    }
}
