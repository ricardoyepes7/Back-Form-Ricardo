package com.example.form.infraestructure.output.feignclient.mapper;

import com.example.form.domain.model.University;
import com.example.form.infraestructure.output.feignclient.entity.UniversityEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UniversityEntityMapper {
    University toModel(UniversityEntity universityEntity);

}
