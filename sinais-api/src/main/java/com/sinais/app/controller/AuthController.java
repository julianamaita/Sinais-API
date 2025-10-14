package com.sinais.app.controller;

import com.sinais.app.dto.AuthDtos.*;
import com.sinais.app.service.UserService;
import com.sinais.app.service.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final UserService userService;
    private final AuthService authService;

    public AuthController(UserService userService, AuthService authService) {
        this.userService = userService;
        this.authService = authService;
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterRequest req) {
        var u = userService.register(req.email(), req.password(), req.fullName());
        return ResponseEntity.ok(new TokenResponse(authService.authenticate(u.getEmail(), req.password())));
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody LoginRequest req) {
        String token = authService.authenticate(req.email(), req.password());
        return ResponseEntity.ok(new TokenResponse(token));
    }
}
