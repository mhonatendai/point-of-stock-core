package com.tenstech.shopper.user;

import com.tenstech.shopper.exception.BusinessErrorCodes;
import com.tenstech.shopper.exception.BusinessException;
import lombok.extern.slf4j.Slf4j;
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
    public ResponseEntity<String> loginUser(@RequestBody @Validated UserDto userDto) {
//        boolean isAuthenticated = userService.login(userDto.getUsername(), userDto.getPassword());
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login successful!");
//        } else {
//            return ResponseEntity.badRequest().body("Invalid username or password");
//        }
        return null;
    }
}