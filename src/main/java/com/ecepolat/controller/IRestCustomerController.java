package com.ecepolat.controller;

import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.dto.DtoCustomerIU;

import java.util.List;

public interface IRestCustomerController {

    public RootEntity<DtoCustomer> saveCustomer(DtoCustomerIU dtoCustomerIU);

    public RootEntity<DtoCustomer> updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);

    public RootEntity<List<DtoCustomer>> getAllCustomers();

    public RootEntity<String> deleteCustomer(Long id);
}
