package com.Main.domain.record.domain.service;

import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.record.domain.repository.RecordRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RecordReader {
    private final RecordRepository recordRepository;
    public Record getRecordByUserId(Long userId){
        return recordRepository.findByUserId(userId);
    }
}
