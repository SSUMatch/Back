package com.Main.domain.elo.dto;

import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class EloResultDto {
    private Long userId;
    private double beforeRating;
    private double newRating;
    public static EloResultDto of(Long userId, double beforeRating, double newRating){
        return EloResultDto.builder()
                .userId(userId)
                .beforeRating(beforeRating)
                .newRating(newRating)
                .build();

    }
}
