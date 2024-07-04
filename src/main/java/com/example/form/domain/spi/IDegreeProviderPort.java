package com.example.form.domain.spi;

import com.example.form.domain.model.Degree;

import java.util.List;

public interface IDegreeProviderPort {
    List<Degree> getAllDegreesByUserId(long userId);
    void saveDegree(Degree degree);
    void deleteAllDegreesByUserId(long userId);
}
