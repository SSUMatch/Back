package com.Main.domain.user.application.dto.request;

public record SignInRequest(
        String account,
        String password
) {
}
