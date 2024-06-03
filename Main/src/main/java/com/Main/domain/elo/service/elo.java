package com.Main.domain.elo.service;

import com.Main.domain.elo.dto.EloResultDto;
import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.service.MatchesReader;
import com.Main.domain.quarter.entity.QuarterInfo;
import com.Main.domain.quarter.service.QuarterInfoReader;
import com.Main.domain.team.entity.TeamType;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import com.Main.domain.userMatch.domain.repository.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class elo {
    private static final int K_FACTOR = 32;
    private static final int SCALE_FACTOR = 400;

    private final UserMatchRepository userMatchRepository;
    private final MatchesReader matchesReader;
    private final QuarterInfoReader quarterInfoReader;

    public List<EloResultDto> updateUserRatings(Long matchId) {
        Matches match = matchesReader.findById(matchId);
        List<UserMatch> userMatches = userMatchRepository.findAllByMatchesId(matchId);
        TeamType winnerTeam = match.getWinner();

        List<EloResultDto> eloResults = new ArrayList<>();

        for (UserMatch userMatch : userMatches) {
            User user = userMatch.getUser();
            double currentRating = user.getRecord().getScore();
            TeamType userTeam = userMatch.getTeamType();

            double teamAverageRating = getTeamAverageRating(userTeam, userMatches);
            double expectedScore = getExpectedScore(teamAverageRating, winnerTeam, userTeam);
            double actualScore = calculateActualScore(userMatch, match);
            double newRating = calculateNewRating(currentRating, actualScore, expectedScore, winnerTeam, userTeam);

            eloResults.add(EloResultDto.of(user.getId(), currentRating, newRating));

            user.getRecord().setScore(newRating);
            // 사용자의 레이팅을 업데이트하는 로직 추가 (예: userRepository.save(user))
        }

        return eloResults;
    }

    private double getTeamAverageRating(TeamType userTeam, List<UserMatch> userMatches) {
        double totalRating = 0;
        int teamMemberCount = 0;
        for (UserMatch userMatch : userMatches) {
            if (userMatch.getTeamType() == userTeam) {
                totalRating += userMatch.getUser().getRecord().getScore();
                teamMemberCount++;
            }
        }
        return totalRating / teamMemberCount;
    }

    private double getExpectedScore(double teamAverageRating, TeamType winnerTeam, TeamType userTeam) {
        if (winnerTeam == userTeam) {
            return 0.8; // 승리팀일 경우 기대점수를 0.8로 설정
        } else {
            double exponent = (1500 - teamAverageRating) / SCALE_FACTOR;
            return 1 / (1 + Math.pow(10, exponent));
        }
    }

    private double calculateActualScore(UserMatch userMatch, Matches match) {
        double goalScore = getGoalScore(userMatch, match);
        double assistScore = getAssistScore(userMatch, match);
        double defenceScore = getDefenceScore(userMatch, match);

        double totalScore = goalScore + assistScore + defenceScore;
        double maxScore = 3.0; // 골, 어시스트, 수비 최대 점수의 합

        return totalScore / maxScore;
    }

    private double getGoalScore(UserMatch userMatch, Matches match) {
        int userGoals = 0;
        for (Long quarterNum = 1L; quarterNum < 7; quarterNum++) {
            List<QuarterInfo> quarterInfoList = quarterInfoReader.findAllByQuarterId(quarterNum);
            for (QuarterInfo quarterInfo : quarterInfoList) {
                if (quarterInfo.getUserMatch().equals(userMatch)) {
                    userGoals += quarterInfo.getGoal();
                }
            }
        }
        return (double) userGoals;
    }

    private double getAssistScore(UserMatch userMatch, Matches match) {
        int userAssists = 0;
        for (Long quarterNum = 1L; quarterNum < 7; quarterNum++) {
            List<QuarterInfo> quarterInfoList = quarterInfoReader.findAllByQuarterId(quarterNum);
            for (QuarterInfo quarterInfo : quarterInfoList) {
                if (quarterInfo.getUserMatch().equals(userMatch)) {
                    userAssists += quarterInfo.getAssist();
                }
            }
        }
        return (double) userAssists;
    }

    private double getDefenceScore(UserMatch userMatch, Matches match) {
        int userDefences = 0;
        for (Long quarterNum = 1L; quarterNum < 7; quarterNum++) {
            List<QuarterInfo> quarterInfoList = quarterInfoReader.findAllByQuarterId(quarterNum);
            for (QuarterInfo quarterInfo : quarterInfoList) {
                if (quarterInfo.getUserMatch().equals(userMatch)) {
                    userDefences += quarterInfo.getDefence();
                }
            }
        }
        return (double) userDefences;
    }

    private double calculateNewRating(double currentRating, double actualScore, double expectedScore, TeamType winnerTeam, TeamType userTeam) {
        double ratingChange;
        double averageRatingInRange = getAverageRatingInRange(currentRating);

        if (winnerTeam == userTeam) {
            ratingChange = K_FACTOR * (actualScore - expectedScore) * (currentRating / averageRatingInRange);
        } else {
            ratingChange = -K_FACTOR * (actualScore - expectedScore) * (currentRating / averageRatingInRange);
        }
        return currentRating + ratingChange;
    }

    private double getAverageRatingInRange(double currentRating) {
        // 구현 생략
        return 1500.0; // 예시로 1500.0을 반환합니다.
    }
}