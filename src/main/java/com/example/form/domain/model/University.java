package com.example.form.domain.model;

public class University {
    private final String name;

    private final String iso2;

    public University(String name, String iso2) {
        this.name = name;
        this.iso2 = iso2;
    }

    public String getName() {
        return name;
    }

    public String getIso2() {
        return iso2;
    }

}
