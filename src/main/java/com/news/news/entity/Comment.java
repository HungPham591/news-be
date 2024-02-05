package com.news.news.entity;


import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity<Comment> {
    private String content;

}
