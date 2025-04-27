package com.sppascm.project.model;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "review_rounds")
public class ReviewRound {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name; // Example: "First Review", "Second Review"

    @Column(nullable = false)
    private LocalDate startDate;

    @Column(nullable = false)
    private LocalDate endDate;

    private boolean isActive; // Can be used to enable/disable review window

    public ReviewRound() {}

    public ReviewRound(String name, LocalDate startDate, LocalDate endDate, boolean isActive) {
        this.name = name;
        this.startDate = startDate;
        this.endDate = endDate;
        this.isActive = isActive;
    }

    // Getters & setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }
}
