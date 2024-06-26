package com.Main.domain.userMatch.domain.service;

import com.Main.domain.team.entity.TeamType;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import com.Main.domain.userMatch.domain.repository.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserMatchReader {
    private final UserMatchRepository userMatchRepository;
    public List<UserMatch> findAllByMatchId(Long matchId){
        return userMatchRepository.findAllByMatchesId(matchId);
    }
    public List<UserMatch> getAllUserMatchByUserId(Long userId){
        return userMatchRepository.findAllByUserId(userId);
    }
    public List<UserMatch> getTeam(Long matchesId, TeamType teamType){
        return userMatchRepository.findAllByMatchesIdAndTeamType(matchesId, teamType);
    }
    public UserMatch findByUserIdAndMatchesId(Long userId, Long matchesId){
        return userMatchRepository.findByUserIdAndMatchesId(userId, matchesId);
    }
}
