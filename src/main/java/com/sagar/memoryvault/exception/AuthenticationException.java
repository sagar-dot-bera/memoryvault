package com.sagar.memoryvault.exception;

import org.springframework.http.HttpStatus;

public class AuthenticationException extends RuntimeException {
    private final int code;
    private final HttpStatus status;
    public AuthenticationException(int code,HttpStatus status,String message) {
        super(message);
        this.code = code;
        this.status = status;
    }
}
