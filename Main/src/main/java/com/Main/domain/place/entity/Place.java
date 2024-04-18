package com.Main.domain.place.entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "place")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; // 이름
    private String image; // 구장 사진
    private String address; // 주소
    private String number; // 전화번호

    private Integer parking; // 주차
    private boolean toilet; // 화장실
    private boolean rental; // 용품 대여
    private boolean shower_room; // 샤워시설



    public static Place of(Long id, String name, String image, String address, String number, Integer parking, boolean toilet, boolean rental, boolean shower_room) {
        return new Place(id, name, image, address, number, parking, toilet, rental, shower_room);
    }
}
