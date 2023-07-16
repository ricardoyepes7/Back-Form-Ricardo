package com.example.form.application.handler.interfaces;

import com.example.form.application.dto.LocationDto;


import java.util.List;

public interface ILocationHandler {
    List<LocationDto> getAllCountries();
    List<LocationDto> getAllStateByCountryIso2(String iso2);
    List<LocationDto> getAllCitiesByStateIso2AndCountryIso2(String sateIso2,String countryIso2);

}
