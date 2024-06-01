package com.Main.domain.place.application.controller;

import com.Main.domain.place.application.dto.LocationRequest;
import com.Main.domain.place.application.dto.PlaceInfoResponse;
import com.Main.domain.place.application.service.PlaceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Set;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;

    @PostMapping("/nearby")
    public Set<PlaceInfoResponse> getNearbyPlaces(@RequestBody LocationRequest locationRequest) {
        return placeService.getWgs84(locationRequest.latitude(), locationRequest.longitude());
    }
}
