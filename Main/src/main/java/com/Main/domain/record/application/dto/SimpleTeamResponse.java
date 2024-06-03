package com.Main.domain.record.application.dto;

import com.Main.domain.user.domain.entity.User;
import com.Main.domain.userMatch.domain.entity.UserMatch;

public record SimpleTeamResponse(
        Long userId,
        String color,
        String name,
        int age,
        String location
) {
    public static SimpleTeamResponse of(UserMatch userMatch){
        User user = userMatch.getUser();
        return new SimpleTeamResponse(user.getId(), userMatch.getTeamType().getColor(), user.getName(), user.getAge(), user.getLocation());
    }
}
