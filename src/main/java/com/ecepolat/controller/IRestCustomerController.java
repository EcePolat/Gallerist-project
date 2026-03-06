package com.ecepolat.controller;

import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.dto.DtoCustomerIU;

public interface IRestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);
}
