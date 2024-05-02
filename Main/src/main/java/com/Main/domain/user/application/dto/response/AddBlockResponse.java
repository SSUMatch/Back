package com.Main.domain.user.application.dto.response;

import com.Main.domain.user.domain.entity.Block;

public record AddBlockResponse(
        Long requestingUserId,
        Long blockedUserId
) {
    public static AddBlockResponse of(Block block) {
        return new AddBlockResponse(
                block.getRequestingUser().getId(),
                block.getBlockedUser().getId()
        );
    }
}
