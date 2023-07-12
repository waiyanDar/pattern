package com.example.apisecurity.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class NoFreshTokenError extends ResponseStatusException {

    public NoFreshTokenError(){
        super(HttpStatus.UNAUTHORIZED,"No refresh token");
    }
}
