package com.Main.domain.user.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "block")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Block {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "requesting_user_id")
    private User requestingUser;  // 차단을 요청한 사용자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "blocked_user_id")
    private User blockedUser;  // 차단당한 사용자



    public static Block of(Long id, User requestingUser, User blockedUser) {
        return new Block(id, requestingUser, blockedUser);
    }
}
