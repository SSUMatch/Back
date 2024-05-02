package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.entity.User;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static com.Main.global.error.status.ErrorStatus.USER_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final BlockRepositoryJPA blockRepositoryJPA;

    @Override
    public User findById(Long id) {
        return userRepositoryJPA.findById(id).orElseThrow(() -> new GeneralException(USER_NOT_FOUND));
    }

    @Override
    public List<Block> findByRequestingUserId(Long userId) {
        return blockRepositoryJPA.findByRequestingUserId(userId);
    }

    @Override
    public Block saveBlock(User requestingUser, User blockedUser) {
        return blockRepositoryJPA.save(Block.of(null, requestingUser, blockedUser));
    }

    @Override
    public void deleteBlock(Block block) {
        blockRepositoryJPA.delete(block);
    }

    @Override
    public Optional<Block> findByRequestingUserIdAndBlockedUserId(Long requestingUserId, Long blockedUserId) {
        return blockRepositoryJPA.findByRequestingUserIdAndBlockedUserId(requestingUserId, blockedUserId);
    }
}
