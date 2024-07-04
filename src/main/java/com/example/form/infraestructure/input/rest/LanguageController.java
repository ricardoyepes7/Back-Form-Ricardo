package com.example.form.infraestructure.input.rest;

import com.example.form.application.dto.LanguageDto;
import com.example.form.application.handler.interfaces.ILanguageHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/language")
@RequiredArgsConstructor
public class LanguageController {
    private final ILanguageHandler languageHandler;

    @GetMapping
    public ResponseEntity<List<LanguageDto>> getLanguages(){
        return ResponseEntity.ok(languageHandler.getAllLanguage());
    }
    @GetMapping("/{isoCode}")
    public ResponseEntity<LanguageDto> getLanguageByIsoCode(@PathVariable String isoCode){
        return ResponseEntity.ok(languageHandler.getLanguageByIsoCode(isoCode));
    }
}
