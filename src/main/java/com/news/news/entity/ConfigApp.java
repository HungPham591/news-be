package com.news.news.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CONFIG_APP")
public class ConfigApp extends BaseEntity<ConfigApp> {
    @Column(name = "email")
    private String email;
}
