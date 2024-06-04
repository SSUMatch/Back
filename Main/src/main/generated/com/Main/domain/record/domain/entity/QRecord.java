package com.Main.domain.record.domain.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QRecord is a Querydsl query type for Record
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QRecord extends EntityPathBase<Record> {

    private static final long serialVersionUID = 1803607373L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QRecord record = new QRecord("record");

    public final NumberPath<Integer> assist = createNumber("assist", Integer.class);

    public final NumberPath<Integer> defence = createNumber("defence", Integer.class);

    public final NumberPath<Integer> goal = createNumber("goal", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<Level> level = createEnum("level", Level.class);

    public final NumberPath<Integer> participant = createNumber("participant", Integer.class);

    public final NumberPath<Integer> pom = createNumber("pom", Integer.class);

    public final NumberPath<Double> score = createNumber("score", Double.class);

    public final com.Main.domain.user.domain.entity.QUser user;

    public final NumberPath<Integer> victory = createNumber("victory", Integer.class);

    public QRecord(String variable) {
        this(Record.class, forVariable(variable), INITS);
    }

    public QRecord(Path<? extends Record> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QRecord(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QRecord(PathMetadata metadata, PathInits inits) {
        this(Record.class, metadata, inits);
    }

    public QRecord(Class<? extends Record> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.user = inits.isInitialized("user") ? new com.Main.domain.user.domain.entity.QUser(forProperty("user"), inits.get("user")) : null;
    }

}

