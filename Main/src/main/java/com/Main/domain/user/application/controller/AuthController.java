package com.Main.domain.user.application.controller;

import com.Main.domain.user.application.dto.request.SignInRequest;
import com.Main.domain.user.application.dto.request.SignUpRequest;
import com.Main.domain.user.application.dto.response.SignInResponse;
import com.Main.domain.user.application.dto.response.UserProfileResponse;
import com.Main.domain.user.application.service.AuthService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/auth")
public class AuthController {
    private final AuthService authService;
    @PostMapping("/signup")
    public ApiResponse<String> getUserInfo(@RequestBody SignUpRequest signUpRequest) {
        authService.signup(signUpRequest);
        return ApiResponse.onSuccess("Success");
    }
    @PostMapping("/signin")
    public ApiResponse<SignInResponse> getUserInfo(@RequestBody SignInRequest signInRequest) {
        SignInResponse signInResponse = authService.signin(signInRequest);
        return ApiResponse.onSuccess(signInResponse);
    }
}
