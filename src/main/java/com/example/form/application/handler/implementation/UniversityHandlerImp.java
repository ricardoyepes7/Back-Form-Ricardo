package com.example.form.application.handler.implementation;

import com.example.form.application.dto.UniversityDto;
import com.example.form.application.handler.interfaces.IUniversityHandler;
import com.example.form.application.mapper.UniversityDtoMapper;
import com.example.form.domain.api.IUniversityServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class UniversityHandlerImp implements IUniversityHandler {
    private final IUniversityServicePort universityServicePort;
    private final UniversityDtoMapper universityDtoMapper;

    @Override
    public List<UniversityDto> getUniversitiesByCountry(String country) {
        return universityServicePort.getUniversitiesByCountry(country)
                .stream().map(universityDtoMapper::toDto)
                .toList();
    }
}
