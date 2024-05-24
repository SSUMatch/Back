package com.Main.domain.match.domain.repository;

import com.Main.domain.match.domain.entity.Matches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MatchesRepository {
    Page<Matches> findAllByDate(Pageable pageable, String date);
    Matches findById(Long matchesId);

    List<Matches> findByPlaceIdOrderByDateAndStartTime(Long placeId);
}
