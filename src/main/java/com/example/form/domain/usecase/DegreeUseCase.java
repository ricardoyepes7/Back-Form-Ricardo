package com.example.form.domain.usecase;

import com.example.form.domain.api.IDegreeServicePort;
import com.example.form.domain.model.Degree;
import com.example.form.domain.spi.IDegreePersistencePort;

import java.util.List;

public class DegreeUseCase implements IDegreeServicePort {
    private final IDegreePersistencePort degreePersistencePort;

    public DegreeUseCase(IDegreePersistencePort degreePersistencePort) {
        this.degreePersistencePort = degreePersistencePort;
    }

    @Override
    public List<Degree> getAllDegreesByUserId(long userId) {
        return degreePersistencePort.getAllDegreesByUserId(userId);
    }

    @Override
    public void saveDegree(Degree degree) {
        degreePersistencePort.saveDegree(degree);
    }

    @Override
    public void deleteAllDegreesByUserId(long userId) {
        degreePersistencePort.deleteAllDegreesByUserId(userId);
    }
}
