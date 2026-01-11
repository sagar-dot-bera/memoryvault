package com.sagar.memoryvault.controller;

import lombok.AllArgsConstructor;
import org.openapitools.model.LoginRequest;
import org.openapitools.model.SignUpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.openapitools.api.AuthApi;
import org.springframework.web.context.request.NativeWebRequest;

import java.util.Optional;

@Controller
public class AuthenticationController implements AuthApi {
    @Override
    public Optional<NativeWebRequest> getRequest() {
        return AuthApi.super.getRequest();
    }

    @Override
    public ResponseEntity<Void> loginUser(LoginRequest loginRequest) {
        return AuthApi.super.loginUser(loginRequest);
    }

    @Override
    public ResponseEntity<Void> signUpUser(SignUpRequest signUpRequest) {
        return AuthApi.super.signUpUser(signUpRequest);
    }
}
