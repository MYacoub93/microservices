package com.microservices.customer.web.contollers;

import com.microservices.customer.core.entities.CustomerEntity;
import com.microservices.customer.core.services.CustomerService;
import com.microservices.customer.web.models.CustomerModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @PostMapping(path = "/registerCustomer")
    public CustomerModel registerCustomer(@RequestBody CustomerModel customerModel) {
        CustomerEntity customerEntity = customerService.registerCustomer(new CustomerEntity(null, customerModel.getFirstName(), customerModel.getLastName(), customerModel.getEmail()));
        return new CustomerModel(customerEntity.getId(), customerEntity.getFirstName(), customerEntity.getLastName(), customerEntity.getEmail());
    }
}