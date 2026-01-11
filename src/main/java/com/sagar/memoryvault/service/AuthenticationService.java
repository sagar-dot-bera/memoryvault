package com.sagar.memoryvault.service;

public class AuthenticationService {
    private final UserService userService;
    public AuthenticationService(UserService userService) {
        this.userService = userService;
    }



}
