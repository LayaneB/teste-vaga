package org.rethink.challenge.exception;

import lombok.Getter;
import org.springframework.http.HttpStatus;

import java.util.List;

@Getter
public class ResponseException extends RuntimeException{
    private static final long serialVersionUID = 1L;

    private final HttpStatus httpStatus;
    private final String error;
    public ResponseException(HttpStatus httpStatus, String message) {
        super();
        this.httpStatus = httpStatus;
        this.error = message;
    }
}
