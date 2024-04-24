package com.Main.domain.match.domain.repository;

import com.Main.domain.match.domain.entity.Matches;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface MatchesRepository {
    Page<Matches> findAllByDate(Pageable pageable, String date);
    Matches findById(Long matchesId);
}
