package com.ecepolat.controller;

import com.ecepolat.dto.AuthRequest;
import com.ecepolat.dto.AuthResponse;
import com.ecepolat.dto.DtoUser;
import com.ecepolat.dto.RefreshTokenRequest;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);

    public RootEntity<AuthResponse> authenticate(AuthRequest input);

    public RootEntity<AuthResponse> refreshToken(RefreshTokenRequest input);
}
