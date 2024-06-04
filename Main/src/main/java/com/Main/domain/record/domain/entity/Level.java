package com.Main.domain.record.domain.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Getter
public enum Level {
    ROOKIE("루키"),
    BEGINNER("비기너"),
    AMATUAR("아마추어"),
    SEMIPRO("세미프로"),
    PRO("프로");
    private final String levelString;
}
