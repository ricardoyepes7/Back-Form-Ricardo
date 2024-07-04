package com.example.form.domain.spi;

import com.example.form.domain.model.Language;

import java.util.List;

public interface ILanguageProviderPort {
    List<Language> getAllLanguages();
    Language getLanguageById(String languageId);

}
