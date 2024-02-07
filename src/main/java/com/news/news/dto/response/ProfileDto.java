package com.news.news.dto.response;

import com.news.news.common.enums.Gender;
import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.news.news.entity.Profile}
 */
@Value
public class ProfileDto implements Serializable {
    Date createdAt;
    String createdBy;
    Date updatedAt;
    String updatedBy;
    Date deletedAt;
    Long id;
    String email;
    String phone;
    String name;
    String image;
    Date birthdate;
    Gender gender;
}