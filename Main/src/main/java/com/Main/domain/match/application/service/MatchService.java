package com.Main.domain.match.application.service;

import com.Main.domain.match.application.dto.SimpleMatchInfoResponse;
import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.service.MatchesFormatter;
import com.Main.domain.match.domain.service.MatchesManager;
import com.Main.domain.match.domain.service.MatchesReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchesReader matchesReader;
    private final MatchesFormatter matchesFormatter;
    private final MatchesManager matchesManager;
    public List<SimpleMatchInfoResponse> getMatchInfoList(int page, int take, String date){
        Page<Matches> matchesList = matchesReader.getMatchesWithDate(setPageable(page, take),date);
        return matchesList.stream().map(matches -> SimpleMatchInfoResponse.of(
                String.valueOf(matches.getStart_time()),
                matches.getPlace().getName(),
                matchesFormatter.getMatchInfo(matches),
                matchesManager.isFull(matches.getId())
        )).toList();
    }
    private Pageable setPageable(int page, int take){
        return PageRequest.of(page, take);
    }
}
