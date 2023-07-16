package com.example.form.application.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class UserRegisterDto {
    @NotBlank(message = "Campo obligatorio")
    @Email(message = "Correo no valido")
    private String email;
    @NotBlank(message = "Campo obligatorio")
    @Size(min = 8,message = "Mínimo 8 caracteres")
    private String password;
    @NotBlank(message = "Campo obligatorio")
    private String confirmPassword;
}
