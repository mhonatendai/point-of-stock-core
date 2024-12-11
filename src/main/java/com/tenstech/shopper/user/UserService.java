package com.tenstech.shopper.user;

import com.tenstech.shopper.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final PasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void registerUser(UserDto userDto) {
        User user = new User();
        user.setUsername(userDto.getUsername());
        user.setPassword(passwordEncoder.encode(userDto.getPassword()));
        user.setRoles("ROLE_USER");
        user.setAddress(userDto.getAddress());
        user.setCity(userDto.getCity());
        user.setCountry(userDto.getCountry());
        user.setEmail(userDto.getEmail());
        user.setPhone(userDto.getPhone());
        user.setFirstName(userDto.getFirstName());
        user.setLastName(userDto.getLastName());
        userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String userName) {
        return this.userRepository.findByUsername(userName);
    }
}