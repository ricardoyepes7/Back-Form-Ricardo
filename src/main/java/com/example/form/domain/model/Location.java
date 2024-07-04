package com.example.form.domain.model;

public class Location {
    private final Integer id;
    private final String name;
    private final String iso2;

    public Location(Integer id, String name, String iso2) {
        this.id = id;
        this.name = name;
        this.iso2 = iso2;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getIso2() {
        return iso2;
    }
}
