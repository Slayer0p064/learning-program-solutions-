package com.cognizant.spring_learn.controller;

import com.cognizant.spring_learn.util.JwtUtil;
import org.springframework.http.*;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.StandardCharsets;
import java.util.Base64;
import java.util.Map;

@RestController
public class AuthController {

    private final JwtUtil jwt;

    public AuthController(JwtUtil jwt) {
        this.jwt = jwt;
    }

    @GetMapping("/authenticate")
    public ResponseEntity<?> authenticate(@RequestHeader(HttpHeaders.AUTHORIZATION) String header) {

        if (header == null || !header.startsWith("Basic "))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("No Basic auth header");

        String decoded = new String(Base64.getDecoder()
                .decode(header.substring(6)), StandardCharsets.UTF_8);
        String[] parts = decoded.split(":", 2);
        String user = parts[0], pwd = parts.length > 1 ? parts[1] : "";

        System.out.println("Received credentials: " + user + " / " + pwd); // <-- watch console

        if (!"user".equals(user) || !"pwd".equals(pwd))
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Invalid credentials");

        return ResponseEntity.ok(Map.of("token", jwt.tokenFor(user)));
    }
}
