package com.recime.core.component.common.entity;

import jakarta.persistence.*;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import java.sql.Timestamp;

@EntityListeners(AuditingEntityListener.class)
@MappedSuperclass
public abstract class BaseEntity {

    @Column(name = "CREATED_DATE", insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp createdDate;

    @Column(name = "MODIFY_DATE", insertable = true, updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private Timestamp modifyDate;
}
