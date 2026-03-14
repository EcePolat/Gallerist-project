package com.ecepolat.controller.impl;

import com.ecepolat.controller.IRestCustomerController;
import com.ecepolat.controller.RestBaseController;
import com.ecepolat.controller.RootEntity;
import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.dto.DtoCustomerIU;
import com.ecepolat.service.ICustomerService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/rest/api/customer")
public class RestCustomerControllerImpl extends RestBaseController implements IRestCustomerController {

    @Autowired
    private ICustomerService customerService;

    @PostMapping("/save")
    @Override
    public RootEntity<DtoCustomer> saveCustomer(@Valid @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.saveCustomer(dtoCustomerIU));
    }

    @PutMapping("/update/{id}")
    @Override
    public RootEntity<DtoCustomer> updateCustomer(@PathVariable Long id,
                                                  @RequestBody DtoCustomerIU dtoCustomerIU) {
        return ok(customerService.updateCustomer(id, dtoCustomerIU));
    }

    @GetMapping("/get")
    @Override
    public RootEntity<List<DtoCustomer>> getAllCustomers() {
        return ok(customerService.getAllCustomers());
    }

    @DeleteMapping("/delete/{id}")
    @Override
    public RootEntity<String> deleteCustomer(@PathVariable Long id) {
        return ok(customerService.deleteCustomer(id));
    }


}
