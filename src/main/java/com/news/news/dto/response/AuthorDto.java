package com.news.news.dto.response;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.news.news.entity.Author}
 */
@Value
public class AuthorDto extends BaseDto implements Serializable {
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
    String status;
}