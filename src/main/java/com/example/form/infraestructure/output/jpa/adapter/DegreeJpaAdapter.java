package com.example.form.infraestructure.output.jpa.adapter;

import com.example.form.domain.model.Degree;
import com.example.form.domain.spi.IDegreePersistencePort;
import com.example.form.infraestructure.output.jpa.mapper.DegreeEntityMapper;
import com.example.form.infraestructure.output.jpa.repository.IDegreeRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public class DegreeJpaAdapter implements IDegreePersistencePort {
    private final IDegreeRepository degreeRepository;
    private final DegreeEntityMapper degreeEntityMapper;

    @Override
    public List<Degree> getAllDegreesByUserId(long userId) {
        return degreeRepository.findByUserId(userId)
                .stream()
                .map(degreeEntityMapper::toModel)
                .toList();
    }

    @Override
    public void saveDegree(Degree degree) {
        degreeRepository.save(degreeEntityMapper.toEntity(degree));
    }

    @Override
    public void deleteAllDegreesByUserId(long userId) {
        degreeRepository.deleteByUserId(userId);
    }
}
