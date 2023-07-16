package com.example.form.infraestructure.output.feign.feignclient;

import com.example.form.infraestructure.output.feign.entity.LocationEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;

import java.util.List;

@FeignClient(name = "CountryStateCityApi", url = "${countrystatecity.api.url}")
public interface ICountryStateCityApi {
    @GetMapping("/countries")
    List<LocationEntity> getAllCountries(@RequestHeader("X-CSCAPI-KEY") String key);

    @GetMapping("/countries/{iso2}/states")
    List<LocationEntity> getAllStateByCountryIso2(@RequestHeader("X-CSCAPI-KEY") String key, @PathVariable String iso2);

    @GetMapping("/countries/{countryIso2}/states/{sateIso2}/cities")
    List<LocationEntity> getAllCitiesByStateIso2AndCountryIso2(@RequestHeader("X-CSCAPI-KEY") String key,
                                                               @PathVariable String countryIso2,
                                                               @PathVariable String sateIso2);
}
