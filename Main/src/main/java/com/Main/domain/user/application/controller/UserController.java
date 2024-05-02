package com.Main.domain.user.application.controller;

import com.Main.domain.user.application.dto.UserProfileResponse;
import com.Main.domain.user.application.service.UserService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping("/{id}")
    public ApiResponse<UserProfileResponse> getUserInfo(@PathVariable("id") Long userId) {
        UserProfileResponse userProfile = userService.getUserProfile(userId);
        return ApiResponse.onSuccess(userProfile);
    }
}
