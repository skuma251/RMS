package com.rms.backend.controller;

import com.rms.backend.errors.BadRequest;
import com.rms.backend.errors.GeneralException;
import com.rms.backend.errors.NotFound;
import com.rms.backend.errors.Unauthorized;
import com.rms.backend.model.Users;
import com.rms.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;


@RestController
public class AuthController {

    @Autowired
    UserRepository userRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody Users user) {
        Users existingUser = userRepository.findByEmail(user.getEmail());
        if (existingUser != null) {
            // User with the same email already exists
            throw new BadRequest("User with this email already exists");
        }

        // Set created timestamp
        user.setCreatedAt(String.valueOf(new Date(System.currentTimeMillis())));

        // Hash password
        String hashedPassword = passwordEncoder.encode(user.getPwd());
        user.setPwd(hashedPassword);

        // Save user
        Users savedUser = userRepository.save(user);

        // Check if user saved successfully
        if (savedUser != null && savedUser.getId() > 0) {
            return ResponseEntity.status(HttpStatus.CREATED)
                    .body("User registered successfully");
        } else {
            throw new GeneralException("Failed to register user");
        }
    }

    @GetMapping("/user")
    public ResponseEntity<?>  getUserDetailsAfterLogin(Authentication authentication) {
        if (authentication == null || authentication.getName() == null) {
            throw new Unauthorized("No authentication detected");
        }

        // Get user details by email
        Users user = userRepository.findByEmail(authentication.getName());
        if (user != null) {
            // User found, return user details
            return ResponseEntity.ok(user);
        } else {
            // User not found
            throw new NotFound("User details not found");
        }
    }
}
