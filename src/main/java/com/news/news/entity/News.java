package com.news.news.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity<News> {
    @Column(name = "title")
    private String title;
    @Column(name = "content")
    private String content;

}
