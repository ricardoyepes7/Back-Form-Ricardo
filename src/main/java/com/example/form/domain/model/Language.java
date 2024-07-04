package com.example.form.domain.model;

public class Language {
    private final String id;
    private final String name;

    public Language(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

}
