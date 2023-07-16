package com.example.form.domain.usecase;

import com.example.form.domain.api.IUniversityServicePort;
import com.example.form.domain.model.University;
import com.example.form.domain.spi.IUniversityPersistencePort;

import java.util.List;

public class UniversityUseCase implements IUniversityServicePort {
    private final IUniversityPersistencePort universityPersistencePort;

    public UniversityUseCase(IUniversityPersistencePort universityPersistencePort) {
        this.universityPersistencePort = universityPersistencePort;
    }

    @Override
    public List<University> getUniversitiesByCountry(String country) {
        return universityPersistencePort.getUniversitiesByCountry(country);
    }
}
