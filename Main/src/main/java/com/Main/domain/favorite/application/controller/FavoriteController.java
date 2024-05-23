package com.Main.domain.favorite.application.controller;

import com.Main.domain.favorite.application.dto.FavoriteResponse;
import com.Main.domain.favorite.application.service.FavoriteService;
import com.Main.domain.user.application.dto.response.AddBlockResponse;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class FavoriteController {

    private final FavoriteService favoriteService;

    @GetMapping("/{userId}/favorites")
    public ApiResponse<List<FavoriteResponse>> getFavoriteInfo(@PathVariable("userId") Long userId) {
        List<FavoriteResponse> favoritePlace = favoriteService.getFavoritePlace(userId);
        return ApiResponse.onSuccess(favoritePlace);
    }
}
