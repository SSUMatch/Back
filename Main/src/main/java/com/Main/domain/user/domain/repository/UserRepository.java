package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.entity.User;

import java.util.List;

public interface UserRepository {
    // 유저 id로 검색
    User findById(Long id);

    // userId(차단한 사용자)의 일치하는 모든 'Block'인스턴스 조회
    List<Block> findByRequestingUserId(Long userId);
}
