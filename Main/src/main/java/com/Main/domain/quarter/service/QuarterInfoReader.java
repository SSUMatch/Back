package com.Main.domain.quarter.service;

import com.Main.domain.quarter.entity.QuarterInfo;
import com.Main.domain.quarter.entity.QuarterType;
import com.Main.domain.quarter.repository.QuarterInfoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuarterInfoReader {
    private final QuarterInfoRepository quarterInfoRepository;
    public List<QuarterInfo> findAllByMatchesId(Long matchesId){
        return quarterInfoRepository.findAllByMatchesId(matchesId);
    }
    public List<QuarterInfo> findAllByQuarterId(Long quarterId){
        return quarterInfoRepository.findAllByQuarterId(quarterId);
    }

    public List<QuarterInfo> findAllByMatchesIdAndQuarter(Long matchesId, Long quarterId ){
        return quarterInfoRepository.findAllByMatchesIdAndQuarterId(matchesId, quarterId);
    }
}
