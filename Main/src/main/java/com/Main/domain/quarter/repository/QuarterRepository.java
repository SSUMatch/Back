package com.Main.domain.quarter.repository;

import com.Main.domain.quarter.entity.Quarter;
import com.Main.domain.quarter.entity.QuarterType;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuarterRepository extends JpaRepository<Quarter,Long> {
//    List<Quarter> findAllByMatchesId(Long matchesId);
//    List<Quarter> findAllByMatchIdAndUserMatchId(Long matchesId,Long userMatchId);
    Quarter findByQuarterType(QuarterType quarterType);
}
