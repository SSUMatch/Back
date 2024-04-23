package com.Main.domain.userMatch.domain.repository;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class UserMatchRepositoryImpl implements UserMatchRepository{
    private final UserMatchRepositoryJpa userMatchRepositoryJpa;
    @Override
    public Long countByMatchesId(Long matchesId){
        return userMatchRepositoryJpa.countByMatchesId(matchesId);
    }
}
