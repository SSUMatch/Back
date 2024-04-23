package com.Main.domain.match.application.service;

import com.Main.domain.match.application.dto.SimpleMatchInfoResponse;
import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.service.MatchesFormatter;
import com.Main.domain.match.domain.service.MatchesManager;
import com.Main.domain.match.domain.service.MatchesReader;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchesReader matchesReader;
    private final MatchesFormatter matchesFormatter;
    private final MatchesManager matchesManager;
    public List<SimpleMatchInfoResponse> getMatchInfoList(String date){
        List<Matches> matchesList = matchesReader.getMatchesWithDate(date);
        return matchesList.stream().map(matches -> SimpleMatchInfoResponse.of(
                String.valueOf(matches.getStart_time()),
                matches.getPlace().getName(),
                matchesFormatter.getMatchInfo(matches),
                matchesManager.isFull(matches.getId())
        )).toList();
    }
}
