package com.Main.domain.record.application.dto;

import com.Main.domain.record.domain.entity.Record;

public record RecordDto(
        Integer score,
        Integer participant,
        Integer victory,
        Integer goal,
        Integer assist,
        Integer defence,
        Integer pom
) {
    public static RecordDto of(Record record) {
        if (record == null) {
            return new RecordDto(0, 0, 0, 0, 0, 0, 0); // 모든 필드를 기본 값으로 설정
        }
        return new RecordDto(
                record.getScore(),
                record.getParticipant(),
                record.getVictory(),
                record.getGoal(),
                record.getAssist(),
                record.getDefence(),
                record.getPom()
        );
    }
}

