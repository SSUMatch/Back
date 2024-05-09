package com.Main.domain.match.application.service;

import com.Main.domain.match.application.dto.*;
import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.service.MatchesFormatter;
import com.Main.domain.match.domain.service.MatchesManager;
import com.Main.domain.match.domain.service.MatchesReader;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.place.domain.service.PlaceReader;
import com.Main.domain.user.entity.User;
import com.Main.domain.user.service.UserReader;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import com.Main.domain.userMatch.domain.service.UserMatchReader;
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
    private final PlaceReader placeReader;
    private final UserMatchReader userMatchReader;
    private final UserReader userReader;
    public List<SimpleMatchInfoResponse> getMatchInfoList(int page, int take, String date){
        Page<Matches> matchesList = matchesReader.getMatchesWithDate(setPageable(page, take),date);
        return matchesList.stream().map(matches -> SimpleMatchInfoResponse.of(
                matches.getId(),
                String.valueOf(matches.getStart_time()),
                matches.getPlace().getName(),
                matchesFormatter.getMatchInfo(matches),
                matchesManager.isFull(matches.getId())
        )).toList();
    }
    public MatchDetailResponse getMatchDetail(Long matchesId){
        Matches matches = matchesReader.findById(matchesId);
        Place place = placeReader.findById(matches.getPlace().getId());
        List<UserMatch> userMatches =  userMatchReader.findAllByMatchId(matchesId);
        List<User> users = userMatches.stream().map(userMatch -> userReader.findById(userMatch.getUser().getId())).toList();
        return MatchDetailResponse.of(place.getImage(),
                MatchData.of("세미프로",null),
                PlaceInfo.of(matches.getGender(),matches.getType(), matches.getSize(),"12~18"),
                MatchInfo.of(true, true, place.isRental(), place.getParking(),place.isShower_room(),place.isToilet()),
                matches.getDate(),
                place.getName(),
                place.getAddress(),
                "11000"


                );
    }
    private Pageable setPageable(int page, int take){
        return PageRequest.of(page, take);
    }
}
