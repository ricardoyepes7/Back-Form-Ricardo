package com.example.form.domain.spi;

import com.example.form.domain.model.University;

import java.util.List;

public interface IUniversityPersistencePort {
    List<University> getUniversitiesByCountry(String country);

}
