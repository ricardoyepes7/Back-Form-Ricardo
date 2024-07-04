package com.example.form.application.handler.interfaces;

import com.example.form.application.dto.LanguageDto;

import java.util.List;

public interface ILanguageHandler {
    List<LanguageDto> getAllLanguage();
    LanguageDto getLanguageByIsoCode(String isoCode);
}
