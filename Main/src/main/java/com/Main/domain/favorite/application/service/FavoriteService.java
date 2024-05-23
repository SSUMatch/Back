package com.Main.domain.favorite.application.service;

import com.Main.domain.favorite.application.dto.FavoriteResponse;
import com.Main.domain.favorite.domain.entity.Favorite;
import com.Main.domain.favorite.domain.repository.FavoriteRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
@RequiredArgsConstructor
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final KakaoMapService kaKaoMapService;

    @Transactional(readOnly = true)
    public List<FavoriteResponse> getFavoritePlace(Long userId) {
        return favoriteRepository.findByUserId(userId).stream()
                .map(this::mapToFavoriteResponse)
                .collect(Collectors.toList());
    }

    private FavoriteResponse mapToFavoriteResponse(Favorite favorite) {
        String address = favorite.getPlace().getAddress();
        String region = kaKaoMapService.getRegionFromAddress(address);
        return FavoriteResponse.of(favorite, region);
    }

}
