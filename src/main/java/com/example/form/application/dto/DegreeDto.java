package com.example.form.application.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class DegreeDto {
    @NotEmpty(message = "Campo obligatorio")
    private String university;
    @NotBlank(message = "Campo obligatorio")
    private String title;
    @NotBlank(message = "Campo obligatorio")
    private String iso2;
}
