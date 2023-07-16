package com.example.form.application.mapper;

import com.example.form.application.dto.LocationDto;
import com.example.form.domain.model.Location;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LocationDtoMapper {
    Location toModel(LocationDto locationDto);
    LocationDto toDto(Location location);
}
