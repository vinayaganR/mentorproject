package com.sppascm.project.repository;

import com.sppascm.project.model.ReviewSchedule;
import com.sppascm.project.model.Mentor;
import com.sppascm.project.model.Team;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ReviewScheduleRepository extends JpaRepository<ReviewSchedule, Long> {

    // Get all reviews for a team
    List<ReviewSchedule> findByTeam(Team team);

    // Get all reviews done by a mentor
    List<ReviewSchedule> findByReviewer(Mentor reviewer);

    // Get review by team + round
    List<ReviewSchedule> findByTeamAndReviewRound(Team team, int reviewRound);

    // Optional: check if mentor has reviewed a particular team round
    ReviewSchedule findByTeamAndReviewerAndReviewRound(Team team, Mentor reviewer, int reviewRound);
}
