package com.ecepolat.service;

import com.ecepolat.dto.DtoAccount;
import com.ecepolat.dto.DtoAccountIU;

public interface IAccountService {

    public DtoAccount saveAccount(DtoAccountIU dtoAccountIU);
}
