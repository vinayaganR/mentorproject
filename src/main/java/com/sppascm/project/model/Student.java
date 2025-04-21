package com.sppascm.project.model;

import jakarta.persistence.*;

@Entity
@Table(name = "students")
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true, nullable = false)
    private String kuId;

    @Column(nullable = false)
    private String password;

    public Student() {}

    public Student(String kuId, String password) {
        this.kuId = kuId;
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public String getKuId() {
        return kuId;
    }

    public void setKuId(String kuId) {
        this.kuId = kuId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
