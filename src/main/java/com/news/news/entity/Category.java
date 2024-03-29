package com.news.news.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity<Category> {
    @Column(name = "name")
    private String name;
    @Column(name = "description")
    private String description;

}
