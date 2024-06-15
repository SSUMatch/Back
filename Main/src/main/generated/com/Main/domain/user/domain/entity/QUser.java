package com.Main.domain.user.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QUser is a Querydsl query type for User
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QUser extends EntityPathBase<User> {

    private static final long serialVersionUID = -2134858355L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QUser user = new QUser("user");

    public final StringPath account = createString("account");

    public final NumberPath<Integer> age = createNumber("age", Integer.class);

    public final StringPath description = createString("description");

    public final StringPath gender = createString("gender");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final StringPath image = createString("image");

    public final StringPath location = createString("location");

    public final StringPath name = createString("name");

    public final StringPath number = createString("number");

    public final StringPath password = createString("password");

    public final StringPath position = createString("position");

    public final com.Main.domain.record.domain.entity.QRecord record;

    public final StringPath refreshToken = createString("refreshToken");

    public final com.Main.domain.team.entity.QTeam team;

    public QUser(String variable) {
        this(User.class, forVariable(variable), INITS);
    }

    public QUser(Path<? extends User> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QUser(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QUser(PathMetadata metadata, PathInits inits) {
        this(User.class, metadata, inits);
    }

    public QUser(Class<? extends User> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.record = inits.isInitialized("record") ? new com.Main.domain.record.domain.entity.QRecord(forProperty("record"), inits.get("record")) : null;
        this.team = inits.isInitialized("team") ? new com.Main.domain.team.entity.QTeam(forProperty("team")) : null;
    }

}

