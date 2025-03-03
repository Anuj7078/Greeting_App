package com.example.greetingapp.Services;

import com.example.greetingapp.Model.User;
import org.springframework.stereotype.Service;

@Service
public class CustomGreetingService {

    public String getGreeting(User user) {
        String firstName = user.getFirstName();
        String lastName = user.getLastName();

        if (firstName != null && lastName != null) {
            return "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            return "Hello " + firstName + "!";
        } else if (lastName != null) {
            return "Hello " + lastName + "!";
        } else {
            return "Hello World!";
        }
    }
}