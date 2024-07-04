package com.example.form.domain.model;

import java.time.LocalDate;

public class User {
    private final Long id;
    private final String name;
    private final String lastname;
    private final String email;
    private final String phone;
    private final LocalDate birthDate;
    private final String currentCity;
    private final String password;

    private User(UserBuilder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.lastname = builder.lastname;
        this.email = builder.email;
        this.phone = builder.phone;
        this.birthDate = builder.birthDate;
        this.currentCity = builder.currentCity;
        this.password = builder.password;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastname() {
        return lastname;
    }

    public String getEmail() {
        return email;
    }

    public String getPhone() {
        return phone;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public String getCurrentCity() {
        return currentCity;
    }

    public String getPassword() {
        return password;
    }

    public static UserBuilder builder() {
        return new UserBuilder();
    }

    public static class UserBuilder {
        private Long id;
        private String name;
        private String lastname;
        private String email;
        private String phone;
        private LocalDate birthDate;
        private String currentCity;
        private String password;

        public UserBuilder id(Long id) {
            this.id = id;
            return this;
        }

        public UserBuilder name(String name) {
            this.name = name;
            return this;
        }

        public UserBuilder lastname(String lastname) {
            this.lastname = lastname;
            return this;
        }

        public UserBuilder email(String email) {
            this.email = email;
            return this;
        }

        public UserBuilder phone(String phone) {
            this.phone = phone;
            return this;
        }

        public UserBuilder birthDate(LocalDate birthDate) {
            this.birthDate = birthDate;
            return this;
        }

        public UserBuilder currentCity(String currentCity) {
            this.currentCity = currentCity;
            return this;
        }

        public UserBuilder password(String password) {
            this.password = password;
            return this;
        }

        public User build() {
            return new User(this);
        }
    }
}
