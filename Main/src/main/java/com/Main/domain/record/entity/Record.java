package com.Main.domain.record.entity;

import com.Main.domain.user.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "record")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Record {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer participant; // 출전
    private Integer victory; // 다승
    private Integer goal; // 골
    private Integer assist; // 어시스트
    private Integer defence; // 수비
    private Integer pom; // 플레이 오브 더 매치

    @OneToOne
    private User user;


    public static Record of(Long id, Integer participant, Integer victory, Integer goal, Integer assist, Integer defence, Integer pom, User user) {
        return new Record(id, participant, victory, goal, assist, defence, pom, user);
    }
}
