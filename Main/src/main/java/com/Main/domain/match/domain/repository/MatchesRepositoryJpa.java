package com.Main.domain.match.domain.repository;

import com.Main.domain.match.domain.entity.Matches;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDate;
import java.util.List;

public interface MatchesRepositoryJpa extends JpaRepository<Matches,Long> {
    @Query("SELECT m FROM Matches m WHERE m.date = :date")
    List<Matches> findAllByDate(@Param("date") LocalDate date);
}
