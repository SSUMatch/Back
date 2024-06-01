package com.Main.domain.place.application.controller;

import com.Main.domain.match.application.dto.SimpleMatchDateInfoResponse;
import com.Main.domain.match.application.service.MatchService;
import com.Main.domain.place.application.dto.LocationRequest;
import com.Main.domain.place.application.dto.PlaceInfoResponse;
import com.Main.domain.place.application.service.PlaceService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.Set;

@RestController
@RequestMapping("/places")
@RequiredArgsConstructor
public class PlaceController {

    private final PlaceService placeService;
    private final MatchService matchService;

    @PostMapping("/nearby")
    public Set<PlaceInfoResponse> getNearbyPlaces(@RequestBody LocationRequest locationRequest) {
        return placeService.getWgs84(locationRequest.latitude(), locationRequest.longitude());
    }

    @GetMapping("/{placeId}/matches")
    public ApiResponse<Map<LocalDate, List<SimpleMatchDateInfoResponse>>> getMatchesByFavorite(
            @PathVariable("placeId") Long placeId) {
        Map<LocalDate, List<SimpleMatchDateInfoResponse>> matchesGroupedByDate = matchService.getMatchesByFavorite(placeId);
        return ApiResponse.onSuccess(matchesGroupedByDate);
    }

}
