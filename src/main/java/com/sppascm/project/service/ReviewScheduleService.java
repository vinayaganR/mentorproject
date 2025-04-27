package com.sppascm.project.service;

import com.sppascm.project.model.Mentor;
import com.sppascm.project.model.Team;
import com.sppascm.project.model.ReviewSchedule;
import com.sppascm.project.repository.MentorRepository;
import com.sppascm.project.repository.TeamRepository;
import com.sppascm.project.repository.ReviewScheduleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ReviewScheduleService {

    @Autowired
    private ReviewScheduleRepository reviewScheduleRepository;

    @Autowired
    private TeamRepository teamRepository;

    @Autowired
    private MentorRepository mentorRepository;

    // 1️⃣ Assign 3 reviewers for a team and review round
    public List<ReviewSchedule> assignReviewers(Long teamId, List<Long> mentorIds, int reviewRound, LocalDate startDate, LocalDate endDate) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) throw new RuntimeException("Team not found");

        Team team = optionalTeam.get();
        List<ReviewSchedule> schedules = new ArrayList<>();

        for (Long mentorId : mentorIds) {
            Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);
            if (optionalMentor.isEmpty()) continue;

            Mentor mentor = optionalMentor.get();

            ReviewSchedule schedule = new ReviewSchedule(team, mentor, reviewRound, startDate, endDate);
            schedules.add(reviewScheduleRepository.save(schedule));
        }

        return schedules;
    }

    // 2️⃣ Reviewer submits marks and signature
    public ReviewSchedule submitReview(Long teamId, Long mentorId, int reviewRound, int marks) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        Optional<Mentor> optionalMentor = mentorRepository.findById(mentorId);

        if (optionalTeam.isEmpty() || optionalMentor.isEmpty()) throw new RuntimeException("Invalid team or mentor");

        ReviewSchedule review = reviewScheduleRepository
                .findByTeamAndReviewerAndReviewRound(optionalTeam.get(), optionalMentor.get(), reviewRound);

        if (review == null) throw new RuntimeException("Review entry not found");

        review.setMarks(marks);
        review.setSignatureSubmitted(true);

        return reviewScheduleRepository.save(review);
    }

    // 3️⃣ Optional: get all reviews for a team
    public List<ReviewSchedule> getReviewsByTeam(Long teamId) {
        Optional<Team> optionalTeam = teamRepository.findById(teamId);
        if (optionalTeam.isEmpty()) return new ArrayList<>();

        return reviewScheduleRepository.findByTeam(optionalTeam.get());
    }
}
