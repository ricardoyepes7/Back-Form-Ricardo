package com.example.form.domain.exception;

public class UserAlreadyRegistered extends RuntimeException{
    private final Long id;

    public UserAlreadyRegistered(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }
}
