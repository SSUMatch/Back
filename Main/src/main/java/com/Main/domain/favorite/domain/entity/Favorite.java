package com.Main.domain.favorite.domain.entity;


import com.Main.domain.place.domain.entity.Place;

import com.Main.domain.user.domain.entity.User;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "favorite")
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class Favorite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;  // 사용자

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "place_id", nullable = false)
    private Place place;  // 구장

    public static Favorite of(User user, Place place) {
        return new Favorite(null, user, place);
    }
}
