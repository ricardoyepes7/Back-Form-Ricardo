package com.example.form.domain.usecase;

import com.example.form.domain.api.ILanguageServicePort;
import com.example.form.domain.model.Language;
import com.example.form.domain.spi.ILanguageProviderPort;

import java.util.List;

public class LanguageUseCase implements ILanguageServicePort {
    private final ILanguageProviderPort languageProviderPort;

    public LanguageUseCase(ILanguageProviderPort languageProviderPort) {
        this.languageProviderPort = languageProviderPort;
    }

    @Override
    public List<Language> getAllLanguages() {
        return languageProviderPort.getAllLanguages();
    }

    @Override
    public Language getLanguageById(String languageId) {
        return languageProviderPort.getLanguageById(languageId);
    }
}
