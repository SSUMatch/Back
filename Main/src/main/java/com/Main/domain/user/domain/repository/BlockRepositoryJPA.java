package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BlockRepositoryJPA extends JpaRepository<Block, Long> {
    List<Block> findByRequestingUserId(Long userId);

    Optional<Block> findByRequestingUserIdAndBlockedUserId(Long requestingUserId, Long blockedUserId);
}
