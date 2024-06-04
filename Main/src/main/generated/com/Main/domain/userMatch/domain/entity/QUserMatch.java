package com.Main.domain.userMatch.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUserMatch is a Querydsl query type for UserMatch
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUserMatch extends EntityPathBase<UserMatch> {

    private static final long serialVersionUID = 1754559267L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUserMatch userMatch = new QUserMatch("userMatch");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.Main.domain.match.domain.entity.QMatches matches;

    public final NumberPath<Integer> number = createNumber("number", Integer.class);

    public final EnumPath<com.Main.domain.team.entity.TeamType> teamType = createEnum("teamType", com.Main.domain.team.entity.TeamType.class);

    public final com.Main.domain.user.domain.entity.QUser user;

    public QUserMatch(String variable) {
        this(UserMatch.class, forVariable(variable), INITS);
    }

    public QUserMatch(Path<? extends UserMatch> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUserMatch(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUserMatch(PathMetadata metadata, PathInits inits) {
        this(UserMatch.class, metadata, inits);
    }

    public QUserMatch(Class<? extends UserMatch> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.matches = inits.isInitialized("matches") ? new com.Main.domain.match.domain.entity.QMatches(forProperty("matches"), inits.get("matches")) : null;
        this.user = inits.isInitialized("user") ? new com.Main.domain.user.domain.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

