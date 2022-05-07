package com.microservices.merchant.core.services;

import com.microservices.merchant.core.entities.MerchantEntity;
import com.microservices.merchant.core.repository.MerchantRepositroy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MerchantService {

    @Autowired
    private MerchantRepositroy merchantRepositroy;

    public MerchantEntity registerMerchant(MerchantEntity merchantEntity){
        return merchantRepositroy.save(merchantEntity);
    }
}
