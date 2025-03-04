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

    // User Registration
    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@Valid @RequestBody AuthUserDTO authUserDTO) {
        authUserService.registerUser(authUserDTO);
        return ResponseEntity.ok("User registered successfully! Please check your email for verification.");
    }

    // Verify User
    @GetMapping("/verify")
    public ResponseEntity<String> verifyUser(@RequestParam String token) {
        return authUserService.verifyUser(token);
    }

    // User Login
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@Valid @RequestBody LoginDTO loginDTO) {
        return authUserService.loginUser(loginDTO);
    }
}