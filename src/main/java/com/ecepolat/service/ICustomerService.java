package com.ecepolat.service;

import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.dto.DtoCustomerIU;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);
}
