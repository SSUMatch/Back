package com.Main.domain.match.domain.service;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.repository.MatchesRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MatchesReader {
    private final MatchesRepository matchesRepository;
    public List<Matches> getMatchesWithDate(String day){
        return matchesRepository.findAllByDate(day);
    }

}
