package com.Main.domain.match.domain.repository;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

import static com.Main.global.error.status.ErrorStatus.MATCHES_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class MatchesRepositoryImpl implements MatchesRepository{
    private final MatchesRepositoryJpa matchesRepositoryJpa;
    @Override
    public Page<Matches> findAllByDate(Pageable pageable, String date){
        LocalDate localDate = LocalDate.parse(date);
        return matchesRepositoryJpa.findAllByDate(pageable, localDate);
    }
    @Override
    public Matches findById(Long matchesId){
        return matchesRepositoryJpa.findById(matchesId).orElseThrow( () -> new GeneralException(MATCHES_NOT_FOUND));
    }
}
