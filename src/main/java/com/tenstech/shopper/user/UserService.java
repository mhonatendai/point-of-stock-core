package com.tenstech.shopper.user;

import com.tenstech.shopper.mapper.UserMapper;
import com.tenstech.shopper.model.User;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;


    private final UserMapper userMapper;

    public UserService(UserRepository userRepository, UserMapper userMapper) {
        this.userRepository = userRepository;
        this.userMapper = userMapper;
    }

    public void registerUser(UserDto userDto) {
        User user = userMapper.userDTOToUser(userDto);
        user.setRoles("ROLE_USER");
        userRepository.save(user);
    }

    public Optional<User> getUserByUsername(String userName) {
        return this.userRepository.findByUsername(userName);
    }
}