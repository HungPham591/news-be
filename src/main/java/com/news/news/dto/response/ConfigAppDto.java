package com.news.news.dto.response;

import lombok.Value;

import java.io.Serializable;
import java.util.Date;

/**
 * DTO for {@link com.news.news.entity.ConfigApp}
 */
@Value
public class ConfigAppDto extends BaseDto implements Serializable {
    Date createdAt;
    String createdBy;
    Date updatedAt;
    String updatedBy;
    Date deletedAt;
    Long id;
    String email;
}