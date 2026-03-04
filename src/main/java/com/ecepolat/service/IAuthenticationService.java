package com.ecepolat.service;

import com.ecepolat.dto.AuthRequest;
import com.ecepolat.dto.DtoUser;

public interface IAuthenticationService {

    public DtoUser register(AuthRequest input);
}
