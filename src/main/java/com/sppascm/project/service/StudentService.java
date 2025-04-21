package com.sppascm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sppascm.project.model.Student;
import com.sppascm.project.repository.StudentRepository;

import java.util.Optional;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Student register(Student student) {
        return studentRepository.save(student);
    }

    public boolean login(String kuId, String password) {
        Optional<Student> student = studentRepository.findByKuId(kuId);
        return student.isPresent() && student.get().getPassword().equals(password);
    }
}
