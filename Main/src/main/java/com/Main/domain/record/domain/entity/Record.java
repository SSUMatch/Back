package com.Main.domain.record.domain.entity;

import com.Main.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Setter
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double score; // 점수
    private Integer participant; // 출전
    private Integer victory; // 다승
    private Integer goal; // 골
    private Integer assist; // 어시스트
    private Integer defence; // 수비
    private Integer pom; // 플레이 오브 더 매치
    @Enumerated(EnumType.STRING)
    private Level level;

    @OneToOne(mappedBy = "record")
    private User user;

    public static Record of(Long id, Integer score, Integer participant, Integer victory, Integer goal, Integer assist, Integer defence, Integer pom, Level level, User user) {
        return new Record(id, score, participant, victory, goal, assist, defence, pom, level, user);
    }
}
