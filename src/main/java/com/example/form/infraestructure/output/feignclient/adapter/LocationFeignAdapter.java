package com.example.form.infraestructure.output.feignclient.adapter;

import com.example.form.domain.model.Location;
import com.example.form.domain.spi.ILocationProviderPort;
import com.example.form.infraestructure.output.feignclient.feign.ICountryStateCityApi;
import com.example.form.infraestructure.output.feignclient.mapper.LocationEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class LocationFeignAdapter implements ILocationProviderPort {
    private final ICountryStateCityApi countryStateCityApi;
    private final LocationEntityMapper locationEntityMapper;
    private final String token;
    @Override
    public List<Location> getAllCountries() {
        return countryStateCityApi.getAllCountries(token)
                .stream()
                .map(locationEntityMapper::toModel)
                .toList();
    }

    @Override
    public List<Location> getAllStateByCountryIso2(String iso2) {
        return countryStateCityApi.getAllStateByCountryIso2(token,iso2)
                .stream()
                .map(locationEntityMapper::toModel)
                .sorted(Comparator.comparing(Location::getName))
                .toList();
    }

    @Override
    public List<Location> getAllCitiesByStateIso2AndCountryIso2(String sateIso2, String countryIso2) {
        return countryStateCityApi.getAllCitiesByStateIso2AndCountryIso2(token,countryIso2,sateIso2)
                .stream()
                .map(locationEntityMapper::toModel)
                .toList();
    }
}
