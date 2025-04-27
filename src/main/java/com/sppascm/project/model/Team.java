package com.sppascm.project.model;

import jakarta.persistence.*;

@Entity
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String teamName;

    @OneToOne
    private Student student1;

    @OneToOne
    private Student student2;

    @ManyToOne
    private Mentor mentor;

    private boolean mentorAssigned;

    // 👉 Default constructor
    public Team() {
    }

    // 👉 Parameterized constructor
    public Team(Long id, String teamName, Student student1, Student student2, Mentor mentor, boolean mentorAssigned) {
        this.id = id;
        this.teamName = teamName;
        this.student1 = student1;
        this.student2 = student2;
        this.mentor = mentor;
        this.mentorAssigned = mentorAssigned;
    }

    // 👉 Getters & Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTeamName() {
        return teamName;
    }

    public void setTeamName(String teamName) {
        this.teamName = teamName;
    }

    public Student getStudent1() {
        return student1;
    }

    public void setStudent1(Student student1) {
        this.student1 = student1;
    }

    public Student getStudent2() {
        return student2;
    }

    public void setStudent2(Student student2) {
        this.student2 = student2;
    }

    public Mentor getMentor() {
        return mentor;
    }

    public void setMentor(Mentor mentor) {
        this.mentor = mentor;
    }

    public boolean isMentorAssigned() {
        return mentorAssigned;
    }

    public void setMentorAssigned(boolean mentorAssigned) {
        this.mentorAssigned = mentorAssigned;
    }
}
