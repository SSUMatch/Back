package com.Main.domain.match.application.dto;

import java.util.List;

public record MatchData(
        String expect,
        List<LevelDto> levels
) {
    public static MatchData of(String expect,
                               List<LevelDto> levels){
        return new MatchData(expect, levels);
    }
}
