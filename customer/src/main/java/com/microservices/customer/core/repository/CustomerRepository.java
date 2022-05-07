package com.microservices.customer.core.repository;

import com.microservices.customer.core.entities.CustomerEntity;
import org.springframework.data.repository.CrudRepository;

public interface CustomerRepository extends CrudRepository<CustomerEntity,Long> {
}

