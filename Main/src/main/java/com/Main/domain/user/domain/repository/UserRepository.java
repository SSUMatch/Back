package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.User;

public interface UserRepository {
    User findById(Long id);
}
