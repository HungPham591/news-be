package com.news.news.entity;

import com.news.news.common.enums.Gender;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "ADMIN")
public class Admin extends BaseEntity<Admin> {
    @Column(name = "email")
    private String email;
    private String phone;
    private String name;
    private String image;
    private Date birthdate;
    private Gender gender;
}
