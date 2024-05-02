package com.Main.domain.user.application.dto.response;

import com.Main.domain.user.domain.entity.User;

public record BlockedResponse(
        Long blockId,
        String name,
        Integer age,
        String image,
        String description,
        String location
) {
    public static BlockedResponse of(User user) {
        return new BlockedResponse(
                user.getId(),
                user.getName(),
                user.getAge(),
                user.getImage(),
                user.getDescription(),
                user.getLocation()
        );
    }
}
