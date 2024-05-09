package com.Main.domain.user.application.service;

import com.Main.domain.user.application.dto.response.BlockedResponse;
import com.Main.domain.user.application.dto.response.AddBlockResponse;
import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.entity.User;
import com.Main.domain.user.domain.repository.UserRepository;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

import static com.Main.global.error.status.ErrorStatus.ALREADY_BLOCK_EXIST;
import static com.Main.global.error.status.ErrorStatus.BLOCK_NOT_FOUND;


@Service
@Transactional
@RequiredArgsConstructor
public class BlockService {

    private final UserRepository userRepository;

    @Transactional(readOnly = true)
    public List<BlockedResponse> getBlockedUsers(Long userId) {
        return userRepository.findByRequestingUserId(userId).stream()
                .map(block -> BlockedResponse.of(block.getBlockedUser()))
                .collect(Collectors.toList());
    }

    public AddBlockResponse blockUser(Long requestingUserId, Long blockedUserId) {

        boolean blockExists = userRepository.findByRequestingUserIdAndBlockedUserId(requestingUserId, blockedUserId).isPresent();
        if (blockExists) {
            throw new GeneralException(ALREADY_BLOCK_EXIST);
        }

        User requestingUser = userRepository.findById(requestingUserId);
        User blockedUser = userRepository.findById(blockedUserId);
        return AddBlockResponse.of(userRepository.saveBlock(requestingUser, blockedUser));
    }

    public void unBlockUser(Long requestingUserId, Long blockedUserId) {
        Block block = userRepository.findByRequestingUserIdAndBlockedUserId(requestingUserId, blockedUserId).orElseThrow(() -> new GeneralException(BLOCK_NOT_FOUND));
        userRepository.deleteBlock(block);
    }
}
