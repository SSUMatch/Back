package com.Main.domain.match.application.dto;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public record MatchDetailResponse(
        String image,
        MatchData matchData,
        PlaceInfo placeInfo,
        MatchInfo matchInfo,
        String date,
        String placeName,
        String location,
        String price
) {
    private static final DateTimeFormatter DATE_TIME_FORMATTER = DateTimeFormatter.ofPattern("M월 d일 E요일 a h:mm");
    public static MatchDetailResponse of(String image,
                                         MatchData matchData,
                                         PlaceInfo placeInfo,
                                         MatchInfo matchInfo,
                                         LocalDateTime date,
                                         String placeName,
                                         String location,
                                         String price){
        String formattedDate = date.format(DATE_TIME_FORMATTER);
        return new MatchDetailResponse(image, matchData, placeInfo, matchInfo, formattedDate, placeName, location, price);
    }
}
