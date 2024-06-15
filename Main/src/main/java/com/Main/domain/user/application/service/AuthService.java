package com.Main.domain.user.application.service;

import com.Main.domain.user.application.dto.request.SignInRequest;
import com.Main.domain.user.application.dto.request.SignUpRequest;
import com.Main.domain.user.application.dto.response.SignInResponse;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.domain.service.UserModifier;
import com.Main.domain.user.domain.service.UserReader;
import com.Main.global.config.auth.JwtProvider;
import com.Main.global.config.auth.TokenInfo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
@Transactional
public class AuthService {
    private final UserReader userReader;
    private final UserModifier userModifier;
    private final JwtProvider jwtProvider;
    public void signup(SignUpRequest signUpRequest){
        User createUser = userReader.getUserByIdAndPassword(signUpRequest);
        User user = userModifier.saveUser(createUser);
        TokenInfo tokenInfo = issueAccessTokenAndRefreshToken(user);
        updateRefreshToken(tokenInfo.getRefreshToken(), user);
    }
    public SignInResponse signin(SignInRequest signInRequest){
        User user = userReader.getUserByIdAndPassword2(signInRequest.account(), signInRequest.password());
        TokenInfo tokenInfo = issueAccessTokenAndRefreshToken(user);
        updateRefreshToken(tokenInfo.getRefreshToken(), user);
        return SignInResponse.of(user,tokenInfo);
    }
    private TokenInfo issueAccessTokenAndRefreshToken(User user) {
        return jwtProvider.issueToken(user.getId());
    }
    private void updateRefreshToken(String refreshToken, User user) {
        user.updateRefreshToken(refreshToken);
    }
}
