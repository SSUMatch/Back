package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;
import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepository {

    List<Favorite> findByUserId(Long userId);

    Favorite saveFavorite(Long userId, String location); // 사용자 차단 추가

}
