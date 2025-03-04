package com.example.greetingapp.Services;

import com.example.greetingapp.DTO.AuthUserDTO;
import com.example.greetingapp.DTO.LoginDTO;
import com.example.greetingapp.Model.AuthUser;
import com.example.greetingapp.Repository.AuthUserRepository;
import com.example.greetingapp.Util.TokenUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class AuthUserService {

    @Autowired
    private AuthUserRepository authUserRepository;

    @Autowired
    private EmailService emailService;

    // User Registration
    public AuthUser registerUser(AuthUserDTO authUserDTO) {
        AuthUser authUser = new AuthUser();
        authUser.setFirstName(authUserDTO.getFirstName());
        authUser.setLastName(authUserDTO.getLastName());
        authUser.setEmail(authUserDTO.getEmail());
        authUser.setPassword(authUserDTO.getPassword());

        // Generate and set verification token (for future use if needed)
        String token = TokenUtil.generateToken();
        authUser.setVerificationToken(token);

        // Mark user as verified directly
        authUser.setVerified(true);

        // Save user to database
        AuthUser savedUser = authUserRepository.save(authUser);

        // Send welcome email (optional)
        String emailSubject = "Welcome to Greeting App!";
        String emailText = "Thank you for registering with us. You can now login and start using the app.";
        emailService.sendEmail(savedUser.getEmail(), emailSubject, emailText);

        return savedUser;
    }

    // Verify User (Optional - Not needed for now)
    public ResponseEntity<String> verifyUser(String token) {
        System.out.println("Verification token received: " + token);

        AuthUser authUser = authUserRepository.findByVerificationToken(token);
        if (authUser != null) {
            System.out.println("User found with token: " + authUser.getEmail());
            authUser.setVerified(true);
            authUser.setVerificationToken(null); // Clear the token after verification
            authUserRepository.save(authUser);
            return ResponseEntity.ok("Email verified successfully!");
        } else {
            System.out.println("No user found with token: " + token);
            return ResponseEntity.badRequest().body("Invalid token");
        }
    }

    // User Login
    public ResponseEntity<String> loginUser(LoginDTO loginDTO) {
        AuthUser authUser = authUserRepository.findByEmail(loginDTO.getEmail());
        if (authUser != null && authUser.getPassword().equals(loginDTO.getPassword())) {
            // Send login success email (optional)
            String emailSubject = "Login Successful";
            String emailText = "Congratulations! You have successfully logged in.";
            emailService.sendEmail(authUser.getEmail(), emailSubject, emailText);

            return ResponseEntity.ok("Login successful!");
        } else {
            return ResponseEntity.badRequest().body("Invalid email or password");
        }
    }
}