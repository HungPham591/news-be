package com.news.news.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "NEWS")
public class News extends BaseEntity<News> {
    private String title;
    private String content;
}
