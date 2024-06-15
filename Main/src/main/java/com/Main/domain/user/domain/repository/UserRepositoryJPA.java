package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UserRepositoryJPA extends JpaRepository<User, Long> {
    Optional<User> findByAccountAndPassword(String account, String password);
}
