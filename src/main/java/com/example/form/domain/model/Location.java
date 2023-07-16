package com.example.form.domain.model;

public class Location {
    private Integer id;
    private String name;
    private String iso2;

    public Location(Integer id, String name, String iso2) {
        this.id = id;
        this.name = name;
        this.iso2 = iso2;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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
