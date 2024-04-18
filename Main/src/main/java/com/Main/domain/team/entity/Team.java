package com.Main.domain.team.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedHashSet;
import java.util.Set;

@Entity
@Table(name = "team")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Team {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 이름
    private String image; // 사진
    private String description; // 팀 소개
    private Integer score; // 점수
    private String location; //활동 지역


    public static Team of(Long id, String name, String image, String description, Integer score, String location) {
        return new Team(id, name, image, description, score, location);
    }
}
