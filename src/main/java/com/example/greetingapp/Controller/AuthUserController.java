package com.example.greetingapp.Controller;

import com.example.greetingapp.DTO.AuthUserDTO;
import com.example.greetingapp.DTO.LoginDTO;
import com.example.greetingapp.Services.AuthUserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthUserController {

    @Autowired
    private AuthUserService authUserService;
    //UC10
    // User Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        authUserService.registerUser(authUserDTO);
        return ResponseEntity.ok("User registered successfully!");
    }

    // Store Login Credentials (No verification for now)
    @PostMapping("/login")
    public ResponseEntity<String> storeLoginCredentials(@Valid @RequestBody LoginDTO loginDTO) {
        authUserService.storeLoginCredentials(loginDTO);
        return ResponseEntity.ok("Login credentials stored successfully!");
    }
}