package com.Main.domain.quarter.dto;

import com.Main.domain.record.application.dto.SimpleRecordResponse;

import java.util.List;

public record TeamDto(
        String team1,
        String team2,
        int team1Goal,
        int team2Goal,
        List<SimpleRecordResponse> team1Record,
        List<SimpleRecordResponse> team2Record

) {
    public static TeamDto of(String team1, String team2,int team1Goal,
                             int team2Goal,
                             List<SimpleRecordResponse> team1Record,
                             List<SimpleRecordResponse> team2Record){
        return new TeamDto(team1, team2, team1Goal, team2Goal, team1Record, team2Record);
    }
}
