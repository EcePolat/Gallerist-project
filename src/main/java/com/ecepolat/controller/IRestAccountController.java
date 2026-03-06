package com.ecepolat.controller;

import com.ecepolat.dto.DtoAccount;
import com.ecepolat.dto.DtoAccountIU;

public interface IRestAccountController {

    public RootEntity<DtoAccount> saveAccount(DtoAccountIU dtoAccountIU);
}
