package com.Main.domain.match.domain.service;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.repository.MatchesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchesReader {
    private final MatchesRepository matchesRepository;
    public Page<Matches> getMatchesWithDate(Pageable pageable,String day){
        LocalDateTime startDateTime = LocalDateTime.parse(day + " 00:00:00.000000", DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSSSSS"));
        return matchesRepository.findAllByDate(pageable, startDateTime);
    }
    public Matches findById(Long matchesId){
        return matchesRepository.findById(matchesId);
    }

}
