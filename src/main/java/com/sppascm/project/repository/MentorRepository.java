package com.sppascm.project.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.sppascm.project.model.Mentor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface MentorRepository extends JpaRepository<Mentor, Long> {
    Optional<Mentor> findByMentorId(String mentorId);
}
