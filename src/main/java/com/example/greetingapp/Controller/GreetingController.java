package com.example.greetingapp.Controller;

import com.example.greetingapp.Model.GreetingMessage;
import com.example.greetingapp.Model.User;
import com.example.greetingapp.Services.CustomGreetingService;
import com.example.greetingapp.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {

    @Autowired
    private CustomGreetingService greetingService;

    // Basic Greeting Endpoints
    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        return response;
    }

    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        response.put("receivedData", request.toString());
        return response;
    }

    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        response.put("receivedData", request.toString());
        return response;
    }

    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        return response;
    }
    //UC2
    // Custom Greeting with User Object
    @PostMapping("/custom")
    public Map<String, String> getCustomGreeting(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting(user));
        return response;
    }
    //UC3
    // Custom Greeting with First Name and Last Name
    @PostMapping("/custom2")
    public Map<String, String> getCustomGreeting2(@RequestBody Map<String, String> request) {
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");

        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting(firstName, lastName));
        return response;
    }
    //UC4
    // Get All Greetings
    @GetMapping("/all")
    public List<GreetingMessage> getAllGreetings() {
        return greetingService.getAllGreetings();
    }
    //UC5
    // Get Greeting by ID
    @GetMapping("/{id}")
    public GreetingMessage getGreetingById(@PathVariable Long id) {
        return greetingService.getGreetingById(id);
    }
}