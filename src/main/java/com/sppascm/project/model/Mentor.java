package com.sppascm.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "mentors")
public class Mentor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String mentorId;

    @Column(nullable = false)
    private String password;

    public Mentor() {}

    public Mentor(String mentorId, String password) {
        this.mentorId = mentorId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getMentorId() {
        return mentorId;
    }

    public void setMentorId(String mentorId) {
        this.mentorId = mentorId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
