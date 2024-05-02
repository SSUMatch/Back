package com.Main.domain.user.application.service;

import com.Main.domain.user.application.dto.BlockedResponse;
import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional(readOnly = true)
@RequiredArgsConstructor
public class BlockService {

    private final UserRepository userRepository;

    public List<BlockedResponse> getBlockedUsers(Long userId) {
        List<Block> blocks = userRepository.findByRequestingUserId(userId);

        return blocks.stream()
                .map(block -> BlockedResponse.of(block.getBlockedUser()))
                .collect(Collectors.toList());
    }
}
