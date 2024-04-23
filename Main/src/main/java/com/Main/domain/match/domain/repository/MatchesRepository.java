package com.Main.domain.match.domain.repository;

import com.Main.domain.match.domain.entity.Matches;

import java.util.List;

public interface MatchesRepository {
    List<Matches> findAllByDate(String date);
    Matches findById(Long matchesId);
}
