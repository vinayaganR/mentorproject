package com.sppascm.project.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sppascm.project.model.Mentor;
import com.sppascm.project.repository.MentorRepository;

import java.util.Optional;

@Service
public class MentorService {
    @Autowired
    private MentorRepository mentorRepository;

    public Mentor register(Mentor mentor) {
        return mentorRepository.save(mentor);
    }

    public boolean login(String mentorId, String password) {
        Optional<Mentor> mentor = mentorRepository.findByMentorId(mentorId);
        return mentor.isPresent() && mentor.get().getPassword().equals(password);
    }
}
