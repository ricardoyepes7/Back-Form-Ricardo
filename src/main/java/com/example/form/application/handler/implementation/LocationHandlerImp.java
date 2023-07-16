package com.example.form.application.handler.implementation;

import com.example.form.application.dto.LocationDto;
import com.example.form.application.handler.interfaces.ILocationHandler;
import com.example.form.application.mapper.LocationDtoMapper;
import com.example.form.domain.api.ILocationServicePort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class LocationHandlerImp implements ILocationHandler {
    private final ILocationServicePort locationServicePort;
    private final LocationDtoMapper locationDtoMapper;

    @Override
    public List<LocationDto> getAllCountries() {
        return locationServicePort.getAllCountries()
                .stream()
                .map(locationDtoMapper::toDto)
                .toList();
    }

    @Override
    public List<LocationDto> getAllStateByCountryIso2(String iso2) {
        return locationServicePort.getAllStateByCountryIso2(iso2)
                .stream()
                .map(locationDtoMapper::toDto)
                .toList();
    }

    @Override
    public List<LocationDto> getAllCitiesByStateIso2AndCountryIso2(String sateIso2, String countryIso2) {
        return locationServicePort.getAllCitiesByStateIso2AndCountryIso2(sateIso2,countryIso2)
                .stream()
                .map(locationDtoMapper::toDto)
                .toList();
    }
}
