package com.example.greetingapp.Repository;

import com.example.greetingapp.Model.AuthUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthUserRepository extends JpaRepository<AuthUser, Long> {
    // Method to find user by email
    AuthUser findByEmail(String email);
}