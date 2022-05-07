package com.microservices.merchant.web.controllers;

import com.microservices.merchant.core.entities.MerchantEntity;
import com.microservices.merchant.core.services.MerchantService;
import com.microservices.merchant.web.models.MerchantModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/merchant")
public class MerchantController {

    @Autowired
    MerchantService merchantService;

    @PostMapping(path = "/registerMerchant")
    public MerchantModel registerMerchant(@RequestBody MerchantModel merchantModel){
        MerchantEntity merchantEntity= merchantService.registerMerchant(new MerchantEntity(null,merchantModel.getFirstName(),merchantModel.getLastName()));
        return new MerchantModel(merchantEntity.getId(),merchantEntity.getFirstName(),merchantEntity.getLastName());
    }
}
