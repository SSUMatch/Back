package com.Main.domain.quarter.service;

import com.Main.domain.quarter.entity.Quarter;
import com.Main.domain.quarter.entity.QuarterType;
import com.Main.domain.quarter.repository.QuarterRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class QuarterReader {
    private final QuarterRepository quarterRepository;
    public Quarter getQuarterByQuarterType(QuarterType quarterType){
        return quarterRepository.findByQuarterType(quarterType);
    }

}
