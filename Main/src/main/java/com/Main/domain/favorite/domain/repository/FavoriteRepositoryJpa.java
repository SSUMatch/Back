package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface FavoriteRepositoryJpa extends JpaRepository<Favorite, Long> {

    @Query("SELECT f FROM Favorite f JOIN f.place WHERE f.user.id = :userId ORDER BY f.place.address ASC")
    List<Favorite> findByUserId(@Param("userId") Long userId);
}
