package com.tenstech.pointofstock.user;

import com.tenstech.pointofstock.common.utils.ApiResponse;
import com.tenstech.pointofstock.exception.BusinessErrorCodes;
import com.tenstech.pointofstock.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.registerUser(userDto).orElseThrow( () -> new BusinessException(BusinessErrorCodes.GENERAL_EXCEPTION)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse> loginUser(@RequestBody @Validated LoginDTO loginDTO) {

        UserDto authenticateUser = userService.authenticateUser(loginDTO.getUsername(), loginDTO.getPassword());
        ApiResponse apiResponse = new ApiResponse();

        if (authenticateUser != null) {
            apiResponse.setUserDto(authenticateUser);
            apiResponse.setApiMessage("Login successful");
            return ResponseEntity.ok(apiResponse);
        } else {
            apiResponse.setApiMessage("Invalid username or password.");
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(apiResponse);
        }
    }
}
