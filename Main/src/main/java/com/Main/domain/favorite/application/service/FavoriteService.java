package com.Main.domain.favorite.application.service;

import com.Main.domain.favorite.application.dto.AddFavoriteResponse;
import com.Main.domain.favorite.application.dto.FavoriteResponse;
import com.Main.domain.favorite.domain.entity.Favorite;
import com.Main.domain.favorite.domain.repository.FavoriteRepository;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.place.domain.repository.PlaceRepository;
import com.Main.domain.place.domain.repository.PlaceRepositoryJpa;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.domain.repository.UserRepository;
import com.Main.global.error.exception.GeneralException;
import com.Main.service.kakaomap.KakaoMapService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.Main.global.error.status.ErrorStatus.ALREADY_FAVORITE_EXIST;

@Service
@Transactional
@RequiredArgsConstructor
@Slf4j
public class FavoriteService {

    private final FavoriteRepository favoriteRepository;
    private final UserRepository userRepository;
    private final PlaceRepository placeRepository;
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

    public AddFavoriteResponse addFavorite(Long userId, String location, String name) {
        User user = userRepository.findById(userId);
        Place place = placeRepository.findByAddressAndName(location, name);

        Optional<Favorite> existingFavorite = favoriteRepository.findByUserAndPlace(user, place);
        if (existingFavorite.isPresent()) {
            throw new GeneralException(ALREADY_FAVORITE_EXIST);
        }
        return AddFavoriteResponse.of(favoriteRepository.saveFavorite(user, place));
    }

    public void deleteFavorites(Long userId, List<Long> favoriteIds) {
        List<Favorite> favorites = favoriteRepository.findAllById(favoriteIds);
        for (Favorite favorite : favorites) {
            if (!favorite.getUser().getId().equals(userId)) {
                throw new IllegalArgumentException();
            }
        }
        favoriteRepository.deleteAll(favorites);
    }

}
