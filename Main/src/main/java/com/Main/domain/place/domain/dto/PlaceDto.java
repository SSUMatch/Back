package com.Main.domain.place.domain.dto;

import com.Main.domain.place.domain.entity.Place;

public record PlaceDto(
        Long placeId,
        String name,
        double distance,
        double latitude,
        double longitude
) {
    public static PlaceDto of(Place place, double distance) {
        return new PlaceDto(
                place.getId(),
                place.getName(),
                distance,
                place.getLatitude(),
                place.getLongitude()
        );
    }
}
