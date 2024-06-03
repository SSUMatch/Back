package com.Main.domain.record.application.service;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.service.MatchesFormatter;
import com.Main.domain.match.domain.service.MatchesReader;
import com.Main.domain.quarter.dto.QuarterInfoList;
import com.Main.domain.quarter.dto.QuarterRecordResponse;
import com.Main.domain.quarter.entity.QuarterInfo;
import com.Main.domain.quarter.entity.QuarterType;
import com.Main.domain.quarter.service.QuarterInfoManager;
import com.Main.domain.quarter.service.QuarterInfoReader;
import com.Main.domain.quarter.service.QuarterReader;
import com.Main.domain.record.application.dto.RecordResponseDto;
import com.Main.domain.record.application.dto.SimpleTeamResponse;
import com.Main.domain.team.entity.TeamType;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import com.Main.domain.userMatch.domain.service.UserMatchReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class RecordService {
    private final UserMatchReader userMatchReader;
    private final QuarterInfoManager quarterInfoManager;
    private final QuarterInfoReader quarterInfoReader;
    private final QuarterReader quarterReader;
    private final MatchesFormatter matchesFormatter;
    public List<RecordResponseDto> getUserRecord(Long userId){
        List<UserMatch> userMatchList = userMatchReader.getAllUserMatchByUserId(userId);
        List<Matches> matchesList = userMatchList.stream().map(userMatch -> userMatch.getMatches()).toList();
        List<RecordResponseDto> recordResponseDtos = matchesList.stream().map(matches ->
                RecordResponseDto.of(
                        matches,
                        true,
                        matchesFormatter.getMatchInfo(matches),
                        20,
                        userMatchReader.findByUserIdAndMatchesId(userId, matches.getId()),
                        createQuarterRecordResponses(userId, matches),
                        userMatchReader.getTeam(matches.getId(), TeamType.RED).stream().map(userMatch -> SimpleTeamResponse.of(userMatch)).toList(),
                        userMatchReader.getTeam(matches.getId(), TeamType.GREEN).stream().map(userMatch -> SimpleTeamResponse.of(userMatch)).toList(),
                        userMatchReader.getTeam(matches.getId(), TeamType.BLUE).stream().map(userMatch -> SimpleTeamResponse.of(userMatch)).toList()
                )).toList();
        return recordResponseDtos;
    }
    private List<QuarterRecordResponse> createQuarterRecordResponses(Long myId, Matches matches){
        UserMatch userMatch = userMatchReader.findByUserIdAndMatchesId(myId,matches.getId());
//        List<QuarterInfoList> quarterInfoLists = createQuarterInfoList();
        return createQuarterRecordResponse(
                        userMatch,
                        createQuarterInfoList(matches)
                );
    }
    private List<QuarterRecordResponse> createQuarterRecordResponse(UserMatch userMatch, List<QuarterInfoList> quarterInfoLists){
        int goal = quarterInfoManager.getGoalByUserMatchId(userMatch.getId());
        int assist = quarterInfoManager.getAssistByUserMatchId(userMatch.getId());
        int defense = quarterInfoManager.getDefenseByUserMatchId(userMatch.getId());

        return quarterInfoLists.stream().map( quarterInfoList ->
                QuarterRecordResponse.of(
                        quarterInfoList.quarter(),
                        goal,
                        assist,
                        defense,
                        quarterInfoManager.getTeamDto(quarterInfoList.quarterInfos())
                )).toList();
    }
    private List<QuarterInfoList> createQuarterInfoList(Matches matches){

        List<QuarterInfoList> quarterInfoLists = new ArrayList<>();

        //쿼터별로 쿼터정보 리스트 만들기
        for(QuarterType quarterType : QuarterType.values()){
            QuarterInfoList quarterInfoList = QuarterInfoList.of(
                    quarterType.getQuarter(),
                    quarterInfoReader.findAllByMatchesIdAndQuarter(
                            matches.getId(),
                            quarterReader.getQuarterByQuarterType(quarterType).getId()
                            )
            );
            quarterInfoLists.add(quarterInfoList);
        }
        return quarterInfoLists;
    }
}
