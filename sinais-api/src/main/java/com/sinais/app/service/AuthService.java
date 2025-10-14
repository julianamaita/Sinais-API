package com.sinais.app.service;

import com.sinais.app.security.JwtUtil;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import com.sinais.app.domain.User;
import com.sinais.app.repository.UserRepository;
import java.util.List;

@Service
public class AuthService {

    private final UserRepository repo;
    private final PasswordEncoder encoder;
    private final JwtUtil jwt;

    public AuthService(UserRepository repo, PasswordEncoder encoder, JwtUtil jwt) {
        this.repo = repo;
        this.encoder = encoder;
        this.jwt = jwt;
    }

    public String authenticate(String email, String rawPassword) {
        User user = repo.findByEmail(email).orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
        if (!encoder.matches(rawPassword, user.getPasswordHash())) throw new RuntimeException("Senha inválida");
        return jwt.generateToken(user.getEmail(), user.getRoles().stream().toList());
    }
}
