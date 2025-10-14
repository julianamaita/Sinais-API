package com.sinais.app.domain;

import jakarta.persistence.*;
import java.time.LocalDate;

@Entity
public class Checkup {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional=false)
    private User user;

    private LocalDate date = LocalDate.now();

    // Simple self-report score 0..100 (higher = more at risk)
    private Integer riskScore;

    @Column(length=1000)
    private String notes;

    public Long getId() { return id; }
    public User getUser() { return user; }
    public void setUser(User user) { this.user = user; }
    public LocalDate getDate() { return date; }
    public void setDate(LocalDate date) { this.date = date; }
    public Integer getRiskScore() { return riskScore; }
    public void setRiskScore(Integer riskScore) { this.riskScore = riskScore; }
    public String getNotes() { return notes; }
    public void setNotes(String notes) { this.notes = notes; }
}
