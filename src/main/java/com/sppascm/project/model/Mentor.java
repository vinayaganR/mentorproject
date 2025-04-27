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

    private int maxSlots;   // total slots mentor has
    private int usedSlots;  // how many teams already assigned

    public Mentor() {}

    public Mentor(String mentorId, String password, int maxSlots) {
        this.mentorId = mentorId;
        this.password = password;
        this.maxSlots = maxSlots;
        this.usedSlots = 0; // default value when mentor is created
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public int getMaxSlots() {
        return maxSlots;
    }

    public void setMaxSlots(int maxSlots) {
        this.maxSlots = maxSlots;
    }

    public int getUsedSlots() {
        return usedSlots;
    }

    public void setUsedSlots(int usedSlots) {
        this.usedSlots = usedSlots;
    }
}
