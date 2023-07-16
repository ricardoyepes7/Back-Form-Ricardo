package com.example.form.infraestructure.output.feign.feignclient;

import com.example.form.infraestructure.output.feign.entity.UniversityEntity;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Set;

@FeignClient(name = "UniversityHipolabs", url = "${universities.hipolabs.api.url}")
public interface IUniversityHipolabsApi {
    @GetMapping("/search")
    Set<UniversityEntity> getUniversitiesByCountry(@RequestParam String country);
}
