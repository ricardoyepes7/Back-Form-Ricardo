package com.example.form.infraestructure.output.jpa.mapper;

import com.example.form.domain.model.User;
import com.example.form.infraestructure.output.jpa.entity.UserEntity;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserEntityMapper {
    User toModel(UserEntity userEntity);
    UserEntity toEntity(User user);
}
