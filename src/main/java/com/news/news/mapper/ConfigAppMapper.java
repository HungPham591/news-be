package com.news.news.mapper;

import com.news.news.dto.response.ConfigAppDto;
import com.news.news.entity.ConfigApp;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ConfigAppMapper {
    ConfigApp toEntity(ConfigAppDto configAppDto);

    ConfigAppDto toDto(ConfigApp configApp);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    ConfigApp partialUpdate(ConfigAppDto configAppDto, @MappingTarget ConfigApp configApp);
}