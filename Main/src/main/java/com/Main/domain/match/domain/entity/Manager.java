package com.Main.domain.match.domain.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "manager")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Manager {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 이름
    private String description; //소개
    private String number; // 전화번호
    private String location; //활동 지역

    private static Manager of(Long id, String name, String description, String number, String location) {
        return new Manager (id, name, description, number, location);
    }
}
