package com.Main.domain.match.domain.adapter;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.repository.MatchesRepository;
import com.Main.domain.match.domain.service.MatchesManager;
import com.Main.domain.record.domain.entity.Level;
import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.userMatch.domain.entity.UserMatch;
import com.Main.domain.userMatch.domain.repository.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MatchesManagerAdapter implements MatchesManager {
    private final UserMatchRepository userMatchRepository;
    private final MatchesRepository matchesRepository;

    @Override
    public String isFull(Long matchesId) {
        Matches matches = matchesRepository.findById(matchesId);
        int requiredParticipants = getRequiredParticipants(matches);
        long currentParticipants = userMatchRepository.countByMatchesId(matchesId);
        if (currentParticipants >= requiredParticipants) {
            return "마감";
        } else if (currentParticipants >= requiredParticipants * 0.8) {
            return "마감임박";
        } else {
            return "신청";
        }
    }
    @Override
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

    private int getRequiredParticipants(Matches matches) {
        switch (matches.getSize()) {
            case FIVE:
                return 15;
            case SIX:
                return 18;
            // 다른 size에 대한 처리 추가
            default:
                throw new IllegalArgumentException("지원하지 않는 매치 크기입니다.");
        }
    }
}
