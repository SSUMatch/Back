package com.Main.domain.quarter.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QQuarterInfo is a Querydsl query type for QuarterInfo
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuarterInfo extends EntityPathBase<QuarterInfo> {

    private static final long serialVersionUID = 421266419L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QQuarterInfo quarterInfo = new QQuarterInfo("quarterInfo");

    public final NumberPath<Integer> assist = createNumber("assist", Integer.class);

    public final NumberPath<Integer> defence = createNumber("defence", Integer.class);

    public final NumberPath<Integer> goal = createNumber("goal", Integer.class);

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final com.Main.domain.match.domain.entity.QMatches matches;

    public final QQuarter quarter;

    public final com.Main.domain.userMatch.domain.entity.QUserMatch userMatch;

    public QQuarterInfo(String variable) {
        this(QuarterInfo.class, forVariable(variable), INITS);
    }

    public QQuarterInfo(Path<? extends QuarterInfo> path) {
        this(path.getType(), path.getMetadata(), PathInits.getFor(path.getMetadata(), INITS));
    }

    public QQuarterInfo(PathMetadata metadata) {
        this(metadata, PathInits.getFor(metadata, INITS));
    }

    public QQuarterInfo(PathMetadata metadata, PathInits inits) {
        this(QuarterInfo.class, metadata, inits);
    }

    public QQuarterInfo(Class<? extends QuarterInfo> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.matches = inits.isInitialized("matches") ? new com.Main.domain.match.domain.entity.QMatches(forProperty("matches"), inits.get("matches")) : null;
        this.quarter = inits.isInitialized("quarter") ? new QQuarter(forProperty("quarter")) : null;
        this.userMatch = inits.isInitialized("userMatch") ? new com.Main.domain.userMatch.domain.entity.QUserMatch(forProperty("userMatch"), inits.get("userMatch")) : null;
    }

}

