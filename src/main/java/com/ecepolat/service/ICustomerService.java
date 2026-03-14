package com.ecepolat.service;

import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.dto.DtoCustomerIU;

import java.util.List;

public interface ICustomerService {

    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU);

    public List<DtoCustomer> getAllCustomers();

    public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU);

    public String deleteCustomer(Long id);

}
