package com.tenstech.shopper.user;

import com.tenstech.shopper.exception.InvalidRequestException;
import com.tenstech.shopper.exception.UserRegistrationException;
import com.tenstech.shopper.exception.ValidationException;
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
        try{
            return ResponseEntity.ok(userService.registerUser(userDto));
        }catch (InvalidRequestException e) {
            throw new InvalidRequestException("Invalid request");
        }catch (UserRegistrationException e) {
            log.error("User registration error: {}", e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }catch (Exception e) {
           log.error(e.getMessage());
        }
        return ResponseEntity.badRequest().build();
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