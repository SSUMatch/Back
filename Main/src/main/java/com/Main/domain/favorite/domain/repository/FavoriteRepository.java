package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;

import java.util.List;

public interface FavoriteRepository {

    List<Favorite> findByUserId(Long userId);
}
