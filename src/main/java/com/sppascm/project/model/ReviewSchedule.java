package com.sppascm.project.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "review_schedule")
public class ReviewSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Which team this review is for
    @ManyToOne
    @JoinColumn(name = "team_id", nullable = false)
    private Team team;

    // Which mentor is reviewing
    @ManyToOne
    @JoinColumn(name = "reviewer_id", nullable = false)
    private Mentor reviewer;

    // 1st, 2nd, 3rd, or 4th review
    private int reviewRound;

    private LocalDate startDate;
    private LocalDate endDate;

    private int marks; // out of 100
    private boolean signatureSubmitted;

    public ReviewSchedule() {}

    public ReviewSchedule(Team team, Mentor reviewer, int reviewRound, LocalDate startDate, LocalDate endDate) {
        this.team = team;
        this.reviewer = reviewer;
        this.reviewRound = reviewRound;
        this.startDate = startDate;
        this.endDate = endDate;
        this.signatureSubmitted = false;
        this.marks = 0;
    }

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public Team getTeam() {
        return team;
    }

    public void setTeam(Team team) {
        this.team = team;
    }

    public Mentor getReviewer() {
        return reviewer;
    }

    public void setReviewer(Mentor reviewer) {
        this.reviewer = reviewer;
    }

    public int getReviewRound() {
        return reviewRound;
    }

    public void setReviewRound(int reviewRound) {
        this.reviewRound = reviewRound;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public int getMarks() {
        return marks;
    }

    public void setMarks(int marks) {
        this.marks = marks;
    }

    public boolean isSignatureSubmitted() {
        return signatureSubmitted;
    }

    public void setSignatureSubmitted(boolean signatureSubmitted) {
        this.signatureSubmitted = signatureSubmitted;
    }
}
