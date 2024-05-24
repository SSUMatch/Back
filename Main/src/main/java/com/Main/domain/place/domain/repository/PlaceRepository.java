package com.Main.domain.place.domain.repository;

import com.Main.domain.place.domain.entity.Place;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PlaceRepository extends JpaRepository<Place, Long> {

    Place findByAddressAndName(String address, String name);
}
