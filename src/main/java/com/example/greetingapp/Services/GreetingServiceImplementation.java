package com.example.greetingapp.Services;
import org.springframework.stereotype.Service;

@Service
public class GreetingServiceImplementation implements GreetingService {
    @Override
    public String getGreeting() {
        return "Hello World";
    }
}