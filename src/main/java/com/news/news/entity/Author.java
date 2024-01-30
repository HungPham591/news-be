package com.news.news.entity;

import com.news.news.commons.enums.Gender;
import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Data
@Entity
@Table(name = "AUTHOR")
public class Author extends BaseEntity<Author> {
    private String email;
    private String phone;
    private String name;
    private String image;
    private Date birthdate;
    private Gender gender;
    private String status;

}
