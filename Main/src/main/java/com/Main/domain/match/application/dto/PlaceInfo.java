package com.Main.domain.match.application.dto;

import com.Main.domain.match.domain.entity.MatchGender;
import com.Main.domain.match.domain.entity.MatchSize;
import com.Main.domain.match.domain.entity.MatchType;

public record PlaceInfo(
        String gender,
        String type,
        String size,
        String num
) {
    public static PlaceInfo of(MatchGender gender,
                               MatchType type,
                               MatchSize size,
                               String num){
        return new PlaceInfo(String.valueOf(gender),String.valueOf(type),String.valueOf(size),num);
    }
}
