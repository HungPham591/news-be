package com.news.news.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.news.news.config.audit.AuditEntity;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
public class BaseEntity<U> extends AuditEntity<U> {
    @Id
    @JsonProperty(access = JsonProperty.Access.READ_ONLY)
    @GeneratedValue(strategy = GenerationType.AUTO)
    protected Long id = 0L;
}
