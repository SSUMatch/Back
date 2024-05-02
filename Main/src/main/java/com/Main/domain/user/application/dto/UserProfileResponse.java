package com.Main.domain.user.application.dto;

import com.Main.domain.record.application.dto.RecordDto;
import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.user.domain.entity.User;

public record UserProfileResponse(
        Long userId,
        String name,
        Integer age,
        String image,
        String description,
        String number,
        String grade,
        String location,
        String teamName,
        RecordDto record
) {
    public static UserProfileResponse of(User user, String grade, Record record) {
        String teamName = user.getTeam() != null ? user.getTeam().getName() : null;

        return new UserProfileResponse(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getImage(),
                user.getDescription(),
                user.getNumber(),
                grade,
                user.getLocation(),
                teamName,
                RecordDto.of(record)
        );
    }
}
