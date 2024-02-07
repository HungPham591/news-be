package com.news.news.mapper;

import com.news.news.dto.response.ProfileDto;
import com.news.news.entity.Profile;
import org.mapstruct.*;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface ProfileMapper {
    Profile toEntity(ProfileDto profileDto);

    ProfileDto toDto(Profile profile);

    @BeanMapping(nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    Profile partialUpdate(ProfileDto profileDto, @MappingTarget Profile profile);
}