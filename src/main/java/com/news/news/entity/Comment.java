package com.news.news.entity;


import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "COMMENT")
public class Comment extends BaseEntity<Comment> {
    @Column(name = "content")
    private String content;

}
