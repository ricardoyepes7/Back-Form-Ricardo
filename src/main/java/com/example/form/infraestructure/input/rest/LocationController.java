package com.example.form.infraestructure.input.rest;

import com.example.form.application.dto.LocationDto;
import com.example.form.application.handler.interfaces.ILocationHandler;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("/location")
@RequiredArgsConstructor
public class LocationController {
    private final ILocationHandler locationHandler;
    @GetMapping("/country")
    public ResponseEntity<List<LocationDto>> getAllCountries(){
        return ResponseEntity.ok(locationHandler.getAllCountries());
    }
    @GetMapping("/state/{countryIso2}")
    private ResponseEntity<List<LocationDto>> getAllStatesByCountryIso2(@PathVariable String countryIso2){
        return ResponseEntity.ok(locationHandler.getAllStateByCountryIso2(countryIso2));
    }
    @GetMapping("/city/{stateIso2}/{countryIso2}")
    private ResponseEntity<List<LocationDto>> getAllCitiesByCountryIso2AndStateIso2(@PathVariable String stateIso2,
                                                                                    @PathVariable String countryIso2){
        return ResponseEntity.ok(locationHandler.getAllCitiesByStateIso2AndCountryIso2(stateIso2,countryIso2));
    }
}
