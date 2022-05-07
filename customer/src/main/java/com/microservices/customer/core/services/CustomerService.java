package com.microservices.customer.core.services;

import com.microservices.customer.core.entities.CustomerEntity;
import com.microservices.customer.core.repository.CustomerRepository;
import com.microservices.customer.outbound.requests.NotificationServiceRequest;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@AllArgsConstructor
public class CustomerService {

    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    Environment environment;

    @Autowired
    RestTemplate restTemplate;

    public CustomerEntity registerCustomer(CustomerEntity customerEntity){
        customerEntity = customerRepository.save(customerEntity);
        String emailBody = "New customer was registred with the user " + customerEntity.getFirstName() + " " +customerEntity.getLastName();
        NotificationServiceRequest notificationServiceRequest = new NotificationServiceRequest(
                customerEntity.getEmail(),
                "Registration Confirmation",
                emailBody
        );

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<NotificationServiceRequest> httpEntity = new HttpEntity<>(notificationServiceRequest, headers);
        restTemplate.postForObject(
                environment.getProperty("notification.service.url"),
                httpEntity,
                String.class
        );

       return customerEntity;
    }
}
