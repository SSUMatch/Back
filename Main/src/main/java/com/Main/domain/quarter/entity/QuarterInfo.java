package com.Main.domain.quarter.entity;

import com.Main.domain.userMatch.entity.UserMatch;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "quarter_info")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class QuarterInfo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer goal; // 골
    private Integer assist; // 수비
    private Integer defence; // 어시스트

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_match_id")
    private UserMatch userMatch;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "quarter_id")
    private Quarter quarter;


    public static QuarterInfo of(Long id, Integer goal, Integer assist, Integer defence, UserMatch userMatch, Quarter quarter) {
        return new QuarterInfo(id, goal, assist, defence,userMatch, quarter);
    }
}
