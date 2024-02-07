package com.news.news.entity;

import com.news.news.common.enums.Gender;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "PROFILE")
public class Profile extends BaseEntity<Profile> {
    @Column(name = "email")
    private String email;
    @Column(name = "phone")
    private String phone;
    @Column(name = "name")
    private String name;
    @Column(name = "image")
    private String image;
    @Column(name = "birthdate")
    private Date birthdate;
    @Column(name = "gender")
    private Gender gender;
}
