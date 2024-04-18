package com.Main.domain.match.entity;

import com.Main.domain.place.entity.Place;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table(name = "match")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Match {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDate match_date; // 매치 날짜
    private LocalTime start_time; // 시작 시간
    private LocalTime end_time; // 종료 시간
    private String number; // 전화번호

    @Enumerated(EnumType.STRING) private MatchType type; // 게임 종류
    @Enumerated(EnumType.STRING) private MatchSize size; // 인원 수
    @Enumerated(EnumType.STRING) private MatchGender gender; // 성별

    @ManyToOne
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manger_id")
    private Manager manager;


    public static Match of(Long id, LocalDate match_date, LocalTime start_time, LocalTime end_time, String number, MatchType type, MatchSize size, MatchGender gender, Place place, Manager manager) {
        return new Match(id, match_date, start_time, end_time, number, type, size, gender, place, manager);
    }
}
