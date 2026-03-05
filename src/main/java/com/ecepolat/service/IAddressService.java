package com.ecepolat.service;

import com.ecepolat.dto.DtoAddress;
import com.ecepolat.dto.DtoAddressIU;

public interface IAddressService {

    public DtoAddress saveAddress(DtoAddressIU dtoAddressIU);
}
