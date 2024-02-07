package com.news.news.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "FILE")
public class File extends BaseEntity<Long> {
    @Column(name = "name")
    private String name;
    @Column(name = "url")
    private String url;
}
