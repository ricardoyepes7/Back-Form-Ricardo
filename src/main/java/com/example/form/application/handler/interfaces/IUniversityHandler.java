package com.example.form.application.handler.interfaces;


import com.example.form.application.dto.UniversityDto;

import java.util.List;

public interface IUniversityHandler {
    List<UniversityDto> getUniversitiesByCountry(String country);

}
