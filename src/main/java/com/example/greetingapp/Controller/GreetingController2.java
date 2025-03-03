package com.example.greetingapp.Controller;

import com.example.greetingapp.Services.GreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting2")
public class GreetingController2 {
    private final GreetingService greetingService;

    @Autowired
    public GreetingController2(GreetingService greetingService) {
        this.greetingService = greetingService;
    }

    // GET Request
    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        return response;
    }

    // POST Request
    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        response.put("receivedData", request.toString());
        return response;
    }

    // PUT Request
    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        response.put("receivedData", request.toString());
        return response;
    }

    // DELETE Request
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", greetingService.getGreeting());
        return response;
    }
}