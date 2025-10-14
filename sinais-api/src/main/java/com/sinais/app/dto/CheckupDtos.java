package com.sinais.app.dto;

public class CheckupDtos {
    public record CreateCheckupRequest(Long userId, Integer riskScore, String notes) {}
}
