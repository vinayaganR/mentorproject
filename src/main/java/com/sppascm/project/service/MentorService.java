package com.sppascm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sppascm.project.model.Mentor;
import com.sppascm.project.repository.MentorRepository;

import java.util.Optional;
import java.util.List;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    // Register new mentor
    public Mentor register(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    // Mentor login validation
    public boolean login(String mentorId, String password) {
        Optional<Mentor> mentor = mentorRepository.findByMentorId(mentorId);
        return mentor.isPresent() && mentor.get().getPassword().equals(password);
    }

    // Get mentor by ID
    public Optional<Mentor> getMentorById(Long id) {
        return mentorRepository.findById(id);
    }

    // Update mentor details
    public Mentor updateMentor(Mentor mentor) {
        return mentorRepository.save(mentor); // Save the updated mentor
    }

    public List<Mentor> getAllMentors() {
        return mentorRepository.findAll();
    }

    // Delete mentor by ID
    public boolean deleteMentor(Long id) {
        Optional<Mentor> mentor = mentorRepository.findById(id);
        if (mentor.isPresent()) {
            mentorRepository.delete(mentor.get());
            return true;
        }
        return false;
    }
}
