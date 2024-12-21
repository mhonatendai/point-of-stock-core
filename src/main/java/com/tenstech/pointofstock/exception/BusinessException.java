package com.tenstech.pointofstock.exception;

import lombok.Getter;

import java.util.StringJoiner;

@Getter
public class BusinessException extends RuntimeException{

    private final BusinessErrorCodes businessErrorCodes;

    public BusinessException(BusinessErrorCodes businessErrorCodes){
        super();
        this.businessErrorCodes = businessErrorCodes;
    }

    public BusinessException(BusinessErrorCodes businessErrorCodes, String message){
        super(message);
        this.businessErrorCodes = businessErrorCodes;
    }

    public BusinessException(BusinessErrorCodes businessErrorCodes, String message, Throwable cause){
        super(message,cause);
        this.businessErrorCodes = businessErrorCodes;
    }

    public BusinessException(BusinessErrorCodes businessErrorCodes, Throwable cause){
        super(cause);
        this.businessErrorCodes = businessErrorCodes;
    }

    @Override
    public String toString() {
        return new StringJoiner(", ", BusinessException.class.getSimpleName() + "[", "]")
                .add("errorCode=" + businessErrorCodes)
                .add("message='" + getMessage() + '\'')
                .toString();
    }
}
