package com.ecepolat.service;

import com.ecepolat.dto.AuthRequest;
import com.ecepolat.dto.AuthResponse;
import com.ecepolat.dto.DtoUser;
import com.ecepolat.dto.RefreshTokenRequest;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);

    public AuthResponse authenticate(AuthRequest input);

    public AuthResponse refreshToken(RefreshTokenRequest input);

}
