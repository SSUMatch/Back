package com.Main.domain.match.application.service;

import com.Main.domain.match.application.dto.*;
import com.Main.domain.match.domain.adapter.MatchesManagerAdapter;
import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.repository.MatchesRepository;
import com.Main.domain.match.domain.service.MatchesFormatter;
import com.Main.domain.match.domain.service.MatchesManager;
import com.Main.domain.match.domain.service.MatchesReader;
import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.place.domain.service.PlaceReader;

import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.record.domain.service.RecordManager;
import com.Main.domain.record.domain.service.RecordReader;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.service.UserReader;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import com.Main.domain.userMatch.domain.service.UserMatchReader;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class MatchService {
    private final MatchesReader matchesReader;
    private final MatchesFormatter matchesFormatter;
    private final MatchesManager matchesManager;
    private final PlaceReader placeReader;
    private final UserMatchReader userMatchReader;
    private final UserReader userReader;
    private final MatchesRepository matchesRepository;
    private final RecordReader recordReader;
    private final RecordManager recordManager;

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

    public Map<String, List<SimpleMatchDateInfoResponse>> getMatchesByFavorite(Long placeId) {
        List<Matches> matches = matchesRepository.findByPlaceIdOrderByDateAndStartTime(placeId);

        Map<String, List<SimpleMatchDateInfoResponse>> matchesGroupedByDate = matches.stream()
                .map(this::toSimpleMatchInfoResponse)
                .collect(Collectors.groupingBy(SimpleMatchDateInfoResponse::getDate));

        // TreeMap을 사용하여 키를 오름차순으로 정렬
        return new TreeMap<>(matchesGroupedByDate);
    }

    private SimpleMatchDateInfoResponse toSimpleMatchInfoResponse(Matches match) {
        String time = match.getStart_time() + " - " + match.getEnd_time();
        String name = match.getPlace().getName();
        String type = matchesFormatter.getMatchInfo(match);
        String status = matchesManager.isFull(match.getId());

        return SimpleMatchDateInfoResponse.of(match.getId(), time, name, type, status, match.getDate().toLocalDate());
    }

    public MatchDetailResponse getMatchDetail(Long matchesId){
        Matches matches = matchesReader.findById(matchesId);
        Place place = placeReader.findById(matches.getPlace().getId());
        List<UserMatch> userMatches =  userMatchReader.findAllByMatchId(matchesId);
        List<User> users = userMatches.stream().map(userMatch -> userReader.findById(userMatch.getUser().getId())).toList();
        MatchData matchData = createMatchData(userMatches);
        return MatchDetailResponse.of(place.getImage(),
                matchData,
                PlaceInfo.of(matches.getGender(),matches.getType(), matches.getSize(),"12~18"),
                MatchInfo.of(true, true, place.isRental(), place.getParking(),place.isShower_room(),place.isToilet()),
                matches.getDate(),
                place.getName(),
                place.getAddress(),
                "11000"


                );
    }
    private MatchData createMatchData(List<UserMatch> userMatches){
        List<User> users = userMatches.stream().map(userMatch -> userReader.findById(userMatch.getUser().getId())).toList();
        List<Record> records = users.stream().map(user -> recordReader.getRecordByUserId(user.getId())).toList();
        String expect = recordManager.getExpectRate(records);
        List<LevelDto> levelDtos = recordManager.getLevelDtos(records);
        return MatchData.of(expect,levelDtos);
    }
    private Pageable setPageable(int page, int take){
        return PageRequest.of(page, take);
    }
}
