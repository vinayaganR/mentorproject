package com.sppascm.project.controller;

import com.sppascm.project.model.ReviewSchedule;
import com.sppascm.project.service.ReviewScheduleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequestMapping("/api/reviews")
@CrossOrigin(origins = "*") // React frontend integration
public class ReviewScheduleController {

    @Autowired
    private ReviewScheduleService reviewScheduleService;

    // 1️⃣ Assign reviewers (by class coordinator)
    @PostMapping("/assign")
    public List<ReviewSchedule> assignReviewers(
            @RequestParam Long teamId,
            @RequestParam List<Long> mentorIds, // Expects 3 mentor IDs
            @RequestParam int reviewRound,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate startDate,
            @RequestParam @DateTimeFormat(iso = DateTimeFormat.ISO.DATE) LocalDate endDate
    ) {
        return reviewScheduleService.assignReviewers(teamId, mentorIds, reviewRound, startDate, endDate);
    }

    // 2️⃣ Submit review by mentor
    @PostMapping("/submit")
    public ReviewSchedule submitReview(
            @RequestParam Long teamId,
            @RequestParam Long mentorId,
            @RequestParam int reviewRound,
            @RequestParam int marks
    ) {
        return reviewScheduleService.submitReview(teamId, mentorId, reviewRound, marks);
    }

    // 3️⃣ Optional: Get all reviews of a team
    @GetMapping("/team/{teamId}")
    public List<ReviewSchedule> getReviewsForTeam(@PathVariable Long teamId) {
        return reviewScheduleService.getReviewsByTeam(teamId);
    }
}
