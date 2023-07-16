package com.example.form.application.mapper;

import com.example.form.application.dto.DegreeDto;
import com.example.form.domain.model.Degree;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DegreeDtoMapper {
    Degree toModel(DegreeDto degreeDto);
    DegreeDto toDto(Degree degree);
}
