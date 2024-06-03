package com.Main.domain.quarter.entity;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum QuarterType {
    FIRST_QUARTER("1쿼터"),
    SECOND_QUARTER("2쿼터"),
    THIRD_QUARTER("3쿼터"),
    FOURTH_QUARTER("4쿼터"),
    FIFTH_QUARTER("5쿼터"),
    SIXTH_QUARTER("6쿼터");
    private final String quarter;
}
