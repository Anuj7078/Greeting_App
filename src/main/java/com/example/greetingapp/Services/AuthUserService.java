package com.example.greetingapp.Services;

import com.example.greetingapp.DTO.AuthUserDTO;
import com.example.greetingapp.DTO.LoginDTO;
import com.example.greetingapp.Model.AuthUser;
import com.example.greetingapp.Repository.AuthUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;
    //UC10
    // User Registration
    public AuthUser registerUser(AuthUserDTO authUserDTO) {
        AuthUser authUser = new AuthUser();
        authUser.setFirstName(authUserDTO.getFirstName());
        authUser.setLastName(authUserDTO.getLastName());
        authUser.setEmail(authUserDTO.getEmail());
        authUser.setPassword(authUserDTO.getPassword()); // Note: Password should be encrypted in future
        return authUserRepository.save(authUser);
    }

    // Store Login Credentials (No verification for now)
    public void storeLoginCredentials(LoginDTO loginDTO) {
        AuthUser authUser = new AuthUser();
        authUser.setEmail(loginDTO.getEmail());
        authUser.setPassword(loginDTO.getPassword()); // Note: Password should be encrypted in future
        authUserRepository.save(authUser);
    }
}