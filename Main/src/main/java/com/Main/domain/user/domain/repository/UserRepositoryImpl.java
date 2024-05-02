package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.User;
import com.Main.global.error.exception.GeneralException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

import static com.Main.global.error.status.ErrorStatus.USER_NOT_FOUND;

@Repository
@RequiredArgsConstructor
public class UserRepositoryImpl implements UserRepository {

    private final UserRepositoryJPA userRepositoryJPA;

    @Override
    public User findById(Long id) {
        return userRepositoryJPA.findById(id).orElseThrow( () -> new GeneralException(USER_NOT_FOUND));
    }
}
