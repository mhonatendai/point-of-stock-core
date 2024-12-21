package com.tenstech.pointofstock.common.utils;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse <T>{

    private T data;

    private String apiMessage;

}