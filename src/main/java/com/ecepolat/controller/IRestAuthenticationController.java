package com.ecepolat.controller;

import com.ecepolat.dto.AuthRequest;
import com.ecepolat.dto.DtoUser;

public interface IRestAuthenticationController {

    public RootEntity<DtoUser> register(AuthRequest input);
}
