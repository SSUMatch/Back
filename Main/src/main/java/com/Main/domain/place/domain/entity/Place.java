package com.Main.domain.place.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "place")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Place {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String address; // 주소
    private double latitude; // 위도
    private double longitude; // 경도

    private String name; // 이름
    private String image; // 구장 사진
    private String number; // 전화번호

    private Integer parking; // 주차
    private boolean toilet; // 화장실
    private boolean rental; // 용품 대여
    private boolean shower_room; // 샤워시설


    public static Place of(Long id, String address, double latitude, double longitude, String name, String image, String number, Integer parking, boolean toilet, boolean rental, boolean shower_room) {
        return new Place(id, address, latitude, longitude, name, image, number, parking, toilet, rental, shower_room);
    }
}
