package com.example.greetingapp.Util;

import java.util.UUID;

public class TokenUtil {

    // Generate a random token
    public static String generateToken() {
        return UUID.randomUUID().toString();
    }
}