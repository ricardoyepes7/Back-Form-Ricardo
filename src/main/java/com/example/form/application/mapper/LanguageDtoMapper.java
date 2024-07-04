package com.example.form.application.mapper;

import com.example.form.application.dto.LanguageDto;
import com.example.form.domain.model.Language;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LanguageDtoMapper {
    LanguageDto toDto(Language language);
}
