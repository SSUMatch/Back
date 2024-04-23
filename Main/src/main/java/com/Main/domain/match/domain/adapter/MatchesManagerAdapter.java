package com.Main.domain.match.domain.adapter;

import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.match.domain.repository.MatchesRepository;
import com.Main.domain.match.domain.service.MatchesManager;
import com.Main.domain.userMatch.domain.repository.UserMatchRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

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
