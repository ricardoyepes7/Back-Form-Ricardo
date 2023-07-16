package com.example.form.application.mapper;

import com.example.form.application.dto.UserDto;
import com.example.form.application.dto.UserRegisterDto;
import com.example.form.domain.model.User;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface UserDtoMapper {
    User toModel(UserDto userDto);
    User toModel(UserRegisterDto userRegisterDto);
    UserDto toDto(User user);
}
