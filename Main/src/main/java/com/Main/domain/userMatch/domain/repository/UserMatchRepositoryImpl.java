package com.Main.domain.userMatch.domain.repository;

import com.Main.domain.team.entity.TeamType;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@RequiredArgsConstructor
public class UserMatchRepositoryImpl implements UserMatchRepository{
    private final UserMatchRepositoryJpa userMatchRepositoryJpa;
    @Override
    public Long countByMatchesId(Long matchesId){
        return userMatchRepositoryJpa.countByMatchesId(matchesId);
    }
    @Override
    public List<UserMatch> findAllByMatchesId(Long matchesId){
        return userMatchRepositoryJpa.findAllByMatchesId(matchesId);
    }
    @Override
    public List<UserMatch> findAllByUserId(Long userId){
        return userMatchRepositoryJpa.findAllByUserId(userId);
    }
    @Override
    public List<UserMatch> findAllByMatchesIdAndTeamType(Long matchesId, TeamType teamType){
        return userMatchRepositoryJpa.findAllByMatchesIdAndTeamType(matchesId,teamType);
    }
    @Override
    public UserMatch findByUserIdAndMatchesId(Long userId, Long matchesId){
        return userMatchRepositoryJpa.findByUserIdAndMatchesId(userId,matchesId);
    }
}
