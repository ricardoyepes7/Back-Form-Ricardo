package com.example.form.infraestructure.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class UserException extends RuntimeException{
    private final String title;
    private final HttpStatus status;

    public UserException(String message, String title,HttpStatus status) {
        super(message);
        this.title = title;
        this.status=status;
    }
}
