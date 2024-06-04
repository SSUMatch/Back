package com.Main.domain.match.domain.repository;

import com.Main.domain.match.domain.entity.Matches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface MatchesRepository {
    Page<Matches> findAllByDate(Pageable pageable, LocalDateTime date);
    Matches findById(Long matchesId);

    List<Matches> findByPlaceIdOrderByDateAndStartTime(Long placeId);
}
