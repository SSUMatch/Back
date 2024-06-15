package com.Main.domain.record.application.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record PointResponseDto(
        int point,
        String date
) {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy년 M월 d일");
    public static PointResponseDto of(int point, LocalDateTime date){
        String formattedDate = date.format(DATE_TIME_FORMATTER);
        return new PointResponseDto(point, formattedDate);
    }
}
