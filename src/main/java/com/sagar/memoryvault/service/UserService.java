package com.sagar.memoryvault.service;

import com.sagar.memoryvault.entity.User;
import com.sagar.memoryvault.exception.AuthenticationException;
import com.sagar.memoryvault.repository.UserRepository;
import jakarta.validation.constraints.NotNull;
import org.springframework.http.HttpStatus;

import java.util.UUID;

public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public @NotNull User getUserById(String userId){
        return userRepository.getUserById(UUID.fromString(userId)).orElseThrow(
                () -> new AuthenticationException(404, HttpStatus.NOT_FOUND, "User not found")
        );
    }





}
