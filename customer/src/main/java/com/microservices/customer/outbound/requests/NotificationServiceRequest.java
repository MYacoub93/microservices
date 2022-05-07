package com.microservices.customer.outbound.requests;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@AllArgsConstructor
@Data
@Builder
public class NotificationServiceRequest {
    private String to;
    private String subject;
    private String text;
}
