package com.Main.domain.match.application.dto;

import java.time.LocalDate;

public record SimpleMatchDateInfoResponse(
        Long matchId,
        String time,
        String name,
        String type,
        String status,
        LocalDate date
) {
    public static SimpleMatchDateInfoResponse of(Long matchId, String time, String name, String type, String status, LocalDate date) {
        return new SimpleMatchDateInfoResponse(matchId, time, name, type, status, date);
    }

    public LocalDate getDate() {
        return date;
    }
}