package com.sinais.app.service;

import com.sinais.app.domain.User;
import com.sinais.app.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;

    public UserService(UserRepository repo, PasswordEncoder encoder) {
        this.repo = repo;
        this.encoder = encoder;
    }

    public User register(String email, String rawPassword, String fullName) {
        if (repo.existsByEmail(email)) throw new IllegalArgumentException("Email já cadastrado");
        String hash = encoder.encode(rawPassword);
        return repo.save(new User(email, hash, fullName));
    }

    public Optional<User> findByEmail(String email) { return repo.findByEmail(email); }
}
