package com.Main.domain.record.application.dto;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.quarter.dto.QuarterRecordResponse;
import com.Main.domain.userMatch.domain.entity.UserMatch;

import java.time.format.DateTimeFormatter;
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
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("yyyy년 M월 d일 (EE) a h:mm");
    public static RecordResponseDto of(Matches matches,String type,
                                       UserMatch userMatch,
                                       List<QuarterRecordResponse> quarterRecords,
                                       List<SimpleTeamResponse> redTeam,
                                       List<SimpleTeamResponse> greenTeam,
                                       List<SimpleTeamResponse> blueTeam){
        String formattedDate = matches.getDate().format(DATE_TIME_FORMATTER);
        return new RecordResponseDto(matches.getIsWin(),formattedDate, matches.getPlace().getName(), type, matches.getIsPom(), matches.getPom(), userMatch.getNumber(), userMatch.getTeamType().getColor(),quarterRecords, redTeam,greenTeam,blueTeam );
    }
}
