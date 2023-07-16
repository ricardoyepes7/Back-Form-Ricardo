package com.example.form.infraestructure.output.feign.mapper;

import com.example.form.domain.model.Location;
import com.example.form.infraestructure.output.feign.entity.LocationEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LocationEntityMapper {
    Location toModel(LocationEntity locationEntity);
    LocationEntity toEntity(Location location);
}
