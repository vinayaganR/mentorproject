package com.sppascm.project.repository;

import com.sppascm.project.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.Optional;

@Repository
public interface TeamRepository extends JpaRepository<Team, Long> {
    Optional<Team> findByStudent1IdOrStudent2Id(Long student1Id, Long student2Id);
    boolean existsByMentorId(Long mentorId);
}