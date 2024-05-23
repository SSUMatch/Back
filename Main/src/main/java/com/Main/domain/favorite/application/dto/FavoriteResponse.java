package com.Main.domain.favorite.application.dto;

import com.Main.domain.favorite.domain.entity.Favorite;

public record FavoriteResponse(
        Long favoriteId,
        String region,
        String name,
        String address
) {
    public static FavoriteResponse of(Favorite favorite, String region) {
        return new FavoriteResponse(
                favorite.getId(),
                region,
                favorite.getPlace().getName(),
                favorite.getPlace().getAddress()
        );
    }
}
