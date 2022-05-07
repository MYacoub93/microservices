package com.microservices.merchant.core.repository;

import com.microservices.merchant.core.entities.MerchantEntity;
import org.springframework.data.repository.CrudRepository;

public interface MerchantRepositroy extends CrudRepository<MerchantEntity,Long> {
}
