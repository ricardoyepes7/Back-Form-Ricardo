package com.example.form.domain.model;

public class Degree {
    private Long id;
    private Long userId;
    private String university;
    private String title;
    private String iso2;

    public Degree(Long id, Long userId, String university, String title, String iso2) {
        this.id = id;
        this.userId = userId;
        this.university = university;
        this.title = title;
        this.iso2 = iso2;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIso2() {
        return iso2;
    }

    public void setIso2(String iso2) {
        this.iso2 = iso2;
    }
}
