package com.example.greetingapp.Controller;

import com.example.greetingapp.Model.GreetingMessage;
import com.example.greetingapp.Repository.GreetingRepository;
import com.example.greetingapp.Services.CustomGreetingService2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/greeting4")
public class GreetingController4 {

    @Autowired
    private CustomGreetingService2 customGreetingService;

    @Autowired
    private GreetingRepository greetingRepository;

    @PostMapping
    public Map<String, String> getCustomGreeting(@RequestBody Map<String, String> request) {
        String firstName = request.get("firstName");
        String lastName = request.get("lastName");

        Map<String, String> response = new HashMap<>();
        response.put("message", customGreetingService.getGreeting(firstName, lastName));
        return response;
    }

    @GetMapping("/all")
    public List<GreetingMessage> getAllGreetings() {
        return greetingRepository.findAll();
    }
}