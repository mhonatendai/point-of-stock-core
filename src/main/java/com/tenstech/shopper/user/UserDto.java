package com.tenstech.shopper.user;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserDto {

    private Long id;

    @NotEmpty(message = "Username should not be empty")
    private String username;

    @Email(message = "Email should be valid")
    @NotEmpty(message = "Email should not be empty")
    private String email;

    @NotEmpty(message = "Password should not be empty")
    private String password;

    private String phone;

    private String address;

    private String city;

    private String country;

    @NotEmpty(message = "First name should not be empty")
    private String firstName;

    @NotEmpty(message = "Last name should not be empty")
    private String lastName;

    private String gender;

    private Boolean accountNonExpired;

    private Boolean accountNonLocked;

    private Boolean enabled;

}