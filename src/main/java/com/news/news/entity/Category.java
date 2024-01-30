package com.news.news.entity;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "CATEGORY")
public class Category extends BaseEntity<Category> {
    private String name;
    private String description;

}
