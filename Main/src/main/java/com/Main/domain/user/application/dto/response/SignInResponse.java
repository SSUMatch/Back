package com.Main.domain.user.application.dto.response;

import com.Main.domain.user.domain.entity.User;
import com.Main.global.config.auth.TokenInfo;

public record SignInResponse(
        Long userId,
        String name,
        String accessToken,
        String refreshToken
) {
    public static SignInResponse of(User user, TokenInfo tokenInfo){
        return new SignInResponse(user.getId(), user.getName(), tokenInfo.getAccessToken(), tokenInfo.getRefreshToken());
    }
}
