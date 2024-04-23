package com.Main.domain.userMatch.domain.entity;


import com.Main.domain.match.domain.entity.Matches;
import com.Main.domain.team.entity.TeamType;
import com.Main.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "user_match")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class UserMatch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private TeamType type; // 게임 종류

    private Integer number; // 조끼 번호

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "matches_id")
    private Matches matches;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private User user;



    public static UserMatch of(Long id, TeamType type, Integer number, Matches matches, User user) {
        return new UserMatch(id, type, number, matches, user);
    }
}
