package com.example.form.domain.usecase;

import com.example.form.domain.api.ILocationServicePort;
import com.example.form.domain.model.Location;
import com.example.form.domain.spi.ILocationPersistencePort;

import java.util.List;

public class LocationUseCase implements ILocationServicePort {
    private final ILocationPersistencePort locationPersistencePort;

    public LocationUseCase(ILocationPersistencePort locationPersistencePort) {
        this.locationPersistencePort = locationPersistencePort;
    }

    @Override
    public List<Location> getAllCountries() {
        return locationPersistencePort.getAllCountries();
    }

    @Override
    public List<Location> getAllStateByCountryIso2(String iso2) {
        return locationPersistencePort.getAllStateByCountryIso2(iso2);
    }

    @Override
    public List<Location> getAllCitiesByStateIso2AndCountryIso2(String sateIso2, String countryIso2) {
        return locationPersistencePort.getAllCitiesByStateIso2AndCountryIso2(sateIso2,countryIso2);
    }
}
