package com.ecepolat.controller;

import com.ecepolat.dto.DtoAddress;
import com.ecepolat.dto.DtoAddressIU;

public interface IRestAddressController {

    public RootEntity<DtoAddress> saveAddress(DtoAddressIU dtoAddressIU);
}
