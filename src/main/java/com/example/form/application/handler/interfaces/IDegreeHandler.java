package com.example.form.application.handler.interfaces;

import com.example.form.application.dto.DegreeDto;

import java.util.List;

public interface IDegreeHandler {
    List<DegreeDto> getUserDegrees(String email);
    void saveUserDegrees(String email, List<DegreeDto> degreesDto);

}
