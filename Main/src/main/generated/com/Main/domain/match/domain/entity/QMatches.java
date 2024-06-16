package com.Main.domain.match.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QMatches is a Querydsl query type for Matches
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QMatches extends EntityPathBase<Matches> {

    private static final long serialVersionUID = 1615357863L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QMatches matches = new QMatches("matches");

    public final DateTimePath<java.time.LocalDateTime> date = createDateTime("date", java.time.LocalDateTime.class);

    public final TimePath<java.time.LocalTime> end_time = createTime("end_time", java.time.LocalTime.class);

    public final EnumPath<MatchGender> gender = createEnum("gender", MatchGender.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final BooleanPath isPom = createBoolean("isPom");

    public final BooleanPath isWin = createBoolean("isWin");

    public final QManager manager;

    public final StringPath number = createString("number");

    public final com.Main.domain.place.domain.entity.QPlace place;

    public final NumberPath<Integer> pom = createNumber("pom", Integer.class);

    public final EnumPath<MatchSize> size = createEnum("size", MatchSize.class);

    public final TimePath<java.time.LocalTime> start_time = createTime("start_time", java.time.LocalTime.class);

    public final EnumPath<MatchType> type = createEnum("type", MatchType.class);

    public final EnumPath<com.Main.domain.team.entity.TeamType> winner = createEnum("winner", com.Main.domain.team.entity.TeamType.class);

    public QMatches(String variable) {
        this(Matches.class, forVariable(variable), INITS);
    }

    public QMatches(Path<? extends Matches> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QMatches(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QMatches(PathMetadata metadata, PathInits inits) {
        this(Matches.class, metadata, inits);
    }

    public QMatches(Class<? extends Matches> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.manager = inits.isInitialized("manager") ? new QManager(forProperty("manager")) : null;
        this.place = inits.isInitialized("place") ? new com.Main.domain.place.domain.entity.QPlace(forProperty("place")) : null;
    }

}

