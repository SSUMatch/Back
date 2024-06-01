package com.Main.domain.place.domain.repository;

import com.Main.domain.place.domain.dto.PlaceDto;
import com.Main.domain.place.domain.entity.Place;
import com.querydsl.core.Tuple;
import com.querydsl.core.types.dsl.Expressions;
import com.querydsl.core.types.dsl.NumberTemplate;
import com.querydsl.jpa.impl.JPAQueryFactory;
import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static com.Main.domain.place.domain.entity.QPlace.*;

@RequiredArgsConstructor
@Repository
public class PlaceRepositoryImpl implements PlaceRepository {

    private final PlaceRepositoryJpa placeRepositoryJpa;
    private final EntityManager em;

    @Override
    public Place findByAddressAndName(String address, String name) {
        return placeRepositoryJpa.findByAddressAndName(address, name);
    }

    @Override
    public Optional<Place> findById(Long placeId) {
        return placeRepositoryJpa.findById(placeId);
    }

    @Override
    public List<PlaceDto> findAllWithinDistance(double lat, double lon, double distance) {

        JPAQueryFactory queryFactory = new JPAQueryFactory(em);
        double radiusOfEarthKm = 6371.0;
        NumberTemplate<Double> haversineDistance = createHaversineDistanceExpression(radiusOfEarthKm, lat, lon);

        List<Tuple> results = queryFactory.select(place, haversineDistance.as("distance"))
                .from(place)
                .where(haversineDistance.loe(distance))
                .fetch();

        return results.stream()
                .map(tuple -> {
                    Place p = tuple.get(place);
                    Double dist = tuple.get(haversineDistance.as("distance"));
                    return PlaceDto.of(p, dist);
                })
                .collect(Collectors.toList());
    }

    private NumberTemplate<Double> createHaversineDistanceExpression(double radiusOfEarthKm, double lat, double lon) {
        return Expressions.numberTemplate(Double.class,
                "{0} * acos(cos(radians({1})) * cos(radians({2})) * cos(radians({3}) - radians({4})) + sin(radians({1})) * sin(radians({2})))",
                radiusOfEarthKm, lat, place.latitude, place.longitude, lon);
    }
}
