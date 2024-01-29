package com.news.news.entity;

import com.news.news.commons.enums.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "USER")
public class User extends BaseEntity<User> {
    private String email;
    private String phone;
    private String name;
    private String image;
    private Date birthdate;
    private Gender gender;
}
