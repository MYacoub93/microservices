package com.microservices.util.web.controllers;

import com.microservices.util.web.models.EmailModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.microservices.util.core.EmailUtil;

@RestController
@RequestMapping(path = "api/v1/email")
public class EmailController {

    @Autowired
    private EmailUtil emailUtil;

    @PostMapping(path = "/send")
    public boolean sendEmail(@RequestBody EmailModel emailModel){
        return emailUtil.sendEmail(emailModel.getTo(),emailModel.getSubject(),emailModel.getText());
    }
}
