package com.example.form.infraestructure.output.feign.adapter;

import com.example.form.domain.model.University;
import com.example.form.domain.spi.IUniversityPersistencePort;
import com.example.form.infraestructure.output.feign.feignclient.IUniversityHipolabsApi;
import com.example.form.infraestructure.output.feign.mapper.UniversityEntityMapper;
import lombok.RequiredArgsConstructor;

import java.util.Comparator;
import java.util.List;

@RequiredArgsConstructor
public class UniversityFeignAdapter implements IUniversityPersistencePort {
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
