package com.Main.domain.elo.controller;

import com.Main.domain.elo.dto.EloResultDto;
import com.Main.domain.elo.service.EloRatingService;
import com.Main.domain.match.application.dto.SimpleMatchInfoResponse;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/elo")
@RequiredArgsConstructor
public class EloController {
    private final EloRatingService eloRatingService;
    @GetMapping
    ApiResponse<List<EloResultDto>> eloReating(@RequestParam(name = "matchesId") Long matchesId){
        final List<EloResultDto> eloResultDtos = eloRatingService.updateUserRatings(matchesId);
        return ApiResponse.onSuccess(eloResultDtos);
    }
}
