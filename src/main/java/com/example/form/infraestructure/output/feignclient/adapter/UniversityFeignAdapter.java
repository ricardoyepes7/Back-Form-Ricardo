package com.example.form.infraestructure.output.feignclient.adapter;

import com.example.form.domain.model.University;
import com.example.form.domain.spi.IUniversityProviderPort;
import com.example.form.infraestructure.output.feignclient.feign.IUniversityHipolabsApi;
import com.example.form.infraestructure.output.feignclient.mapper.UniversityEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class UniversityFeignAdapter implements IUniversityProviderPort {
    private final IUniversityHipolabsApi universityHipolabsApi;
    private final UniversityEntityMapper universityEntityMapper;

    @Override
    public List<University> getUniversitiesByCountry(String country) {
        return universityHipolabsApi.getUniversitiesByCountry(country)
                .stream()
                .map(universityEntityMapper::toModel)
                .sorted(Comparator.comparing(University::getName))
                .toList();
    }
}
