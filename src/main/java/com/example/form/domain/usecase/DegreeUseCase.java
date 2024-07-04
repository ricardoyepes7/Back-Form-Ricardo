package com.example.form.domain.usecase;

import com.example.form.domain.api.IDegreeServicePort;
import com.example.form.domain.model.Degree;
import com.example.form.domain.spi.IDegreeProviderPort;

import java.util.List;

public class DegreeUseCase implements IDegreeServicePort {
    private final IDegreeProviderPort degreeProviderPort;

    public DegreeUseCase(IDegreeProviderPort degreeProviderPort) {
        this.degreeProviderPort = degreeProviderPort;
    }

    @Override
    public List<Degree> getAllDegreesByUserId(long userId) {
        return degreeProviderPort.getAllDegreesByUserId(userId);
    }

    @Override
    public void saveDegree(Degree degree) {
        degreeProviderPort.saveDegree(degree);
    }

    @Override
    public void deleteAllDegreesByUserId(long userId) {
        degreeProviderPort.deleteAllDegreesByUserId(userId);
    }
}
