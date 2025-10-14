package com.sinais.app.dto;

public class AlertDtos {
    public record CreateAlertRequest(Long userId, String type, String message) {}
}
