package com.example.form.application.handler.implementation;

import com.example.form.application.dto.LanguageDto;
import com.example.form.application.handler.interfaces.ILanguageHandler;
import com.example.form.application.mapper.LanguageDtoMapper;
import com.example.form.domain.api.ILanguageServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LanguageHandlerImp implements ILanguageHandler {
    private final ILanguageServicePort languageServicePort;
    private final LanguageDtoMapper languageDtoMapper;

    @Override
    public List<LanguageDto> getAllLanguage() {
        return languageServicePort.getAllLanguages()
                .stream()
                .map(languageDtoMapper::toDto)
                .toList();
    }

    @Override
    public LanguageDto getLanguageByIsoCode(String isoCode) {
        return languageDtoMapper.toDto(languageServicePort.getLanguageById(isoCode.toLowerCase()));
    }
}
