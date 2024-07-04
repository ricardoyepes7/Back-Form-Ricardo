package com.example.form.domain.api;

import com.example.form.domain.model.Language;

import java.util.List;

public interface ILanguageServicePort {
    List<Language> getAllLanguages();
    Language getLanguageById(String  languageId);
}
