package com.example.form.infraestructure.output.jpa.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "titulaciones")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class DegreeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;
    @Column(name = "id_usuario")
    private Long userId;
    @Column(name = "universidad")
    private String university;
    @Column(name = "titulo")
    private String title;
    @Column(name = "pais_iso2")
    private String iso2;
}
