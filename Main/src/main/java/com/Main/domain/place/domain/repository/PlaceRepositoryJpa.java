package com.Main.domain.place.domain.repository;

import com.Main.domain.place.domain.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PlaceRepositoryJpa extends JpaRepository<Place, Long> {

    Place findByAddressAndName(String address, String name);
}
