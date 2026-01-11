package com.sagar.memoryvault.exception;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class MemoryException extends RuntimeException{
    private final int code;
    private final HttpStatus status;
    public MemoryException(int code, HttpStatus status, String message){
        super(message);
        this.code = code;
        this.status = status;
    }
}
