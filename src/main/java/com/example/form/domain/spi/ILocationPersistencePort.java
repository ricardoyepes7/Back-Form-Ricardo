package com.example.form.domain.spi;

import com.example.form.domain.model.Location;

import java.util.List;

public interface ILocationPersistencePort {
    List<Location> getAllCountries();
    List<Location> getAllStateByCountryIso2(String iso2);
    List<Location> getAllCitiesByStateIso2AndCountryIso2(String sateIso2,String countryIso2);

}
