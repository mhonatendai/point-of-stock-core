package com.tenstech.pointofstock.user;

import com.tenstech.pointofstock.common.utils.ApiResponse;
import com.tenstech.pointofstock.exception.BusinessErrorCodes;
import com.tenstech.pointofstock.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;

@RestController
@RequestMapping("/api/users")
@Slf4j
@CrossOrigin(origins = "http://localhost:4700")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<UserDto> registerUser(@RequestBody @Validated UserDto userDto) {
        return ResponseEntity.ok(userService.registerUser(userDto).orElseThrow(() -> new BusinessException(BusinessErrorCodes.GENERAL_EXCEPTION)));
    }

    @PostMapping("/login")
    public ResponseEntity<ApiResponse<UserDto>> loginUser(@RequestBody @Validated LoginDTO loginDTO) {

        try {

            log.info("Attempting to login at {}", LocalDateTime.now());
            UserDto authenticatedUser = userService.authenticateUser(loginDTO.getUsername(), loginDTO.getPassword());
            return ResponseEntity.ok(ApiResponse.<UserDto>builder()
                    .data(authenticatedUser)
                    .apiMessage("Login successful")
                    .build());
        } catch (BadCredentialsException e) {

            log.warn("Login failed for user: {} due to invalid credentials.", loginDTO.getUsername());
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED)
                    .body(ApiResponse.<UserDto>builder()
                            .apiMessage("Invalid username or password.")
                            .build());
        } catch (Exception e) {

            log.error("An unexpected error occurred during login for user: {}", loginDTO.getUsername(), e);
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(ApiResponse.<UserDto>builder()
                            .apiMessage("An unexpected error occurred during login.")
                            .build());
        }
    }
}
