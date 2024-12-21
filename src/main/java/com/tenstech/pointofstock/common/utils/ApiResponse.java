package com.tenstech.pointofstock.common.utils;

import com.tenstech.pointofstock.user.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ApiResponse {
    private UserDto userDto;
    private String apiMessage;

}