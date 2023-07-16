package com.example.form.application.mapper;

import com.example.form.application.dto.UniversityDto;
import com.example.form.domain.model.University;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UniversityDtoMapper {
    UniversityDto toDto(University university);
}
