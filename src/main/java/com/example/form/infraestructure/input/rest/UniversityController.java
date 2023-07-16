package com.example.form.infraestructure.input.rest;

import com.example.form.application.dto.UniversityDto;
import com.example.form.application.handler.interfaces.IUniversityHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequiredArgsConstructor
@RequestMapping("/university")
public class UniversityController {
    private final IUniversityHandler universityHandler;
    @GetMapping("/{country}")
    public ResponseEntity<List<UniversityDto>> getUniversitiesByCountry(@PathVariable String country){
        return ResponseEntity.ok(universityHandler.getUniversitiesByCountry(country));
    }

}
