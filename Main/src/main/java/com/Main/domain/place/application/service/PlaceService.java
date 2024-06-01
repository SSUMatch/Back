package com.Main.domain.place.application.service;

import com.Main.domain.place.application.dto.PlaceInfoResponse;
import com.Main.domain.place.domain.dto.PlaceDto;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.place.domain.repository.PlaceRepository;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Set;
import java.util.TreeSet;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class PlaceService {

    private final PlaceRepository placeRepository;


    public Set<PlaceInfoResponse> getWgs84(double lat1, double lon1) {
        TreeSet<PlaceInfoResponse> placeInfoSet = new TreeSet<>();
        double maxDistance = 30.0; // km

        List<PlaceDto> allWithinDistance = placeRepository.findAllWithinDistance(lat1, lon1, maxDistance);

        for (PlaceDto placeDto : allWithinDistance) {
            placeInfoSet.add(PlaceInfoResponse.of(placeDto));
        }

        return placeInfoSet;
    }
}
