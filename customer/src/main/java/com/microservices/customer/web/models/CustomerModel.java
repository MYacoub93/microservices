package com.microservices.customer.web.models;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CustomerModel {

    private long id;
    private String firstName;
    private String lastName;
    private String email;
}
