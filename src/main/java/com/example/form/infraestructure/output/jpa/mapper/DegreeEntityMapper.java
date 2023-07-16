package com.example.form.infraestructure.output.jpa.mapper;

import com.example.form.domain.model.Degree;
import com.example.form.infraestructure.output.jpa.entity.DegreeEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface DegreeEntityMapper {
    Degree toModel(DegreeEntity degreeEntity);
    DegreeEntity toEntity(Degree degree);
}
