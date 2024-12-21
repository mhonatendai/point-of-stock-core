package com.tenstech.pointofstock.user;

import com.tenstech.pointofstock.mapper.TypeMapper;
import com.tenstech.pointofstock.model.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;


    private final TypeMapper typeMapper;

    public UserService(UserRepository userRepository, TypeMapper typeMapper) {
        this.userRepository = userRepository;
        this.typeMapper = typeMapper;
    }

    public Optional<UserDto> registerUser(UserDto userDto){
        User user = typeMapper.userDTOToUser(userDto);
        user.setRoles("ROLE_USER");
        user.setPassword(new BCryptPasswordEncoder().encode(userDto.getPassword()));
        return Optional.ofNullable(typeMapper.userToUserDTO(userRepository.save(user)));
    }

    public Optional<User> getUserByUsername(String userName) {
        return this.userRepository.findByUsername(userName);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User not found: " + username));
        return new org.springframework.security.core.userdetails.User(user.getUsername(),
                user.getPassword(), new ArrayList<>());
    }
}