package com.sppascm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.bind.annotation.CrossOrigin;
import com.sppascm.project.model.Mentor;
import com.sppascm.project.service.MentorService;

import java.util.Optional;
import java.util.List;

@RestController
@RequestMapping("/mentors")
@CrossOrigin(origins = "http://localhost:8081")  // Allow CORS from frontend's port
public class MentorController {

    @Autowired
    private MentorService mentorService;

    // Register new mentor
    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Mentor mentor) {
        mentorService.register(mentor);
        return ResponseEntity.ok("Mentor registered successfully!");
    }

    // Mentor login
    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Mentor mentor) {
        boolean isAuthenticated = mentorService.login(mentor.getMentorId(), mentor.getPassword());
        return isAuthenticated
                ? ResponseEntity.ok("Login successful")
                : ResponseEntity.status(401).body("Invalid credentials");
    }

    // Get mentor by ID
    @GetMapping("/{id}")
    public ResponseEntity<Mentor> getMentor(@PathVariable Long id) {
        Optional<Mentor> mentor = mentorService.getMentorById(id);
        return mentor.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.status(404).body(null));
    }

    @GetMapping
    public ResponseEntity<List<Mentor>> getAllMentors() {
        List<Mentor> mentors = mentorService.getAllMentors();
        return ResponseEntity.ok(mentors);
    }

    // Update mentor details
    @PutMapping("/{id}")
    public ResponseEntity<String> updateMentor(@PathVariable Long id, @RequestBody Mentor mentor) {
        Optional<Mentor> existingMentor = mentorService.getMentorById(id);
        if (existingMentor.isPresent()) {
            mentor.setId(id); // Maintain same ID
            mentorService.updateMentor(mentor);
            return ResponseEntity.ok("Mentor updated successfully!");
        }
        return ResponseEntity.status(404).body("Mentor not found");
    }

    // Delete mentor by ID
    @DeleteMapping("/{id}")
    public ResponseEntity<String> deleteMentor(@PathVariable Long id) {
        if (mentorService.deleteMentor(id)) {
            return ResponseEntity.ok("Mentor deleted successfully!");
        }
        return ResponseEntity.status(404).body("Mentor not found");
    }
}
