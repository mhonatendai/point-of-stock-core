package com.tenstech.shopper.user;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

// This can be a REST controller
@RestController
@RequestMapping("/api/users")
@Slf4j
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/register")
    public ResponseEntity<String> registerUser(@RequestBody @Validated UserDto userDto, BindingResult result) {
        try{
            log.info("This is an information message: {} : {}", userDto.getPassword(), userDto.getUsername());
            // Validate the registration data
            if (result.hasErrors()) {
                return ResponseEntity.badRequest().body("Invalid registration data");
            }
            userService.registerUser(userDto);
        }catch (Exception e) {
            e.printStackTrace();
        }

        return ResponseEntity.ok("User registered successfully!");
    }

    // Add the login endpoint if using session-based authentication
    @PostMapping("/login")
    public ResponseEntity<String> loginUser(@RequestBody @Validated UserDto userDto) {
        // You would typically delegate to a separate Authentication Service
        // For example:
//        boolean isAuthenticated = userService.login(userDto.getUsername(), userDto.getPassword());
//        if (isAuthenticated) {
//            return ResponseEntity.ok("Login successful!");
//        } else {
//            return ResponseEntity.badRequest().body("Invalid username or password");
//        }
        return null;
    }
}