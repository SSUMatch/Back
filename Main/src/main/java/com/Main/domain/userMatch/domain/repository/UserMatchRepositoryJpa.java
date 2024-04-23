package com.Main.domain.userMatch.domain.repository;

import com.Main.domain.userMatch.domain.entity.UserMatch;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserMatchRepositoryJpa extends JpaRepository<UserMatch, Long> {
    Long countByMatchesId(Long matchesId);
}
