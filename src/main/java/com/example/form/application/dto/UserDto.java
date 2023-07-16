package com.example.form.application.dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserDto {
    @NotBlank(message = "Campo obligatorio")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo debe contener solo letras")
    private String name;
    @NotBlank(message = "Campo obligatorio")
    @Pattern(regexp = "^[a-zA-Z]+$", message = "El campo debe contener solo letras")
    private String lastname;
    @NotBlank(message = "Campo obligatorio")
    @Pattern(regexp = "^\\+?\\d+$", message = "El campo debe contener solo números y un signo de '+' opcional al inicio")
    private String phone;
    @NotNull(message = "Campo obligatorio")
    @Past(message = "Fecha de nacimiento no valida")
    private LocalDate birthDate;
    @NotBlank(message = "Campo obligatorio")
    private String currentCity;
}
