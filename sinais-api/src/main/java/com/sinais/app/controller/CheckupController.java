package com.sinais.app.controller;

import com.sinais.app.dto.CheckupDtos.CreateCheckupRequest;
import com.sinais.app.service.CheckupService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/checkups")
public class CheckupController {

    private final CheckupService service;

    public CheckupController(CheckupService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateCheckupRequest req) {
        return ResponseEntity.ok(service.create(req.userId(), req.riskScore(), req.notes()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.byUser(userId));
    }
}
