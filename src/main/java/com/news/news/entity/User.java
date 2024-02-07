package com.news.news.entity;

import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Data
@Entity
@Table(name = "PROFILE")
public class User extends BaseEntity<User> {
    @Column(name = "user_name")
    private String userName;
    @Column(name = "password")
    private String password;
}
