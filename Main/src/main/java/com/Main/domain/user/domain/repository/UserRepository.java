package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    Optional<User> findById(Long id); // 유저 id로 검색

    Block saveBlock(User requestingUser, User blockedUser); // 사용자 차단 추가

    void deleteBlock(Block block); // 사용자 차단 해제

    List<Block> findByRequestingUserId(Long userId); // userId와 일치하는 모든 'Block' 인스턴스 조회

    Optional<Block> findByRequestingUserIdAndBlockedUserId(Long requestingUserId, Long blockedUserId);
    Optional<User> findByAccountAndPassword(String account, String password);
    User save(User user);
}
