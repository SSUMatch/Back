package com.Main.domain.quarter.dto;

import com.Main.domain.quarter.entity.QuarterInfo;

import java.util.List;

public record QuarterInfoList(
        String quarter,
        List<QuarterInfo> quarterInfos
) {
    public static QuarterInfoList of(String quarter, List<QuarterInfo> quarterInfos){
        return new QuarterInfoList(quarter, quarterInfos);
    }
}
