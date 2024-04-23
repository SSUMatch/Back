package com.Main.domain.match.domain.service;

import com.Main.domain.match.domain.entity.MatchGender;
import com.Main.domain.match.domain.entity.MatchSize;
import com.Main.domain.match.domain.entity.MatchType;
import com.Main.domain.match.domain.entity.Matches;
import org.springframework.stereotype.Service;

@Service
public class MatchesFormatter {
    public String getMatchInfo(Matches matches) {
        String genderString = matches.getGender() == MatchGender.MALE ? "남성" : "여성";
        String sizeString = matches.getSize() == MatchSize.SIX ? "6 vs 6" : "5 vs 5";
        String typeString = getMatchTypeString(matches.getType());

        return genderString + " " + sizeString + " " + typeString;
    }

    private String getMatchTypeString(MatchType type) {
        switch (type) {
            case RANK:
                return "랭크매치";
            case NORMAL:
                return "일반매치";
            // 다른 매치 타입에 대한 처리 추가
            default:
                return "";
        }
    }
}
