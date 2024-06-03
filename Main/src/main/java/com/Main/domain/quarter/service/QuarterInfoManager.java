package com.Main.domain.quarter.service;

import com.Main.domain.quarter.dto.TeamDto;
import com.Main.domain.quarter.entity.QuarterInfo;
import com.Main.domain.quarter.repository.QuarterInfoRepository;
import com.Main.domain.record.application.dto.SimpleRecordResponse;
import com.Main.domain.team.entity.TeamType;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@RequiredArgsConstructor
public class QuarterInfoManager {
    private final QuarterInfoRepository quarterInfoRepository;
    public int getGoalByUserMatchId(Long userMatchId) {
        List<QuarterInfo> quarterInfos = quarterInfoRepository.findAllByUserMatchId(userMatchId);
        return quarterInfos.stream()
                .mapToInt(QuarterInfo::getGoal)
                .sum();
    }

    public int getAssistByUserMatchId(Long userMatchId) {
        List<QuarterInfo> quarterInfos = quarterInfoRepository.findAllByUserMatchId(userMatchId);
        return quarterInfos.stream()
                .mapToInt(QuarterInfo::getAssist)
                .sum();
    }

    public int getDefenseByUserMatchId(Long userMatchId) {
        List<QuarterInfo> quarterInfos = quarterInfoRepository.findAllByUserMatchId(userMatchId);
        return quarterInfos.stream()
                .mapToInt(QuarterInfo::getDefence)
                .sum();
    }
    public TeamDto getTeamDto(List<QuarterInfo> quarterInfos) {
        // 1. 중복되지 않는 UserMatch 리스트 생성
        List<UserMatch> userMatchList = quarterInfos.stream().map(quarterInfo -> quarterInfo.getUserMatch()).toList();

        // 2. team1, team2 색깔 구하기
        String team1 = null;
        String team2 = null;
        for (UserMatch userMatch : userMatchList) {
            TeamType teamType = userMatch.getTeamType();
            if (team1 == null) {
                team1 = teamType.getColor();
            } else if (team2 == null && !teamType.getColor().equals(team1)) {
                team2 = teamType.getColor();
            }
        }

        // 3. team1Record, team2Record 생성
        List<SimpleRecordResponse> team1Record = new ArrayList<>();
        List<SimpleRecordResponse> team2Record = new ArrayList<>();
        int team1Goal = 0;
        int team2Goal = 0;
        for (QuarterInfo quarterInfo : quarterInfos) {
            UserMatch userMatch = quarterInfo.getUserMatch();
            if (userMatch.getTeamType().getColor().equals(team1)) {
                team1Record.add(SimpleRecordResponse.of(quarterInfo));
                team1Goal += quarterInfo.getGoal();
            } else {
                team2Record.add(SimpleRecordResponse.of(quarterInfo));
                team2Goal += quarterInfo.getGoal();
            }
        }

        // 4. TeamDto 반환
        return TeamDto.of(team1, team2, team1Goal, team2Goal, team1Record, team2Record);
    }
}
