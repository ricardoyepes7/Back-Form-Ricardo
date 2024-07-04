package com.example.form.domain.model;

public class Degree {
    private final Long id;
    private final Long userId;
    private final String university;
    private final String title;
    private final String cityId;

    private Degree(DegreeBuilder builder) {
        this.id = builder.id;
        this.userId = builder.userId;
        this.university = builder.university;
        this.title = builder.title;
        this.cityId = builder.cityId;
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public String getUniversity() {
        return university;
    }

    public String getTitle() {
        return title;
    }

    public String getCityId() {
        return cityId;
    }

    public static DegreeBuilder builder() {
        return new DegreeBuilder();
    }

    public static class DegreeBuilder {
        private Long id;
        private Long userId;
        private String university;
        private String title;
        private String cityId;

        public DegreeBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public DegreeBuilder userId(Long userId) {
            this.userId = userId;
            return this;
        }

        public DegreeBuilder university(String university) {
            this.university = university;
            return this;
        }

        public DegreeBuilder title(String title) {
            this.title = title;
            return this;
        }

        public DegreeBuilder cityId(String cityId) {
            this.cityId = cityId;
            return this;
        }

        public Degree build() {
            return new Degree(this);
        }
    }
}
