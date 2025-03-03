package com.example.greetingapp.Controller;

import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting")
public class GreetingController {
    // GET Request
    @GetMapping
    public Map<String, String> getGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, GET request received!");
        return response;
    }
    // POST Request
    @PostMapping
    public Map<String, String> postGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, POST request received!");
        response.put("receivedData", request.toString());
        return response;
    }
    // PUT Request
    @PutMapping
    public Map<String, String> putGreeting(@RequestBody Map<String, String> request) {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, PUT request received!");
        response.put("receivedData", request.toString());
        return response;
    }
    // DELETE Request
    @DeleteMapping
    public Map<String, String> deleteGreeting() {
        Map<String, String> response = new HashMap<>();
        response.put("message", "Hello, DELETE request received!");
        return response;
    }
}