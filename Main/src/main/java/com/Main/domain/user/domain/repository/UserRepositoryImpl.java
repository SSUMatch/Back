package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.Block;
import com.Main.domain.user.domain.entity.User;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

import static com.Main.global.error.status.ErrorStatus.USER_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;
    private final BlockRepositoryJPA blockRepositoryJPA;

    @Override
    public User findById(Long id) {
        return userRepositoryJPA.findById(id).orElseThrow( () -> new GeneralException(USER_NOT_FOUND));
    }

    @Override
    public List<Block> findByRequestingUserId(Long userId) {
        return blockRepositoryJPA.findByRequestingUserId(userId);
    }
}
