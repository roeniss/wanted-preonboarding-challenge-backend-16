package com.wanted.preonboarding.core.api;

import org.springframework.http.HttpStatus;

public record ResponseWrapper<T>(HttpStatus statusCode, String message, T data) {
    static public <T> ResponseWrapper<T> created(T data) {
        return new ResponseWrapper<>(HttpStatus.CREATED, null, data);
    }
}
