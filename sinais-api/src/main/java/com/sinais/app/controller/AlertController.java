package com.sinais.app.controller;

import com.sinais.app.dto.AlertDtos.CreateAlertRequest;
import com.sinais.app.service.AlertService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/alerts")
public class AlertController {

    private final AlertService service;

    public AlertController(AlertService service) { this.service = service; }

    @PostMapping
    public ResponseEntity<?> create(@RequestBody CreateAlertRequest req) {
        return ResponseEntity.ok(service.create(req.userId(), req.type(), req.message()));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> byUser(@PathVariable Long userId) {
        return ResponseEntity.ok(service.byUser(userId));
    }
}
