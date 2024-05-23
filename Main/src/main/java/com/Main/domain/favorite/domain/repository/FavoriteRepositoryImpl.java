package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@RequiredArgsConstructor
@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {

    private final FavoriteRepositoryJpa favoriteRepositoryJpa;

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return favoriteRepositoryJpa.findByUserId(userId);
    }

    @Override
    public Favorite saveFavorite(Long userId, String location) {
        return null;
    }
}
