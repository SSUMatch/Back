package com.Main.domain.user.domain.repository;

import com.Main.domain.user.domain.entity.Block;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface BlockRepositoryJPA extends JpaRepository<Block, Long> {
    @Query("SELECT b FROM Block b JOIN b.blockedUser bu WHERE b.requestingUser.id = :userId ORDER BY bu.name ASC")
    List<Block> findByRequestingUserId(@Param("userId") Long userId); // 차단당한 유저의 이름 오름차순으로 정렬된 차단 인스턴스

    Optional<Block> findByRequestingUserIdAndBlockedUserId(Long requestingUserId, Long blockedUserId);
}
