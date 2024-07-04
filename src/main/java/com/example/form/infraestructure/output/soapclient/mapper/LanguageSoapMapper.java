package com.example.form.infraestructure.output.soapclient.mapper;

import com.example.form.domain.model.Language;
import com.example.form.wsdl.TLanguage;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;

@Mapper(componentModel = "spring",
        unmappedTargetPolicy = ReportingPolicy.IGNORE,
        unmappedSourcePolicy = ReportingPolicy.IGNORE)
public interface LanguageSoapMapper {
    @Mapping(target = "id", source = "SISOCode")
    @Mapping(target = "name", source = "SName")
    Language toModel(TLanguage language);
}
