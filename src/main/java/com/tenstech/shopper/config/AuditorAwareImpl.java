package com.tenstech.shopper.config;

import com.tenstech.shopper.model.User;
import com.tenstech.shopper.user.UserService;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private UserService userService;
 
    @Override
    public Optional<String> getCurrentAuditor() {
        String currentUsername = SecurityContextHolder.getContext().getAuthentication().getName();
        Optional<User> optionalUser = userService.getUserByUsername(currentUsername);
        return optionalUser.isPresent() ? Optional.of(currentUsername) : Optional.of("system");
    }
}