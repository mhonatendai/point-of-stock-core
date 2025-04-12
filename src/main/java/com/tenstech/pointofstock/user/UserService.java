package com.tenstech.pointofstock.user;

import com.tenstech.pointofstock.mapper.TypeMapper;
import com.tenstech.pointofstock.model.User;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder;

    private final TypeMapper typeMapper;

    public UserService(UserRepository userRepository, TypeMapper typeMapper, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.typeMapper = typeMapper;
        this.passwordEncoder = bCryptPasswordEncoder;
    }

    public Optional<UserDto> registerUser(UserDto userDto){
        User user = typeMapper.userDTOToUser(userDto);
        user.setRoles("ROLE_USER");
        user.setPassword(this.passwordEncoder.encode(userDto.getPassword()));
        return Optional.ofNullable(typeMapper.userToUserDTO(userRepository.save(user)));
    }

    public Optional<User> getUserByUsername(String userName) {
        return this.userRepository.findByUsername(userName);
    }

    public UserDto authenticateUser(String username, String password) {
        Optional<User> optionalUser = this.userRepository.findByUsername(username);

        if (optionalUser.isPresent()) {
            User user = optionalUser.get();
            if (passwordEncoder.matches(password, user.getPassword())) {
                return typeMapper.userToUserDTO(user);
            } else {
                throw new BadCredentialsException("Invalid password");
            }
        } else {
            throw new BadCredentialsException("Invalid username");
        }
    }
}