package com.example.form.infraestructure.output.feign.mapper;

import com.example.form.domain.model.University;
import com.example.form.infraestructure.output.feign.entity.UniversityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UniversityEntityMapper {
    University toModel(UniversityEntity universityEntity);

}
