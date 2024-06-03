package com.Main.domain.match.domain.entity;


import com.Main.domain.place.domain.entity.Place;
import com.Main.domain.team.entity.TeamType;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Entity
@Table(name = "matches")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Matches {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime date; // 매치 날짜
    private LocalTime start_time; // 시작 시간
    private LocalTime end_time; // 종료 시간
    private String number; // 전화번호

    @Enumerated(EnumType.STRING) private MatchType type; // 게임 종류
    @Enumerated(EnumType.STRING) private MatchSize size; // 인원 수
    @Enumerated(EnumType.STRING) private MatchGender gender; // 성별

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id")
    private Place place;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manager_id")
    private Manager manager;
    @Enumerated(EnumType.STRING)
    private TeamType winner;
//    private String winner;
    private Long pom;

    public static Matches of(Long id, LocalDateTime date, LocalTime start_time, LocalTime end_time, String number, MatchType type, MatchSize size, MatchGender gender, Place place, Manager manager, TeamType winner, Long pom) {
        return new Matches(id, date, start_time, end_time, number, type, size, gender, place, manager,winner, pom);
    }
}
