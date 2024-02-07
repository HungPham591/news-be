package com.news.news.mapper;

import com.news.news.dto.response.AdminDto;
import com.news.news.entity.Admin;

@org.mapstruct.Mapper(unmappedTargetPolicy = org.mapstruct.ReportingPolicy.IGNORE, componentModel = "spring")
public interface AdminMapper {
    Admin toEntity(AdminDto adminDto);

    AdminDto toDto(Admin admin);

    @org.mapstruct.BeanMapping(nullValuePropertyMappingStrategy = org.mapstruct.NullValuePropertyMappingStrategy.IGNORE)
    Admin partialUpdate(AdminDto adminDto, @org.mapstruct.MappingTarget Admin admin);
}