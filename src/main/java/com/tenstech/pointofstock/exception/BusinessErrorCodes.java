package com.tenstech.pointofstock.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@AllArgsConstructor
public enum BusinessErrorCodes {

    USER_NOT_FOUND("User Not Found", HttpStatus.BAD_REQUEST),
    INVALID_REQUEST("Invalid Request", HttpStatus.BAD_REQUEST),
    GENERAL_EXCEPTION("Unexpected Error processing your request", HttpStatus.INTERNAL_SERVER_ERROR);

    private final String message;
    private final HttpStatus httpStatus;

    public String getResponseCode() {
        return String.format("%d.%s", httpStatus.value(), message);
    }

    public String toString() {
        return String.format("%s - %s", getResponseCode(), httpStatus.getReasonPhrase());
    }
}
