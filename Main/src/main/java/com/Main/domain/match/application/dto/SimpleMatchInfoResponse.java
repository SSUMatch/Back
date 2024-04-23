package com.Main.domain.match.application.dto;

public record SimpleMatchInfoResponse(
        String time,
        String name,
        String type,
        String status
) {
    public static SimpleMatchInfoResponse of(String time, String name, String type, String status){
        return new SimpleMatchInfoResponse(time, name,type,status);
    }
}
