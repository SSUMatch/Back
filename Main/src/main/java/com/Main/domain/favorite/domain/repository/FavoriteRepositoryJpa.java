package com.Main.domain.favorite.domain.repository;

import com.Main.domain.favorite.domain.entity.Favorite;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface FavoriteRepositoryJpa extends JpaRepository<Favorite, Long> {

    @Query("SELECT f FROM Favorite f JOIN f.place WHERE f.user.id = :userId ORDER BY f.place.address ASC")
    List<Favorite> findByUserId(@Param("userId") Long userId);

    Optional<Favorite> findByUserAndPlace(User user, Place place);
    Optional<Favorite> findByUserIdAndPlaceId(Long userId, Long placeId);
}
