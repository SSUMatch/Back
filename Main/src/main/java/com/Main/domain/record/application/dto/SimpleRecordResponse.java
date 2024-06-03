package com.Main.domain.record.application.dto;

import com.Main.domain.quarter.entity.QuarterInfo;

public record SimpleRecordResponse(
        int num,
        int goal,
        int assist,
        int defense
) {
    public static SimpleRecordResponse of(QuarterInfo quarterInfo){
        return new SimpleRecordResponse(quarterInfo.getUserMatch().getNumber(), quarterInfo.getGoal(), quarterInfo.getAssist(), quarterInfo.getDefence() );
    }
}
