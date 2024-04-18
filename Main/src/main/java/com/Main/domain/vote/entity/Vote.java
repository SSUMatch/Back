package com.Main.domain.vote.entity;

import com.Main.domain.userMatch.entity.UserMatch;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "vote")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer count; // 투표 수

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_match_id")
    private UserMatch userMatch;


    public static Vote of(Long id, Integer count, UserMatch userMatch) {
        return new Vote(id, count, userMatch);
    }
}
