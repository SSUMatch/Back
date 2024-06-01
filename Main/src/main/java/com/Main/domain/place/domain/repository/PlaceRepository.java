package com.Main.domain.place.domain.repository;

import com.Main.domain.place.domain.dto.PlaceDto;
import com.Main.domain.place.domain.entity.Place;

import java.util.List;
import java.util.Optional;

public interface PlaceRepository {

    Optional<Place> findById(Long placeId);
    Place findByAddressAndName(String address, String name);

    List<PlaceDto> findAllWithinDistance(double lat, double lon, double distance);
}
