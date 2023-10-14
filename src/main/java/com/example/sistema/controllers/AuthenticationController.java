package com.example.sistema.controllers;

import com.example.sistema.models.user.AuthenticationDTO;
import com.example.sistema.models.user.RegisterDTO;
import com.example.sistema.models.user.User;
import com.example.sistema.services.authentication.AuthenticationService;
import com.example.sistema.services.user.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("auth")
public class AuthenticationController {

    @Autowired
    private AuthenticationService authenticationService;

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public ResponseEntity login(@RequestBody @Valid AuthenticationDTO data) {
        this.authenticationService.login(data);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/register")
    public ResponseEntity register(@RequestBody @Valid RegisterDTO data) {
        this.userService.create(data);
        return ResponseEntity.ok().build();
    }
}
