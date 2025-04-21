package com.sppascm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sppascm.project.model.Mentor;
import com.sppascm.project.service.MentorService;

@RestController
@RequestMapping("/mentors")
public class MentorController {
    @Autowired
    private MentorService mentorService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Mentor mentor) {
        mentorService.register(mentor);
        return ResponseEntity.ok("Mentor registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Mentor mentor) {
        boolean isAuthenticated = mentorService.login(mentor.getMentorId(), mentor.getPassword());
        return isAuthenticated ? ResponseEntity.ok("Login successful")
                : ResponseEntity.status(401).body("Invalid credentials");
    }
}
