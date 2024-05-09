package com.Main.domain.userMatch.domain.repository;

import com.Main.domain.userMatch.domain.entity.UserMatch;

import java.util.List;

public interface UserMatchRepository {
    Long countByMatchesId(Long matchedId);
    List<UserMatch> findAllByMatchesId(Long matchesId);
}
