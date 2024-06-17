package com.Main.domain.place.application.dto;

import com.Main.domain.place.domain.dto.PlaceDto;

import java.math.BigDecimal;
import java.math.RoundingMode;

public record PlaceInfoResponse(
        Long placeId,
        String name,
        String distance
//        double latitude,
//        double longitude
) implements Comparable<PlaceInfoResponse> {

    public static PlaceInfoResponse of(PlaceDto placeDto) {
        // 소수 둘째 자리에서 반올림
        double roundedDistance = BigDecimal.valueOf(placeDto.distance())
                .setScale(1, RoundingMode.HALF_UP)
                .doubleValue();

        String distanceString = roundedDistance + "km";

        return new PlaceInfoResponse(
                placeDto.placeId(),
                placeDto.name(),
                distanceString);
//                placeDto.latitude(),
//                placeDto.longitude());
    }

    @Override
    public int compareTo(PlaceInfoResponse other) {
        double thisDistance = Double.parseDouble(this.distance.replace("km", ""));
        double otherDistance = Double.parseDouble(other.distance.replace("km", ""));
        return Double.compare(thisDistance, otherDistance);
    }
}
