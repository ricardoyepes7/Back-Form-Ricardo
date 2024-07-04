package com.example.form.domain.usecase;

import com.example.form.domain.api.ILocationServicePort;
import com.example.form.domain.model.Location;
import com.example.form.domain.spi.ILocationProviderPort;

import java.util.List;

public class LocationUseCase implements ILocationServicePort {
    private final ILocationProviderPort locationProviderPort;

    public LocationUseCase(ILocationProviderPort locationProviderPort) {
        this.locationProviderPort = locationProviderPort;
    }

    @Override
    public List<Location> getAllCountries() {
        return locationProviderPort.getAllCountries();
    }

    @Override
    public List<Location> getAllStateByCountryIso2(String iso2) {
        return locationProviderPort.getAllStateByCountryIso2(iso2);
    }

    @Override
    public List<Location> getAllCitiesByStateIso2AndCountryIso2(String sateIso2, String countryIso2) {
        return locationProviderPort.getAllCitiesByStateIso2AndCountryIso2(sateIso2,countryIso2);
    }
}
