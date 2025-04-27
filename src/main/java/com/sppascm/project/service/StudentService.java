package com.sppascm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sppascm.project.model.Student;
import com.sppascm.project.repository.StudentRepository;

import java.util.List;
import java.util.Optional;

@Service
public class StudentService {

    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) {
        return studentRepository.save(student);
    }

    public boolean login(String kuId, String password) {
        System.out.println("Login Attempt: " + kuId + " / " + password);
        Optional<Student> student = studentRepository.findByKuId(kuId);
        if (student.isPresent()) {
            System.out.println("Student Found: " + student.get().getKuId());
            System.out.println("Password in DB: " + student.get().getPassword());
        } else {
            System.out.println("Student Not Found");
        }
        return student.isPresent() && student.get().getPassword().equals(password);
    }
    

    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // 🔁 Update password logic
    public boolean updatePassword(String kuId, String newPassword) {
        Optional<Student> studentOpt = studentRepository.findByKuId(kuId);
        if (studentOpt.isPresent()) {
            Student student = studentOpt.get();
            student.setPassword(newPassword);
            studentRepository.save(student);
            return true;
        }
        return false;
    }

    // ❌ Delete student logic
    public boolean deleteStudentByKuId(String kuId) {
        Optional<Student> studentOpt = studentRepository.findByKuId(kuId);
        if (studentOpt.isPresent()) {
            studentRepository.delete(studentOpt.get());
            return true;
        }
        return false;
    }
}
