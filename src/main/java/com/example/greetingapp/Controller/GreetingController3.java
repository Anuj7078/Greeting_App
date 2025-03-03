package com.example.greetingapp.Controller;

import com.example.greetingapp.Model.User;
import com.example.greetingapp.Services.CustomGreetingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/greeting3")
public class GreetingController3 {
    private final CustomGreetingService customGreetingService;

    @Autowired
    public GreetingController3(CustomGreetingService customGreetingService) {
        this.customGreetingService = customGreetingService;
    }

    @PostMapping
    public Map<String, String> getCustomGreeting(@RequestBody User user) {
        Map<String, String> response = new HashMap<>();
        response.put("message", customGreetingService.getGreeting(user));
        return response;
    }
}