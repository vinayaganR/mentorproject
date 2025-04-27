package com.sppascm.project.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.sppascm.project.model.Student;
import com.sppascm.project.service.StudentService;

import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:8081") // 👈 Allow frontend from React port
@RestController
@RequestMapping("/students")
public class StudentController {

    @Autowired
    private StudentService studentService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody Student student) {
        studentService.register(student);
        return ResponseEntity.ok("Student registered successfully!");
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody Student student) {
        boolean isAuthenticated = studentService.login(student.getKuId(), student.getPassword());
        return isAuthenticated
                ? ResponseEntity.ok("Login successful")
                : ResponseEntity.status(401).body("Invalid credentials");
    }

    @GetMapping("/all")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }

    @PutMapping("/update-password/{kuId}")
    public ResponseEntity<String> updatePassword(@PathVariable String kuId, @RequestBody Map<String, String> request) {
        boolean updated = studentService.updatePassword(kuId, request.get("newPassword"));
        return updated
                ? ResponseEntity.ok("Password updated successfully!")
                : ResponseEntity.status(404).body("Student not found");
    }

    @DeleteMapping("/delete/{kuId}")
    public ResponseEntity<String> deleteStudent(@PathVariable String kuId) {
        boolean deleted = studentService.deleteStudentByKuId(kuId);
        return deleted
                ? ResponseEntity.ok("Student deleted successfully!")
                : ResponseEntity.status(404).body("Student not found");
    }
}
