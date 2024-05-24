package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository {

    List<Favorite> findByUserId(Long userId);

    Optional<Favorite> findById(Long favoriteId);

    Favorite saveFavorite(User user, Place place);

    Optional<Favorite> findByUserAndPlace(User user, Place place);

    List<Favorite> findAllById(List<Long> favoriteIds);

    void deleteAll(List<Favorite> favorites);

}
