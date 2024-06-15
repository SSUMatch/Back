package com.Main.domain.user.domain.entity;

import com.Main.domain.record.domain.entity.Record;
import com.Main.domain.team.entity.Team;
import com.Main.domain.user.application.dto.request.SignUpRequest;
import jakarta.persistence.*;
import lombok.*;

@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
@Builder
@Getter
@Setter
@Table(name = "user")
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String account;

    private String name; // 이름
    private Integer age; // 나이
    private String image; // 프로필 사진
    private String description; //소개
    private String number; // 전화번호
    private String location; //활동 지역
    private String gender;
    private String password;
    private String position;
    private String refreshToken;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team; //팀

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "record_id")
    private Record record;  // 기록
    public void updateRefreshToken(String refreshToken) {
        this.refreshToken = refreshToken;
    }


    public static User createUser(SignUpRequest signUpRequest) {
        return User.builder()
                .account(signUpRequest.id())
                .name(signUpRequest.name())
                .age(signUpRequest.age())
                .image(null)
                .description("안녕하세요")
                .gender(signUpRequest.gender())
                .password(signUpRequest.password())
                .position(signUpRequest.position())
                .build();
    }
}
