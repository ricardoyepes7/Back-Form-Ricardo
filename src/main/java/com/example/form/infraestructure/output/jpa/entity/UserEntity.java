package com.example.form.infraestructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Entity
@Table(name = "usuario")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "nombre")
    private String name;
    @Column(name = "apellido")
    private String lastname;
    @Column(name = "correo")
    private String email;
    @Column(name = "telefono")
    private String phone;
    @Column(name = "fecha_nacimiento")
    private LocalDate birthDate;
    @Column(name = "ciudad_recidencia")
    private String currentCity;
    @Column(name = "contraseña")
    private String password;
}
