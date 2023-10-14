package com.example.sistema.models.user;

import com.example.sistema.models.enums.UserRole;

public record RegisterDTO(String login, String password, UserRole role) {
}
