package com.Main.domain.user.entity;

import com.Main.domain.team.entity.Team;
import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;


import java.util.Objects;

@Entity
@Table(name = "user")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 이름
    private Integer age; // 나이
    private String image; // 프로필 사진
    private String description; //소개
    private String number; // 전화번호
    private String grade; // 등급
    private String location; //활동 지역

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team; //팀

    @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
    private Record record;  // 기록


    public static User of(Long id, String name, Integer age, String image, String description, String number, String grade, String location, Team team, Record record) {
        return new User(id, name, age, image, description, number, grade, location, team, record);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof User user)) return false;
        return Objects.equals(id, user.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
