package com.Main.domain.favorite.application.controller;

import com.Main.domain.favorite.application.dto.AddFavoriteResponse;
import com.Main.domain.favorite.application.dto.FavoriteResponse;
import com.Main.domain.favorite.application.service.FavoriteService;
import com.Main.domain.match.application.dto.SimpleMatchDateInfoResponse;
import com.Main.domain.match.application.service.MatchService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;
    private final MatchService matchService;

    @GetMapping("/{userId}/favorites")
    public ApiResponse<List<FavoriteResponse>> getFavoriteInfo(@PathVariable("userId") Long userId) {
        List<FavoriteResponse> favoritePlace = favoriteService.getFavoritePlace(userId);
        return ApiResponse.onSuccess(favoritePlace);
    }

    @PostMapping("/{userId}/favorites")
    public ApiResponse<AddFavoriteResponse> addFavorite(@PathVariable("userId") Long userId, @RequestParam("location") String location, @RequestParam("placeName") String placeName ) {
        AddFavoriteResponse addFavoriteResponse = favoriteService.addFavorite(userId, location, placeName);
        return ApiResponse.onSuccess(addFavoriteResponse);
    }

    @DeleteMapping("/{userId}/favorites")
    public ApiResponse<Void> deleteFavorites(@PathVariable("userId") Long userId, @RequestBody List<Long> favoriteIds) {
        favoriteService.deleteFavorites(userId, favoriteIds);
        return ApiResponse.onSuccess();
    }
}
