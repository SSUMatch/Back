package com.Main.domain.match.application.dto;

public record SimpleMatchInfoResponse(
        Long matchId,
        String time,
        String name,
        String type,
        String status
) {
    public static SimpleMatchInfoResponse of(Long matchId, String time, String name, String type, String status){
        return new SimpleMatchInfoResponse(matchId,time, name,type,status);
    }
}
