package com.tenstech.pointofstock.config;

import com.tenstech.pointofstock.model.User;
import com.tenstech.pointofstock.user.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.domain.AuditorAware;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import java.util.Optional;

@Configuration
public class AuditorAwareImpl implements AuditorAware<String> {

    @Autowired
    private UserService userService;
 
    @Override
    public Optional<String> getCurrentAuditor() {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication != null && authentication.isAuthenticated() && authentication.getName() != null) {
            String currentUsername = authentication.getName();
            Optional<User> optionalUser = userService.getUserByUsername(currentUsername);
            return optionalUser.isPresent() ? Optional.of(currentUsername) : Optional.empty();
        }
        return Optional.of("system");
    }
}