package com.tenstech.shopper.exception;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.time.LocalDateTime;

@ControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(BusinessException.class)
    public ResponseEntity<ErrorResponse> handleBusinessException(BusinessException e, HttpServletRequest request){
        return ResponseEntity.status(e.getBusinessErrorCodes().getHttpStatus()).body(new ErrorResponse(e.getBusinessErrorCodes().getMessage(), LocalDateTime.now(),request.getPathInfo()));
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleException(Exception e,HttpServletRequest request){
        return ResponseEntity.status(BusinessErrorCodes.GENERAL_EXCEPTION.getHttpStatus()).body(new ErrorResponse(e.getMessage(), LocalDateTime.now(),request.getPathInfo()));
    }
}