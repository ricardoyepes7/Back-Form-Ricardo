package com.example.form.domain.api;

import com.example.form.domain.model.University;

import java.util.List;

public interface IUniversityServicePort {
    List<University> getUniversitiesByCountry(String country);

}
