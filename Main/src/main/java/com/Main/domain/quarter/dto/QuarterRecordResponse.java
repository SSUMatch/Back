package com.Main.domain.quarter.dto;

import com.Main.domain.quarter.entity.QuarterInfo;
import com.Main.domain.record.application.dto.SimpleRecordResponse;
import com.Main.domain.record.domain.entity.Record;

import java.util.List;

public record QuarterRecordResponse(
        String quarter,
        int goal,
        int assist,
        int defense,
        String team1,
        String team2,
        int team1Goal,
        int team2Goal,
        List<SimpleRecordResponse> team1Record,
        List<SimpleRecordResponse> team2Record
) {
    public static QuarterRecordResponse of(String quarter, int goal, int assist, int defense, TeamDto teamDto){
        return new QuarterRecordResponse(quarter, goal, assist, defense, teamDto.team1(), teamDto.team2(), teamDto.team1Goal(), teamDto.team2Goal(), teamDto.team1Record(),teamDto.team2Record());
    }
}
