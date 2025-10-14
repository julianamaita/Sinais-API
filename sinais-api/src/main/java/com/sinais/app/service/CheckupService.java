package com.sinais.app.service;

import com.sinais.app.domain.Checkup;
import com.sinais.app.domain.User;
import com.sinais.app.repository.CheckupRepository;
import com.sinais.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class CheckupService {

    private final CheckupRepository repo;
    private final UserRepository userRepo;

    public CheckupService(CheckupRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public Checkup create(Long userId, Integer riskScore, String notes) {
        User u = userRepo.findById(userId).orElseThrow();
        Checkup c = new Checkup();
        c.setUser(u);
        c.setRiskScore(riskScore);
        c.setNotes(notes);
        return repo.save(c);
    }

    public List<Checkup> byUser(Long userId) {
        User u = userRepo.findById(userId).orElseThrow();
        return repo.findByUser(u);
    }
}
