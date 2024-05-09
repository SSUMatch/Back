package com.Main.domain.match.application.dto;

public record LevelDto(
        String level,
        String percent
) {
    public static LevelDto of(String level,
                              String percent){
        return new LevelDto(level, percent);
    }
}
