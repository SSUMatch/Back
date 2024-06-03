package com.Main.domain.userMatch.domain.repository;

import com.Main.domain.team.entity.TeamType;
import com.Main.domain.userMatch.domain.entity.UserMatch;

import java.util.List;

public interface UserMatchRepository {
    Long countByMatchesId(Long matchesId);
    List<UserMatch> findAllByMatchesId(Long matchesId);
    List<UserMatch> findAllByUserId(Long userId);
    List<UserMatch> findAllByMatchesIdAndTeamType(Long matchesId, TeamType teamType);
    UserMatch findByUserIdAndMatchesId(Long userId, Long matchesId);
}
