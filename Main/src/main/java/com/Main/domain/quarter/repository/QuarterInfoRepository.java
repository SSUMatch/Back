package com.Main.domain.quarter.repository;

import com.Main.domain.quarter.entity.QuarterInfo;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface QuarterInfoRepository extends JpaRepository<QuarterInfo,Long> {
    List<QuarterInfo> findAllByMatchesId(Long matchesId);
    List<QuarterInfo> findAllByQuarterId(Long quarterId);
}
