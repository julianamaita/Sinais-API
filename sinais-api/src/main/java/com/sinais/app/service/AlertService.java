package com.sinais.app.service;

import com.sinais.app.domain.Alert;
import com.sinais.app.domain.User;
import com.sinais.app.repository.AlertRepository;
import com.sinais.app.repository.UserRepository;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AlertService {

    private final AlertRepository repo;
    private final UserRepository userRepo;

    public AlertService(AlertRepository repo, UserRepository userRepo) {
        this.repo = repo;
        this.userRepo = userRepo;
    }

    public Alert create(Long userId, String type, String message) {
        User u = userRepo.findById(userId).orElseThrow();
        Alert a = new Alert();
        a.setUser(u);
        a.setType(type);
        a.setMessage(message);
        return repo.save(a);
    }

    public List<Alert> byUser(Long userId) {
        User u = userRepo.findById(userId).orElseThrow();
        return repo.findByUser(u);
    }
}
