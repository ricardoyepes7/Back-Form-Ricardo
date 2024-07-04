package com.example.form.domain.usecase;

import com.example.form.domain.api.IUniversityServicePort;
import com.example.form.domain.model.University;
import com.example.form.domain.spi.IUniversityProviderPort;

import java.util.List;

public class UniversityUseCase implements IUniversityServicePort {
    private final IUniversityProviderPort universityProviderPort;

    public UniversityUseCase(IUniversityProviderPort universityProviderPort) {
        this.universityProviderPort = universityProviderPort;
    }

    @Override
    public List<University> getUniversitiesByCountry(String country) {
        return universityProviderPort.getUniversitiesByCountry(country);
    }
}
