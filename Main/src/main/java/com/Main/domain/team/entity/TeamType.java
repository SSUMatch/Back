package com.Main.domain.team.entity;
import com.Main.global.error.exception.InvalidValueException;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

import java.util.Arrays;

import static com.Main.global.error.status.ErrorStatus.INVALID_TEAMTYPE;

@RequiredArgsConstructor
@Getter
public enum TeamType {
    RED("RED"),
    BLUE("BLUE"),
    GREEN("GREEN");
    private final String color;
    public static TeamType getEnumTeamTypeFromColor(String color) {
        return Arrays.stream(values())
                .filter(teamType -> teamType.color.equals(color))
                .findFirst()
                .orElseThrow(() -> new InvalidValueException(INVALID_TEAMTYPE));
    }
}
