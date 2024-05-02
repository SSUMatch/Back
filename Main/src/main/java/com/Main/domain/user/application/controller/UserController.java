package com.Main.domain.user.application.controller;

import com.Main.domain.user.application.dto.BlockedResponse;
import com.Main.domain.user.application.dto.UserProfileResponse;
import com.Main.domain.user.application.service.BlockService;
import com.Main.domain.user.application.service.UserService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;
    private final BlockService blockService;

    @GetMapping("/{userId}")
    public ApiResponse<UserProfileResponse> getUserInfo(@PathVariable("userId") Long userId) {
        UserProfileResponse userProfile = userService.getUserProfile(userId);
        return ApiResponse.onSuccess(userProfile);
    }

    @GetMapping("/{userId}/blocked")
    public ApiResponse<List<BlockedResponse>> getBlockedUserInfo(@PathVariable("userId") Long userId) {
        List<BlockedResponse> blockedUsers = blockService.getBlockedUsers(userId);
        return ApiResponse.onSuccess(blockedUsers);
    }
}
