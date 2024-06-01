package com.Main.domain.place.domain.service;

import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.place.domain.repository.PlaceRepository;
import com.Main.domain.place.domain.repository.PlaceRepositoryJpa;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import static com.Main.global.error.status.ErrorStatus.PLACE_NOT_FOUND;

@Service
@RequiredArgsConstructor
public class PlaceReader {
    private final PlaceRepository placeRepository;
    public Place findById(Long placeId){
        return placeRepository.findById(placeId).orElseThrow(()->new GeneralException(PLACE_NOT_FOUND));
    }

}
