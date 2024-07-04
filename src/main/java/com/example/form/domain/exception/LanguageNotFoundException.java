package com.example.form.domain.exception;

public class LanguageNotFoundException extends RuntimeException{
    private final String languageId;

    public LanguageNotFoundException(String languageId) {
        this.languageId = languageId;
    }

    public String getLanguageId() {
        return languageId;
    }
}
