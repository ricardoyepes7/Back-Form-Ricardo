package com.example.form.infraestructure.output.soapclient.soap;

import com.example.form.domain.exception.LanguageNotFoundException;
import com.example.form.infraestructure.configuration.soap.SoapClientTemplate;
import com.example.form.wsdl.*;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class LanguageSoapClient {
    private final SoapClientTemplate soapClientTemplate;

    public List<TLanguage> findAllLanguages() {
        ListOfLanguagesByNameResponse listOfLanguagesByNameResponse = (ListOfLanguagesByNameResponse) soapClientTemplate.execute(new ListOfLanguagesByName());
        return listOfLanguagesByNameResponse.getListOfLanguagesByNameResult().getTLanguage();
    }

    public String findLanguageById(String languageId) {
        LanguageName languageName = new LanguageName();
        languageName.setSISOCode(languageId);
        LanguageNameResponse languageNameResponse = (LanguageNameResponse) soapClientTemplate.execute(languageName);
        if (languageNameResponse.getLanguageNameResult().equalsIgnoreCase("Language ISO Code not found!")) {
            throw new LanguageNotFoundException(languageId);
        }
        return languageNameResponse.getLanguageNameResult();
    }
}
