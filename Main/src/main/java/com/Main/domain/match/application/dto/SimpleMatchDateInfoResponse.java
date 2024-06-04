package com.Main.domain.match.application.dto;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public record SimpleMatchDateInfoResponse(
        Long matchId,
        String time,
        String name,
        String type,
        String status,
        String date
) {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (EE) a h:mm");
    public static SimpleMatchDateInfoResponse of(Long matchId, String time, String name, String type, String status, LocalDate date) {
        String formattedDate = date.format(DATE_TIME_FORMATTER);
        return new SimpleMatchDateInfoResponse(matchId, time, name, type, status, formattedDate);
    }

    public String getDate() {
        return date;
    }
}