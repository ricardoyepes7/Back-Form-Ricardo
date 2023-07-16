package com.example.form.application.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class PasswordNotMachException extends RuntimeException {
    private final String title;
    private final HttpStatus status;

    public PasswordNotMachException(String message, String title, HttpStatus status) {
        super(message);
        this.title = title;
        this.status = status;
    }


}
