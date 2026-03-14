package com.ecepolat.service.impl;

import com.ecepolat.dto.DtoAccount;
import com.ecepolat.dto.DtoAddress;
import com.ecepolat.dto.DtoCustomer;
import com.ecepolat.dto.DtoCustomerIU;
import com.ecepolat.exception.BaseException;
import com.ecepolat.exception.ErrorMessage;
import com.ecepolat.exception.MessageType;
import com.ecepolat.model.Account;
import com.ecepolat.model.Address;
import com.ecepolat.model.Customer;
import com.ecepolat.repository.AccountRepository;
import com.ecepolat.repository.AddressRepository;
import com.ecepolat.repository.CustomerRepository;
import com.ecepolat.service.ICustomerService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.DeleteMapping;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Autowired
    private AccountRepository accountRepository;

    private Customer createCustomer(DtoCustomerIU dtoCustomerIU){
        Optional<Address> optAddress = addressRepository.findById(dtoCustomerIU.getAddressId());
        if(optAddress.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAddressId().toString()));
        }

        Optional<Account> optAccount = accountRepository.findById(dtoCustomerIU.getAccountId());
        if(optAccount.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, dtoCustomerIU.getAccountId().toString()));
        }

        Customer customer = new Customer();
        customer.setCreateTime(new Date());
        BeanUtils.copyProperties(dtoCustomerIU, customer);

        customer.setAddress(optAddress.get());
        customer.setAccount(optAccount.get());

        return customer;
    }

    @Override
    public DtoCustomer saveCustomer(DtoCustomerIU dtoCustomerIU) {
        DtoCustomer dtoCustomer = new DtoCustomer();
        DtoAddress dtoAddress = new DtoAddress();
        DtoAccount dtoAccount = new DtoAccount();

        Customer savedCustomer = customerRepository.save(createCustomer(dtoCustomerIU));

        BeanUtils.copyProperties(savedCustomer, dtoCustomer);
        BeanUtils.copyProperties(savedCustomer.getAddress(), dtoAddress);
        BeanUtils.copyProperties(savedCustomer.getAccount(), dtoAccount);

        dtoCustomer.setAddress(dtoAddress);
        dtoCustomer.setAccount(dtoAccount);

        return dtoCustomer;
    }

    @Override
    public List<DtoCustomer> getAllCustomers() {

        List<Customer> customerList = customerRepository.findAll();
        List<DtoCustomer> dtoList = new ArrayList<>();

        for (Customer customer : customerList){
            DtoCustomer dtoCustomer = new DtoCustomer();
            BeanUtils.copyProperties(customer, dtoCustomer);

            dtoList.add(dtoCustomer);
        }

        return dtoList;
    }

    @Override
    public DtoCustomer updateCustomer(Long id, DtoCustomerIU dtoCustomerIU) {

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if(optCustomer.isEmpty()){
            throw new BaseException(new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        Customer customer = optCustomer.get();

        BeanUtils.copyProperties(dtoCustomerIU, customer);

        Customer updatedCustomer = customerRepository.save(customer);

        DtoCustomer dtoCustomer = new DtoCustomer();
        BeanUtils.copyProperties(updatedCustomer, dtoCustomer);

        return dtoCustomer;
    }

    @Override
    public String deleteCustomer(Long id) {

        Optional<Customer> optCustomer = customerRepository.findById(id);

        if (optCustomer.isEmpty()){
            throw new BaseException( new ErrorMessage(MessageType.NO_RECORD_EXIST, id.toString()));
        }

        customerRepository.delete(optCustomer.get());
        return id + "id'li customer deleted successfully.";
    }
}
