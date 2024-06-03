package com.Main.domain.favorite.application.dto;

import com.Main.domain.favorite.domain.entity.Favorite;

public record AddFavoriteResponse(
        Long favoriteId,
        Long userId,
        String name,
        String address
) {
    public static AddFavoriteResponse of(Favorite favorite) {
        return new AddFavoriteResponse(
                favorite.getId(),
                favorite.getUser().getId(),
                favorite.getPlace().getName(),
                favorite.getPlace().getAddress()
        );
    }
}
