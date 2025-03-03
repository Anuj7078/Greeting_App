package com.example.greetingapp.Services;

import com.example.greetingapp.Model.GreetingMessage;
import com.example.greetingapp.Model.User;
import com.example.greetingapp.Repository.GreetingRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomGreetingService {

    @Autowired
    private GreetingRepository greetingRepository;
    //UC1
    // Basic Greeting
    public String getGreeting() {
        return "Hello World";
    }
    //UC2
    // Custom Greeting with User Object
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
    //UC3
    // Custom Greeting with First Name and Last Name
    public String getGreeting(String firstName, String lastName) {
        String message;
        if (firstName != null && lastName != null) {
            message = "Hello " + firstName + " " + lastName + "!";
        } else if (firstName != null) {
            message = "Hello " + firstName + "!";
        } else if (lastName != null) {
            message = "Hello " + lastName + "!";
        } else {
            message = "Hello World!";
        }
        //UC4
        // Save the greeting message to the database
        GreetingMessage greetingMessage = new GreetingMessage(message);
        greetingRepository.save(greetingMessage);

        return message;
    }

    //UC5
    // Get Greeting by ID
    public GreetingMessage getGreetingById(Long id) {
        return greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));
    }
    //UC6
    // Get All Greetings
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }
    //UC7
    //Edit a Greeting Message
    public GreetingMessage updateGreeting(Long id, String newMessage) {
        GreetingMessage greetingMessage = greetingRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Greeting not found with id: " + id));

        greetingMessage.setMessage(newMessage);
        return greetingRepository.save(greetingMessage);
    }
}