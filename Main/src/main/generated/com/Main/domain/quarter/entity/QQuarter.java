package com.Main.domain.quarter.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.processing.Generated;
import com.querydsl.core.types.Path;


/**
 * QQuarter is a Querydsl query type for Quarter
 */
@Generated("com.querydsl.codegen.DefaultEntitySerializer")
public class QQuarter extends EntityPathBase<Quarter> {

    private static final long serialVersionUID = -995195483L;

    public static final QQuarter quarter = new QQuarter("quarter");

    public final NumberPath<Long> id = createNumber("id", Long.class);

    public final EnumPath<QuarterType> quarterType = createEnum("quarterType", QuarterType.class);

    public QQuarter(String variable) {
        super(Quarter.class, forVariable(variable));
    }

    public QQuarter(Path<? extends Quarter> path) {
        super(path.getType(), path.getMetadata());
    }

    public QQuarter(PathMetadata metadata) {
        super(Quarter.class, metadata);
    }

}

