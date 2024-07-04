package com.example.form.infraestructure.output.feignclient.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class UniversityEntity {
    private String name;
    @JsonProperty("alpha_two_code")
    private String iso2;
}
