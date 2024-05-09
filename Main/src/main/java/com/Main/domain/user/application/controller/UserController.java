package com.Main.domain.user.application.controller;

import com.Main.domain.user.application.dto.response.BlockedResponse;
import com.Main.domain.user.application.dto.response.UserProfileResponse;
import com.Main.domain.user.application.dto.response.AddBlockResponse;
import com.Main.domain.user.application.service.BlockService;
import com.Main.domain.user.application.service.UserService;
import com.Main.global.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/{userId}/blocks")
    public ApiResponse<List<BlockedResponse>> getBlockedUserInfo(@PathVariable("userId") Long userId) {
        List<BlockedResponse> blockedUsers = blockService.getBlockedUsers(userId);
        return ApiResponse.onSuccess(blockedUsers);
    }

    @PostMapping("/{userId}/blocks")
    public ApiResponse<AddBlockResponse> addBlockUser(@PathVariable("userId") Long userId, @RequestParam("blockedUserId") Long blockedUserId ) {
        AddBlockResponse block = blockService.blockUser(userId, blockedUserId);
        return ApiResponse.onSuccess(block);
    }

    @DeleteMapping("/{userId}/blocks/{blockedUserId}")
    public ApiResponse<Void> unBlockUser(@PathVariable("userId") Long userId, @PathVariable("blockedUserId") Long blockedUserId) {
        blockService.unBlockUser(userId, blockedUserId);
        return ApiResponse.onSuccess();
    }
}
