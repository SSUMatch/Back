package com.Main.domain.user.application.dto.request;

public record SignUpRequest(
        String id,
        String password,
        String name,
        int age,
        String gender,
        String location,
        String position
) {
}
