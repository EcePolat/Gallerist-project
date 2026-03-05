package com.ecepolat.controller.impl;

import com.ecepolat.controller.IRestAuthenticationController;
import com.ecepolat.controller.RootEntity;
import com.ecepolat.dto.AuthRequest;
import com.ecepolat.dto.AuthResponse;
import com.ecepolat.dto.DtoUser;
import com.ecepolat.dto.RefreshTokenRequest;
import com.ecepolat.service.IAuthenticationService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import static com.ecepolat.controller.RootEntity.ok;

@RestController
public class RestAuthenticationControllerImpl implements IRestAuthenticationController {

    @Autowired
    private IAuthenticationService authenticationService;

    @PostMapping("/register")
    @Override
    public RootEntity<DtoUser> register(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.register(input));
    }

    @PostMapping("/authenticate")
    @Override
    public RootEntity<AuthResponse> authenticate(@Valid @RequestBody AuthRequest input) {
        return ok(authenticationService.authenticate(input));
    }

    @PostMapping("/refreshToken")
    @Override
    public RootEntity<AuthResponse> refreshToken(@Valid @RequestBody RefreshTokenRequest input) {
        return ok(authenticationService.refreshToken(input));
    }
}
