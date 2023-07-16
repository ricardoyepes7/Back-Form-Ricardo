package com.example.form.domain.model;

public class University {
    private String name;

    private String iso2;

    public University(String name, String iso2) {
        this.name = name;
        this.iso2 = iso2;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
}
