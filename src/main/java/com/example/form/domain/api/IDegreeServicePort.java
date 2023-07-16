package com.example.form.domain.api;

import com.example.form.domain.model.Degree;

import java.util.List;

public interface IDegreeServicePort {
    List<Degree> getAllDegreesByUserId(long userId);
    void saveDegree(Degree degree);
    void deleteAllDegreesByUserId(long userId);
}
