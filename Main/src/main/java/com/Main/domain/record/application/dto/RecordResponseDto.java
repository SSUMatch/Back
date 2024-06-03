package com.Main.domain.record.application.dto;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.quarter.dto.QuarterRecordResponse;
import com.Main.domain.userMatch.domain.entity.UserMatch;

import java.util.List;

public record RecordResponseDto(
        Boolean isWin,
        String date,
        String place,
        String type,
        Boolean isPom,
        int point,
        int num,
        String color,
        List<QuarterRecordResponse> quarterRecords,
        List<SimpleTeamResponse> redTeam,
        List<SimpleTeamResponse> greenTeam,
        List<SimpleTeamResponse> blueTeam
) {
    public static RecordResponseDto of(Matches matches, Boolean isPom, String type, int point,
                                       UserMatch userMatch,
                                       List<QuarterRecordResponse> quarterRecords,
                                       List<SimpleTeamResponse> redTeam,
                                       List<SimpleTeamResponse> greenTeam,
                                       List<SimpleTeamResponse> blueTeam, Boolean isWin){
        return new RecordResponseDto(isWin,matches.getDate().toString(), matches.getPlace().getName(), type, isPom, point, userMatch.getNumber(), userMatch.getTeamType().getColor(),quarterRecords, redTeam,greenTeam,blueTeam );
    }
}
