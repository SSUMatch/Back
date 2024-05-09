package com.Main.domain.match.application.dto;

public record MatchInfo(
        boolean size,
        boolean shoes,
        boolean borrow,
        int parking,
        boolean shower,
        boolean toilet
) {
    public static MatchInfo of(boolean size,
                               boolean shoes,
                               boolean borrow,
                               int parking,
                               boolean shower,
                               boolean toilet){
        return new MatchInfo(size,shoes,borrow,parking,shower,toilet);
    }
}
