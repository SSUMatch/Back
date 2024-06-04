package com.Main.domain.record.domain.service;

import com.Main.domain.match.application.dto.LevelDto;
import com.Main.domain.record.domain.entity.Level;
import com.Main.domain.record.domain.entity.Record;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class RecordManager {
    public List<LevelDto> getLevelDtos(List<Record> records) {
        if (records.isEmpty()) {
            return List.of();
        }

        Map<Level, Integer> levelCount = new HashMap<>();
        int totalRecords = records.size();

        for (Record record : records) {
            Level level = record.getLevel();
            levelCount.put(level, levelCount.getOrDefault(level, 0) + 1);
        }

        List<LevelDto> levelDtos = new ArrayList<>();
        for (Map.Entry<Level, Integer> entry : levelCount.entrySet()) {
            Level level = entry.getKey();
            int count = entry.getValue();
            double percent = (double) count / totalRecords * 100;
            String percentString = String.format("%.2f%%", percent);
            levelDtos.add(LevelDto.of(level.getLevelString(), percentString));
        }

        return levelDtos;
    }
    public String getExpectRate(List<Record> records) {
        if (records.isEmpty()) {
            return "No records found.";
        }

        Map<Level, Integer> levelCount = new HashMap<>();

        for (Record record : records) {
            Level level = record.getLevel();
            levelCount.put(level, levelCount.getOrDefault(level, 0) + 1);
        }

        Level mostCommonLevel = null;
        int maxCount = 0;

        for (Map.Entry<Level, Integer> entry : levelCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostCommonLevel = entry.getKey();
                maxCount = entry.getValue();
            }
        }

        return mostCommonLevel != null ? mostCommonLevel.getLevelString() : "No common level found.";
    }
}
