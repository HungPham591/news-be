package com.news.news.dto.response;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.news.news.entity.Admin}
 */
@Value
public class AdminDto extends BaseDto implements Serializable {
    Date createdAt;
    String createdBy;
    Date updatedAt;
    String updatedBy;
    Date deletedAt;
    Long id;
    String userName;
    String password;
}