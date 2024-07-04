package com.example.form.infraestructure.output.soapclient.adapter;

import com.example.form.domain.model.Language;
import com.example.form.domain.spi.ILanguageProviderPort;
import com.example.form.infraestructure.output.soapclient.mapper.LanguageSoapMapper;
import com.example.form.infraestructure.output.soapclient.soap.LanguageSoapClient;
import lombok.RequiredArgsConstructor;

import java.util.List;
@RequiredArgsConstructor
public class LanguageSoapAdapter implements ILanguageProviderPort {
    private final LanguageSoapClient languageSoapClient;
    private final LanguageSoapMapper languageSoapMapper;

    @Override
    public List<Language> getAllLanguages() {
        return languageSoapClient.findAllLanguages()
                .stream()
                .map(languageSoapMapper::toModel)
                .toList();
    }

    @Override
    public Language getLanguageById(String languageId) {
        return new Language(languageId, languageSoapClient.findLanguageById(languageId));
    }
}
