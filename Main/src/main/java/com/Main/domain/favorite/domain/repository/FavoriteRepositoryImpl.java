package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.user.domain.entity.User;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@RequiredArgsConstructor
@Repository
public class FavoriteRepositoryImpl implements FavoriteRepository {

    private final FavoriteRepositoryJpa favoriteRepositoryJpa;

    @Override
    public List<Favorite> findByUserId(Long userId) {
        return favoriteRepositoryJpa.findByUserId(userId);
    }

    @Override
    public Optional<Favorite> findById(Long favoriteId) {
        return favoriteRepositoryJpa.findById(favoriteId);
    }

    @Override
    public Favorite saveFavorite(User user, Place place) {
        return favoriteRepositoryJpa.save(Favorite.of(user, place));
    }

    @Override
    public Optional<Favorite> findByUserAndPlace(User user, Place place) {
        return favoriteRepositoryJpa.findByUserAndPlace(user, place);
    }

    @Override
    public List<Favorite> findAllById(List<Long> favoriteIds) {
        return favoriteRepositoryJpa.findAllById(favoriteIds);
    }

    @Override
    public void deleteAll(List<Favorite> favorites) {
        favoriteRepositoryJpa.deleteAll(favorites);
    }
}
